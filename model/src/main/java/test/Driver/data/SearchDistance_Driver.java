package test.Driver.data;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.DistancePO;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchDistanceService;

public class SearchDistance_Driver {
	
	public static void main(String[] args) {
		ArrayList<String> requirement = new ArrayList<String>();
		requirement.add("city_2 = '南京' AND city_1 = '北京'");
		
		SearchDistanceService s;
		try {
			s = (SearchDistanceService) Naming.lookup(RMIHelper.SEARCH_DISTANCE_IMPL);
			DistancePO distance = s.searchDistance(requirement).get(0);
			
			System.out.println(distance.getDistance());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
