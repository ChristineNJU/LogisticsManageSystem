package businesslogic.Impl.Repository;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.StockTakingPO;
import State.AddState;
import VO.StockTakingVO;
import businesslogic.Service.Repository.StockTakingConfirmService;
import businesslogic.SystemLog.SystemLog;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;

public class StockTakingConfirmImpl implements StockTakingConfirmService{

	@Override
	public AddState stockTakingConfirm(ArrayList<StockTakingVO> stockList) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			AddService stockTakingAdd=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			for(int i=0;i<stockList.size();i++){
				state=stockTakingAdd.add(new StockTakingPO(stockList.get(i), SystemLog.getInstitutionId()));
			}
		} catch (Exception ex) {
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

}
