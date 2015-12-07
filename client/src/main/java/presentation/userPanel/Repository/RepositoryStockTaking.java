package presentation.userPanel.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;

import State.AddState;
import State.StorageArea;
import VO.StockTakingVO;
import presentation.components.ButtonConfirm;
import presentation.components.LabelHeader;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;

public class RepositoryStockTaking extends RepositoryCheck{

	String[] tableH = {"航空区","   ","   ","   ","   ","   "};
	String[] tableH2 = {"火车区","   ","   ","   ","   ","   "};
	String[] tableH3 = {"汽运区","   ","   ","   ","   ","   "};
	
	ArrayList<StockTakingVO> stockTaking = new ArrayList<StockTakingVO>();
	
	protected ScrollPaneTable sPanel2;
	protected Vector<Vector<String>> tableV2 = new Vector<Vector<String>>();
	protected TableModelSearch model2;
	protected TableSearch table2;
	
	protected ScrollPaneTable sPanel3;
	protected Vector<Vector<String>> tableV3 = new Vector<Vector<String>>();
	protected TableModelSearch model3;
	protected TableSearch table3;
	
	public RepositoryStockTaking(){
		confirmSearch = new ButtonConfirm("提交库存盘点");
		initUI("库存盘点");
	}
	
	@Override
	protected void initHeader() {
		header = new Header();
		panel.add(header);
	}

	@Override
	protected void initTable() {
		stockTaking = service.getStockTaking();
		getStockTaking(stockTaking);
		
		model = new TableModelSearch(tableV,tableH);
		table = new TableSearch(model);
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		sPanel.setSize(sPanel.getWidth(),180);
		panel.add(sPanel);
		
		model2 = new TableModelSearch(tableV2,tableH2);
		table2 = new TableSearch(model2);
		sPanel2 = new ScrollPaneTable(table2);
		sPanel2.setLocation(sPanel.getX(),sPanel.getHeight()+header.getHeight()+150);
		sPanel2.setSize(sPanel.getWidth(),180);
		panel.add(sPanel2);
		
		model3 = new TableModelSearch(tableV3,tableH3);
		table3 = new TableSearch(model3);
		sPanel3 = new ScrollPaneTable(table3);
		sPanel3.setLocation(sPanel.getX(),sPanel.getHeight()+sPanel2.getHeight()+header.getHeight()+180);
		sPanel3.setSize(sPanel.getWidth(),180);
		panel.add(sPanel3);
	}

	protected void getStockTaking(ArrayList<StockTakingVO> stockTaking) {
        for(StockTakingVO temp:stockTaking){
        	Vector<String> vRow = new Vector<String>();
        	
        	vRow.add(format.format(temp.getStorageDate()));
        	vRow.add(temp.getShelf()+"");
        	vRow.add(temp.getRow()+"");
        	vRow.add(temp.getPosition()+"");
        	vRow.add(temp.getBarCode());
        	vRow.add(temp.getDestination());
        	
        	StorageArea area = temp.getAreaCode();
        	if(area.equals(StorageArea.AIR_TRANSPORTATION)){
        		tableV.add(vRow);
        	}else if(area.equals(StorageArea.RAILWAY_TRANSPORTATION)){
        		tableV2.add(vRow);
        	}else if(area.equals(StorageArea.CAR_TRANSPORTATION)){
        		tableV3.add(vRow);
        	}
        }
	}
	
	@Override
	protected void initFooter() {
	}

	@Override
	protected void showSearch() {
		AddState state = service.stockTakingConfirm(stockTaking);		
	}
	
	private class Header extends JLabel{
		LabelHeader date = new LabelHeader("当前日期:");
//		LabelHeader dateEnd = new LabelHeader("结束日期:");
		
		public Header(){
			this.setBounds(120,115,770,30);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dateNow = format.format(Calendar.getInstance().getTime());
			date.addInfo(dateNow);
			date.setBounds(0,0,80,30);
			this.add(date);
		}
	}

}
