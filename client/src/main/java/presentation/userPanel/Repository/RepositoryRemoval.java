package presentation.userPanel.Repository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.table.TableColumnModel;

import State.AddState;
import State.ErrorState;
import State.TransferType;
import VO.RemovalVO;
import VO.VO;
import VO.WareHouseVO;
import businesslogic.Impl.Repository.BlWareHouseImpl;
import businesslogic.Impl.Repository.RepositoryController;
import businesslogic.Service.Repository.BlWareHouseService;
import businesslogic.SystemLog.SystemLog;
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
import presentation.table.TableModelAddOnly;

public class RepositoryRemoval extends FunctionAdd{

	BlWareHouseService wareHouse = new BlWareHouseImpl();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
	
	RepositoryController service = new RepositoryController();
//	ArrayList<RemovalVO> needRemoval;
	

	
	ArrayList<WareHouseVO> total = new ArrayList<WareHouseVO>();
	
	public TextFieldHeader transferCodeInput = new TextFieldHeader();
	public TextFieldHeader dateInput = new TextFieldHeader();
	public FlatComboBox destinationInput = new FlatComboBox();
	public TextFieldHeader transferWayInput = new TextFieldHeader();
	
	NavigationRepository nav;
	
	ProgressBarPanel progress_bar = new ProgressBarPanel();
	
	public RepositoryRemoval(NavigationRepository navigationRepository) {
		super.buttonNew = new ButtonNew("新增出库项");
		super.confirm = new ButtonConfirm("提交出库单");
		
		nav = navigationRepository;
		
		total = wareHouse.getWareHouse();
		initDestinationInput();
		
		initUI("出库");
		
		panel.add(progress_bar.getPanel());
	}
	
	private void initDestinationInput() {
		ArrayList<String> city = new ArrayList<String>();
		for(int i=0;i<total.size();i++){
			if(!city.contains(total.get(i).getDestination())){
				city.add(total.get(i).getDestination());
			}
		}
		
		for(int i=0;i<city.size();i++){
			destinationInput.addItem(city.get(i));
		}
		
		destinationInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tableV = new Vector<Vector<String>>();
//				Vector<Vector<String>> temp = new Vector<Vector<String>>();
//				Vector<String> tmp = new Vector<String>();
//				tmp.add("");
//
//				temp.add(tmp);
//				
//				tableV = temp;
				
				model = TableModelFactory.getRemovalModel(tableV);
				table = TableFactory.getRemovalTable(model);
				table.addMouseListener(tableListener);
				sPanel.setViewportView(table);
				table.repaint();
//				table.setModel(model);
				TableColumnModel tcm = table.getColumnModel();
				tcm.getColumn(0).setCellEditor(new DefaultCellEditor(getComboBox()));
				
				table.repaint();
			}
		});
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
//		needRemoval = new ArrayList<RemovalVO>();
//		
//		tableV = getVector(needRemoval);
//		Vector<Vector<String>> temp = new Vector<Vector<String>>();
//		Vector<String> tmp = new Vector<String>();
//		tmp.add("");
//
//		temp.add(tmp);
//		
//		tableV = temp;
		tableV = new Vector<Vector<String>>();
		model = TableModelFactory.getRemovalModel(tableV);
		table = TableFactory.getRemovalTable(model);

		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellEditor(new DefaultCellEditor(getComboBox()));
		
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

	private FlatComboBox getComboBox() {
		FlatComboBox tmp = new FlatComboBox();
		for(int i=0;i<total.size();i++){
			if(total.get(i).getDestination().equals(destinationInput.getSelectedItem())){
				tmp.addItem(total.get(i).getBar_code());
			}
		}
		return tmp;
	}
	
	@Override
	public void performConfirm() {
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
		else{ if(state==AddState.FAIL){
			showError(ErrorState.ADDERROR);
		}else{
			nav.changeTask(2);
		}
			
		}
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// 将表格的一行转换成vo
		String tempbarCode = vector.get(0);
		System.out.println("bar_code="+ vector.get(0));
		Date tempdate = new Date();
		String tempdestination = (String)destinationInput.getSelectedItem();
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
//		JLabel destination = new JLabel("目   的   地");
//		FlatComboBox destination_actual = new FlatComboBox();
		
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
			destinationInput.setBounds(390,0 , 60, 30);
			transferWayInput.setBounds(390, 33, 120,30 );
			
			
			add(InstitutionIDIuput);
			add(dateInput);
			add(transferCodeInput);
			add(destinationInput);
			add(transferWayInput);
			
		}
		
	}
	@Override
	public void performCancel() {
		MainFrame.changeContentPanel(new RepositoryRemoval(nav).getPanel());		
	}
}
