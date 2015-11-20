package businesslogic.Impl.Admin;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.UserPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.UserVO;
import businesslogic.Service.Admin.AddUserService;
import businesslogic.Service.Admin.DeleteUserService;
import businesslogic.Service.Admin.GetUserService;
import businesslogic.Service.Admin.UpdateUserService;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;
import data.Service.Search.SearchUserService;
import data.Service.Update.UpdateService;

public class AdminImpl implements AddUserService,DeleteUserService,GetUserService,UpdateUserService{

	@Override
	public UpdateState updateUser(UserVO user, String field, String value) {
		// TODO Auto-generated method stub
		UpdateState state=UpdateState.SUCCESS;
		
		try{
			
			SearchUserService userSearch=(SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("id='"+user.getId()+"'");
			ArrayList<UserPO> result=userSearch.searchUser(requirement);
			for(int i=0;i<result.size();i++){
				state=updateService.update(result.get(i), field, value);
			}
			
		} catch(Exception ex){
			state=UpdateState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return state;
	}

	@Override
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement) {
		// TODO Auto-generated method stub
		ArrayList<UserVO> result=new ArrayList<UserVO>();
		
		try{
			
			SearchUserService userSearch=(SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			ArrayList<String> requirementID=new ArrayList<String>();
			ArrayList<String> requirementName=new ArrayList<String>();
			for(int i=0;i<requirement.size();i++){
				requirementID.add("id='"+requirement.get(i)+"'");
				requirementName.add("name='"+requirement.get(i)+"'");
			}
			ArrayList<UserPO> userListID=userSearch.searchUser(requirementID);
			ArrayList<UserPO> userListName=userSearch.searchUser(requirementName);
			for(int i=0;i<userListID.size();i++){
				result.add(new UserVO(userListID.get(i)));
			}
			for(int i=0;i<userListName.size();i++){
				result.add(new UserVO(userListName.get(i)));
			}
			
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		DeleteState state=DeleteState.SUCCESS;
		try{
			
			SearchUserService userSearch=(SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("id='"+user.getId()+"'");
			ArrayList<UserPO> userList=userSearch.searchUser(requirement); 
			DeleteService userDelete=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			for(int i=0;i<userList.size();i++){
				state=userDelete.delete(userList.get(i));
			}
			
		} catch (Exception ex){
			state=DeleteState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

	@Override
	public AddState addUser(UserVO user) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		
		try{
			AddService userAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			state=userAdd.add(new UserPO(user));
		} catch(Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return state;
	}

	

}
