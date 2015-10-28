package businesslogic.VO;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.PO.PeriodPO;

public class PeriodVO extends VO {

	private Date date = null;
	private int institution_size = 0;
	private int staff_size = 0;
	private int car_size = 0;
	private int storage_size = 0;
	private ArrayList<AccountVO> account = new ArrayList<AccountVO>();
	
	public PeriodVO(Date date, int institution_size, int staff_size, int car_size, int storage_size, 
			ArrayList<AccountVO> account) {
		// TODO Auto-generated constructor stub
		this.date = date;
		this.institution_size = institution_size;
		this.staff_size = staff_size;
		this.car_size = car_size;
		this.storage_size = storage_size;
		this.account = account;
	}
	public PeriodVO(PeriodPO po) {
		this.date = po.getDate();
		this.institution_size = po.getInstitutionSize();
		this.staff_size = po.getStaffSize();
		this.car_size = po.getCarSize();
		this.storage_size = po.getStorageSize();
		for(int i=0;i<po.getAccount().size();i++){
			account.add(new AccountVO(po.getAccount().get(i)));
		}
	}

	public Date getDate() {
		return date;
	}

	public int getInstitution_size() {
		return institution_size;
	}

	public int getStaff_size() {
		return staff_size;
	}

	public int getCar_size() {
		return car_size;
	}

	public int getStorage_size() {
		return storage_size;
	}

	public ArrayList<AccountVO> getAccount() {
		return account;
	}
	
}
