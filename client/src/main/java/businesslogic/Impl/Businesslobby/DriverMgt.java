package businesslogic.Impl.Businesslobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.DriverInfoPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.CarInfoVO;
import VO.DriverInfoVO;
import businesslogic.Service.BusinessLobby.DriverMgtService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;
import data.Service.Search.SearchDriverInfoService;
import data.Service.Update.UpdateService;

public class DriverMgt implements DriverMgtService{

	@Override
	public ArrayList<DriverInfoVO> searchDriver(String id) {
		// TODO Auto-generated method stub
		ArrayList<DriverInfoVO> result=new ArrayList<DriverInfoVO>();
		try {
			SearchDriverInfoService searchDriver=(SearchDriverInfoService) Naming.lookup(RMIHelper.SEARCH_DRIVERINFO_IMPL);
			System.out.println(id+" searchDriver debug "+SystemLog.getInstitutionId());
			ArrayList<String> requirementId=new ArrayList<String>();
			requirementId.add("Driver_Number='"+id+"'");
			
			ArrayList<String> requirementName=new ArrayList<String>();
			requirementName.add("DRiver_Name='"+id+"'");
			
			ArrayList<DriverInfoPO> searchResultId=new ArrayList<DriverInfoPO>();
			ArrayList<DriverInfoPO> searchResultName=new ArrayList<DriverInfoPO>();
			
			searchResultId=searchDriver.searchDriverInfo(URLHelper.getDriverInfoURL(SystemLog.getInstitutionId()), requirementId);
			searchResultName=searchDriver.searchDriverInfo(URLHelper.getDriverInfoURL(SystemLog.getInstitutionId()), requirementName);
			
			for(int i=0;i<searchResultName.size();i++)
				searchResultId.add(searchResultName.get(i));
			
			if(searchResultId.isEmpty()){
				System.out.println("searchDriver: not found");
				return null;
			}
			
			else{
				for(int i=0;i<searchResultId.size();i++)
					result.add(new DriverInfoVO(searchResultId.get(i)));
				System.out.println(searchResultId.get(0).getDriverId());
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public UpdateState updateDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		UpdateState result=UpdateState.NOTFOUND;
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			SearchDriverInfoService searchDriver=(SearchDriverInfoService) Naming.lookup(RMIHelper.SEARCH_DRIVERINFO_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("Driver_number='"+driver.getNumber()+"'");
			
			ArrayList<DriverInfoPO> searchResult=searchDriver.searchDriverInfo(URLHelper.getDriverInfoURL(driver.getNumber().substring(0, driver.getNumber().length()-3)), requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return UpdateState.NOTFOUND;
			}
			
			else{
				
					result=updateService.update(new DriverInfoPO(driver));
				
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=UpdateState.CONNECTERROR;
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public DeleteState deleteDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		DeleteState result=DeleteState.FAIL;
		try {
			DeleteService deleteService=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			SearchDriverInfoService searchDriver=(SearchDriverInfoService) Naming.lookup(RMIHelper.SEARCH_DRIVERINFO_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("Driver_Number='"+driver.getNumber()+"'");
			
			ArrayList<DriverInfoPO> searchResult=searchDriver.searchDriverInfo(URLHelper.getDriverInfoURL(driver.getNumber().substring(0, driver.getNumber().length()-3)), requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return DeleteState.FAIL;
			}
			
			else{
				for(int i=0;i<searchResult.size();i++){
					result=deleteService.delete(new DriverInfoPO(driver));
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=DeleteState.CONNECTERROR;
			System.out.println("error");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public AddState addDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
				AddState state=AddState.SUCCESS;
				
				try{
					AddService driverAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
					state=driverAdd.add(new DriverInfoPO(driver));
					System.out.println("add debug "+driver.getId());
				} catch (Exception ex){
					state=AddState.CONNECTERROR;
					System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
				
				return state;
	}

	

}
