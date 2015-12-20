package presentation.userPanel.BusinessLb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.JLabel;

import State.AddState;
import State.ErrorState;
import VO.DeliveryVO;
import VO.VO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import businesslogic.Service.BusinessLobby.BsLbService;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.frame.MainFrame;
import presentation.main.FunctionAdd;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;

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
		needDelivery = service.getNeedDelivery();
		
//		//测试用
//		try {
//			ArrayList<String> id = new ArrayList<String>();
//			id.add("0000000009");
//			DeliveryVO delivery0 = new DeliveryVO(sdf.parse("2015-12-4 10:27:40"), id, "张斯栋");
//			needDelivery.add(delivery0);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		tableV = getVector(needDelivery);
		model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		table = new TableAddOnly(model);
		
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		panel.add(sPanel);
	}

	@Override
	public void performConfirm() {
		//提交所有更新
		for(Vector<String> vector:tableV){
			DeliveryVO temp = (DeliveryVO) this.getVO(vector);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AddState state=AddState.CONNECTERROR;
			state=service.delivery(temp);
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
		ArrayList<String> tempbarCodeList = new ArrayList<String>();
		tempbarCodeList.add(vector.get(0));
		Date tempdate = Calendar.getInstance().getTime();
		String tempname = vector.get(2);
		DeliveryVO tempDelivery = new DeliveryVO(tempdate, tempbarCodeList, tempname);
		return tempDelivery;
	}
	
	protected Vector<Vector<String>> getVector(ArrayList<DeliveryVO> vo){
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(DeliveryVO temp:vo){
			Vector<String> vRow = new Vector<String>();
			vRow.add(temp.getBarCodeList().get(0));
			vRow.add(sdf.format(new Date()));
			vRow.add("");
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
	@Override
	public void performCancel() {
		MainFrame.changeContentPanel(new BusinessLbDelivery().getPanel());
	}
}
