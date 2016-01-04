package presentation.userPanel.Finance;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.components.ButtonCancel;
import presentation.components.ButtonConfirm;
import presentation.components.PanelContent;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.frame.MainFrame;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;
import PO.CarInfoPO;
import State.ErrorState;
import State.InstitutionType;
import State.StorageArea;
import State.UpdateState;
import VO.AccountVO;
import VO.CarInfoVO;
import VO.InstitutionVO;
import VO.PeriodVO;
import VO.StaffVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import businesslogic.Impl.Finance.FinanceController;
import businesslogic.Impl.Manage.ManageController;
import businesslogic.Service.BusinessLobby.BsLbService;
import businesslogic.Service.Finance.FinanceService;
import businesslogic.Service.Manage.ManageService;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchCarInfoService;
import data.Service.Sundry.WareHouseService;

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
	
	AttentionFrame attentionFrame;
	
//	private FunctionListener listener = new FunctionListener();
	NavigationFinance nav;
	
	public FinanceInitial(NavigationFinance navigationFinance){
		panel = new PanelContent("期初信息");
		panel.setLayout(null);
		
		nav = navigationFinance;
		
		initial = new ButtonConfirm("新建期初");
		initial.setLocation(888-initial.getWidth(), 110);
		panel.add(initial);
		
//		int timeInitial = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//		if(timeInitial != 1){
//			initial.setEnabled(false);
//		}else{
			initial.addMouseListener(new MouseAdapter(){
				
				public void mouseClicked(MouseEvent e) {
					ManageService man = new ManageController();
					SearchCarInfoService car;
					WareHouseService ware;
					try {
						ware = (WareHouseService) Naming.lookup(RMIHelper.WAREHOUSE_IMPL);
						car = (SearchCarInfoService) Naming.lookup(RMIHelper.SEARCH_CARINFO_IMPL);
						
						ArrayList<InstitutionVO> ins_size = man.searchInstitution("%%");
						
						ArrayList<CarInfoVO> car_size = new ArrayList<CarInfoVO>();
						int storage_size = 0;
						for(InstitutionVO vo:ins_size){
							if(vo.getType()==InstitutionType.BusinessLobby){
								ArrayList<CarInfoPO> tmp;
								
								ArrayList<String> requirement = new ArrayList<String>();
								requirement.add("car_number like '%%'");
								
								tmp = car.searchCarInfo(URLHelper.getCarInfoURL(vo.getCode()), requirement);
								
								for(int i=0;i<tmp.size();i++){
									car_size.add(new CarInfoVO(tmp.get(i)));
								}
							}else if(vo.getType()==InstitutionType.Repository){
								storage_size = storage_size+ware.getAmount(URLHelper.getWareHouseURL(vo.getCode()), StorageArea.AIR_TRANSPORTATION);
							}
						}
						ArrayList<StaffVO> user_size = man.searchStaff("%%");
						ArrayList<AccountVO> acc = service.searchAccount("%%");
						
						PeriodVO pe = new PeriodVO(Calendar.getInstance().getTime(), ins_size.size(),
								user_size.size(), car_size.size(), storage_size, acc);
						
//						tableV = new Vector<Vector<String>>();
//						model = TableModelFactory.getInitialInfoModel(tableV);
//						table = TableFactory.getInitialInfoTable(model);
						
//						panel.repaint();
						
						UpdateState state = service.updatePeriod(pe);
						if(state==UpdateState.SUCCESS){
							nav.changeTask(6);
						}else{
							showError(ErrorState.UPDATEERROR);
							nav.changeTask(6);
						}
					} catch (MalformedURLException | RemoteException
							| NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
//		}
		
		initTable();
		
	}
	
	protected void initTable() {
		period = service.getPeriod();
		getVector(period);
		model = TableModelFactory.getInitialInfoModel(tableV);
		table = TableFactory.getInitialInfoTable(model);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}

	private void getVector(PeriodVO period){
//		period = service.getPeriod();
		
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
	
	public void showError(ErrorState state){
		
		attentionFrame=new AttentionFrame(state);
//		panel.add(attention);
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
	
	public class AttentionFrame extends JFrame implements Runnable{
		public AttentionFrame(ErrorState state){
			ImageIcon Image=null;
			if(state==ErrorState.CONNECTERROR){
				Image = new ImageIcon("src/graphics/Tips/connectError.png");
			}
			else if(state==ErrorState.DELETEERROR){
				Image = new ImageIcon("src/graphics/Tips/deleteError.png");
			}
			else if(state==ErrorState.UPDATEERROR){
				Image = new ImageIcon("src/graphics/Tips/updateError.png");
			}
			else if(state==ErrorState.SEARCHERROR){
				Image = new ImageIcon("src/graphics/Tips/searchError.png");
			}
			else if(state==ErrorState.ADDERROR){
				Image = new ImageIcon("src/graphics/Tips/addError.png");
			}
		    JLabel errorNote=new JLabel(Image);
			this.setUndecorated(true);
			this.setSize(150, 50);
			this.setLocation((int)(MainFrame.FRAME_X+MainFrame.FRAME_WIDTH/2),(int) (MainFrame.FRAME_Y+MainFrame.FRAME_HEIGHT/2));
			this.add(errorNote);
			this.setVisible(true);
			System.out.println("Error infomation");
//			run();
			Thread t = new Thread(this);
			t.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				System.out.println("staff error thread");
				Thread.sleep(1000);
				this.setVisible(true);
//				this.repaint();
				Thread.sleep(500);
				this. setVisible(false);
//				this.repaint();
//				System.exit(0);
				} catch (InterruptedException e) {
				 e.printStackTrace();
			}

		}
	}
}
