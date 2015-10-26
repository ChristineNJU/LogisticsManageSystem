package test.Stub.businesslogic;

import java.rmi.RemoteException;
import java.util.ArrayList;

import test.Stub.data.SearchService_Stub;
import businesslogic.PO.StockTakingPO;
import businesslogic.State.OutputState;
import businesslogic.State.StorageArea;
import businesslogic.State.StorageState;
import businesslogic.VO.BalanceVO;
import businesslogic.VO.RemovalVO;
import businesslogic.VO.StockTakingVO;
import businesslogic.VO.StorageVO;
import businesslogic.VO.VO;
import data.State.AddState;

public class ReponsitoryBlService_Stub {
	SearchService_Stub sss = new SearchService_Stub();
	/*-------------------------------------------
	 显示当天库存信息
	---------------------------------------------*/
	public ArrayList<StockTakingVO> stockTaking(){
		System.out.println("查询成功");
		ArrayList<String> requirement = new ArrayList<String>();
		ArrayList<StockTakingVO> listResult = new ArrayList<StockTakingVO>();
		ArrayList<StockTakingPO> listSource = null;
		try{
			listSource = sss.searchStockTaking(null, requirement);
			for (int i = 0; i < listSource.size();i++){
				listResult.add(null);
			}
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listResult;		
	}
	/*-------------------------------------------
	 确认库存盘点信息
	---------------------------------------------*/
	public AddState stockTakingConfirm(){
		System.out.println("确认库存盘点成功");
		AddState state=AddState.SUCCESS;
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
	public String getNeedStorage(){
		System.out.println("返回成功");
		return "1234512345";
	}
	/*-------------------------------------------
	 生成入库信息并储存
	---------------------------------------------*/
	public StorageState storage(ArrayList<StorageVO> Storage){
		System.out.println("生成，储存入库信息成功");
		StorageState state=StorageState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 返回需要出库的快递
	---------------------------------------------*/
	public String getNeedRemoval(){
		System.out.println("返回成功");
		return "1234512345";
	}
	/*-------------------------------------------
	 生成出库信息确认并存储
	---------------------------------------------*/
	public AddState removal(ArrayList<RemovalVO> removal){
		System.out.println("生成，储存入库信息成功");
		AddState state=AddState.SUCCESS;
		return state;
		}
	/*-------------------------------------------
	 存储库存调整信息
	---------------------------------------------*/
	public StorageState balance(BalanceVO balance){
		System.out.println("存储库存调整信息成功");
		StorageState state=StorageState.SUCCESS;
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
