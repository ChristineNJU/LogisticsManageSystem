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
			ArrayList<String> requirementId=new ArrayList<String>();
			requirementId.add("Institution_Number="+id);
			ArrayList<InstitutionPO> searchResultId=searchInstitution.searchInstitutionInfo(requirementId);
			
			ArrayList<String> requirementName=new ArrayList<String>();
			requirementName.add("Institution_Name"+id);
			ArrayList<InstitutionPO> searchResultName=searchInstitution.searchInstitutionInfo(requirementName);
			
			for(int i=0;i<searchResultName.size();i++)
				searchResultId.add(searchResultName.get(i));
			
			
			if(searchResultId.isEmpty()){
				System.out.println("not found");
				return null;
			}
			
			else{
				for(int i=0;i<searchResultId.size();i++){
					InstitutionVO temp=new InstitutionVO(searchResultId.get(i));
					result.add(temp);
				}
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public DeleteState deleteInstitution(InstitutionVO instiution) {
		// TODO Auto-generated method stub
		DeleteState result=DeleteState.FAIL;
		try {
			DeleteService deleteService=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("Institution_Number="+instiution.getCode());
			ArrayList<InstitutionPO> searchResult=searchInstitution.searchInstitutionInfo(requirement);			
			
			for(int i=0;i<searchResult.size();i++)
				result=deleteService.delete(searchResult.get(i));
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=DeleteState.FAIL;
			System.out.println("Exception");
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
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("Institution_Number="+institution.getCode());
			ArrayList<InstitutionPO> searchResult=searchInstitution.searchInstitutionInfo(requirement);			
			
			for(int i=0;i<searchResult.size();i++)
				result=updateService.update(searchResult.get(i), field, value);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=UpdateState.CONNECTERROR;
			System.out.println("Exception");
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
			InstitutionPO requirement=new InstitutionPO(institution);
			result=addService.add(requirement);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=AddState.FAIL;
			System.out.println("Exception");
			e.printStackTrace();
		}
		
		return result;
	}

}
