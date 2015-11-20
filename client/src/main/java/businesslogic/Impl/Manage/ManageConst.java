package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.ConstPO;
import PO.SalaryPO;
import State.AddState;
import State.UpdateState;
import VO.ConstVO;
import businesslogic.Service.Manage.AddConstService;
import businesslogic.Service.Manage.ShowConstService;
import businesslogic.Service.Manage.UpdateConstService;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Search.SearchConstService;
import data.Service.Update.UpdateService;

public class ManageConst implements ShowConstService,UpdateConstService,AddConstService{

	@Override
	public ArrayList<ConstVO> showConst() {
		// TODO Auto-generated method stub
		ArrayList<ConstVO> result=new ArrayList<ConstVO>();
		try {
			SearchConstService searchConst=(SearchConstService) Naming.lookup(RMIHelper.SEARCH_CONST_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
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
	public UpdateState updateConst(ConstVO constant, String field, String value) {
		// TODO Auto-generated method stub
		UpdateState result=UpdateState.NOTFOUND;
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
			SearchConstService searchConst=(SearchConstService) Naming.lookup(RMIHelper.SEARCH_CONST_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("name="+constant.getName());
			ArrayList<ConstPO> searchResult=searchConst.searchConst(requirement);
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return UpdateState.NOTFOUND;
				}
			else{
				for(int i=0;i<searchResult.size();i++)
					result=updateService.update(searchResult.get(i), field, value);
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

}
