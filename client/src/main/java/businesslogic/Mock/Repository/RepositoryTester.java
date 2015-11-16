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
		System.out.println(mockBalance.balance());
		System.out.println(getNeedRemoval.getNeedRemoval());
		System.out.println(getNeedStorage.getNeedStorage());
		System.out.println(removal.removal(null));
		System.out.println(see.see(null, null));
		System.out.println(stockTaking.stockTakingConfirm());
		System.out.println(stockTakingExcel.stockTakingExcel());
		System.out.println(stockTakingConfirm.stockTaking());
	}
}
