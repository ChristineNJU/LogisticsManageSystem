package data.Service.Search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.BenefitPO;

/**
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public interface SearchBenefitService extends Remote {
	
	/**
	 * 从数据库中搜索BenefitPO
	 * 
	 * @param DB_URL 表链接
	 * @return BenefitPO的ArrayList 
	 */
	public ArrayList<BenefitPO> searchBenefit(ArrayList<String> requirement) throws RemoteException;
}
