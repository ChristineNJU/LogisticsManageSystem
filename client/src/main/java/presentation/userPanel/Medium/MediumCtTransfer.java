package presentation.userPanel.Medium;
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
import presentation.frame.MainFrame;
import presentation.main.FunctionAdd;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;

import State.AddState;
import State.ErrorState;

import presentation.userPanel.Manager.ManagerInstitutionMgt;

import VO.TransferVO;
import VO.VO;
import businesslogic.Impl.MediumCenter.MediumCenterController;
import businesslogic.SystemLog.SystemLog;

public class MediumCtTransfer extends FunctionAdd{

	SimpleDateFormat sdfs=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdfd=new SimpleDateFormat("yyyy-MM-dd");
	
	MediumCenterController service = new MediumCenterController();
	ArrayList<TransferVO> needTransfer;
	
	String[] tableH = {"快递单号",""};
	boolean[] isCellEditable = {false};
	
	public TextFieldHeader idInput  = new TextFieldHeader();
	public TextFieldHeader planeIdInput = new TextFieldHeader();
	public TextFieldHeader superCarGoInput = new TextFieldHeader();
	public TextFieldHeader rowInput = new TextFieldHeader();
	public TextFieldHeader departureInput = new TextFieldHeader();
	public TextFieldHeader destinationInput = new TextFieldHeader();
	public TextFieldHeader costInput = new TextFieldHeader();
	
	public  MediumCtTransfer() {
		super.buttonNew = new ButtonNew("新增中转快递");
		super.confirm = new ButtonConfirm("提交中转单");
		initUI("中转发送");
		confirm.setLocation(confirm.getX(), confirm.getY()+45);
		cancel.setLocation(cancel.getX(),cancel.getY()+45);
		
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
//		needTransfer = new ArrayList<TransferVO>();
		
		needTransfer = service.getNeedTransfer();
		
		
		//测试用
		
//		try {
//			ArrayList<String> itemID = new ArrayList<String>();
//			itemID.add("0000000001");
//			TransferVO transfer0 = new TransferVO(sdfs.parse("2015-12-4 16:44:44"), "02502015112300300", "D0324", "上海", "南京", "0123", "张斯栋", itemID, 12);
//			needTransfer.add(transfer0);
//			} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		tableV = getVector(needTransfer);
		
		model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		table = new TableAddOnly(model);
		
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
//		sPanel.setSize(sPanel.getWidth(),250);
		panel.add(sPanel);
		
		
	}

	@Override
	public void performConfirm() {
		//提交所有更新
		ArrayList<String> barCodeList = new ArrayList<String>();
		for(Vector<String> vector:tableV){
			barCodeList.add(vector.get(0));
		}
		Date tempdate = new Date();
		String templistId =  idInput.getText();
		String temptransferId = planeIdInput.getText();
		String tempsdeparture = departureInput.getText();
		String tempdestination = destinationInput.getText();
		String tempcontainnumber = rowInput.getText();
		String tempguardname = superCarGoInput.getText();
		double tempamount = Double.valueOf(costInput.getText());
		TransferVO tempTransfer = new TransferVO(tempdate, templistId, temptransferId, tempsdeparture, tempdestination, tempcontainnumber, tempguardname, barCodeList, tempamount);
		AddState state=AddState.CONNECTERROR;
		
		state=service.transfer(tempTransfer);
		if(state==AddState.CONNECTERROR){
			showError(ErrorState.CONNECTERROR);
		}
		else if(state==AddState.FAIL){
			showError(ErrorState.ADDERROR);
		}
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		
		return null;
	}
	protected Vector<Vector<String>> getVector(ArrayList<TransferVO> vo ){
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(TransferVO temp:vo){
			for(String s:temp.getItemId()){
			Vector<String> vRow = new Vector<String>();
			vRow.add(s);
			result.add(vRow);
			}
		}
		return result;
	}
	public class Header extends JLabel{
		LabelHeader mediumCenterId = new LabelHeader("中转中心编号");
		LabelHeader date = new  LabelHeader      ("中  转  日  期");
		LabelHeader id = new  LabelHeader        ("中 转 单 编 号");
		LabelHeader carId = new LabelHeader		 ("航     班     号");
		LabelHeader superCarGo = new LabelHeader ("监     装     员");
		LabelHeader row = new LabelHeader		 ("货     柜     员");
		LabelHeader departure = new LabelHeader ("出     发     地");
		LabelHeader destination = new LabelHeader("到     达     地");
		LabelHeader cost = new LabelHeader		 ("运             费");
		
		LabelHeader mediumCenterIdInput = new LabelHeader(SystemLog.getInstitutionId());
		LabelHeader dateInput = new LabelHeader(sdfd.format(new Date()));
	
		public Header(){
			this.setBounds(120,100,760,140);
			
			ArrayList<LabelHeader> maohao = new ArrayList<LabelHeader>();
			for(int i = 0; i < 8;i++){
				maohao.add(new LabelHeader(":"));
				maohao.get(i).setBounds(115+260*(i/3),(i%3)*33,14,30);
				this.add(maohao.get(i));
			}
			
			mediumCenterId.setBounds(0,0,115,30);
			date.setBounds(0,33,115,30);
			id.setBounds(0,66,115,30);
			carId.setBounds(260, 0, 115, 30);
			superCarGo.setBounds(260, 33, 115, 30);
			row.setBounds(260, 66, 115, 30);
			departure.setBounds(520,0,115,30);
			destination.setBounds(520, 33,115, 30);
			cost.setBounds(520, 66, 115, 30);
			
			add(mediumCenterId);
			add(date);
			add(id);
			add(carId);
			add(superCarGo);
			add(row);
			add(departure);
			add(destination);
			add(cost);
			
			
			mediumCenterIdInput.setBounds(130, 0, 120, 30);
			mediumCenterIdInput.setVisible(true);
			dateInput.setBounds(130, 33, 120, 30);
			
			idInput.setBounds(130, 66, 120, 30);
			planeIdInput.setBounds(390,0 , 120, 30);
			superCarGoInput.setBounds(390, 33, 120,30 );
			rowInput.setBounds(390,66 , 120, 30);
			departureInput.setBounds(650, 0, 120, 30);
			destinationInput.setBounds(650, 33, 120, 30);
			costInput.setBounds(650, 66, 120, 30);
			
			add(mediumCenterIdInput);
			add(dateInput);
			add(idInput);
			add(planeIdInput);
			add(superCarGoInput);
			add(rowInput);
			add(departureInput);
			add(destinationInput);
			add(costInput);
			
			
			
			
		}
	}
	@Override
	public void performCancel() {
		MainFrame.changeContentPanel(new MediumCtTransfer().getPanel());		
	}
}
