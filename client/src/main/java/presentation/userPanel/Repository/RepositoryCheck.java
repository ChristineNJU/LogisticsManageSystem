package presentation.userPanel.Repository;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;

import State.ErrorState;
import VO.RemovalVO;
import VO.StorageVO;
import businesslogic.Impl.Repository.RepositoryController;
import businesslogic.Service.Repository.RepositoryService;
import presentation.components.ButtonConfirm;
import presentation.components.DateChooser;
import presentation.components.LabelHeader;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.main.FunctionSearch;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class RepositoryCheck extends FunctionSearch{

	ArrayList<StorageVO> storages = new ArrayList<StorageVO>();
	ArrayList<RemovalVO> removals = new ArrayList<RemovalVO>();
	
	public DateChooser dateBeginChooser;
	public DateChooser dateEndChooser;
	
	private ProgressBarPanel pbp = new ProgressBarPanel();
	
	RepositoryService service = new RepositoryController();
	
	protected ScrollPaneTable sPanel2;
	protected Vector<Vector<String>> tableV2 = new Vector<Vector<String>>();
	protected TableModelSearch model2;
	protected TableSearch table2;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	private LabelHeader errorTime = new LabelHeader("开始时间需在结束时间之前!!");
	
	public RepositoryCheck(){
		confirmSearch = new ButtonConfirm("查看出库入库记录");
		initUI("查看出库入库记录");
		
		panel.add(pbp.getPanel());
		errorTime.setBounds(120,90,300,40);
		errorTime.setForeground(Color.red);
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
		tableV = getVector(storages);
		model = TableModelFactory.getRemovalSearchModel(tableV);
		table = TableFactory.getRemovalSearchTable(model);
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		sPanel.setSize(sPanel.getWidth(),250);
		panel.add(sPanel);
		
		tableV2 = getVector2(removals);
		model2 = TableModelFactory.getStorageSearchModel(tableV2);
		table2 = TableFactory.getStorageSearchTable(model2);
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
		panel.repaint();
		String timeBegin = dateBeginChooser.getTime();
		String timeEnd = dateEndChooser.getTime();
		if(timeBegin.compareTo(timeEnd) >= 0){

//			showError("开始时间需要在结束时间之前");

			showErrorTime();

		}else{
			storages = service.seeStorage(timeBegin, timeEnd);
			removals = service.seeRemoval(timeBegin, timeEnd);
			if(storages==null||removals==null){
				showError(ErrorState.CONNECTERROR);
				storages=new ArrayList<StorageVO>();
				removals=new ArrayList<RemovalVO>();
			}
			else{
				if(storages.isEmpty()&&removals.isEmpty()){
					showError(ErrorState.SEARCHERROR);
				}
			}
			model = TableModelFactory.getRemovalSearchModel(getVector(storages));
			table.setModel(model);
			table.repaint();
			model2 = TableModelFactory.getStorageSearchModel(getVector2(removals));
			table2.setModel(model2);
			table2.repaint();
		}
	}
	
	private void showErrorTime(){
		panel.add(errorTime);
		panel.repaint();
	}
	
	protected Vector<Vector<String>> getVector(ArrayList<StorageVO> storages) {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
        for(StorageVO temp:storages){
        	Vector<String> vRow = new Vector<String>();
        	
        	vRow.add(format.format(temp.getStorageDate()));
        	vRow.add(trans.getChineseForStorageArea(temp.getAreaCode()));
        	vRow.add("架号"+temp.getShelf()+"");
        	vRow.add("排号"+temp.getRow()+"");
        	vRow.add("位号"+temp.getPosition()+"");
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
        	vRow.add(trans.getChineseTransferType(temp.getTransferWay()));
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
