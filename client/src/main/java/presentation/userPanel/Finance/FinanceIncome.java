package presentation.userPanel.Finance;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;

import VO.GatheringVO;
import businesslogic.Impl.Finance.FinanceController;
import businesslogic.Service.Finance.FinanceService;
import presentation.components.ButtonConfirm;
import presentation.components.DateChooser;
import presentation.components.FlatComboBox;
import presentation.components.LabelHeader;
import presentation.main.FunctionSearch;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class FinanceIncome extends FunctionSearch{
	FinanceService service = new FinanceController();
	ArrayList<GatheringVO> costs;
	String[] tableH = {"付款日期","金额","付款人","付款账户","条目","备注"};
	boolean[] isCellEditable = {false,false,false,false,false,false};
	
	public DateChooser dateBeginChooser;
	public DateChooser dateEndChooser;
	public FinanceIncome(){
		confirmSearch = new ButtonConfirm("查看进项");
		initUI("增加支出");
	}
	
	@Override
	protected void initHeader() {
		dateBeginChooser = new DateChooser(panel,210,120);
//		dateEndChooser = new DateChooser(panel,480,120);
		header = new Header();
		panel.add(header);
		
	}

	@Override
	protected void initTable() {
//		costs = service.searchCost("2015-01-01", "2015-12-31");
//		costs = service.searchGathering(date, businesslobby);
//		tableV = getVector(costs);
		tableV = new Vector<Vector<String>>();
		model = new TableModelSearch(tableV,tableH);
		table = new TableSearch(model);
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		panel.add(sPanel);
		
	}

	private Vector<Vector<String>> getVector(ArrayList<GatheringVO> costs2) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
        for(GatheringVO temp:costs2){
        	Vector<String> vRow = new Vector<String>();
        	vRow.add(temp.getDate()+"");
        	vRow.add(temp.getMoney()+"");
        	vRow.add(temp.getName());
        	result.add(vRow);
        }
		return result;
	}


	@Override
	protected void showSearch() {
		String time = dateBeginChooser.getTime();
		String businessLb = ((Header) header).getBusinessLobby();
		costs = service.searchGathering(time, businessLb);
		tableV = new Vector<Vector<String>>();
		model = new TableModelSearch(tableV,tableH);
		table.setModel(model);
		table.repaint();
	}

	
	private class Header extends JLabel{
		LabelHeader dateBegin = new LabelHeader("日期:");
		LabelHeader dateEnd = new LabelHeader("结束日期:");
		LabelHeader businessLb = new LabelHeader("营业厅:");
		
		String[] businessLbName = {"仙林营业厅","鼓楼营业厅","江宁营业厅","雨花营业厅"};
		public FlatComboBox businessLbChooser = new FlatComboBox(businessLbName);
		public Header(){
			this.setBounds(120,115,770,30);
			dateBegin.setBounds(0,0,80,30);
			this.add(dateBegin);
//			dateEnd.setBounds(270,0,80,30);
//			this.add(dateEnd);
			businessLb.setBounds(240,0,60,30);
			this.add(businessLb);
			businessLbChooser.setBounds(320,0,80,30);
			this.add(businessLbChooser);
		}
		public String getBusinessLobby(){
//			System.out.println(businessLbChooser.getSelectedItem().toString());
			return businessLbChooser.getSelectedItem().toString();
		}
	}

	
}
