package test.Driver.data;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import PO.LogisticsInfoPO;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchLogisticsService;

public class SearchLogistics_Driver {
	
	public static void main(String[] args) {
		
		try {
			SearchLogisticsService search_logistics = (SearchLogisticsService) Naming.lookup(RMIHelper.SEARCH_LOGISTICS_IMPL);
		
			ArrayList<String> requirement = new ArrayList<String>();
			
			requirement.add("bar_code = '0000000001'");
			
			ArrayList<LogisticsInfoPO> list = search_logistics.searchLogisticsInfo(requirement);
			
			LogisticsInfoPO logistics = list.get(0);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			String day = sdf.format(logistics.getSendDate());
			
			System.out.println(logistics.getSenderName()+" "+logistics.getType()+" "+logistics.getSendDate()+" "+day);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
