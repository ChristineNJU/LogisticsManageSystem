package test.Stub.businesslogic;
import java.rmi.RemoteException;
import java.util.ArrayList;

import test.Stub.data.AddService_Stub;
import test.Stub.data.DeleteService_Stub;
import test.Stub.data.SearchService_Stub;
import test.Stub.data.UpdateService_Stub;
import PO.ArrivalPO;
import PO.EntruckingPO;
import PO.TransferPO;
import State.AddState;
import VO.ArrivalVO;
import VO.EntruckingVO;
import VO.TransferVO;
public class MediumCenterBlService_Stub {
	AddService_Stub addSev = new AddService_Stub();
	DeleteService_Stub deleteSev = new DeleteService_Stub();
	SearchService_Stub searchSev = new SearchService_Stub();
	UpdateService_Stub updateSev = new UpdateService_Stub();
	/*-------------------------------------------
	 快递到达
	---------------------------------------------*/
	public AddState arrival(ArrayList<ArrivalVO> list){
		System.out.println("到达成功");
		AddState state = AddState.FAIL;
		ArrayList<ArrivalPO> dataList = new ArrayList<ArrivalPO>();
		for(int i = 0; i < list.size(); i++){
			ArrivalVO arrival = list.get(i);
			try {
				state = addSev.add(new ArrivalPO(arrival.getBarCode(), arrival.getDate(), arrival.getListId(), arrival.getDeparture(), arrival.getLogisticsState(), null));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return state;
		//ArrivalVO arrive1=new ArrivalVO("2015-1-1","1234512345","南京",LogisticsState.INTACT);
		//ArrivalVO arrive2=new ArrivalVO("2015-1-1","1234512345","南京",LogisticsState.INTACT);
	}
	/*-------------------------------------------
	 查询需要装车的订单信息
	---------------------------------------------*/
	public ArrayList<String> getNeedEntrucking(){
		System.out.println("查询成功");
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<EntruckingPO> entruckingPO = null;
		try {
			entruckingPO = searchSev.searchEntrucking(null, null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list.size() ; i++){
			list.add(entruckingPO.get(i).toString());
		}
		return list;
	}
	/*-------------------------------------------
	 装车操作
	---------------------------------------------*/
	public AddState entrucking(EntruckingVO entrucking){
		System.out.println("装车成功");
		
		AddState state = AddState.FAIL;
		try {
			state = addSev.add(new EntruckingPO(entrucking.getDate(),"",entrucking.getDestination(),
					entrucking.getCarNumber(),entrucking.getguardNumber(),entrucking.getSupercargoName(),entrucking.getBarCodeList(),entrucking.getAmount(),null));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	/*-------------------------------------------
	 查询中转的订单
	---------------------------------------------*/
	public ArrayList<String> getNeedTransfer(){
		System.out.println("查询成功");
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<TransferPO> transferPO = null;
		try {
			transferPO = searchSev.searchTransfer(null, null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < list.size() ; i++){
			list.add(transferPO.get(i).toString());
		}
		return list;
	}
	/*-------------------------------------------
	 中转操作
	---------------------------------------------*/
	public AddState transfer(TransferVO transfer){
		System.out.println("中转成功");
		AddState state = AddState.FAIL;
		try {
			state = addSev.add(new TransferPO(transfer.getDate(),null,null,transfer.getDeparture(),transfer.getDestination(),
					transfer.getContainerNumber(),transfer.getGuardName(),transfer.getItemId(),transfer.getTransferCharge(), null));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
}
