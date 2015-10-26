package test.Driver.businesslogic;

import java.util.ArrayList;

import test.Stub.businesslogic.FinanceBlService_Stub;
import businesslogic.VO.AccountVO;
import businesslogic.VO.BenefitVO;
import businesslogic.VO.CostVO;
import businesslogic.VO.EntruckingVO;
import businesslogic.VO.GatheringVO;
import businesslogic.VO.LogVO;
import businesslogic.VO.TransferVO;

public class Finance_Driver {
	public void drive(FinanceBlService_Stub finance){
		ArrayList<GatheringVO> gathering=finance.searchGathering(null, null);
		System.out.println();
		for(int i=0;i<gathering.size();i++){
			gathering.get(i).getDate();
			gathering.get(i).getName();
			gathering.get(i).getMoney();
		}
		System.out.println();
		
		CostVO cost=new CostVO(null, 0, null, null, null, null);
		System.out.println(finance.addCost(cost));
		System.out.println();
		
		ArrayList<EntruckingVO> entrucking=finance.getEntrucking(null, null);
		System.out.println();
		for(int i=0;i<entrucking.size();i++){
			System.out.println(entrucking.get(i).getAmount());
			ArrayList<String> barcode=entrucking.get(i).getBarCodeList();
			for(int j=0;j<barcode.size();j++)
				System.out.println(barcode.get(j));
			System.out.println(entrucking.get(i).getCarNumber());
			System.out.println(entrucking.get(i).getDate());
			System.out.println(entrucking.get(i).getDestination());
			System.out.println(entrucking.get(i).getguardNumber());
			System.out.println(entrucking.get(i).getInstitutioNumber());
			System.out.println(entrucking.get(i).getSupercargoName());
		}
		System.out.println();
		
		ArrayList<TransferVO> transfer=finance.getTransfer(null, null);
		System.out.println();
		for(int i=0;i<transfer.size();i++){
			ArrayList<String> itemID=transfer.get(i).getItemId();
			for(int j=0;j<itemID.size();j++)
				System.out.println(itemID.get(j));
			System.out.println(transfer.get(i).getArrival());
			System.out.println(transfer.get(i).getContainerNumber());
			System.out.println(transfer.get(i).getDate());
			System.out.println(transfer.get(i).getDeparture());
			System.out.println(transfer.get(i).getGuardName());
			System.out.println(transfer.get(i).getList());
			System.out.println(transfer.get(i).getTransferCharge());
			System.out.println(transfer.get(i).getTransferId());
			
		}
		System.out.println();
		
		ArrayList<CostVO> costlist=finance.searchCost(null, null);
		System.out.println();
		for(int i=0;i<costlist.size();i++){
			System.out.println(costlist.get(i).getAmount());
			System.out.println(costlist.get(i).getDate());
			System.out.println(costlist.get(i).getPayer());
			System.out.println(costlist.get(i).getPayerAccount());
			System.out.println(costlist.get(i).getRemark());
			System.out.println(costlist.get(i).getType());
		}
		System.out.println();
		
		BenefitVO benefit=new BenefitVO(0, 0);
		System.out.println(finance.addBenefit(benefit));
		System.out.println();
		
		benefit=finance.searchBenefit(null);
		System.out.println(benefit.getBenefit());
		System.out.println(benefit.getCost());
		System.out.println(benefit.getIncome());
		System.out.println();
		
		ArrayList<AccountVO> account=finance.searchAccount(null);
		for(int i=0;i<account.size();i++){
			System.out.println(account.get(i).getName());
			System.out.println(account.get(i).getMoney());
		}
		System.out.println();
		
		AccountVO accountvo=new AccountVO(null, 0);
		System.out.println(finance.addAccount(accountvo));
		System.out.println();
		
		System.out.println(finance.deleteAccount(accountvo));
		System.out.println();
		
		System.out.println(finance.updateAccount(accountvo, null, null));
		System.out.println();
		
		ArrayList<LogVO> log=finance.getLog(null, null);
		for(int i=0;i<log.size();i++){
			System.out.println(log.get(i).getOperation());
			System.out.println(log.get(i).getOperator());
			System.out.println(log.get(i).getTime());
		}
		System.out.println();
		
		
	}
	
	public static void main(String[] args){
		new Finance_Driver().drive(new FinanceBlService_Stub());
	}
}

