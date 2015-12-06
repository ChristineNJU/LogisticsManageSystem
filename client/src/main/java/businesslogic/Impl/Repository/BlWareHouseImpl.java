package businesslogic.Impl.Repository;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.WareHousePO;
import State.UpdateState;
import VO.WareHouseVO;
import businesslogic.Service.Repository.BlWareHouseService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Sundry.WareHouseService;
import data.Service.Update.UpdateService;

/**
 * 获取仓库所有快递信息
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class BlWareHouseImpl implements BlWareHouseService{

	@Override
	public ArrayList<WareHouseVO> getWareHouse() {
		// TODO Auto-generated method stub
		
		ArrayList<WareHouseVO> vo = new ArrayList<WareHouseVO>();
		try {
			WareHouseService service = (WareHouseService) Naming.lookup(RMIHelper.WAREHOUSE_IMPL);
			ArrayList<WareHousePO> tmp = service.searchWareHouse(URLHelper.getWareHouseURL(SystemLog.getInstitutionId()));
			
			for(int i=0;i<tmp.size();i++){
				vo.add(new WareHouseVO(tmp.get(i)));
			}
			
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public UpdateState updateWareHouse(WareHouseVO vo) {
		// TODO Auto-generated method stub
		UpdateState state = UpdateState.SUCCESS;
		
		try {
			UpdateService service = (UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			state = service.update(new WareHousePO(vo, URLHelper.getWareHouseURL(SystemLog.getInstitutionId())));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return UpdateState.CONNECTERROR;
		}
		return state;
	}
}
