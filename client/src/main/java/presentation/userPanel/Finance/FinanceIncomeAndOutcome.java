package presentation.userPanel.Finance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;

import VO.BenefitVO;
import VO.CostVO;
import businesslogic.Impl.Finance.FinanceController;
import businesslogic.Service.Finance.FinanceService;
import presentation.components.ButtonConfirm;
import presentation.components.DateChooser;
import presentation.components.LabelHeader;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.main.FontSet;
import presentation.main.FunctionSearch;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class FinanceIncomeAndOutcome extends FunctionSearch{

	FinanceService service = new FinanceController();
	ArrayList<BenefitVO> benefits;
	
	public DateChooser dateBeginChooser;
	public DateChooser dateEndChooser;
	String dateInitial = Calendar.getInstance().get(Calendar.YEAR)+"-"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"-01";
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String dateNow = format.format(Calendar.getInstance().getTime());
	
	public FinanceIncomeAndOutcome(){
		confirmSearch = new ButtonConfirm("查看经营情况");
		initUI("经营情况查看");
	}
	
	@Override
	protected void initHeader() {
//		dateBeginChooser = new DateChooser(panel,210,120);
//		dateEndChooser = new DateChooser(panel,480,120);
		header = new Header();
		panel.add(header);
		
	}

	@Override
	protected void initTable() {
//		tableV = getVector(service.searchBenefit(dateNow));
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DATE, 1);
		String searchDate = format.format(rightNow.getTime());
		ArrayList<BenefitVO> benefit = service.searchBenefit(searchDate);
		
		tableV = getVector(benefit);
		model = TableModelFactory.getIncomeAndOutcomeModel(tableV);
		table = TableFactory.getOutcomeAndIncomeTable(model);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
		
	}

	private Vector<Vector<String>> getVector(ArrayList<BenefitVO> benefitVO) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
        for(BenefitVO temp:benefitVO){
        	Vector<String> vRow = new Vector<String>();
        	vRow.add(format.format(temp.getDate())+"");
        	vRow.add(temp.getIncome()+"");
        	vRow.add(temp.getCost()+"");
        	vRow.add(temp.getBenefit()+"");
        	
        	result.add(vRow);
        }
		return result;
	}

	@Override
	protected void initFooter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showSearch() {
		// TODO Auto-generated method stub
		
	}

	private class Header extends JLabel{
		LabelHeader dateBegin = new LabelHeader("期初日期:");
		LabelHeader dateEnd = new LabelHeader("当前日期:");
		
		public Header(){
			this.setBounds(120,115,770,30);
			
//			String timeInitial = Calendar.getInstance().get(Calendar.YEAR)+"-01-01";
			dateBegin.addInfo(dateInitial);
			dateBegin.setFont(FontSet.twenty);
			dateBegin.setBounds(0,0,200,30);
			this.add(dateBegin);
			

//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			String dateNow = format.format(Calendar.getInstance().getTime());
			dateEnd.addInfo(dateNow);
			dateBegin.setFont(FontSet.twenty);
			dateEnd.setBounds(270,0,200,30);
			this.add(dateEnd);
		}
	}

}
