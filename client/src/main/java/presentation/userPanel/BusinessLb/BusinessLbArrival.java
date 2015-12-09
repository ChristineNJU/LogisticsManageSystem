package presentation.userPanel.BusinessLb;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.TableColumnModel;

import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import businesslogic.Impl.MediumCenter.MediumCenterController;
import businesslogic.Service.BusinessLobby.BsLbService;
import businesslogic.SystemLog.SystemLog;
import State.AddState;
import State.ErrorState;
import State.LogisticsState;
import VO.ArrivalVO;
import VO.VO;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.components.LabelHeader;
import presentation.components.TextFieldHeader;
import presentation.main.FunctionAdd;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import presentation.userPanel.BusinessLb.BusinessLbEntrucking.Header;

/**
 * 营业厅到达单的列表
 * 
 * @author 张馨中
 * @version 1.0.0
 * */
public class BusinessLbArrival extends FunctionAdd{
	SimpleDateFormat sdfs=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdfd=new SimpleDateFormat("yyyy-MM-dd");
	
	BusinessLobbyController service = new BusinessLobbyController();
	ArrayList<ArrivalVO> arrivals;
	
	String[] tableH={"快递单号","出发地","快递状态","到达单编号",""};
	boolean[] isCellEditable = {false,false,false,false};
	
	public TextFieldHeader listIdIuput = new TextFieldHeader();
	
	public BusinessLbArrival(){
		super.buttonNew = new ButtonNew("新增到达单");
		super.confirm = new ButtonConfirm("提交所有到达单");
		initUI("中转接收");
	}
	
	protected void initTable() {
		// 表格初始化
		
		arrivals = new ArrayList<ArrivalVO>();
		
		//测试用
		try {
			ArrivalVO arrival0 = new ArrivalVO("0000001001", sdfs.parse("2015-12-03 10:30:10"), "0210210201021020102102", "南京", LogisticsState.INTACT);
			arrivals.add(arrival0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableV = getVector(arrivals);
		
		model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		table = new TableAddOnly(model);
		
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
	protected void confirmAll() {
		//提交所有更新
		AddState state=AddState.CONNECTERROR;
		ArrayList<ArrivalVO> temps = new ArrayList<ArrivalVO>();
		for(Vector<String> vector:tableV){
			ArrivalVO temp = (ArrivalVO)this.getVO(vector);
			temps.add(temp);
		}
		state=service.arrival(temps);
		if(state==AddState.CONNECTERROR){
			showError(ErrorState.CONNECTERROR);
		}
		else if(state==AddState.FAIL){
			showError(ErrorState.ADDERROR);
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
	
	

}
