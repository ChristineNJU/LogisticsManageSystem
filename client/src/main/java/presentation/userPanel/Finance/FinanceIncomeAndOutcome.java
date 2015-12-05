package presentation.userPanel.Finance;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;

import VO.CostVO;
import VO.GatheringVO;
import presentation.components.ButtonConfirm;
import presentation.components.DateChooser;
import presentation.components.LabelHeader;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class FinanceIncomeAndOutcome extends FinanceIncome{

	ArrayList<CostVO> costs;
	ArrayList<GatheringVO> incomes;
	
	
	public DateChooser dateBeginChooser;
	public DateChooser dateEndChooser;
	
	private ScrollPaneTable sPanel2;
	private Vector<Vector<String>> tableV2 = new Vector<Vector<String>>();
	private TableModelSearch model2;
	private TableSearch table2;

	public FinanceIncomeAndOutcome(){
		
	}
	
	@Override
	protected void init(){
		confirmSearch = new ButtonConfirm("查看成本收益");
		initUI("查看成本收益");
	}
	
	@Override
	protected void initHeader() {
		dateBeginChooser = new DateChooser(panel,210,120);
		dateEndChooser = new DateChooser(panel,480,120);
		header = new Header();
		panel.add(header);
		
	}

	@Override
	protected void initTable() {
		tableV = new Vector<Vector<String>>();
		model = new TableModelSearch(tableV,tableH);
		table = new TableSearch(model);
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		sPanel.setSize(sPanel.getWidth(),200);
		panel.add(sPanel);
		
		tableV2 = new Vector<Vector<String>>();
		String[] tableH2 = {"付款日期","金额","付款人","付款账户","条目","备注"};
		model2 = new TableModelSearch(tableV2,tableH2);
		table2 = new TableSearch(model2);
		sPanel2 = new ScrollPaneTable(table2);
		sPanel2.setLocation(sPanel.getX(),sPanel.getHeight()+header.getHeight()+150);
		sPanel2.setSize(sPanel.getWidth(),300);
		panel.add(sPanel2);
	}

	@Override
	protected void initFooter() {
//		System.out.println("construct");
		foot = new FooterNew();
		panel.add(foot);
		
	}
	

	@Override
	protected void showSearch() {
		String timeBegin = dateBeginChooser.getTime();
		String timeEnd = dateEndChooser.getTime();
		if(timeBegin.compareTo(timeEnd) >= 0){
			showError("开始时间需要在结束时间之前");
		}else{
			costs = service.searchCost(timeBegin, timeEnd);
			// incomes = service.searchGathering(date, businesslobby)
		}
		
	}
	
	private class Header extends JLabel{
		LabelHeader dateBegin = new LabelHeader("开始日期:");
		LabelHeader dateEnd = new LabelHeader("结束日期:");
		
//		String[] businessLbName = {"仙林营业厅","鼓楼营业厅","江宁营业厅","雨花营业厅"};
//		public FlatComboBox businessLbChooser = new FlatComboBox(businessLbName);
		public Header(){
			this.setBounds(120,115,770,30);
			dateBegin.setBounds(0,0,80,30);
			this.add(dateBegin);
			dateEnd.setBounds(270,0,80,30);
			this.add(dateEnd);
//			businessLbChooser.setBounds(320,0,120,30);
//			this.add(businessLbChooser);
		}
//		public String getBusinessLobby(){
//			System.out.println(businessLbChooser.getSelectedItem().toString());
//			return businessLbChooser.getSelectedItem().toString();
//		}
	}
	
	public double getTotalCost(){
		double total = 0;
		for(int i = 0; i < model2.getRowCount();i++){
			total += Double.valueOf((String)model.getValueAt(i, 1));
		}
		return total;
	}
	
	public String getBenefitDetail(){
		double income = super.getTotalIncome();
		double cost = getTotalCost();
		double benefit = income - cost;
		return "总收入："+benefit+"    总支出:"+cost+"     总收入:"+income;
	}
	
	private class FooterNew extends JLabel{
		public FooterNew(){
//			System.out.println("footer in child"+table2.getHeight()+table2.getY()+200);
			setBounds(120,600,600,40);
			setText(getBenefitDetail());
			setForeground(ColorPallet.Pink);
			setFont(FontSet.twenty);
		}
	}

}
