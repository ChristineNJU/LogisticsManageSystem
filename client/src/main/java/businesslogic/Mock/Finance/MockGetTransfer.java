package businesslogic.Mock.Finance;

import java.util.ArrayList;

import businesslogic.Impl.Finance.GetTransferImpl;
import businesslogic.VO.TransferVO;

public class MockGetTransfer extends GetTransferImpl{
	public ArrayList<TransferVO> getTransfer(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return new ArrayList<TransferVO>();
	}
}
