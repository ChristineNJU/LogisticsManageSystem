package presentation.userPanel.Finance;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;

import State.ErrorState;
import VO.LogVO;
import businesslogic.Impl.Finance.FinanceController;
import businesslogic.Service.Finance.FinanceService;
import presentation.components.ButtonConfirm;
import presentation.components.DateChooser;
import presentation.components.LabelHeader;
import presentation.main.FunctionSearch;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class FinanceSystem extends FunctionSearch{

	FinanceService service = new FinanceController();
	String[] tableH = {"操作日期","操作类型","操作人员"};
	
	ArrayList<LogVO> logs;
	
	public DateChooser dateBeginChooser;
	public DateChooser dateEndChooser;
	
	public FinanceSystem(){
		confirmSearch = new ButtonConfirm("查看系统日志");
		initUI("系统日志查看");
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
		panel.add(sPanel);
		
	}

	@Override
	protected void initFooter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showSearch() {
		String timeBegin = dateBeginChooser.getTime();
		String timeEnd = dateEndChooser.getTime();
		logs = service.getLog(timeBegin, timeEnd);
		if(logs==null){
			showError(ErrorState.CONNECTERROR);
			tableV=new Vector<Vector<String>>();
		}
		else if(logs.isEmpty()){
			tableV = getVector(logs);
			showError(ErrorState.SEARCHERROR);
		}
		else {
			tableV = getVector(logs);
		}
		
		model = new TableModelSearch(tableV,tableH);
		table.setModel(model);
		table.repaint();
		
	}
	
	protected Vector<Vector<String>> getVector(ArrayList<LogVO> logs2) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
        for(LogVO temp:logs2){
        	Vector<String> vRow = new Vector<String>();
        	vRow.add(temp.getTime()+"");
        	vRow.add(temp.getOperation());
        	vRow.add(temp.getOperator());
        }
		return result;
	}
	
	private class Header extends JLabel{
		LabelHeader dateBegin = new LabelHeader("开始日期:");
		LabelHeader dateEnd = new LabelHeader("结束日期:");
		
		public Header(){
			this.setBounds(120,115,770,30);
			
			dateBegin.setBounds(0,0,80,30);
			this.add(dateBegin);
			dateEnd.setBounds(270,0,80,30);
			this.add(dateEnd);
		}
	}
	
}
