package test.Driver.businesslogic;

import java.util.ArrayList;

import test.Stub.businesslogic.MediumCenterBlService_Stub;

public class Medium_Driver {
	
	  public void drive(MediumCenterBlService_Stub mediumbl){
		  System.out.println(mediumbl.arrival(null));
		  
		  ArrayList<String> entruckingList = mediumbl.getNeedEntrucking();
		  for(int i = 0; i < entruckingList.size();i++){
			  System.out.println(entruckingList.get(i));
		  }
		  
		  System.out.println(mediumbl.entrucking(null));
		  
		  ArrayList<String> transferList = mediumbl.getNeedTransfer();
		  for(int i = 0; i < transferList.size();i++){
			  System.out.println(transferList.get(i));
		  }
		  
		  System.out.println(mediumbl.transfer(null));
		  
	  }
}
