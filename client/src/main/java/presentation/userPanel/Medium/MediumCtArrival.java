package presentation.userPanel.Medium;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JLabel;

import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import businesslogic.Impl.MediumCenter.MediumCenterController;
import businesslogic.Service.BusinessLobby.BsLbService;
import businesslogic.SystemLog.SystemLog;
import State.LogisticsState;
import VO.ArrivalVO;
import VO.VO;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.LabelHeader;
import presentation.main.FunctionAdd;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import presentation.userPanel.BusinessLb.BusinessLbArrival.Header;

public class MediumCtArrival extends FunctionAdd{
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	MediumCenterController service = new MediumCenterController();
	ArrayList<ArrivalVO> arrivals;
	
	String[] tableH={"快递单号","日期","出发地","快递状态","到达单编号"};
	boolean[] isCellEditable = {false,false,false,false};
	
	public MediumCtArrival(){
		super.buttonNew = new ButtonNew("新增到达单");
		super.confirm = new ButtonConfirm("提交所有到达单");
		initUI("中转接收");
	}
	
	protected void initTable() {
		// 表格初始化
		
		arrivals = new ArrayList<ArrivalVO>();
		
		//测试用
		try {
			ArrivalVO arrival0 = new ArrivalVO("0000000001", sdf.parse("2015-12-03"), "0210210201021020102102", "南京", LogisticsState.INTACT);
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
	}
	
	private Vector<Vector<String>> getVector(ArrayList<ArrivalVO> vo) {
		//VO转显示
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(ArrivalVO temp:vo){
			Vector<String> vRow = new Vector<String>();
			vRow.add(temp.getBarCode());
			vRow.add(sdf.format(temp.getDate()));
			vRow.add(temp.getDeparture());
			vRow.add(Translater.getChineseLogisticsState(temp.getLogisticsState()));
			vRow.add(temp.getListId());
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
		ArrayList<ArrivalVO> temps = new ArrayList<ArrivalVO>();
		for(Vector<String> vector:tableV){
			ArrivalVO temp = (ArrivalVO)this.getVO(vector);
			temps.add(temp);
			
		}
		service.arrival(temps);
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// 将表格的一行转化成vo
		try {
			Date tempdate = sdf.parse(vector.get(1));
			String tempbarCode = vector.get(0);
			String tempdep = vector.get(2);
			LogisticsState tempstate = Translater.getLogisticsState(vector.get(3));
			String tempnumber = vector.get(4);
			ArrivalVO tempArrival = new ArrivalVO(tempbarCode, tempdate, tempnumber, tempdep, tempstate);
			return tempArrival;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public class Header extends JLabel{
		LabelHeader businessLobbyID = new LabelHeader("营业厅编号");
		LabelHeader gatheringId = new LabelHeader("到达单编号");
		public Header(){
			this.setBounds(120,100,680,60);
			this.setBackground(null);
			businessLobbyID.addInfo(SystemLog.getInstitutionId());
			gatheringId.addInfo("");
			
			businessLobbyID.setBounds(0,0,400,30);
			gatheringId.setBounds(0,35,400,30);
			
			add(businessLobbyID);
			add(gatheringId);
		}
	}

}
