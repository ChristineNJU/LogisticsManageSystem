package businesslogic.Impl.Businesslobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.CarInfoPO;
import PO.DriverInfoPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.CarInfoVO;
import VO.DriverInfoVO;
import businesslogic.Service.BusinessLobby.AddCarService;
import businesslogic.Service.BusinessLobby.DeleteCarService;
import businesslogic.Service.BusinessLobby.GetCarService;
import businesslogic.Service.BusinessLobby.UpdateCarService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;
import data.Service.Search.SearchCarInfoService;
import data.Service.Search.SearchDriverInfoService;
import data.Service.Update.UpdateService;

public class CarMgt implements UpdateCarService,GetCarService,DeleteCarService,AddCarService{

	@Override
	public AddState addCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		
		try{
			AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			state=addService.add(new CarInfoPO(car));
		} catch (Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return state;
		
	}

	@Override
	public DeleteState deleteCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		DeleteState result=DeleteState.FAIL;
		try {
			DeleteService deleteService=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			SearchCarInfoService searchCar=(SearchCarInfoService) Naming.lookup(RMIHelper.SEARCH_DRIVERINFO_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("id='"+car.getCarNumber()+"'");
			
			ArrayList<CarInfoPO> searchResult=searchCar.searchCarInfo(URLHelper.getCarInfoURL(car.getCarNumber().substring(0, car.getCarNumber().length()-3)), requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return DeleteState.FAIL;
			}
			
			else{
				for(int i=0;i<searchResult.size();i++){
					result=deleteService.delete(new CarInfoPO(car));
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
	public ArrayList<CarInfoVO> searchCar(String id) {
		// TODO Auto-generated method stub
		ArrayList<CarInfoVO> result=new ArrayList<CarInfoVO>();
		try {
			SearchCarInfoService searchCar=(SearchCarInfoService) Naming.lookup(RMIHelper.SEARCH_CARINFO_IMPL);
			
			ArrayList<String> requirementId=new ArrayList<String>();
			requirementId.add("id='"+id+"'");
			
			ArrayList<String> requirementName=new ArrayList<String>();
			requirementName.add("name='"+id+"'");
			
			ArrayList<CarInfoPO> searchResultId=new ArrayList<CarInfoPO>();
			ArrayList<CarInfoPO> searchResultName=new ArrayList<CarInfoPO>();
			
			searchResultId=searchCar.searchCarInfo(SystemLog.getInstitutionId(), requirementId);
			searchResultName=searchCar.searchCarInfo(SystemLog.getInstitutionId(), requirementName);
			
			for(int i=0;i<searchResultName.size();i++)
				searchResultId.add(searchResultName.get(i));
			
			if(searchResultId.isEmpty()){
				System.out.println("not found");
				return null;
			}
			
			else{
				for(int i=0;i<searchResultId.size();i++)
					result.add(new CarInfoVO(searchResultId.get(i)));
				
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public UpdateState updateCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		UpdateState result=UpdateState.NOTFOUND;
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			SearchCarInfoService searchCar=(SearchCarInfoService) Naming.lookup(RMIHelper.SEARCH_DRIVERINFO_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("id='"+car.getCarNumber()+"'");
			
			ArrayList<CarInfoPO> searchResult=searchCar.searchCarInfo(URLHelper.getCarInfoURL(car.getCarNumber().substring(0, car.getCarNumber().length()-3)), requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return UpdateState.NOTFOUND;
			}
			
			else{
				for(int i=0;i<searchResult.size();i++){
					result=updateService.update(new CarInfoPO(car));
				}
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=UpdateState.CONNECTERROR;
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	}

}
