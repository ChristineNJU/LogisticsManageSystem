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
import presentation.components.TextField;
import presentation.components.TextFieldHeader;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.frame.MainFrame;
import presentation.main.FunctionAdd;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;

import State.AddState;
import State.ErrorState;

import presentation.userPanel.Manager.ManagerInstitutionMgt;

import VO.EntruckingVO;
import VO.VO;
import businesslogic.Impl.MediumCenter.MediumCenterController;
import businesslogic.SystemLog.SystemLog;

public class MediumCtEntrucking extends FunctionAdd{
	SimpleDateFormat sdfs=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdfd=new SimpleDateFormat("yyyy-MM-dd");
	
	MediumCenterController service = new MediumCenterController();
	ArrayList<EntruckingVO> needEntrucking;
	
	public TextFieldHeader idInput  = new TextFieldHeader();
	public TextFieldHeader carIdInput = new TextFieldHeader();
	public TextFieldHeader superCarGoInput = new TextFieldHeader();
	public TextFieldHeader guardInput = new TextFieldHeader();
	public TextFieldHeader destinationInput = new TextFieldHeader();
	public TextFieldHeader costInput = new TextFieldHeader();
	
	public MediumCtEntrucking(){
		super.buttonNew = new ButtonNew("新增装运快递");
		super.confirm = new ButtonConfirm("提交装运单");
		initUI("装运发送");
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
		// 表格的初始化
		
		needEntrucking = new ArrayList<EntruckingVO>();
		
//		needEntrucking = service.getNeedEntrucking();
		
		tableV = getVector(needEntrucking);
		
		model = TableModelFactory.getEntruckingModel(tableV);
		table = TableFactory.getEntrucking(model);
		
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		panel.add(sPanel);
	}

	@Override
	public void performConfirm() {
		// 提交所有更新
		ArrayList<String> tempbarCodeList = new ArrayList<String>();
		for(Vector<String> vector:tableV){
			
			tempbarCodeList.add(vector.get(0));
		}
		Date tempdate = new Date();
		String tempdestination = destinationInput.getText();
		String tempcarnumber = carIdInput.getText();
		String tempname = guardInput.getText();
		String tempsupercargo = superCarGoInput.getText();
		double tempamount = Double.valueOf(costInput.getText());
		String temptransfer = idInput.getText();
		EntruckingVO tempEntrucking = new EntruckingVO(tempdate, temptransfer, tempdestination,tempcarnumber,tempname, tempsupercargo,tempbarCodeList, tempamount);
		
		AddState state=AddState.CONNECTERROR;
		state=service.entrucking(tempEntrucking);
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
	
	protected Vector<Vector<String>> getVector(ArrayList<EntruckingVO> vo){
		//将所needEntrucking加到界面的table之中
		Vector<Vector<String>> result= new Vector<Vector<String>> ();
		for(EntruckingVO temp:vo){
			
			for(String s:temp.getBarCodeList()){
				Vector<String> vRow = new Vector<String>();
				vRow.add(s);
				result.add(vRow);
			}
				
		}
		return result;
	}
	public class Header extends JLabel{
		LabelHeader mediumCenterId = new LabelHeader("中转中心编号");
		LabelHeader date = new  LabelHeader      ("装  车  日  期");
		LabelHeader id = new  LabelHeader        ("装 车 单 编 号");
		LabelHeader carId = new LabelHeader		 ("车  辆   代  号");
		LabelHeader superCarGo = new LabelHeader ("监     运     员");
		LabelHeader guard = new LabelHeader		 ("押     运     员");
		LabelHeader destination = new LabelHeader("到     达     地");
		LabelHeader cost = new LabelHeader		 ("运             费");
		
		LabelHeader mediumCenterIdInput = new LabelHeader(SystemLog.getInstitutionId());
		LabelHeader dateInput = new LabelHeader(sdfd.format(new Date()));
		
		
		public Header(){
			this.setBounds(120,100,760,100);
			
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
			guard.setBounds(260, 66, 115, 30);
			destination.setBounds(520, 0,115, 30);
			cost.setBounds(520, 33, 115, 30);
			
			add(mediumCenterId);
			add(date);
			add(id);
			add(carId);
			add(superCarGo);
			add(guard);
			add(destination);
			add(cost);
			
			
			mediumCenterIdInput.setBounds(130, 0, 120, 30);
			mediumCenterIdInput.setVisible(true);
			dateInput.setBounds(130, 33, 120, 30);
			
			idInput.setBounds(130, 66, 120, 30);
			carIdInput.setBounds(390,0 , 120, 30);
			superCarGoInput.setBounds(390, 33, 120,30 );
			guardInput.setBounds(390,66 , 120, 30);
			destinationInput.setBounds(650, 0, 120, 30);
			costInput.setBounds(650, 33, 120, 30);
			
			add(mediumCenterIdInput);
			add(dateInput);
			add(idInput);
			add(carIdInput);
			add(superCarGoInput);
			add(guardInput);
			add(destinationInput);
			add(costInput);
			
			
			
			
		}
	}
	@Override
	public void performCancel() {
		MainFrame.changeContentPanel(new MediumCtEntrucking().getPanel());		
	}
}
