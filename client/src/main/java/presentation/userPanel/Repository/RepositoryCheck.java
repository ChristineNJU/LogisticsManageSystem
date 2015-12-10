package presentation.userPanel.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;

import VO.RemovalVO;
import VO.StorageVO;
import businesslogic.Impl.Repository.RepositoryController;
import businesslogic.Service.Repository.RepositoryService;
import presentation.components.ButtonConfirm;
import presentation.components.DateChooser;
import presentation.components.LabelHeader;
import presentation.main.FunctionSearch;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class RepositoryCheck extends FunctionSearch{

	ArrayList<StorageVO> storages;
	ArrayList<RemovalVO> removals;
	
	public DateChooser dateBeginChooser;
	public DateChooser dateEndChooser;
	
	private ProgressBarPanel pbp = new ProgressBarPanel();
	
	RepositoryService service = new RepositoryController();
	String[] tableH = {"入库记录","   ","   ","   ","   ","  ","   "};
	
	String[] tableH2 = {"出库记录","   ","   ","   ","   "};
	protected ScrollPaneTable sPanel2;
	protected Vector<Vector<String>> tableV2 = new Vector<Vector<String>>();
	protected TableModelSearch model2;
	protected TableSearch table2;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	private LabelHeader errorTime = new LabelHeader("开始时间需在结束时间之前");
	
	public RepositoryCheck(){
		confirmSearch = new ButtonConfirm("查看出库入库记录");
		initUI("查看出库入库记录");
		
		panel.add(pbp.getPanel());
		errorTime.setBounds(500,0,200,40);
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
		sPanel.setSize(sPanel.getWidth(),250);
		panel.add(sPanel);
		
		tableV2 = new Vector<Vector<String>>();
		model2 = new TableModelSearch(tableV2,tableH2);
		table2 = new TableSearch(model2);
		sPanel2 = new ScrollPaneTable(table2);
		sPanel2.setLocation(sPanel.getX(),sPanel.getHeight()+header.getHeight()+150);
		sPanel2.setSize(sPanel.getWidth(),300);
		panel.add(sPanel2);
		
//		tableV = service.seeRemoval(time_start, time_end)
	}

	@Override
	protected void initFooter() {
		
	}

	@Override
	protected void showSearch() {
		panel.remove(errorTime);
		String timeBegin = dateBeginChooser.getTime();
		String timeEnd = dateEndChooser.getTime();
		if(timeBegin.compareTo(timeEnd) >= 0){
			showErrorTime();
		}else{
			storages = service.seeStorage(timeBegin, timeEnd);
			removals = service.seeRemoval(timeBegin, timeEnd);
			model = new TableModelSearch(getVector(storages),tableH);
			table.setModel(model);
			table.repaint();
			model2 = new TableModelSearch(getVector2(removals),tableH2);
			table2.setModel(model2);
			table2.repaint();
		}
	}
	
	private void showErrorTime(){
//		LabelHeader errorTime = new LabelHeader("开始时间需在结束时间之前");
//		errorTime.setBounds(500,0,200,40);
		panel.add(errorTime);
	}
	
	protected Vector<Vector<String>> getVector(ArrayList<StorageVO> storages) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
        for(StorageVO temp:storages){
        	Vector<String> vRow = new Vector<String>();
        	
        	vRow.add(format.format(temp.getStorageDate()));
        	vRow.add(temp.getAreaCode()+"");
        	vRow.add(temp.getShelf()+"");
        	vRow.add(temp.getRow()+"");
        	vRow.add(temp.getPosition()+"");
        	vRow.add(temp.getBarCode());
        	vRow.add(temp.getDestination());
        	
        	result.add(vRow);
        }
		return result;
	}

	protected Vector<Vector<String>> getVector2(ArrayList<RemovalVO> removals) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
        for(RemovalVO temp:removals){
        	Vector<String> vRow = new Vector<String>();

        	vRow.add(format.format(temp.getOutDate()));
        	vRow.add(temp.getBarCode());
        	vRow.add(temp.getDestination());
        	vRow.add(temp.getTransferWay()+"");
        	vRow.add(temp.getTransferCode());
        	result.add(vRow);
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
