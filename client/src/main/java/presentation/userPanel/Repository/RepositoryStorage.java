package presentation.userPanel.Repository;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import presentation.components.ButtonCancel;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.FlatScrollPane;
import presentation.components.PanelContent;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;
import State.StateSwitch;
import State.StorageArea;
import State.StorageState;
import VO.StorageVO;
import businesslogic.Impl.Repository.RepositoryController;
import businesslogic.Service.Repository.ReponsitoryService;

public class RepositoryStorage {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	ReponsitoryService service = new RepositoryController();
	
	private ProgressBarPanel pbp = new ProgressBarPanel();
	
	private PanelContent panel = new PanelContent("入库");
	
	private JLabel arrival_date = new JLabel("入库日期:", JLabel.CENTER);
	private JLabel arrival_date_actual = new JLabel();
	
	protected ButtonNew buttonNew = new ButtonNew("添加入库单");
	protected ButtonConfirm buttonConfirm = new ButtonConfirm("提交入库单");
	protected ButtonCancel buttonCancel = new ButtonCancel();
	
	String[] tableH = {"快递编号", "到达地", "区号", "排号", "架号", "位号", ""};
	boolean[] isCellEditable = {true, true, true, true, true, true, false};
	
	private TableADUS table;
	private TableModelADUS tableModel;
	private FlatScrollPane scrollPane;
	
	ArrayList<StorageVO> storage_air = new ArrayList<StorageVO>();
	ArrayList<StorageVO> storage_car = new ArrayList<StorageVO>();
	ArrayList<StorageVO> storage_rail = new ArrayList<StorageVO>();
	
	Vector<Vector<String>> vector = new Vector<Vector<String>>();
	
	AddListener addListener = new AddListener();
	
	JLabel info = new JLabel("", JLabel.CENTER);
	
	public RepositoryStorage() {
		
		Vector<String> v = new Vector<String>();
		for(int i=0;i<6;i++){
			v.add("");
		}
		vector.add(v);
		
		init();
		initListener();
	}
	
	private void init() {
		panel.setLayout(null);
		panel.add(pbp.getPanel());
	
		arrival_date.setBounds(108, 125, 100, 50);
		arrival_date.setForeground(ColorPallet.Purple);
		arrival_date.setFont(FontSet.twenty);
		panel.add(arrival_date);
		
		
		arrival_date_actual.setText(sdf.format(Calendar.getInstance().getTime()));
		arrival_date_actual.setBounds(218, 125, 250, 50);
		arrival_date_actual.setForeground(ColorPallet.Purple);
		arrival_date_actual.setFont(FontSet.twenty);
		panel.add(arrival_date_actual);
		
		buttonNew.setBounds(645, 135, buttonNew.getWidth(), buttonNew.getHeight());
		panel.add(buttonNew);
		
		tableModel = new TableModelADUS(vector, tableH, isCellEditable);
		table = new TableADUS(tableModel);
		
		scrollPane = new FlatScrollPane(table);
		scrollPane.setBounds(117, 170, 673, 430);
		scrollPane.setBorder(new LineBorder(Color.black, 0));
		scrollPane.setOpaque(false);
		panel.add(scrollPane);
		
		buttonConfirm.setBounds(117, 610, buttonCancel.getWidth(), buttonConfirm.getHeight());
		panel.add(buttonConfirm);
		
		buttonCancel.setBounds(277, 610, buttonCancel.getWidth(), buttonConfirm.getHeight());
		panel.add(buttonCancel);
		
		info.setBounds(480, 600, 100, 50);
		info.setForeground(Color.red);
		info.setFont(FontSet.twenty);
		panel.add(info);
	}
	
	private void initListener() {
		buttonNew.addMouseListener(addListener);
		buttonConfirm.addMouseListener(addListener);
		buttonCancel.addMouseListener(addListener);
	}
	
	public JPanel getPanel() {
		return panel;
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
	
	private StorageVO getVO(Vector<String> vector) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StorageVO vo = new StorageVO(vector.get(0), Calendar.getInstance().getTime(),
				vector.get(1), StateSwitch.switchToStorageArea(vector.get(2)), Integer.parseInt(vector.get(3))
				, Integer.parseInt(vector.get(4)), Integer.parseInt(vector.get(5)));
		return vo;
	}
	
	class AddListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(buttonNew)){
				tableModel.addEmptyRow();
				table.repaint();
			}else if(e.getSource().equals(buttonConfirm)){
				
				if(pbp.a>=95||pbp.c>=95||pbp.r>=95){
					info.setText("请调整库存！");
				}else{					
					for(int i=0;i<tableModel.getRowCount();i++){
						
						StorageArea area = StateSwitch.switchToStorageArea(tableModel.getRow(i).get(2));
						
						if(area==StorageArea.AIR_TRANSPORTATION){						
							storage_air.add(getVO(tableModel.getRow(i)));
						}else if(area==StorageArea.CAR_TRANSPORTATION){
							storage_car.add(getVO(tableModel.getRow(i)));
						}else if(area==StorageArea.RAILWAY_TRANSPORTATION){
							storage_rail.add(getVO(tableModel.getRow(i)));
						}
						
					}
					StorageState state = StorageState.SUCCESS;
					state = service.storage(storage_air);
					
					if(state==StorageState.CONNECTERROR){
						info.setText("连接错误");
					}else if(state==StorageState.SUCCESS){
						info.setText("提交成功");
					}else if(state==StorageState.FAIL){
						info.setText("提交失败");
					}
					
					pbp = new ProgressBarPanel();
					panel.add(pbp.getPanel());
					
					panel.repaint();
				}
			}
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
		
	}
}
