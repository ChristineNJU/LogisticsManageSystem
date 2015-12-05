package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.ConstPO;
import PO.DistancePO;
import State.AddState;
import State.UpdateState;
import VO.ConstVO;
import VO.DistanceVO;
import businesslogic.Service.Manage.AddConstService;
import businesslogic.Service.Manage.GetDistanceService;
import businesslogic.Service.Manage.ShowConstService;
import businesslogic.Service.Manage.UpdateConstService;
import businesslogic.Service.Manage.UpdateDistanceService;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Search.SearchConstService;
import data.Service.Search.SearchDistanceService;
import data.Service.Update.UpdateService;

public class ManageConst implements ShowConstService,UpdateConstService,AddConstService, GetDistanceService
, UpdateDistanceService{

	@Override
	public ArrayList<ConstVO> showConst() {
		// TODO Auto-generated method stub
		ArrayList<ConstVO> result=new ArrayList<ConstVO>();
		try {
			SearchConstService searchConst=(SearchConstService) Naming.lookup(RMIHelper.SEARCH_CONST_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("name like '%%'");
			ArrayList<ConstPO> searchResult=searchConst.searchConst(requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return result;
			}
			else{
			for(int i=0;i<searchResult.size();i++){
				ConstVO temp=new ConstVO(searchResult.get(i));
				result.add(temp);
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public UpdateState updateConst(ConstVO constant) {
		// TODO Auto-generated method stub
		UpdateState result=UpdateState.NOTFOUND;
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
			SearchConstService searchConst=(SearchConstService) Naming.lookup(RMIHelper.SEARCH_CONST_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("name='"+constant.getName()+"'");
			ArrayList<ConstPO> searchResult=searchConst.searchConst(requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return UpdateState.NOTFOUND;
				}
			else{
				
					result=updateService.update(new ConstPO(constant));
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			result=UpdateState.CONNECTERROR;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public AddState addConst(ConstVO constant) {
		// TODO Auto-generated method stub
		AddState result=AddState.FAIL;
		try {
			AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			ConstPO requirement=new ConstPO(constant);
			result=addService.add(requirement);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<DistanceVO> getDistance() {
		// TODO Auto-generated method stub
		ArrayList<DistanceVO> result = new ArrayList<DistanceVO>();
		
		try {
			SearchDistanceService searchDistanceService = (SearchDistanceService) Naming.lookup(RMIHelper.SEARCH_DISTANCE_IMPL);
			ArrayList<String> requirement = new ArrayList<String>();
			requirement.add("city_1 like '%%'");
			
			ArrayList<DistancePO> tmp = searchDistanceService.searchDistance(requirement);
			
			if(tmp.isEmpty()){
				return result;
			}
			
			for(int i=0;i<tmp.size();i++){
				result.add(new DistanceVO(tmp.get(i)));
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public UpdateState updateDistance(DistanceVO distance) {
		// TODO Auto-generated method stub
		UpdateState state = UpdateState.SUCCESS;
		try {
			UpdateService service = (UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
			SearchDistanceService searchDistanceService = (SearchDistanceService) Naming.lookup(RMIHelper.SEARCH_DISTANCE_IMPL);
			ArrayList<String> requirement = new ArrayList<String>();
			requirement.add("city_1 = '"+distance.getCity_1()+"' AND city_2 = '"+distance.getCity_2()+"'");
			
			ArrayList<DistancePO> tmp = searchDistanceService.searchDistance(requirement);
			
			DistancePO result = new DistancePO(distance, tmp.get(0).getTime(), tmp.get(0).getURL());
			
			state = service.update(result);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return UpdateState.CONNECTERROR;
		}
		
		return state;
	}

	
	
}
