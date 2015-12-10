package businesslogic.Impl.Businesslobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.CarInfoPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.CarInfoVO;
import businesslogic.Service.BusinessLobby.CarMgtService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;
import data.Service.Search.SearchCarInfoService;
import data.Service.Update.UpdateService;

// TODO: Auto-generated Javadoc
/**
 * The Class CarMgt.
 */
public class CarMgt implements CarMgtService{
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.CarMgtService#addCar(VO.CarInfoVO)
	 */
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.CarMgtService#deleteCar(VO.CarInfoVO)
	 */
	@Override
	public DeleteState deleteCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		DeleteState result=DeleteState.FAIL;
		try {
			DeleteService deleteService=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			SearchCarInfoService searchCar=(SearchCarInfoService) Naming.lookup(RMIHelper.SEARCH_CARINFO_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("CAR_NUMBER='"+car.getCarNumber()+"'");
			
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.CarMgtService#searchCar(java.lang.String)
	 */
	@Override
	public ArrayList<CarInfoVO> searchCar(String id) {
		// TODO Auto-generated method stub
		ArrayList<CarInfoVO> result=new ArrayList<CarInfoVO>();
		try {
			SearchCarInfoService searchCar=(SearchCarInfoService) Naming.lookup(RMIHelper.SEARCH_CARINFO_IMPL);
			
			ArrayList<String> requirementId=new ArrayList<String>();
			ArrayList<CarInfoPO> searchResultId=new ArrayList<CarInfoPO>();
			if(!id.equals("%%")){
				requirementId.add("CAR_NUMBER='"+id+"'");
				
				ArrayList<String> requirementName=new ArrayList<String>();
				requirementName.add("Car_License='"+id+"'");
				
				
				ArrayList<CarInfoPO> searchResultName=new ArrayList<CarInfoPO>();
				
				searchResultId=searchCar.searchCarInfo(URLHelper.getCarInfoURL(SystemLog.getInstitutionId()), requirementId);
				searchResultName=searchCar.searchCarInfo(URLHelper.getCarInfoURL(SystemLog.getInstitutionId()), requirementName);
				
				for(int i=0;i<searchResultName.size();i++)
					searchResultId.add(searchResultName.get(i));
			}
			else {
				requirementId.add("car_number like '%%'");
				searchResultId=searchCar.searchCarInfo(URLHelper.getCarInfoURL(SystemLog.getInstitutionId()), requirementId);
			}
			if(searchResultId.isEmpty()){
				System.out.println("not found");
				return result;
			}
			
			else{
				for(int i=0;i<searchResultId.size();i++)
					result.add(new CarInfoVO(searchResultId.get(i)));
				
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
			return null;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.BusinessLobby.CarMgtService#updateCar(VO.CarInfoVO)
	 */
	@Override
	public UpdateState updateCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		UpdateState result=UpdateState.NOTFOUND;
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			SearchCarInfoService searchCar=(SearchCarInfoService) Naming.lookup(RMIHelper.SEARCH_CARINFO_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("CAR_NUMBER='"+car.getCarNumber()+"'");
			
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
		}catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=UpdateState.CONNECTERROR;
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	
	}
}
