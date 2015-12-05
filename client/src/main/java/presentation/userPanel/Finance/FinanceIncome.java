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
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.main.FunctionSearch;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class FinanceIncome extends FunctionSearch{
	FinanceService service = new FinanceController();
	ArrayList<GatheringVO> incomes;
//	String[] tableH = {"付款日期","金额","付款人","付款账户","条目","备注"};
	String[] tableH = {"收款日期","收款金额(￥)","收款快递员","快递单号"};
//	boolean[] isCellEditable = {false,false,false,false,false,false};
	
	public DateChooser dateBeginChooser;
	public DateChooser dateEndChooser;
	public FinanceIncome(){
//		System.out.println("     ");
		confirmSearch = new ButtonConfirm("查看进项");
		initUI("查看进项");
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
	
	@Override
	protected void initFooter() {
		foot = new Footer();
		panel.add(foot);
		
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

	public int getTotal(){
		int total = 0;
		for(int i = 0; i < model.getRowCount();i++){
			total += Integer.parseInt((String)model.getValueAt(i, 1));
		}
		return total;
	}

	@Override
	protected void showSearch() {
		String time = dateBeginChooser.getTime();
		String businessLb = ((Header) header).getBusinessLobby();
		incomes = service.searchGathering(time, businessLb);
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
			businessLb.setBounds(240,0,150,30);
			this.add(businessLb);
			businessLbChooser.setBounds(320,0,120,30);
			this.add(businessLbChooser);
		}
		public String getBusinessLobby(){
//			System.out.println(businessLbChooser.getSelectedItem().toString());
			return businessLbChooser.getSelectedItem().toString();
		}
	}

	private class Footer extends JLabel{
		public Footer(){
			setBounds(120,table.getHeight()+200,300,40);
			setText("合计："+getTotal()+"￥");
			setForeground(ColorPallet.Pink);
			setFont(FontSet.eighteen);
//			int total = getTotal();
		}
	}


	
}
