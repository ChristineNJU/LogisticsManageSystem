package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;
import data.Service.Search.SearchInstitutionInfoService;
import data.Service.Update.UpdateService;
import PO.InstitutionPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.InstitutionVO;
import businesslogic.Service.Manage.AddInstitutionService;
import businesslogic.Service.Manage.DeleteInstitutionService;
import businesslogic.Service.Manage.GetInstitutionService;
import businesslogic.Service.Manage.UpdateInstitutionService;
import businesslogic.URLHelper.URLHelper;

public class ManageInstitution implements AddInstitutionService,UpdateInstitutionService,
											DeleteInstitutionService,GetInstitutionService{

	@Override
	public ArrayList<InstitutionVO> searchInstitution(String id) {
		// TODO Auto-generated method stub
		ArrayList<InstitutionVO> result=new ArrayList<InstitutionVO>();
		try {
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("id="+id);
			ArrayList<InstitutionPO> searchresult=searchInstitution.searchInstitutionInfo(requirement);
			
			if(searchresult.isEmpty()){
				System.out.println("not found");
				return null;
			}
			
			else{
				for(int i=0;i<searchresult.size();i++){
					InstitutionVO temp=new InstitutionVO(searchresult.get(i));
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
	public DeleteState deleteInstitution(InstitutionVO insitiution) {
		// TODO Auto-generated method stub
		DeleteState result=DeleteState.FAIL;
		try {
			DeleteService deleteService=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			InstitutionPO requirement=new InstitutionPO(insitiution.getName(), insitiution.getType(),
											insitiution.getCity(), insitiution.getCode(), URLHelper.getInstitutionURL());
			result=deleteService.delete(requirement);			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public UpdateState UpdateInstitution(InstitutionVO institution,
			String field, String value) {
		// TODO Auto-generated method stub
		UpdateState result=UpdateState.NOTFOUND;
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			InstitutionPO requirement=new InstitutionPO(institution.getName(), institution.getType(),
										institution.getCity(), institution.getCode(), URLHelper.getInstitutionURL());
			result=updateService.update(requirement, field, value);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=UpdateState.CONNECTERROR;
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public AddState addInstitution(InstitutionVO institution) {
		// TODO Auto-generated method stub
		AddState result=AddState.FAIL;
		try {
			AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			InstitutionPO requirement=new InstitutionPO(institution.getName(), institution.getType(),
								institution.getCity(), institution.getCode(), URLHelper.getInstitutionURL());
			result=addService.add(requirement);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
