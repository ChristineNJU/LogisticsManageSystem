package PO;

// TODO: Auto-generated Javadoc
/**
 * The Class InstitutionStoragePO.
 * 
 * @author 尹子越
 * @version 1.0.0
 */
public class InstitutionStoragePO extends PO {

	/** The bar_code. */
	private String bar_code = "";
	
	/** The is out. */
	private boolean isOut;
	
	/** The is transfer. */
	private boolean isTransfer;
	
	/**
	 * Instantiates a new institution storage po.
	 *
	 * @param bar_code the bar_code
	 * @param isOut the is out
	 * @param isTransfer the is transfer
	 * @param DB_URL the db url
	 */
	public InstitutionStoragePO(String bar_code, boolean isOut, boolean isTransfer, String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.bar_code = bar_code;
		this.isOut = isOut;
		this.isTransfer = isTransfer;
	}

	/**
	 * Checks if is transfer.
	 *
	 * @return true, if is transfer
	 */
	public boolean isTransfer() {
		return isTransfer;
	}

	/**
	 * Sets the transfer.
	 *
	 * @param isTransfer the new transfer
	 */
	public void setTransfer(boolean isTransfer) {
		this.isTransfer = isTransfer;
	}

	/**
	 * Gets the bar_code.
	 *
	 * @return the bar_code
	 */
	public String getBar_code() {
		return bar_code;
	}

	/**
	 * Sets the bar_code.
	 *
	 * @param bar_code the new bar_code
	 */
	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}

	/**
	 * Checks if is out.
	 *
	 * @return true, if is out
	 */
	public boolean isOut() {
		return isOut;
	}

	/**
	 * Sets the out.
	 *
	 * @param isOut the new out
	 */
	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}

	/* (non-Javadoc)
	 * @see PO.PO#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		result = result+"'"+bar_code+"', ";
		result = result+"'"+isOut+"', ";
		result = result+"'"+isTransfer+"'";
		
		System.out.println(result);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see PO.PO#getPrimaryKey()
	 */
	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "bar_code = '"+bar_code+"'";
	}

}
