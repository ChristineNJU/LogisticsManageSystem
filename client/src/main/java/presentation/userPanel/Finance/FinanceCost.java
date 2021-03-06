package presentation.userPanel.Finance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.frame.MainFrame;
import presentation.main.FunctionAdd;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import State.AddState;
import State.CostType;
import State.ErrorState;
import VO.AccountVO;
import VO.CostVO;
import VO.VO;
import businesslogic.Impl.Finance.FinanceController;
import businesslogic.Service.Finance.FinanceService;

public class FinanceCost extends FunctionAdd{
	SimpleDateFormat sdfs=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdfd=new SimpleDateFormat("yyyy-MM-dd");
	
	FinanceService service = new FinanceController();
	ArrayList<CostVO> costs;
	
//<<<<<<< HEAD
//=======
////	String[] tableH = {"付款日期","金额","付款人","付款账目","条目","备注",""};
//	String[] tableH = {"金额","付款人","付款账目","条目","备注",""};
//	boolean[] isCellEditable = {false,false,false,false,false};
//	
//>>>>>>> master2
	public FinanceCost(){
		super.buttonNew = new ButtonNew("新增支出项");
		super.confirm = new ButtonConfirm("提交支出单");
		initUI("增加支出");
	}
	@Override
	protected void initHeader() {
		// 空
		header = new Header();
		panel.add(header);
		panel.repaint();
	}
	@Override
	protected void initTable() {
		//表格的初始化
		costs = new ArrayList<CostVO>();
		

//		CostVO cost0 = new CostVO("2015-12-5 19:59:11", 120, "张斯栋","0123456789" ,CostType.reward,"超过预计" );
//		costs=service.searchCost("%%");
		if(costs==null){
			super.isConnectError=true;
			tableV=new Vector<Vector<String>>();
		}
		else {
			tableV = getVector(costs);
		}

		model = TableModelFactory.getCostModel(tableV);
		table = TableFactory.getCost(model);
		
		ArrayList<AccountVO> account = service.searchAccount("%%");
		
		FlatComboBox accountBox = new FlatComboBox();
		
		for(AccountVO vo: account){
			accountBox.addItem(vo.getName());
		}
		
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(accountBox));
		
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		panel.add(sPanel);
		
//<<<<<<< HEAD
//=======
//		TableColumnModel tcm = table.getColumnModel(); 
//	    String[] gender = {"租金","运费","薪水","奖金"}; 
//	    JComboBox  genderC = new FlatComboBox(gender);  
//	    
//	    JComboBox accountInfo = new FlatComboBox();
//	    
//	    ArrayList<AccountVO> acc = service.searchAccount("%%");
//	    
//	    for(int i=0;i<acc.size();i++){
//	    	accountInfo.addItem(acc.get(i).getName());
//	    }
//	    
//	    tcm.getColumn(3).setCellEditor(new DefaultCellEditor(genderC)); 
//		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(accountInfo));
//>>>>>>> master2
	}
	
	
	protected Vector<Vector<String>> getVector(ArrayList<CostVO> vo) {
		// 表格初始化
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(CostVO temp:vo){
			Vector<String> vRow = new Vector<String>();
//			vRow.add(sdfd.format(temp.getDate()));
			vRow.add(String.valueOf(temp.getAmount()));
			vRow.add(temp.getPayer());
			vRow.add(temp.getPayerAccount());
			vRow.add(Translater.getChineseCostType(temp.getType()));
			vRow.add(temp.getRemark());
			
			vRow.add("");
			
			result.add(vRow);
		} 
		return result;
	}
	@Override
	public void performConfirm() {
		// 提交所有更新
		for(Vector<String> vector:tableV){
			CostVO temp = (CostVO)this.getVO(vector);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AddState state=AddState.CONNECTERROR;
			state=service.addCost(temp);
			if(state==AddState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
			}
			else if(state==AddState.FAIL){
				showError(ErrorState.ADDERROR);
			}
		}
		
	}
	@Override
	protected VO getVO(Vector<String> vector) {
		//将表格的一行转换成vo
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String tempdate = sdf.format(Calendar.getInstance().getTime());
		double amount = Double.valueOf(vector.get(0));
		String temppayer = vector.get(1);
		String tempaccount = vector.get(2);
		CostType temptype = Translater.getCostType(vector.get(3));
		String tempremark = vector.get(4);
		CostVO tempcost = new CostVO(tempdate, amount, temppayer, tempaccount, temptype, tempremark);
		return tempcost;
	}
	
	public class Header extends JLabel{
//		LabelHeader businessLobbyID = new LabelHeader("营业厅编号");
	//	LabelHeader gatheringId = new LabelHeader( "装运单编号 ");
		public Header(){
			this.setBounds(120,100,680,60);
			this.setBackground(null);
//			businessLobbyID.addInfo(SystemLog.getInstitutionId());
//			gatheringId.addInfo("");
			
//			businessLobbyID.setBounds(0,0,400,30);
//			gatheringId.setBounds(0,35,400,30);
			
//			add(businessLobbyID);
//			add(gatheringId);
		}
	}

	@Override
	public void performCancel() {
		MainFrame.changeContentPanel(new FinanceCost().getPanel());		
	}
	
}
