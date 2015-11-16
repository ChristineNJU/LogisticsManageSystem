package businesslogic.Mock.Repository;

import java.util.ArrayList;

import businesslogic.Impl.Reponsitory.SeeImpl;
import businesslogic.VO.VO;

public class MockSee extends  SeeImpl{

	@Override
	public ArrayList<VO> see(String time_start, String time_end) {
		// TODO Auto-generated method stub
		return new ArrayList<VO>();
	}

}
