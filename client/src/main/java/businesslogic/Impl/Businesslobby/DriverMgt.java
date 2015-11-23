package businesslogic.Impl.Businesslobby;

import java.rmi.Naming;
import java.util.ArrayList;

import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import PO.DriverInfoPO;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.DriverInfoVO;
import businesslogic.Service.BusinessLobby.AddDriverService;
import businesslogic.Service.BusinessLobby.DeleteDriverService;
import businesslogic.Service.BusinessLobby.GetDriverService;
import businesslogic.Service.BusinessLobby.UpdateDriverService;

public class DriverMgt implements AddDriverService,DeleteDriverService,UpdateDriverService,GetDriverService{

	@Override
	public ArrayList<DriverInfoVO> searchDriver(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateState updateDriver(DriverInfoVO driver, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteState deleteDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState AddDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
				AddState state=AddState.SUCCESS;
				
				try{
					AddService driverAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
					state=driverAdd.add(new DriverInfoPO(driver));
				} catch (Exception ex){
					state=AddState.CONNECTERROR;
					System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
				
				return state;
	}

}
