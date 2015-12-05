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
import presentation.main.FunctionAdd;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import VO.EntruckingVO;
import VO.VO;
import businesslogic.Impl.MediumCenter.MediumCenterController;

public class MediumCtEntrucking extends FunctionAdd{
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	MediumCenterController service = new MediumCenterController();
	ArrayList<EntruckingVO> needEntrucking;
	
	
	String[] tableH = {"快递单号","日期","目的地","车辆编号","押运人","货物监督员","数量","装运单号"};
	boolean[] isCellEditable = {false,false,false,false,false,false,false};
	
	public TextFieldHeader idInput  = new TextFieldHeader();
	public TextFieldHeader carIdInput = new TextFieldHeader();
	public TextField superCarGoInput = new TextField();
	public TextField guardInput = new TextField();
	public TextField destinationInput = new TextField();
	public TextField costInput = new TextField();
	
	public MediumCtEntrucking(){
		super.buttonNew = new ButtonNew("新增装运单");
		super.confirm = new ButtonConfirm("提交所有装运单");
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
	
		//测试用
		
		try {ArrayList<String> barCodeList = new ArrayList<String>();
			barCodeList.add("0000000001");
			EntruckingVO entrucking0 = new EntruckingVO(sdf.parse("2015-12-03 18:45:20"), "02502015112300000","南京", "苏A 12345", "张斯栋", "张斯栋",barCodeList, 12 );
			needEntrucking.add(entrucking0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableV = getVector(needEntrucking);
		
		model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		table = new TableAddOnly(model);
		
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		panel.add(sPanel);
	}

	@Override
	protected void confirmAll() {
		// 提交所有更新
		for(Vector<String> vector:tableV){
			EntruckingVO temp = (EntruckingVO)this.getVO(vector);
			service.entrucking(temp);
		}
		
		
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// 将表格的一行转化成vo
				try {
					ArrayList<String> tempbarCodeList = new ArrayList<String>();
					tempbarCodeList.add(vector.get(0));
					Date tempdate = sdf.parse(vector.get(1));
//					String tempdestination = vector.get(2);
					String tempdestination = destinationInput.getText();
					String tempcarnumber = vector.get(3);
					String tempname = vector.get(4);
					String tempsupercargo = vector.get(5);
					double tempamount = Double.valueOf(vector.get(6));
					String temptransfer = vector.get(7);
					EntruckingVO tempEntrucking = new EntruckingVO(tempdate, temptransfer, tempdestination,tempcarnumber,tempname, tempsupercargo,tempbarCodeList, tempamount);
					return tempEntrucking;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
	}
	
	protected Vector<Vector<String>> getVector(ArrayList<EntruckingVO> vo){
		//将所needEntrucking加到界面的table之中
		Vector<Vector<String>> result= new Vector<Vector<String>> ();
		for(EntruckingVO temp:vo){
			Vector<String> vRow = new Vector<String>();
			vRow.add(temp.getBarCodeList().get(0));
			vRow.add(sdf.format(temp.getDate()));
			vRow.add(temp.getDestination());
			vRow.add(temp.getCarNumber());
			vRow.add(temp.getguardNumber());
			vRow.add(temp.getSupercargoName());
			
			vRow.add(String.valueOf(temp.getAmount()));
			vRow.add(temp.getInstitutioNumber());
			result.add(vRow);
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
			
			idInput.setBounds(130, 66, 120, 30);
			carIdInput.setBounds(390,0 , 120, 30);
			superCarGoInput.setBounds(390, 33, 120,30 );
			guardInput.setBounds(390,66 , 120, 30);
			destinationInput.setBounds(650, 0, 120, 30);
			costInput.setBounds(650, 33, 120, 30);
			
			add(idInput);
			add(carIdInput);
			add(superCarGoInput);
			add(guardInput);
			add(destinationInput);
			add(costInput);
			
			
			
			
		}
	}
}
