package presentation.userPanel.Repository;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;

import presentation.components.ButtonConfirm;
import presentation.components.LabelHeader;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.table.ScrollPaneTable;
import presentation.table.TableModelSearch;
import presentation.table.TableSearch;
import State.AddState;
import State.ErrorState;
import State.OutputState;
import State.StorageArea;
import VO.StockTakingVO;
import VO.WareHouseVO;
import businesslogic.Impl.Repository.BlWareHouseImpl;
import businesslogic.Impl.Repository.StockTakingExcelImpl;
import businesslogic.Service.Repository.BlWareHouseService;
import businesslogic.Service.Repository.StockTakingExcelService;

public class RepositoryStockTaking extends RepositoryCheck{

	BlWareHouseService wareHouse = new BlWareHouseImpl();
	
	
	ArrayList<StockTakingVO> stockTaking = new ArrayList<StockTakingVO>();
	
	ArrayList<WareHouseVO> total = new ArrayList<WareHouseVO>();
	ArrayList<WareHouseVO> air = new ArrayList<WareHouseVO>();
	ArrayList<WareHouseVO> car = new ArrayList<WareHouseVO>();
	ArrayList<WareHouseVO> rail = new ArrayList<WareHouseVO>();
	
	protected ScrollPaneTable sPanel2;
	protected Vector<Vector<String>> tableV2 = new Vector<Vector<String>>();
	protected TableModelSearch model2;
	protected TableSearch table2;
	
	protected ScrollPaneTable sPanel3;
	protected Vector<Vector<String>> tableV3 = new Vector<Vector<String>>();
	protected TableModelSearch model3;
	protected TableSearch table3;
	
	private ButtonConfirm output = new ButtonConfirm("导出excel表格");
	private StockTakingExcelService excelService = new StockTakingExcelImpl();
	
	private ProgressBarPanel pbp = new ProgressBarPanel();
	
	public RepositoryStockTaking(){
		confirmSearch = new ButtonConfirm("提交库存盘点");
		initUI("库存盘点");
		init();
		
		panel.add(pbp.getPanel());
		
		output.setBounds(508, 110, 180, 30);
		output.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				OutputState state = excelService.stockTakingExcel(stockTaking);
				if(state==OutputState.SUCCESS){					
					showError(ErrorState.SUCCESS);
				}else{
					showError(ErrorState.ADDERROR);
				}
			}
		});
		
		panel.add(output);
	}
	
	private void init() {
		total = wareHouse.getWareHouse();
		for(WareHouseVO vo: total){
			if(vo.getArea_code()==StorageArea.AIR_TRANSPORTATION){
				air.add(vo);
			}else if(vo.getArea_code()==StorageArea.CAR_TRANSPORTATION){
				car.add(vo);
			}else if(vo.getArea_code()==StorageArea.RAILWAY_TRANSPORTATION){
				rail.add(vo);
			}
		}
		
		tableV = getWareHouseVector(air);
		tableV2 = getWareHouseVector(rail);
		tableV3 = getWareHouseVector(car);
		
		model = TableModelFactory.getStockTakingAir(tableV);
		table.setModel(model);
		table.repaint();
		
		model2 = TableModelFactory.getStockTakingRailway(tableV2);
		table2.setModel(model2);
		table2.repaint();
		
		model3 = TableModelFactory.getStockTakingBus(tableV3);
		table3.setModel(model3);
		table3.repaint();
	}
	
	@Override
	protected void initHeader() {
		header = new Header();
		panel.add(header);
	}

	@Override
	protected void initTable() {
		
		model = TableModelFactory.getStockTakingAir(tableV);
		table = TableFactory.getStockTakingAir(model);
		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		sPanel.setSize(sPanel.getWidth(),170);
		panel.add(sPanel);
		
		model2 = TableModelFactory.getStockTakingRailway(tableV2);
		table2 = TableFactory.getStockTakingRailway(model2);
		sPanel2 = new ScrollPaneTable(table2);
		sPanel2.setLocation(sPanel.getX(),sPanel.getHeight()+header.getHeight()+140);
		sPanel2.setSize(sPanel.getWidth(),170);
		panel.add(sPanel2);
		
		model3 = TableModelFactory.getStockTakingBus(tableV3);
		table3 = TableFactory.getStockTakingBus(model3);
		sPanel3 = new ScrollPaneTable(table3);
		sPanel3.setLocation(sPanel.getX(),sPanel.getHeight()+sPanel2.getHeight()+header.getHeight()+170);
		sPanel3.setSize(sPanel.getWidth(),170);
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
		for(WareHouseVO vo: total){
			StockTakingVO tmp = new StockTakingVO(vo.getBar_code(), Calendar.getInstance().getTime(),
					vo.getDestination(), vo.getArea_code(), vo.getRow(), vo.getShelf(), vo.getPosition());
			stockTaking.add(tmp);
		}
		AddState state = service.stockTakingConfirm(stockTaking);
		
		if(state==AddState.SUCCESS){
			showError(ErrorState.SUCCESS);
		}else{
			showError(ErrorState.ADDERROR);
		}
	}
	
	private Vector<Vector<String>> getWareHouseVector(ArrayList<WareHouseVO> voList){
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		for(WareHouseVO vo: voList){
			Vector<String> tmp = new Vector<String>();
			tmp.add(vo.getBar_code());
			tmp.add(vo.getDestination()+"");
			tmp.add(vo.getRow()+"");
			tmp.add(vo.getShelf()+"");
			tmp.add(vo.getPosition()+"");
			result.add(tmp);
		}
		return result;
	}
	
	private class Header extends JLabel{
		LabelHeader date = new LabelHeader("当前日期:");
//		LabelHeader dateEnd = new LabelHeader("结束日期:");
		
		public Header(){
			this.setBounds(120,115,770,30);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dateNow = format.format(Calendar.getInstance().getTime());
			date.addInfo(dateNow);
			date.setBounds(0,0,300,30);
			this.add(date);
		}
	}

}
