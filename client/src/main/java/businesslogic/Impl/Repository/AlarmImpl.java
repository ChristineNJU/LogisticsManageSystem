package businesslogic.Impl.Repository;

import java.rmi.Naming;

import State.StorageArea;
import businesslogic.Service.Repository.AlarmService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Sundry.WareHouseService;

// TODO: Auto-generated Javadoc
/**
 * The Class AlarmImpl.
 */
public class AlarmImpl implements AlarmService {

	/* (non-Javadoc)
	 * @see businesslogic.Service.Repository.AlarmService#alarm()
	 */
	@Override
	public boolean alarm() {
		// TODO Auto-generated method stub
		boolean isOverflow=false;
		try{
			WareHouseService wareHouse=(WareHouseService) Naming.lookup(RMIHelper.WAREHOUSE_IMPL);
			if(wareHouse.getAmount(URLHelper.getWareHouseURL(SystemLog.getInstitutionId()), StorageArea.AIR_TRANSPORTATION)>1000||wareHouse.getAmount(URLHelper.getWareHouseURL(SystemLog.getInstitutionId()), StorageArea.CAR_TRANSPORTATION)>1000||wareHouse.getAmount(URLHelper.getWareHouseURL(SystemLog.getInstitutionId()), StorageArea.MANOEUVERING_AREA)>1000||wareHouse.getAmount(URLHelper.getWareHouseURL(SystemLog.getInstitutionId()), StorageArea.RAILWAY_TRANSPORTATION)>1000){
				isOverflow=true;
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return isOverflow;
	}

}
