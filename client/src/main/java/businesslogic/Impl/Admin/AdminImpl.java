package businesslogic.Impl.Admin;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.UserPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.UserVO;
import businesslogic.Service.Admin.AdminUserService;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;
import data.Service.Search.SearchUserService;
import data.Service.Update.UpdateService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminImpl.
 */
public class AdminImpl implements AdminUserService{

	/* (non-Javadoc)
	 * @see businesslogic.Service.Admin.AdminUserService#updateUser(VO.UserVO)
	 */
	@Override
	public UpdateState updateUser(UserVO user) {
		// TODO Auto-generated method stub
		UpdateState state=UpdateState.SUCCESS;
		
		try{
			
			SearchUserService userSearch=(SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("id='"+user.getId()+"'");
			ArrayList<UserPO> result=userSearch.searchUser(requirement);
			if(result.isEmpty()){
				return UpdateState.NOTFOUND;
			}
			for(int i=0;i<result.size();i++){
				state=updateService.update(new UserPO(user));
			}
			
		} catch(Exception ex){
			state=UpdateState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return state;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Admin.AdminUserService#searchUser(java.util.ArrayList)
	 */
	@Override
	public ArrayList<UserVO> searchUser(ArrayList<String> requirement) {
		// TODO Auto-generated method stub
		ArrayList<UserVO> result=new ArrayList<UserVO>();
		
		try{
			SearchUserService userSearch=(SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			
			ArrayList<String> requirementID=new ArrayList<String>();
			if(!requirement.get(0).equals("%%")){
				ArrayList<String> requirementName=new ArrayList<String>();
				for(int i=0;i<requirement.size();i++){
					requirementID.add("id like '%"+requirement.get(i)+"%'");
					requirementName.add("name like '%"+requirement.get(i)+"%'");
				}
				System.out.println(requirementID.get(0)+" "+requirementName.get(0));
				ArrayList<UserPO> userListID=userSearch.searchUser(requirementID);
				ArrayList<UserPO> userListName=userSearch.searchUser(requirementName);
				
				for(int i=0;i<userListID.size();i++){
					result.add(new UserVO(userListID.get(i)));
				}
				for(int i=0;i<userListName.size();i++){
					result.add(new UserVO(userListName.get(i)));
				}
				
				System.out.println(result.size());
			}
			else {
				requirementID.add("id like '%%'");
				ArrayList<UserPO> userList=new ArrayList<UserPO>();
				userList = userSearch.searchUser(requirementID);
				for(int i=0;i<userList.size();i++){
					result.add(new UserVO(userList.get(i)));
				}
			}
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Admin.AdminUserService#deleteUser(VO.UserVO)
	 */
	@Override
	public DeleteState deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		DeleteState state=DeleteState.SUCCESS;
		try{
			
			SearchUserService userSearch=(SearchUserService) Naming.lookup(RMIHelper.SEARCH_USER_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("id='"+user.getId()+"'");
			ArrayList<UserPO> userList=userSearch.searchUser(requirement); 
			if(userList.isEmpty()){
				return DeleteState.FAIL;
			}
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Admin.AdminUserService#addUser(VO.UserVO)
	 */
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
