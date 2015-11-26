package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.BalancePO;
import State.AddState;
import VO.BalanceVO;
import businesslogic.Service.Repository.AddBalanceService;
import businesslogic.SystemLog.SystemLog;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;

public class BalanceImpl implements AddBalanceService {

	@Override
	public AddState addBalance(ArrayList<BalanceVO> balance) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService balanceAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			for(int i=0;i<balance.size();i++){
				state=balanceAdd.add(new BalancePO(balance.get(i),SystemLog.getInstitutionId()));
			}
		} catch (Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

}
