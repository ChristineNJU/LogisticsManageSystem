package businesslogic.Mock.Businesslobby;

import java.util.ArrayList;

import VO.ArrivalVO;

public class MockBusinessLobbyTester {

	public void testBusinessLobby(){
		MockArrival mockArrival = new MockArrival();
		MockCarMgt mockCarMgt = new MockCarMgt();
		MockDriverMgt mockDriver = new MockDriverMgt();
		MockEntrucking mockEntrucking = new MockEntrucking();
		MockGathering mockGathering = new MockGathering();
		MockGetNeedEntrucking getNeedEntrucking = new MockGetNeedEntrucking();
		MockGetNeedGathering getNeedGathering = new MockGetNeedGathering();
		
		System.out.println(mockArrival.arrival(new ArrayList<ArrivalVO>()));
		System.out.println(mockCarMgt.addCar(null));
		System.out.println(mockCarMgt.deleteCar(null));
		System.out.println(mockCarMgt.searchCar(null));
		System.out.println(mockDriver.searchDriver(null));
		System.out.println(mockDriver.deleteDriver(null));
		System.out.println(mockEntrucking.entrucking(null));
		System.out.println(mockGathering.gathering(null));
		System.out.println(getNeedEntrucking.getNeedEntrucking());
		System.out.println(getNeedGathering.getNeedGathering());
	}
	
}
