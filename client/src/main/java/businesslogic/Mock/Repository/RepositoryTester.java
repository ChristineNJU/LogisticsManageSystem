package businesslogic.Mock.Repository;

public class RepositoryTester {

	public void testAll(){
		MockAlarm mockAlarm = new MockAlarm();
		MockBalance mockBalance = new MockBalance();
		MockGetNeedRemoval getNeedRemoval = new MockGetNeedRemoval();
		MockGetNeedStorage getNeedStorage = new MockGetNeedStorage();
		MockRemoval removal = new MockRemoval();
		MockSee see = new MockSee();
		MockStockTaking stockTaking= new MockStockTaking();
		MockStockTakingExcel stockTakingExcel = new MockStockTakingExcel();
		MockStockTakingConfirm stockTakingConfirm = new MockStockTakingConfirm();
		
		System.out.println(mockAlarm.alarm());
	}
}
