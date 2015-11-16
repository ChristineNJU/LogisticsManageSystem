package businesslogic.Impl.MediumCenter;

import java.util.ArrayList;

import data.State.AddState;
import businesslogic.Service.MediumCenter.*;
import businesslogic.VO.ArrivalVO;
import businesslogic.VO.EntruckingVO;
import businesslogic.VO.TransferVO;

public class MediumCenterController implements ArrivalService,EntruckingService,GetNeedEntruckingService,
											GetNeedTransferService,TransferService{

	@Override
	public AddState transfer(TransferVO transfer) {
		// TODO Auto-generated method stub
		TransferImpl Transfer=new TransferImpl();
		return Transfer.transfer(transfer);
	}

	@Override
	public ArrayList<String> getNeedTransfer() {
		// TODO Auto-generated method stub
		GetNeedTransferImpl getNeedTransfer=new GetNeedTransferImpl();
		return getNeedTransfer.getNeedTransfer();
	}

	@Override
	public ArrayList<String> getNeedEntrucking() {
		// TODO Auto-generated method stub
		GetNeedEntruckingImpl getNeedEntrucking =new GetNeedEntruckingImpl();
		return getNeedEntrucking.getNeedEntrucking();
	}

	@Override
	public AddState entrucking(EntruckingVO entrucking) {
		// TODO Auto-generated method stub
		EntruckingImpl Entrucking=new EntruckingImpl();
		return Entrucking.entrucking(entrucking);
	}

	@Override
	public AddState arrival(ArrayList<ArrivalVO> arrival) {
		// TODO Auto-generated method stub
		ArrivalImpl Arrival=new ArrivalImpl();
		return Arrival.arrival(arrival);
	}

}
