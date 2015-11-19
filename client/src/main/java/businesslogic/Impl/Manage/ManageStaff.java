package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.RMIHelper.RMIHelper;
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
//			UserPO requirement=new UserPO(staff.getSystemId(),null,staff.getName(),staff.getSex(),staff.getAge()
//										staff.getInsitution(),staff.)
			//result=deleteService.delete(requirement);			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
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
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("id="+id);
			ArrayList<UserPO> searchResult=searchUser.searchUser(requirement);
			
			if(!searchResult.isEmpty()){
				System.out.println("not found");
				return null;
			}
			
			else{
				for(int i=0;i<searchResult.size();i++){
				StaffVO temp=new StaffVO(searchResult.get(i));
				result.add(temp);
				}
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public UpdateState updateStaff(StaffVO staff, String field, String value) {
		// TODO Auto-generated method stub
		UpdateState result=UpdateState.NOTFOUND;
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=UpdateState.CONNECTERROR;
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AddState addStaff(StaffVO staff) {
		// TODO Auto-generated method stub
		return null;
	}

}
