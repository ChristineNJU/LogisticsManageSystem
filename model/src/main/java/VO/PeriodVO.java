package VO;

import java.util.ArrayList;
import java.util.Date;

import PO.PeriodPO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodVO.
 */
public class PeriodVO extends VO {

	/** The date. */
	private Date date = null;
	
	/** The institution_size. */
	private int institution_size = 0;
	
	/** The staff_size. */
	private int staff_size = 0;
	
	/** The car_size. */
	private int car_size = 0;
	
	/** The storage_size. */
	private int storage_size = 0;
	
	/** The account. */
	private ArrayList<AccountVO> account = new ArrayList<AccountVO>();
	
	/**
	 * Instantiates a new period vo.
	 *
	 * @param date the date
	 * @param institution_size the institution_size
	 * @param staff_size the staff_size
	 * @param car_size the car_size
	 * @param storage_size the storage_size
	 * @param account the account
	 */
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
	
	/**
	 * Instantiates a new period vo.
	 *
	 * @param po the po
	 */
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

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Gets the institution_size.
	 *
	 * @return the institution_size
	 */
	public int getInstitution_size() {
		return institution_size;
	}

	/**
	 * Gets the staff_size.
	 *
	 * @return the staff_size
	 */
	public int getStaff_size() {
		return staff_size;
	}

	/**
	 * Gets the car_size.
	 *
	 * @return the car_size
	 */
	public int getCar_size() {
		return car_size;
	}

	/**
	 * Gets the storage_size.
	 *
	 * @return the storage_size
	 */
	public int getStorage_size() {
		return storage_size;
	}

	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public ArrayList<AccountVO> getAccount() {
		return account;
	}
	
}
