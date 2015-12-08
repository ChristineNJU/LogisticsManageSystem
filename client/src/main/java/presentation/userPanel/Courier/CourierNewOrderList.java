package presentation.userPanel.Courier;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonCancel;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.LabelHeader;
import presentation.frame.MainFrame;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.main.FunctionAdd;
import presentation.table.RendererDelete;
import presentation.table.RendererReviseLogistics;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import State.AddState;
import VO.LogisticsInputVO;
import VO.VO;
import businesslogic.Impl.Courier.CourierController;
import businesslogic.Service.Courier.CourierService;

public class CourierNewOrderList extends FunctionAdd{

	CourierService service = new CourierController();
	ArrayList<LogisticsInputVO> logistics = new ArrayList<LogisticsInputVO>();
	
	ArrayList<LogisticsInputVO> failedLogistics = new ArrayList<LogisticsInputVO>();
	
	String[] tableH = {"快递单号","出发地","目的地","内件品名","体积","重量","费用合计"};
	boolean[] isCellEditable = {false,false,false,false,false,false,false};
	
	Vector<Vector<String>> result = new Vector<Vector<String>>();
	
	CourierNewOrder newOrder;
	
	JLabel info = new JLabel("", JLabel.CENTER);
	
	TableModelAddOnly oldTableModelAddOnly;
	
	NavigationCourier nav;
	
	public CourierNewOrderList(final NavigationCourier nav){
		
		super.buttonNew = new ButtonNew("新增快递");
		super.confirm = new ButtonConfirm("提交所有订单");
		super.cancel = new ButtonCancel();

		this.nav = nav;
		
		oldTableModelAddOnly = model;
		
		initUI("创建快递单");
		
		buttonNew.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				newItem();
			}
		});
		confirm.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				for(int i=0;i<logistics.size();i++){
					AddState state = AddState.SUCCESS;
					state = service.addLogistics(logistics.get(i));
					if(state!=AddState.SUCCESS){
						failedLogistics.add(logistics.get(i));
					}
				}
				
				if(failedLogistics.isEmpty()){
//					InfomationPanel info = new InfomationPanel("提交成功");
//					Thread t = new Thread(info);
//					t.start();
					info.setText("提交成功！");
					nav.changeTask(1);
				}else{
					info.setText("提交失败");
				
					logistics = failedLogistics;
					failedLogistics = new ArrayList<LogisticsInputVO>();
					result = new Vector<Vector<String>>();
					
					for(int i=0;i<logistics.size();i++){
						result.add(getVector(logistics.get(i)));
					}
					
					table.setModel(new TableModelAddOnly(result, tableH, isCellEditable));
				
					MainFrame.getMainPanel().repaint();
				}
			}
		});
		
		cancel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				nav.changeTask(1);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		info.setBounds(500, 590, 100, 50);
		info.setForeground(ColorPallet.Pink);
		info.setFont(FontSet.eighteen);
		
		this.getPanel().add(info);
	}
	
	@Override
	protected void initHeader() {
		header = new Header();
		panel.add(header);
	}

	@Override
	protected void initTable() {
//		tableV 
		
		model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		table = new TableAddOnly(model);
		
		TableColumnModel tcm = table.getColumnModel();
		
		tcm.addColumn(new TableColumn());
		tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererReviseLogistics());
//		tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(40);
		
		tcm.addColumn(new TableColumn());
		tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererDelete());
		tcm.getColumn(tcm.getColumnCount()-1).setPreferredWidth(40);
		
		table.addMouseListener(tableListener);
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}

	@Override
	protected void confirmAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Vector<String> getVector(LogisticsInputVO vo) {
		Vector<String> v = new Vector<String>();
		v.add(vo.getBar_code());
		v.add(vo.getStarting());
		v.add(vo.getDestination());
		v.add(vo.getInternal_name());
		v.add(vo.getSize()+"");
		v.add(vo.getWeight()+"");
		v.add(vo.getTotal_cost()+"");
		
		return v;
	}
	
	protected void newItem(){
		newOrder = new CourierNewOrder(this);
//		MainFrame.getMainPanel().remove(panel);
//		MainFrame.getMainPanel().add(newOrder.getPanel());
//		MainFrame.getMainPanel().repaint();
		MainFrame.changeContentPanel(newOrder.getPanel());
//		panel.add(newOrder.getPanel());
//		panel.repaint();
	}
	
	public void addItem(LogisticsInputVO vo) {
		
		if(vo!=null){			
			logistics.add(vo);
			Vector<String> v = getVector(vo);
			result.add(v);
			table.setModel(new TableModelAddOnly(result, tableH, isCellEditable));
		}else{
			
		}
		table.repaint();
	}

	public void cancelNewItem(){
//		panel.remove(newOrder.getPanel());
//		MainFrame.getMainPanel().remove(newOrder.getPanel());
//		MainFrame.getMainPanel().add(this.getPanel());
		MainFrame.changeContentPanel(this.getPanel());
//		panel.repaint();
		MainFrame.getMainPanel().repaint();
	}

	class Header extends JLabel {
		
		LabelHeader date = new LabelHeader("接件日期：");
		Header() {
			setBounds(120, 100, 400,30);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date.addInfo(sdf.format(Calendar.getInstance().getTime()));
			
			date.setBounds(0, 0, 400, 30);
			add(date);
		}
	}
	
//	class InfomationPanel extends JPanel implements Runnable {
//		
//		JLabel label;
//		
//		public InfomationPanel(String information) {
//			// TODO Auto-generated constructor stub
//			label = new JLabel(information, JLabel.CENTER);
//			MainFrame.getMainPanel().add(this);
//		}
//		
//		private void init() {
//			setBounds(400, -100, 100, 100);
//			setLayout(null);
//			
//			label.setBounds(25, 15, 70, 50);
//			label.setFont(FontSet.fourteen);
//			label.setForeground(ColorPallet.Pink);
//			
//			add(label);
//		}
//		
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			int i = 0;
//			while(i<100){
//				System.out.println(i);
//				setBounds(400, i-100, 100, 100);
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				repaint();
//				i++;
//			}
//			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			while(i>=0){
//				setBounds(400, i-100, 100, 100);
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				repaint();
//				i--;
//			}
//		}
//	}
}
