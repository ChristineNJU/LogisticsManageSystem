package presentation.userPanel.Finance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;

import State.ErrorState;
import VO.GatheringVO;
import businesslogic.Impl.Finance.FinanceController;
import businesslogic.Service.Finance.FinanceService;
import presentation.components.ButtonConfirm;
import presentation.components.DateChooser;
import presentation.components.FlatComboBox;
import presentation.components.LabelHeader;
import presentation.components.TextField;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.main.FunctionSearch;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class FinanceIncome extends FunctionSearch{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	FinanceService service = new FinanceController();
	ArrayList<GatheringVO> incomes;
	String[] tableH = {"收款日期","收款金额(￥)","收款快递员","快递单号"};
	
	public DateChooser dateBeginChooser;
	public DateChooser dateEndChooser;
	public FinanceIncome(){
		init();
	}
	
	protected void init(){
		confirmSearch = new ButtonConfirm("查看进项");
		initUI("查看进项");
		confirmSearch.setLocation(confirmSearch.getX(), header.getHeight()+header.getY()-10-confirmSearch.getHeight());
	}
	
	@Override
	protected void initHeader() {
		dateBeginChooser = new DateChooser(panel,200,122);
		dateEndChooser = new DateChooser(panel,420,122);
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
	
	protected Vector<Vector<String>> getVector(ArrayList<GatheringVO> income2) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
        for(GatheringVO temp:income2){
        	Vector<String> vRow = new Vector<String>();
        	vRow.add(sdf.format(temp.getDate()));
        	vRow.add(temp.getMoney()+"");
        	vRow.add(temp.getName());
        	result.add(vRow);
        }
		return result;
	}

	

	@Override
	protected void showSearch() {
		String time_start = dateBeginChooser.getTime();
		String time_end = dateEndChooser.getTime();
		String businessLb = ((Header) header).getBusinessLobby();
		incomes = service.searchGathering(time_start, time_end, businessLb);
		if(incomes==null){
			showError(ErrorState.CONNECTERROR);
			tableV = new Vector<Vector<String>>();
		}
		else if(!incomes.isEmpty()){
			tableV = getVector(incomes);
		}
		else if(incomes.isEmpty()){
			showError(ErrorState.SEARCHERROR);
			tableV = getVector(incomes);
		}
		
//		tableV = service.searchGathering(/, endDate, businesslobby)
		model = new TableModelSearch(tableV,tableH);
		table.setModel(model);
		table.repaint();
		foot.setText("合计："+getTotalIncome()+"￥");
	}

	
	private class Header extends JLabel{
		LabelHeader dateBegin = new LabelHeader("起始日期:");
		LabelHeader dateEnd = new LabelHeader("结束日期:");
		LabelHeader businessLb = new LabelHeader("营业厅:");
		
//		String[] businessLbName = {"仙林营业厅","鼓楼营业厅","江宁营业厅","雨花营业厅"};
//		public FlatComboBox businessLbChooser = new FlatComboBox(businessLbName);
		public TextField businessLbChooser = new TextField();
		
		public Header(){
			this.setBounds(120,120,770,40);
			dateBegin.setBounds(0,0,80,30);
			this.add(dateBegin);
			dateEnd.setBounds(220,0,80,30);
			this.add(dateEnd);
			businessLb.setBounds(430,0,65,30);
			this.add(businessLb);
			businessLbChooser.setBounds(495,0,120,30);
			this.add(businessLbChooser);
		}
		public String getBusinessLobby(){
//			System.out.println(businessLbChooser.getSelectedItem().toString());
//			return businessLbChooser.getSelectedItem().toString();
			return businessLbChooser.getText().equals("")? "%%":businessLbChooser.getText();
		}
	}

	public double getTotalIncome(){
		double total = 0;
		for(int i = 0; i < model.getRowCount();i++){
			total += Double.valueOf((String)model.getValueAt(i, 1));
		}
		return total;
	}
	
	private class Footer extends JLabel{
		public Footer(){
			setBounds(120,sPanel.getHeight()+200,300,40);
			setText("合计："+getTotalIncome()+"￥");
			setForeground(ColorPallet.Pink);
			setFont(FontSet.eighteen);
//			int total = getTotal();
		}
	}


	
}
