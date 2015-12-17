package PO;

import businesslogic.URLHelper.URLHelper;
import State.InstitutionType;
import State.StateSwitch;
import VO.InstitutionVO;
/**
 * 用来保存机构信息的持久化数据格式
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public class InstitutionPO extends PO {
	
	// ----- member variables ---------------------------------------
	private String institution_name = "";
	private InstitutionType institution_type;
	private String city = "";
	private String institution_number = "";
	
	/**
	 * 直接创建机构信息的持久化数据对象
	 * */
	public InstitutionPO(String institution_name, InstitutionType institution_type, String city, String institution_number, 
			 String DB_URL) {
		super(DB_URL);
		// TODO Auto-generated constructor stub
		this.institution_name = institution_name;
		this.institution_type = institution_type;
		this.city = city;
		this.institution_number = institution_number;
	}
	
	/**
	 * 通过InstitutionVO创建机构信息的持久化数据对象
	 * */
	public InstitutionPO(InstitutionVO institution){
		super(URLHelper.getInstitutionURL());
		this.institution_name = institution.getName();
		this.institution_type = institution.getType();
		this.city = institution.getCity();
		this.institution_number = institution.getCode();
	}
	/*===============================================================
	 * Public方法
	 * */
	
	/*---------------------------------------------------------------
	 * 对InstitutionPO的数据进行读取
	 * */
	/**
	 * 获取机构名称
	 * 
	 * @return 机构名称String
	 * */
	public String getInstitutionName() {
		return institution_name;
	}
	
	/**
	 * 获取机构类型
	 * 
	 * @return 机构类型InstitutionType
	 * */
	public InstitutionType getInstitutionType() {
		return institution_type;
	}
	
	/**
	 * 获取机构所在城市
	 * 
	 * @return 所在城市String
	 * */
	public String getCity() {
		return city;
	}
	
	/**
	 * 获取机构编号
	 * 
	 * @return 机构编号String
	 * */
	public String getInstitutionNumber() {
		return institution_number;
	}
	
	
	/*--------------------------------------------------------------
	 * 对InstitutionPO的某些信息进行更新
	 * */
	/**
	 * 更新机构名称
	 * 
	 * @param institution_name 新机构名称
	 * */
	public void setInstitutionName(String institution_name) {
		this.institution_name = institution_name;
	}

	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = "";
		
		result = result + "'" + institution_name + "', ";
		result = result + "'" + StateSwitch.switchToStr(institution_type) + "', ";
		result = result + "'" + city + "', ";
		result = result + "'" + institution_number + "'";
		
		System.out.println(result);
		return result;
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "institution_number = '"+institution_number+"'";
	}
	
}
