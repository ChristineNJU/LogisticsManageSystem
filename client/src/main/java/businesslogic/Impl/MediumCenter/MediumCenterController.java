package businesslogic.Impl.MediumCenter;

import java.util.ArrayList;

import State.AddState;
import VO.ArrivalVO;
import VO.EntruckingVO;
import VO.TransferVO;
import businesslogic.Service.MediumCenter.MCService;
import businesslogic.SystemLog.SystemLog;

// TODO: Auto-generated Javadoc
/**
 * The Class MediumCenterController.
 * 
 * @author 张晨剑
 * @version 1.0.0
 */
public class MediumCenterController implements MCService{

	/**
	 * @see TransferImpl
	 * @see SystemLog#addLog(String)
	 * @see businesslogic.Service.MediumCenter.MCService#transfer(VO.TransferVO)
	 */
	@Override
	public AddState transfer(TransferVO transfer) {
		// TODO Auto-generated method stub
		TransferImpl Transfer=new TransferImpl();
		AddState state = Transfer.transfer(transfer);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加中转单信息");
		}
		return state;
	}

	/**
	 * @see GetNeedTransferImpl
	 * @see businesslogic.Service.MediumCenter.MCService#getNeedTransfer()
	 */
	@Override
	public ArrayList<TransferVO> getNeedTransfer() {
		// TODO Auto-generated method stub
		GetNeedTransferImpl getNeedTransfer=new GetNeedTransferImpl();
		return getNeedTransfer.getNeedTransfer();
	}

	/**
	 * @see GetNeedEntruckingImpl
	 * @see businesslogic.Service.MediumCenter.MCService#getNeedEntrucking()
	 */
	@Override
	public ArrayList<EntruckingVO> getNeedEntrucking() {
		// TODO Auto-generated method stub
		GetNeedEntruckingImpl getNeedEntrucking =new GetNeedEntruckingImpl();
		return getNeedEntrucking.getNeedEntrucking();
	}

	/**
	 * @see EntruckingImpl
	 * @see SystemLog#addLog(String)
	 * @see businesslogic.Service.MediumCenter.MCService#entrucking(VO.EntruckingVO)
	 */
	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		EntruckingImpl Entrucking=new EntruckingImpl();
		AddState state = Entrucking.entrucking(entrucking);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加装车单信息");
		}
		return state;
	}

	/**
	 * @see ArrivalImpl
	 * @see SystemLog#addLog(String)
	 * @see businesslogic.Service.MediumCenter.MCService#arrival(java.util.ArrayList)
	 */
	@Override
	public AddState arrival(ArrayList<ArrivalVO> arrival) {
		// TODO Auto-generated method stub
		ArrivalImpl Arrival=new ArrivalImpl();
		AddState state = Arrival.arrival(arrival);
		if(state==AddState.SUCCESS){
			SystemLog.addLog("添加到达单信息");
		}
		return state;
	}

}
