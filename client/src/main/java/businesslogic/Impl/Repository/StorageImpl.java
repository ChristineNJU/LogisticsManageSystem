package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.StoragePO;
import PO.WareHousePO;
import State.AddState;
import State.StorageState;
import VO.StorageVO;
import businesslogic.Service.Repository.StorageService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Sundry.WareHouseService;

public class StorageImpl implements StorageService {

	@Override
	public StorageState storage(ArrayList<StorageVO> storage) {
		// TODO Auto-generated method stub
		StorageState state=StorageState.SUCCESS;
		try{
			AddService storageAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			AddState tempState=AddState.SUCCESS;
			WareHouseService wareManage=(WareHouseService) Naming.lookup(RMIHelper.WAREHOUSE_IMPL);
			for(int i=0;i<storage.size();i++){
				tempState=storageAdd.add(new StoragePO(storage.get(i), SystemLog.getInstitutionId()));
				if(wareManage.getAmount(URLHelper.getWareHouseURL(SystemLog.getInstitutionId()),storage.get(i).getAreaCode())>1000){
					state=StorageState.ALARM;
					break;
				}
				else if(tempState==AddState.SUCCESS){
					state=StorageState.SUCCESS;
				}
				else if(tempState==AddState.FAIL){
					state=StorageState.FAIL;
				}
			}
		} catch (Exception ex){
			state=StorageState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

}
