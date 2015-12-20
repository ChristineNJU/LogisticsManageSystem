package presentation.userPanel.Medium;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.TableColumnModel;

import State.AddState;
import State.ErrorState;
import State.LogisticsState;
import VO.ArrivalVO;
import VO.VO;
import businesslogic.Impl.MediumCenter.MediumCenterController;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.components.LabelHeader;
import presentation.components.TextFieldHeader;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.frame.MainFrame;
import presentation.main.FunctionAdd;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;

public class MediumCtArrival extends FunctionAdd{
	SimpleDateFormat sdfs=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdfd=new SimpleDateFormat("yyyy-MM-dd");
	
	MediumCenterController service = new MediumCenterController();
	ArrayList<ArrivalVO> arrivals;
	
	public TextFieldHeader listIdIuput = new TextFieldHeader();
	
	NavigationMediumCenter nav;
	
	public MediumCtArrival(NavigationMediumCenter navigationMediumCenter){
		super.buttonNew = new ButtonNew("新增到达快递");
		super.confirm = new ButtonConfirm("提交到达单");
	
		nav = navigationMediumCenter;
		
		initUI("中转接收");
	}
	
	protected void initTable() {
		// 表格初始化
		
		arrivals = new ArrayList<ArrivalVO>();		
		tableV = getVector(arrivals);
		
		model = TableModelFactory.getArrivalModel(tableV);
		table = TableFactory.getArrivalTable(model);
		
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		panel.add(sPanel);
		
		TableColumnModel tcm = table.getColumnModel(); 
	    String[] gender = {"完整","丢失","损坏"}; 
	    JComboBox  genderC = new FlatComboBox(gender);  
	    tcm.getColumn(2).setCellEditor(new DefaultCellEditor(genderC)); 
		
	}
	
	private Vector<Vector<String>> getVector(ArrayList<ArrivalVO> vo) {
		//VO转显示
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(ArrivalVO temp:vo){
			Vector<String> vRow = new Vector<String>();
			vRow.add(temp.getBarCode());
			//vRow.add(sdfs.format(temp.getDate()));
			vRow.add(temp.getDeparture());
			vRow.add(Translater.getChineseLogisticsState(temp.getLogisticsState()));
//			vRow.add(temp.getListId());
			result.add(vRow);
		}
		return result;
	}

	@Override
	protected void initHeader() {
		// 获取营业厅的id和到达单的id，加入label中显示
		header = new Header();
		panel.add(header);
		panel.repaint();
	}

	@Override
	public void performConfirm() {
		//提交所有更新
		ArrayList<ArrivalVO> temps = new ArrayList<ArrivalVO>();
		for(Vector<String> vector:tableV){
			ArrivalVO temp = (ArrivalVO)this.getVO(vector);
			temps.add(temp);
			
		}
		AddState state=AddState.CONNECTERROR;
		state=service.arrival(temps);
		if(state==AddState.FAIL){
			showError(ErrorState.ADDERROR);
		}
		else if(state==AddState.CONNECTERROR){
			showError(ErrorState.CONNECTERROR);
		}else{
			nav.changeTask(2);
		}
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		Date tempdate = new Date();
		String tempbarCode = vector.get(0);
		String tempdep = vector.get(1);
		LogisticsState tempstate = Translater.getLogisticsState(vector.get(2));
		String tempnumber = listIdIuput.getText();
		ArrivalVO tempArrival = new ArrivalVO(tempbarCode, tempdate, tempnumber, tempdep, tempstate);
		return tempArrival;
		
	}
	
	public class Header extends JLabel{
		LabelHeader date = new LabelHeader("日         期:");
		LabelHeader arrivalID = new LabelHeader("到达单编号:");
		
		LabelHeader dateInput = new LabelHeader(sdfd.format(new Date()));
		public Header(){
			this.setBounds(120,100,680,70);
			this.setBackground(null);
//			arrivalID.addInfo(SystemLog.getInstitutionId());
//			date.addInfo(sdfd.format(new Date()));
			
			arrivalID.setBounds(0,35,115,30);
			date.setBounds(0,0,115,30);
			
			add(arrivalID);
			add(date);
			
			listIdIuput.setBounds(118, 35, 120, 30);
			dateInput.setBounds(118, 0, 120, 30);
			add(dateInput);
			add(listIdIuput);
		}
	}

	@Override
	public void performCancel() {
//		MainFrame.changeContentPanel(new MediumCtArrival(nav).getPanel());	
		nav.changeTask(1);
	}

}
