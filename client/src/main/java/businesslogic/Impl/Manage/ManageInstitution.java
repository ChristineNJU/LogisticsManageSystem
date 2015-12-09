package businesslogic.Impl.Manage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.InstitutionPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.InstitutionVO;
import businesslogic.Service.Manage.ManageInstitutionService;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Delete.DeleteService;
import data.Service.Search.SearchInstitutionInfoService;
import data.Service.Sundry.TableOperationService;
import data.Service.Update.UpdateService;

// TODO: Auto-generated Javadoc
/**
 * The Class ManageInstitution.
 */
public class ManageInstitution implements ManageInstitutionService{
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageInstitutionService#searchInstitution(java.lang.String)
	 */
	@Override
	public ArrayList<InstitutionVO> searchInstitution(String id) {
		// TODO Auto-generated method stub
		ArrayList<InstitutionVO> result=new ArrayList<InstitutionVO>();
		try {
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			ArrayList<String> requirementId=new ArrayList<String>();
			ArrayList<String> requirementName=new ArrayList<String>();
			
			//show  when id==null
			if(!id.equals("%%")){
			requirementId.add("institution_number='"+id+"'");
			requirementName.add("institution_name'"+id+"'");
			}
			else{
				requirementId.add("institution_number like '%%'");
			}
			
			
			ArrayList<InstitutionPO> searchResultId=searchInstitution.searchInstitutionInfo(requirementId);
			ArrayList<InstitutionPO> searchResultName=searchInstitution.searchInstitutionInfo(requirementName);
			
			for(int i=0;i<searchResultName.size();i++)
				searchResultId.add(searchResultName.get(i));
			
			
			if(searchResultId.isEmpty()){
				System.out.println("not found");
				return result;
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageInstitutionService#deleteInstitution(VO.InstitutionVO)
	 */
	@Override
	public DeleteState deleteInstitution(InstitutionVO institution) {
		// TODO Auto-generated method stub
		DeleteState result=DeleteState.FAIL;
		try {
			DeleteService deleteService=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			TableOperationService operationInstitution=(TableOperationService) Naming.lookup(RMIHelper.TABLE_OPERATION_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("institution_number='"+institution.getCode()+"'");
			ArrayList<InstitutionPO> searchResult=searchInstitution.searchInstitutionInfo(requirement);			
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return DeleteState.FAIL;
				}
			else{
				for(int i=0;i<searchResult.size();i++){
					result=deleteService.delete(searchResult.get(i));
					operationInstitution.deleteInstitutionTable(institution.getCode(), institution.getType());
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=DeleteState.FAIL;
			System.out.println("Exception");
			e.printStackTrace();
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageInstitutionService#UpdateInstitution(VO.InstitutionVO)
	 */
	@Override
	public UpdateState UpdateInstitution(InstitutionVO institution) {
		// TODO Auto-generated method stub
		UpdateState result=UpdateState.NOTFOUND;
		try {
			UpdateService updateService=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			SearchInstitutionInfoService searchInstitution=(SearchInstitutionInfoService) Naming.lookup(RMIHelper.SEARCH_INSTITUTION_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("institution_number='"+institution.getCode()+"'");
			ArrayList<InstitutionPO> searchResult=searchInstitution.searchInstitutionInfo(requirement);		
			
			if(searchResult.isEmpty()){
				System.out.println("not found");
				return UpdateState.NOTFOUND;
				}
			else{
				
					result=updateService.update(new InstitutionPO(institution));
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=UpdateState.CONNECTERROR;
			System.out.println("Exception");
			e.printStackTrace();
		}
			
		return result;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Manage.ManageInstitutionService#addInstitution(VO.InstitutionVO)
	 */
	@Override
	public AddState addInstitution(InstitutionVO institution) {
		// TODO Auto-generated method stub
		AddState result=AddState.FAIL;
		try {
			AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			TableOperationService operationInstitution=(TableOperationService) Naming.lookup(RMIHelper.TABLE_OPERATION_IMPL);
			InstitutionPO requirement=new InstitutionPO(institution);
			result=addService.add(requirement);
			operationInstitution.createInstitutionTable(institution.getCode(), institution.getType());
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			result=AddState.FAIL;
			System.out.println("Exception");
			e.printStackTrace();
		}
		
		return result;
	}

}
