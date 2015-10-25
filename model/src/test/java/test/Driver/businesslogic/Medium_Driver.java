package test.Driver.businesslogic;

import java.util.ArrayList;

import test.Stub.businesslogic.ManageBlService_Stub;
import test.Stub.businesslogic.MediumCenterBlService_Stub;

public class Medium_Driver {
	public static void main(String [] args){
		  Medium_Driver driver=new Medium_Driver();
		  driver.drive(new MediumCenterBlService_Stub());
	  }
	  
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
