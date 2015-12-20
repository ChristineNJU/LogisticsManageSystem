package businesslogic.test.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.URLHelper.URLHelper;
import junit.framework.TestCase;
import PO.InstitutionStoragePO;
import data.RMIHelper.RMIHelper;
import data.Service.Update.UpdateService;

public class TestdeleteInstitutionStorage extends TestCase {

	public void testUpdateInstitutionStorage() {
		try {
			UpdateService update=(UpdateService) Naming.lookup(RMIHelper.INSTITUTION_STORAGE_IMPL);
			InstitutionStoragePO po=new InstitutionStoragePO("0000000008",true,false,URLHelper.getInstitutionStorage("0250"));
			update.update(po);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
