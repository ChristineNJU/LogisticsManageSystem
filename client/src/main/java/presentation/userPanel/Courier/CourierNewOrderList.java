package presentation.userPanel.Courier;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import VO.LogisticsInputVO;
import VO.VO;
import businesslogic.Impl.Courier.CourierController;
import businesslogic.Service.Courier.CourierService;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.main.FunctionAdd;
import presentation.table.RendererDelete;
import presentation.table.RendererReviseLogistics;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;

public class CourierNewOrderList extends FunctionAdd{

	CourierService service = new CourierController();
	ArrayList<LogisticsInputVO> logistics = new ArrayList<LogisticsInputVO>();
	
	String[] tableH = {"快递单号","出发地","目的地","内件品名","体积","重量","费用合计"};
	boolean[] isCellEditable = {false,false,false,false,false,false,false};
	CourierNewOrder newOrder;
	
	public CourierNewOrderList(){
		buttonNew = new ButtonNew("新增快递");
		confirm = new ButtonConfirm("提交所有订单");
		initUI("创建快递单");
		buttonNew.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				newItem();
				
			}
		});
	}
	
	@Override
	protected void initHeader() {
		return;
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
	
	protected void newItem(){
		newOrder = new CourierNewOrder(this);
		newOrder.getPanel().setLocation(0, 0);
		panel.add(newOrder.getPanel());
		panel.repaint();
	}

	public void cancelNewItem(){
		panel.remove(newOrder.getPanel());
		panel.repaint();
	}
}
