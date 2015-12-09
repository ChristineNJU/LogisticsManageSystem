package test.Driver.businesslogic;

import java.util.ArrayList;

import test.Stub.businesslogic.CourierBlService_Stub;
import VO.LogisticsInputVO;

public class Courier_Driver {
	public void drive(CourierBlService_Stub Courier){
		LogisticsInputVO logisticsInfo=null;
		System.out.println(Courier.addLogistics(logisticsInfo));
		System.out.println();
		
		System.out.println(Courier.receiveConfirm(logisticsInfo,null,null));
		System.out.println();
		
		System.out.println(Courier.getAmount(null, null, null, null, 0, 0));
		System.out.println();
		
		ArrayList<String> list=Courier.getCity();
		System.out.println();
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
			System.out.println();
		}
		
		
	}

}
