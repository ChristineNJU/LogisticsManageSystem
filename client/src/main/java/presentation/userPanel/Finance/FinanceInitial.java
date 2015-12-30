package presentation.userPanel.Finance;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JPanel;

import State.AddState;
import VO.AccountVO;
import VO.PeriodVO;
import businesslogic.Impl.Finance.FinanceController;
import businesslogic.Service.Finance.FinanceService;
import presentation.components.ButtonCancel;
import presentation.components.ButtonConfirm;
import presentation.components.PanelContent;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class FinanceInitial{

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	FinanceService service = new FinanceController();
	PeriodVO period;
	
	private PanelContent panel;
	private ButtonConfirm initial;
	private ScrollPaneTable sPanel;
	private Vector<Vector<String>> tableV = new Vector<Vector<String>>();
	private TableModelSearch model;
	private TableSearch table;
	private TableModelAddOnly modelRevise;
	private TableAddOnly tableRevise;
	
	protected ButtonConfirm confirm;
	protected ButtonCancel cancel;
	
	boolean canInitial;
	
//	private FunctionListener listener = new FunctionListener();
	
	
	public FinanceInitial(){
		panel = new PanelContent("期初信息");
		panel.setLayout(null);
		
		initial = new ButtonConfirm("新建期初");
		initial.setLocation(888-initial.getWidth(), 110);
		panel.add(initial);
		
		int timeInitial = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		if(timeInitial != 1){
			initial.setEnabled(false);
		}else{
			initial.addMouseListener(new MouseAdapter(){
				
				public void mouseClicked(MouseEvent e) {
					
				}
			});
		}
		
		initTable();
		
	}
	
	protected void initTable() {
		getVector();
		model = TableModelFactory.getInitialInfoModel(tableV);
		table = TableFactory.getInitialInfoTable(model);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}

	private void getVector(){
		period = service.getPeriod();
		
		Vector<String> temp1 = new Vector<String>();
		temp1.add("时间");
		temp1.add(sdf.format(period.getDate()));
		Vector<String> temp2 = new Vector<String>();
		temp2.add("机构数量");
		temp2.add(period.getInstitution_size()+"");
		Vector<String> temp3 = new Vector<String>();
		temp3.add("员工数量");
		temp3.add(period.getStaff_size()+"");
		Vector<String> temp4 = new Vector<String>();
		temp4.add("货车数量");
		temp4.add(period.getCar_size()+"");
		Vector<String> temp5 = new Vector<String>();
		temp5.add("仓库当前包裹数量");
		temp5.add(period.getStorage_size()+"");

		tableV.add(temp1);
		tableV.add(temp2);
		tableV.add(temp3);
		tableV.add(temp4);
		tableV.add(temp5);
		for(AccountVO account:period.getAccount()){
			Vector<String> temp = new Vector<String>();
			temp.add(account.getName());
			temp.add(account.getMoney()+"");
			tableV.add(temp);
		}
		
	}
	
//	private void revise(){
//		confirm = new ButtonConfirm("提交修改");
//		cancel = new ButtonCancel();
//		panel.add(confirm);
//		panel.add(cancel);
//		
//		Vector<Vector<String>> tableV2 = new Vector<Vector<String>>();
//		Vector<String> temp1 = new Vector<String>();
//		temp1.add("时间");
//		Date now = Calendar.getInstance().getTime();
//		temp1.add(sdf.format(now));
//		Vector<String> temp2 = new Vector<String>();
//		temp2.add("机构数量");
//		Vector<String> temp3 = new Vector<String>();
//		temp3.add("员工数量");
//		Vector<String> temp4 = new Vector<String>();
//		temp4.add("货车数量");
//		Vector<String> temp5 = new Vector<String>();
//		temp5.add("仓库当前包裹数量");
//		
//		tableV2.add(temp1);
//		tableV2.add(temp2);
//		tableV2.add(temp3);
//		tableV2.add(temp4);
//		tableV2.add(temp5);
//		
//		modelRevise = TableModelFactory.getInitialReviseModel(tableV);
//		tableRevise = TableFactory.getInitialReviseTable(modelRevise);
//		panel.remove(sPanel);
//		sPanel = new ScrollPaneTable(tableRevise);
//		panel.add(sPanel);
//		
//		confirm.addMouseListener(new MouseAdapter(){
//			public void mouseClicked(MouseEvent e) {
//				
//				PeriodVO newPeriod = new Period(tableV2.get(0).get(1),Integer.parseInt(tableV2.get(1).get(1)),
//						Integer.parseInt(tableV2.get(2).get(1)),Integer.parseInt(tableV2.get(3).get(1)),)
//				AddState addState = service.addPeriod();
//			}
//		});
//		
//	}
	public JPanel getPanel(){
		return panel;
	}
}
