package businesslogic.test.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import junit.framework.TestCase;
import PO.InstitutionStoragePO;
import State.UpdateState;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Update.UpdateService;

public class TestdeleteInstitutionStorage extends TestCase {

	public void testUpdateInstitutionStorage() {
		try {
			UpdateService update=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			InstitutionStoragePO po=new InstitutionStoragePO("000000008",true,false,URLHelper.getInstitutionStorage("0250"));
			UpdateState state = update.update(po);
			
			System.out.println(state);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
