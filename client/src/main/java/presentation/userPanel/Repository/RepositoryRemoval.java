package presentation.userPanel.Repository;

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
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import State.AddState;
import State.ErrorState;
import State.TransferType;
import VO.RemovalVO;
import VO.VO;
import businesslogic.Impl.Repository.RepositoryController;
import businesslogic.SystemLog.SystemLog;

public class RepositoryRemoval extends FunctionAdd{

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
	
	RepositoryController service = new RepositoryController();
	ArrayList<RemovalVO> needRemoval;
	
	String[]  tableH = {"快递编号",""};
	boolean[] isCellEditable = {false};
	
	public TextFieldHeader transferCodeInput = new TextFieldHeader();
	public TextFieldHeader dateInput = new TextFieldHeader();
	public TextFieldHeader destinationInput = new TextFieldHeader();
	public TextFieldHeader transferWayInput = new TextFieldHeader();
	
	NavigationRepository nav;
	
	public RepositoryRemoval(NavigationRepository navigationRepository) {
		super.buttonNew = new ButtonNew("新增出库项");
		super.confirm = new ButtonConfirm("提交出库单");
		
		nav = navigationRepository;
		
		initUI("出库");
	}
	
	@Override
	protected void initHeader() {
		// TODO Auto-generated method stub
		header = new Header();
		panel.add(header);
		panel.repaint();
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		needRemoval = new ArrayList<RemovalVO>();
		
		//测试用
		try {
			RemovalVO removal0 = new RemovalVO("0000000005", sdf.parse("2015-12-5 10:10:10"), "南京", TransferType.AIR, "123434135321543124");
			needRemoval.add(removal0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableV = getVector(needRemoval);
		
		model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		table = new TableAddOnly(model);

		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		panel.add(sPanel);
	}

	private Vector<Vector<String>> getVector(ArrayList<RemovalVO> vo) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(RemovalVO temp:vo){
			Vector<String> vector = new Vector<String>();
			vector.add(temp.getBarCode());
			result.add(vector);
		}
		return result;
	}

	@Override
	protected void confirmAll() {
		// 提交所有更新
		ArrayList<RemovalVO> reomvals = new ArrayList<RemovalVO>();
		for(Vector<String> vector:tableV){
			RemovalVO temp = (RemovalVO) this.getVO(vector);
			reomvals.add(temp);
			
		}
		AddState state=service.addRemoval(reomvals);
		if(state==AddState.CONNECTERROR){
			showError(ErrorState.CONNECTERROR);
		}
		else if(state==AddState.FAIL){
			showError(ErrorState.ADDERROR);
		}
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// 将表格的一行转换成vo
		String tempbarCode = vector.get(0);
		Date tempdate = new Date();
		String tempdestination = destinationInput.getText();
		TransferType temptransferType = Translater.getTransferType(transferWayInput.getText());
		String temptransferCode = transferCodeInput.getText();
		RemovalVO tempRemoval = new RemovalVO(tempbarCode, tempdate, tempdestination, temptransferType, temptransferCode);
		return tempRemoval;
	}
	public class Header extends JLabel{
		LabelHeader InstitutionID = new LabelHeader("仓 库 编 号");
		LabelHeader date = new LabelHeader		   ("出 库 日 期");
		LabelHeader transferCode = new LabelHeader ("汽 运 编 号");
		LabelHeader destination = new LabelHeader  ("目   的   地");
		LabelHeader transferWay = new LabelHeader  ("装 运 方 式");
		
		LabelHeader InstitutionIDIuput = new LabelHeader(SystemLog.getInstitutionId());
		LabelHeader dateInput = new LabelHeader(sdfd.format(new Date()));
		public Header(){
			this.setBounds(120,100,760,100);
			this.setBackground(null);
			
			ArrayList<LabelHeader> maohao = new ArrayList<LabelHeader>();
			for(int i = 0; i < 5;i++){
				maohao.add(new LabelHeader(":"));
				maohao.get(i).setBounds(115+260*(i/3),(i%3)*33,14,30);
				this.add(maohao.get(i));
			}
			
			InstitutionID.setBounds(0,0,115,30);
			date.setBounds(0,33,115,30);
			transferCode.setBounds(0,66,115,30);
			destination.setBounds(260, 0, 115, 30);
			transferWay.setBounds(260, 33, 115, 30);
			
			add(InstitutionID);
			add(date);
			add(transferCode);
			add(destination);
			add(transferWay);
			
			
			InstitutionIDIuput.setBounds(130, 0, 120, 30);
			dateInput.setBounds(130, 33, 120, 30);
			
			transferCodeInput.setBounds(130, 66, 120, 30);
			destinationInput.setBounds(390,0 , 120, 30);
			transferWayInput.setBounds(390, 33, 120,30 );
			
			add(InstitutionIDIuput);
			add(dateInput);
			add(transferCodeInput);
			add(destinationInput);
			add(transferWayInput);
			
		}
		
	}
}
