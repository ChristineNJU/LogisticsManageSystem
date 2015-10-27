package test.Stub.businesslogic;

import java.rmi.RemoteException;
import java.util.ArrayList;


import businesslogic.PO.BalancePO;
import businesslogic.PO.RemovalPO;
import businesslogic.PO.StockTakingPO;
import businesslogic.PO.StoragePO;
import businesslogic.State.OutputState;
import businesslogic.State.StorageArea;
import businesslogic.State.StorageState;
import businesslogic.VO.BalanceVO;
import businesslogic.VO.RemovalVO;
import businesslogic.VO.StockTakingVO;
import businesslogic.VO.StorageVO;
import businesslogic.VO.VO;
import data.State.AddState;

import test.Stub.data.AddService_Stub;
import test.Stub.data.DeleteService_Stub;
import test.Stub.data.SearchService_Stub;
import test.Stub.data.UpdateService_Stub;

public class ReponsitoryBlService_Stub {
	AddService_Stub addSev = new AddService_Stub();
	DeleteService_Stub deleteSev = new DeleteService_Stub();
	SearchService_Stub searchSev = new SearchService_Stub();
	UpdateService_Stub updateSev = new UpdateService_Stub();

	/*-------------------------------------------
	 显示当天库存信息
	---------------------------------------------*/
	public ArrayList<StockTakingVO> stockTaking(){
		System.out.println("查询成功");

		ArrayList<StockTakingPO> list = new ArrayList<StockTakingPO>();
		ArrayList<StockTakingVO> voList = null;
		try {
			list = searchSev.searchStockTaking(null, null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list.size() ; i++){
			StockTakingPO po = list.get(i);
			voList.add(new StockTakingVO(po.getBarCode(), po.getDate(), po.getDestination(), po.getAreaCode(), 
					po.getRow(), po.getShelf(), po.getPosition()));
		}
		return voList;	

	}
	/*-------------------------------------------
	 确认库存盘点信息
	---------------------------------------------*/
	public AddState stockTakingConfirm(){
		System.out.println("确认库存盘点成功");
		AddState state = AddState.FAIL;
		try {
			state = addSev.add(null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	/*-------------------------------------------
	 生产盘点信息的excel表格
	---------------------------------------------*/
	public OutputState stockTakingExcel(){
		System.out.println("生成成功");
		OutputState state=OutputState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 返回需要入库的快递
	---------------------------------------------*/
	public ArrayList<String> getNeedStorage(){
		System.out.println("返回成功");
		ArrayList<StoragePO> po = null;
		try {
			 po = searchSev.searchStorage(null,null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < po.size();i++){
			list.add(po.get(i).toString());
		}
		return list;
	}
	/*-------------------------------------------
	 生成入库信息并储存
	---------------------------------------------*/
	public AddState storage(ArrayList<StorageVO> Storage){
		System.out.println("生成，储存入库信息成功");
		AddState state=AddState.SUCCESS;
		try {
			state = addSev.add(null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	/*-------------------------------------------
	 返回需要出库的快递
	---------------------------------------------*/
	public String getNeedRemoval(){
		System.out.println("返回成功");
		ArrayList<RemovalPO> po = null;
		try {
			 po = searchSev.searchRemoval(null,null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < po.size();i++){
			list.add(po.get(i).toString());
		}
		return po.get(0).toString();
	}
	/*-------------------------------------------
	 生成出库信息确认并存储
	---------------------------------------------*/
	public AddState removal(ArrayList<RemovalVO> removal){
		System.out.println("生成，储存入库信息成功");
		AddState state=AddState.SUCCESS;
		try {
			state = addSev.add(null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
		}
	/*-------------------------------------------
	 存储库存调整信息
	---------------------------------------------*/
	public AddState balance(BalanceVO balance){
		System.out.println("存储库存调整信息成功");
		AddState state=AddState.SUCCESS;
		try {
			state = addSev.add(new BalancePO(null, null, null, null, 0, 0, 0, null, 0, 0, 0, null));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return state;
	}
	/*-------------------------------------------
	 库存报警
	---------------------------------------------*/
	public boolean alarm(){
		return false;
	}
	/*-------------------------------------------
	 查看入库出库信息
	---------------------------------------------*/
	public ArrayList<VO> see(String time_start, String time_end){
		System.out.println("查看成功");
		VO vo1=new StorageVO("1234512345","2015-10-25","南京",StorageArea.AIR_TRANSPORTATION,1,2,3);
		VO vo2=new RemovalVO("1234512345","2015-10-25","南京","汽运","025000");
		ArrayList<VO> list=new ArrayList<VO>();
		list.add(vo1);
		list.add(vo2);
		return list;
	}
}
