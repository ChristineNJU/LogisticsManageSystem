package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;
import PO.InstitutionPO;
import PO.UserPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.StaffVO;
import data.Service.Search.SearchUserService;
import data.Service.Update.UpdateService;
import businesslogic.Service.Manage.AddStaffService;
import businesslogic.Service.Manage.DeleteStaffService;
import businesslogic.Service.Manage.GetStaffService;
import businesslogic.Service.Manage.UpdateStaffService;
import businesslogic.URLHelper.URLHelper;

public class ManageStaff implements AddStaffService,UpdateStaffService,
									GetStaffService,DeleteStaffService{

	@Override
	public DeleteState DeleteStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		DeleteState result=DeleteState.FAIL;
		try {
			DeleteService deleteService=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			SearchUserService searchUser=(SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("id='"+staff.getSystemId()+"'");
			
			ArrayList<UserPO> searchResult=searchUser.searchUser(requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return DeleteState.FAIL;
				}
			
			else{
				for(int i=0;i<searchResult.size();i++)
					result=deleteService.delete(searchResult.get(i));
			
			}			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			result=DeleteState.FAIL;
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public ArrayList<StaffVO> searchStaff(String id) {
		// TODO Auto-generated method stub
		ArrayList<StaffVO> result=new ArrayList<StaffVO>();
		try {
			SearchUserService searchUser=(SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			
			ArrayList<String> requirementId=new ArrayList<String>();
			ArrayList<String> requirementName=new ArrayList<String>();
			
			//show when id==null
			if(id!=null){
				requirementId.add("id='"+id+"'");
				requirementName.add("name='"+id+"'");
			}else{
				requirementId.add("id like '%%'");
			}
			
			ArrayList<UserPO> searchResultId=searchUser.searchUser(requirementId);
			ArrayList<UserPO> searchResultName=searchUser.searchUser(requirementName);
			
			for(int i=0;i<searchResultName.size();i++)
				searchResultId.add(searchResultName.get(i));
			
			if(searchResultId.isEmpty()){
				System.out.println("not found");
				return result;
			}
			
			else{
				for(int i=0;i<searchResultId.size();i++){
				StaffVO temp=new StaffVO(searchResultId.get(i));
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
	public UpdateState updateStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		UpdateState result=UpdateState.NOTFOUND;
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
			SearchUserService searchUser=(SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("id='"+staff.getSystemId()+"'");
			ArrayList<UserPO> searchResult=searchUser.searchUser(requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return UpdateState.NOTFOUND;
				}
			else{
				
					result=updateService.update(new UserPO(staff));
				}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=UpdateState.CONNECTERROR;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public AddState addStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		AddState result=AddState.FAIL;
		try {
			AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			UserPO requirement=new UserPO(staff);
			result=addService.add(requirement);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=AddState.FAIL;
			System.out.println("error");
			e.printStackTrace();
		}
		
		return result;
	}

}
