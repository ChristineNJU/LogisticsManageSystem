package businesslogic.Impl.MediumCenter;

import java.util.ArrayList;

import State.AddState;
import VO.ArrivalVO;
import VO.EntruckingVO;
import VO.TransferVO;
import businesslogic.Service.MediumCenter.MCService;
import businesslogic.SystemLog.SystemLog;

public class MediumCenterController implements MCService{

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

	@Override
	public ArrayList<TransferVO> getNeedTransfer() {
		// TODO Auto-generated method stub
		GetNeedTransferImpl getNeedTransfer=new GetNeedTransferImpl();
		return getNeedTransfer.getNeedTransfer();
	}

	@Override
	public ArrayList<EntruckingVO> getNeedEntrucking() {
		// TODO Auto-generated method stub
		GetNeedEntruckingImpl getNeedEntrucking =new GetNeedEntruckingImpl();
		return getNeedEntrucking.getNeedEntrucking();
	}

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
