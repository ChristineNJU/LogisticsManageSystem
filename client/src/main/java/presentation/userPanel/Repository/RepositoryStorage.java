package presentation.userPanel.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.LabelHeader;
import presentation.main.FunctionAdd;
import presentation.table.RendererDelete;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;
import State.StateSwitch;
import VO.StorageVO;
import businesslogic.Impl.Repository.RepositoryController;
import businesslogic.Service.Repository.ReponsitoryService;

public class RepositoryStorage extends FunctionAdd {

	ReponsitoryService service = new RepositoryController();
	
	String[] tableH = {"快递编号", "到达地", "区号", "排号", "架号", "位号"};
	boolean[] isCellEditable = {true, true, true, true, true, true};
	
	ArrayList<StorageVO> storage = new ArrayList<StorageVO>();
	
	Vector<Vector<String>> vector = new Vector<Vector<String>>();
	
	boolean isSaved = false;
	
	public RepositoryStorage() {
		super.buttonNew = new ButtonNew("新增入库单");
		super.confirm = new ButtonConfirm("提交入库单");
		initUI("入库");
	}
	
	@Override
	protected void initHeader() {
		// TODO Auto-generated method stub
		header = new Header();
		panel.add(header);
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		model = new TableModelAddOnly(vector, tableH, isCellEditable);
		table = new TableAddOnly(model);
		
//		TableColumnModel tcm = table.getColumnModel();
//		tcm.addColumn(new TableColumn());
//		tcm.getColumn(tcm.getColumnCount()-1).setCellRenderer(new RendererDelete());
//		tcm.getColumn(tcm.getColumnCount()-1).setCellEditor(new ));
		
		sPanel = new ScrollPaneTable(table);
		panel.add(sPanel);
	}

	@Override
	protected void confirmAll() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	protected StorageVO getVO(Vector<String> vector) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StorageVO vo = new StorageVO(vector.get(0), Calendar.getInstance().getTime(),
				vector.get(1), StateSwitch.switchToStorageArea(vector.get(2)), Integer.parseInt(vector.get(3))
				, Integer.parseInt(vector.get(4)), Integer.parseInt(vector.get(5)));
		return vo;
	}
	
	private Vector<String> getVector(StorageVO vo) {
		Vector<String> result = new Vector<String>();
		result.add(vo.getBarCode());
		result.add(vo.getAreaCode()+"");
		result.add(vo.getRow()+"");
		result.add(vo.getShelf()+"");
		result.add(vo.getPosition()+"");
		return result;
	}
	
	private class Header extends JLabel {
		LabelHeader date = new LabelHeader("入库日期");
		public Header() {
			// TODO Auto-generated constructor stub
			setBounds(120, 100, 680, 30);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date.addInfo(sdf.format(Calendar.getInstance().getTime()));
			
			date.setBounds(0, 0, 400, 30);
			add(date);
		}
	}
}
