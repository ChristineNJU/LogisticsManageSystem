package presentation.userPanel.Finance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.components.LabelHeader;
import presentation.main.FunctionAdd;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import presentation.userPanel.BusinessLb.BusinessLbDelivery.Header;
import State.CostType;
import VO.CostVO;
import VO.VO;
import businesslogic.Impl.Finance.FinanceController;
import businesslogic.SystemLog.SystemLog;

public class FinanceCost extends FunctionAdd{
	SimpleDateFormat sdfs=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdfd=new SimpleDateFormat("yyyy-MM-dd");
	
	FinanceController service = new FinanceController();
	ArrayList<CostVO> costs;
	
	String[] tableH = {"付款日期","金额","付款人","付款账目","条目","备注",""};
	boolean[] isCellEditable = {false,false,false,false,false,false};
	
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
		
//		//测试用
//		CostVO cost0 = new CostVO("2015-12-5 19:59:11", 120, "张斯栋","0123456789" ,CostType.reward,"超过预计" );
//		costs.add(cost0);
		
		tableV = getVector(costs);
		model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		table = new TableAddOnly(model);
		
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		panel.add(sPanel);
		
		TableColumnModel tcm = table.getColumnModel(); 
	    String[] gender = {"租金","运费","薪水","奖金"}; 
	    JComboBox  genderC = new FlatComboBox(gender);  
	    tcm.getColumn(4).setCellEditor(new DefaultCellEditor(genderC)); 
		
	}
	
	
	protected Vector<Vector<String>> getVector(ArrayList<CostVO> vo) {
		// 表格初始化
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(CostVO temp:vo){
			Vector<String> vRow = new Vector<String>();
			vRow.add(sdfd.format(temp.getDate()));
			vRow.add(String.valueOf(temp.getAmount()));
			vRow.add(temp.getPayer());
			vRow.add(temp.getPayerAccount());
			vRow.add(Translater.getChineseCostType(temp.getType()));
			vRow.add(temp.getRemark());
			result.add(vRow);
		} 
		return result;
	}
	@Override
	protected void confirmAll() {
		// 提交所有更新
		for(Vector<String> vector:tableV){
			CostVO temp = (CostVO)this.getVO(vector);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			service.addCost(temp);
		}
		
	}
	@Override
	protected VO getVO(Vector<String> vector) {
		//将表格的一行转换成vo
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String tempdate = sdf.format(Calendar.getInstance().getTime());
		double amount = Double.valueOf(vector.get(1));
		String temppayer = vector.get(2);
		String tempaccount = vector.get(3);
		CostType temptype = Translater.getCostType(vector.get(4));
		String tempremark = vector.get(5);
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
	
}
