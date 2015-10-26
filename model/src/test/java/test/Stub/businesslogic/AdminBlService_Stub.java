package test.Stub.businesslogic;

import java.rmi.RemoteException;
import java.util.ArrayList;

import test.Stub.data.AddService_Stub;
import test.Stub.data.DeleteService_Stub;
import test.Stub.data.SearchService_Stub;
import test.Stub.data.UpdateService_Stub;
import businesslogic.PO.UserPO;
import businesslogic.Service.Admin.AddUserService;
import businesslogic.Service.Admin.DeleteUserService;
import businesslogic.Service.Admin.SearchUserService;
import businesslogic.Service.Admin.UpdateUserService;
import businesslogic.State.UserRole;
import businesslogic.VO.UserVO;
import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;

public class AdminBlService_Stub implements AddUserService, DeleteUserService, SearchUserService, UpdateUserService{
	/*-------------------------------------------
	 将传入的用户数据存入数据库
	---------------------------------------------*/
	public AddState addUser(UserVO user){
		System.out.println("Logic_Stub "+"添加成功");
	
		UserPO upo=new UserPO(user.getId(),null,user.getName(),user.getRole(),null,null);
		
		try {
			System.out.println("Data_Stub "+new AddService_Stub().add(upo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AddState state=AddState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 更新数据库中用户数据
	---------------------------------------------*/
	public UpdateState updateUser(UserVO user, String field, String value){
		System.out.println("Logic_Stub "+"更新成功");
		UserPO upo=new UserPO(user.getId(),null,user.getName(),user.getRole(),null, null);
		try {
			System.out.println("Data_Stub"+new UpdateService_Stub().update(upo, field, value));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	删除数据库中用户数据
	---------------------------------------------*/
	public DeleteState deleteUser(UserVO user){
		System.out.println("Logic_Stub "+"删除成功");
		UserPO upo=new UserPO(user.getId(),null,user.getName(),user.getRole(),null, null);
		try {
			System.out.println("Data_Stub"+new DeleteService_Stub().delete(upo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DeleteState state=DeleteState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	查找数据库中用户数据
	---------------------------------------------*/
	public ArrayList<UserVO> searchUser(String id){
		System.out.println("Logic_Stub "+"查看成功");
		ArrayList<String> string=new ArrayList<String>();
		ArrayList<UserVO> list=new ArrayList<UserVO>();
		string.add(id);
		try {
			ArrayList<UserPO> polist=new SearchService_Stub().searchUser(string);
			for(int i=0;i<polist.size();i++){
				UserVO user=new UserVO(polist.get(i).getID(),polist.get(i).getName(),polist.get(i).getRole());
				list.add(user);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
}
