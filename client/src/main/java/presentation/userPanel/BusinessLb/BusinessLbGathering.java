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
import presentation.components.TextFieldHeader;
import presentation.main.FunctionAdd;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import VO.GatheringVO;
import VO.VO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import businesslogic.Impl.Businesslobby.GetNeedGatheringImpl;
import businesslogic.Service.BusinessLobby.BsLbService;
import businesslogic.Service.BusinessLobby.GetNeedGatheringService;
import businesslogic.SystemLog.SystemLog;

public class BusinessLbGathering extends FunctionAdd{
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	BsLbService service = new BusinessLobbyController();
	ArrayList<GatheringVO> Gathering;
	
	
	String[] tableH = {"快递单号","收款日期","收款金额","收款快递员",""};
	boolean[] isCellEditable = {false,false,false,false};
	
//	public TextFieldHeader gatheringIdInput = new TextFieldHeader();
	
	public BusinessLbGathering(){
		super.buttonNew = new ButtonNew("新增收款单");
		super.confirm = new ButtonConfirm("提交所有收款单");
		initUI("收款结算");
	}
	
	@Override
	protected void initHeader() {
		//获取营业厅的id和收款单的id，加入label中显示
		header = new Header();
		panel.add(header);
//		panel.repaint();
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		//首先获得needGathering
		
		Gathering = new ArrayList<GatheringVO>();

//		Gathering = Service.getNeedGathering();
		
		
		// 测试用
		try {ArrayList<String> barCodeList = new ArrayList<String>();
			barCodeList.add("0000000004");
			GatheringVO gathering1 = new GatheringVO(sdf.parse("2015-12-3 10:15:13"),20,"张斯栋是二货",barCodeList);
//			GatheringVO gathering2 = new GatheringVO(sdf.parse("2015-12-3 10:20:20"),20,"张斯栋是傻逼",barCodeList);
//			GatheringVO gathering3 = new GatheringVO(sdf.parse("2015-12-3 10:20:20"),20,"张斯栋是二货",barCodeList);
//			GatheringVO gathering4 = new GatheringVO(sdf.parse("2015-12-3 10:20:20"),20,"张斯栋是二货",barCodeList);
//			GatheringVO gathering5 = new GatheringVO(sdf.parse("2015-12-3 10:20:20"),20,"张斯栋是二货",barCodeList);
			Gathering.add(gathering1);
//			Gathering.add(gathering2);
//			Gathering.add(gathering3);
//			Gathering.add(gathering4);
//			Gathering.add(gathering5);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		tableV = getVector(Gathering);
		
		model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		table = new TableAddOnly(model);

		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		panel.add(sPanel);
	}

	@Override
	protected void confirmAll() {
		// 提交所有更新
		for(Vector<String> vector: tableV ){
			
			GatheringVO temp = (GatheringVO)this.getVO(vector);
			System.out.println("has one"+temp.getName());
			service.gathering(temp);
	}		
		
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// 将表格的一行转化成vo
		try {
			ArrayList<String> tempbarCodeList = new ArrayList<String>();
			tempbarCodeList.add(vector.get(0));
			Date tempdate = sdf.parse(vector.get(1));
			String tempname = vector.get(3);
			double tempmoney = Double.valueOf(vector.get(2));
			GatheringVO tempGathering = new GatheringVO(tempdate, tempmoney, tempname, tempbarCodeList);
			return tempGathering;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	protected Vector<Vector<String>> getVector(ArrayList<GatheringVO> vo){
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(GatheringVO temp:vo){
			Vector<String> vRow = new Vector<String>();
			vRow.add(temp.id().get(0));
			vRow.add(sdf.format(temp.getDate()));
			
			vRow.add(String.valueOf(temp.getMoney()));
			vRow.add(temp.getName());
			result.add(vRow);
		}
		return result;
	}
	
	private class Header extends JLabel{
		LabelHeader businessLobbyID = new LabelHeader("营业厅编号:");
		//LabelHeader gatheringId = new LabelHeader("收款单编号:");
		
		LabelHeader businessLobbyIDInput = new LabelHeader(SystemLog.getInstitutionId());
		public Header(){
			this.setBounds(120,100,680,60);
			this.setBackground(null);
			
			
			businessLobbyID.setBounds(0,0,105,30);
//			gatheringId.setBounds(0,35,105,30);
			businessLobbyIDInput.setBounds(110, 0, 130, 30);
//			gatheringIdInput.setBounds(110, 35, 130, 30);
			
			add(businessLobbyID);
		//	add(gatheringId);
			add(businessLobbyIDInput);
//			add(gatheringIdInput);
		}
	}
}
