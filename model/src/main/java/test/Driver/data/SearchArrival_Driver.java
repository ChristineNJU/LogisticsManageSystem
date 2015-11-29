package test.Driver.data;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.ArrivalPO;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchArrivalService;

public class SearchArrival_Driver {
	
	public static void main(String[] args) {
		
		ArrayList<String> requirement = new ArrayList<String>();
		requirement.add("bar_code = '0000000001'");
		
		try {
			SearchArrivalService s = (SearchArrivalService) Naming.lookup(RMIHelper.SEARCH_ARRIVAL_IMPL);
			
			ArrivalPO p = s.searchArrival(URLHelper.getArrivalURL("025000"), requirement).get(0);
			
			System.out.println(p.getBarCode());
			
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
