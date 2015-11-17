package test.Driver.businesslogic;

import java.util.ArrayList;

import VO.StockTakingVO;
import VO.VO;
import test.Stub.businesslogic.ReponsitoryBlService_Stub;

public class Repository_Driver {
	
	public void drive(ReponsitoryBlService_Stub repositorybl){
		
		ArrayList<StockTakingVO> stockingTakingList = repositorybl.stockTaking();
		for(int i = 0;i < stockingTakingList.size();i++){
			System.out.println(stockingTakingList.get(i));
		}
		
		System.out.println(repositorybl.stockTakingConfirm());
		
		System.out.println(repositorybl.stockTakingExcel());
	
		System.out.println(repositorybl.getNeedStorage());
	
		System.out.println(repositorybl.storage(null));
		
		System.out.println(repositorybl.removal(null));
		
		System.out.println(repositorybl.balance(null));
		
		System.out.println(repositorybl.alarm());
		
		ArrayList<VO> voList = repositorybl.see(null, null);
		for(int i = 0;i < voList.size();i++){
			System.out.println(voList.get(i));
		}
	
	
	
	}
}
