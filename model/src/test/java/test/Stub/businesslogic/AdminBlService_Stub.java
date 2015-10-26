package test.Stub.businesslogic;

import java.util.ArrayList;

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
		System.out.println("添加成功");
		AddState state=AddState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	 更新数据库中用户数据
	---------------------------------------------*/
	public UpdateState updateUser(UserVO user, String field, String value){
		System.out.println("更新成功");
		UpdateState state=UpdateState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	删除数据库中用户数据
	---------------------------------------------*/
	public DeleteState deleteUser(UserVO user){
		System.out.println("删除成功");
		DeleteState state=DeleteState.SUCCESS;
		return state;
	}
	/*-------------------------------------------
	查找数据库中用户数据
	---------------------------------------------*/
	public ArrayList<UserVO> searchUser(String id){
		System.out.println("查看成功");
		UserVO vo1=new UserVO("1234512345","刘钦",UserRole.curier);
		UserVO vo2=new UserVO("1234512346","刘钦",UserRole.admin);
		ArrayList<UserVO> list=new ArrayList<UserVO>();
		list.add(vo1);
		list.add(vo2);
		return list;
	}
	
	
}
