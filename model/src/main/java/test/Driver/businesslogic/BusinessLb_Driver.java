package test.Driver.businesslogic;

import java.util.ArrayList;
import java.util.Date;

import test.Stub.businesslogic.BusinessLobbyBlService_Stub;
import State.LogisticsState;
import VO.ArrivalVO;
import VO.CarInfoVO;
import VO.DriverInfoVO;

public class BusinessLb_Driver {

	 
	  public void drive(BusinessLobbyBlService_Stub businessLBbl){
		  ArrayList<ArrivalVO> arrivalList = new ArrayList<ArrivalVO>();

		  arrivalList.add(0, new ArrivalVO("1111111",new Date(),"南京",null, LogisticsState.LOST));

		  
		  arrivalList.add(new ArrivalVO("1111111",new Date(),"南京",null, LogisticsState.LOST));

		  System.out.println(businessLBbl.arrival(arrivalList));
		  
		  ArrayList<String> gatheringList = businessLBbl.getNeedGathering();
		  for(int i = 0;i < gatheringList.size();i++){
			  System.out.println(gatheringList.get(i));
		  }
		  
		  System.out.println(businessLBbl.gathering(null));
		  
		  ArrayList<String> entruckingList = new ArrayList<String>();
		  entruckingList = businessLBbl.getNeedEntrucking();
		  for(int i = 0; i < entruckingList.size();i++){
			  System.out.println(entruckingList.get(i));
		  }
		  
		  System.out.println(businessLBbl.entrucking(null));
		  
		  ArrayList<CarInfoVO> carInfoList = businessLBbl.searchCar(null);
		  for(int i = 0; i < carInfoList.size();i++){
			  System.out.println(carInfoList.get(i));
		  }
		  
		  System.out.println(businessLBbl.updateCar(null, null, null));
		  
		  System.out.println(businessLBbl.addCar(null));
		  
		  System.out.println(businessLBbl.deleteCar(null));
		  
		  ArrayList<DriverInfoVO> driverList = businessLBbl.searchDriver(null);
		  for(int i = 0; i < driverList.size();i++){
			  System.out.println(driverList.get(i));
		  }
		  
		  System.out.println(businessLBbl.updateDriver(null, null, null));
		  
		  System.out.println(businessLBbl.AddDriver(null));
		  
		  System.out.println(businessLBbl.deleteDriver(null));
		  
	  }
}
