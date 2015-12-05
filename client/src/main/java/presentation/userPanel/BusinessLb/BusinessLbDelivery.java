package presentation.userPanel.BusinessLb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JLabel;

import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.LabelHeader;
import presentation.main.FunctionAdd;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import VO.DeliveryVO;
import VO.EntruckingVO;
import VO.VO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import businesslogic.Service.BusinessLobby.BsLbService;
import businesslogic.SystemLog.SystemLog;

public class BusinessLbDelivery extends FunctionAdd{
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	BsLbService service = new BusinessLobbyController();
	ArrayList<DeliveryVO> needDelivery;
	
	String[] tableH = {"快递单号","日期","派件人",""};
	boolean[] isCellEditable = {false,false,false};
	
	public  BusinessLbDelivery() {
		super.buttonNew = new ButtonNew("新增派件单");
		super.confirm = new ButtonConfirm("提交所有派件单");
		initUI("派件管理");
	}
	
	@Override
	protected void initHeader() {
		// 获取营业厅的id，加入label显示
		header = new Header();
		panel.add(header);
		panel.repaint();
	}

	@Override
	protected void initTable() {
		// 表格的初始化
		needDelivery = new ArrayList<DeliveryVO>();
		
		//测试用
		try {
			ArrayList<String> id = new ArrayList<String>();
			id.add("0000000009");
			DeliveryVO delivery0 = new DeliveryVO(sdf.parse("2015-12-4 10:27:40"), id, "张斯栋");
			needDelivery.add(delivery0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableV = getVector(needDelivery);
		model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		table = new TableAddOnly(model);
		
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		panel.add(sPanel);
	}

	@Override
	protected void confirmAll() {
		//提交所有更新
		for(Vector<String> vector:tableV){
			DeliveryVO temp = (DeliveryVO) this.getVO(vector);
			service.delivery(temp);
		}
		
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// 将表格的一行转化成vo
		try {
			ArrayList<String> tempbarCodeList = new ArrayList<String>();
			tempbarCodeList.add(vector.get(0));
			Date tempdate;
			tempdate = sdf.parse((vector.get(1)));
			String tempname = vector.get(2);
			DeliveryVO tempDelivery = new DeliveryVO(tempdate, tempbarCodeList, tempname);
			return tempDelivery;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected Vector<Vector<String>> getVector(ArrayList<DeliveryVO> vo){
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(DeliveryVO temp:vo){
			Vector<String> vRow = new Vector<String>();
			vRow.add(temp.getBarCodeList().get(0));
			vRow.add(sdf.format(temp.getArrivalDate()));
			vRow.add(temp.getPeople());
			result.add(vRow);
		}
		
		return result;
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
