package presentation.userPanel.Medium;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;

import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.LabelHeader;
import presentation.main.FunctionAdd;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import presentation.userPanel.Medium.MediumCtEntrucking.Header;
import VO.TransferVO;
import VO.VO;
import businesslogic.Impl.MediumCenter.MediumCenterController;
import businesslogic.SystemLog.SystemLog;

public class MediumCtTransfer extends FunctionAdd{

	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	MediumCenterController service = new MediumCenterController();
	ArrayList<TransferVO> needTransfer;
	
	String[] tableH = {"快递单号","日期","出发地","目的地","押运人","装箱编号","中转编号","数量","中转单编号"};
	boolean[] isCellEditable = {false,false,false,false,false,false,false,false,false};
	
	public  void MediumCtTransfer() {
		super.buttonNew = new ButtonNew("新增中转单");
		super.confirm = new ButtonConfirm("提交所有中转单");
		initUI("中转发送");
	}
	
	@Override
	protected void initHeader() {
		//获取营业厅的id和装运单的id，加入label中显示
		header = new Header();
		panel.add(header);
		panel.repaint();
		
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		needTransfer = new ArrayList<TransferVO>();
		
		//测试用
		
		try {
			ArrayList<String> itemID = new ArrayList<String>();
			itemID.add("0000000001");
			TransferVO transfer0 = new TransferVO(sdf.parse("2015-12-4 16:44:44"), "02502015112300300", "D0324", "上海", "南京", "0123", "张斯栋", itemID, 12);
			needTransfer.add(transfer0);
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableV = getVector(needTransfer);
		
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
			TransferVO temp = (TransferVO)this.getVO(vector);
			service.transfer(temp);
		}
		
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		//将表格的一行转化成vo
		try {
			Date tempdate = (Date) sdf.parse(vector.get(1));
			String templistId = vector.get(8);
			String temptransferid = vector.get(6);
			String tempdeparture = vector.get(2);
			String tempdestination = vector.get(3);
			String tempcontainNumber = vector.get(5);
			String tempguardName = vector.get(4);
			ArrayList<String> tempitemId = new ArrayList<String>();
			double tempAmount = Double.valueOf(vector.get(7));
			tempitemId.add(vector.get(0));
			TransferVO tempTransfer = new TransferVO(tempdate, templistId, temptransferid, tempdeparture, tempdestination, tempcontainNumber, tempguardName, tempitemId, tempAmount);
			return tempTransfer;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	protected Vector<Vector<String>> getVector(ArrayList<TransferVO> vo ){
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(TransferVO temp:vo){
			Vector<String> vRow = new Vector<String>();
			vRow.add(temp.getItemId().get(0));
			vRow.add(sdf.format(temp.getDate()));
			vRow.add(temp.getDeparture());
			vRow.add(temp.getDestination());
			vRow.add(temp.getGuardName());
			vRow.add(temp.getContainerNumber());
			vRow.add(temp.getTransferId());
			vRow.add(String.valueOf(temp.getTransferCharge()));
			vRow.add(temp.getList());
			
		}
		return result;
	}
	public class Header extends JLabel{
		LabelHeader businessLobbyID = new LabelHeader("中转中心编号");
		LabelHeader gatheringId = new LabelHeader("装运单编号");
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
