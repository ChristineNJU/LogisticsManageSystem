package businesslogic.VO;

public class ConstVO extends VO {

	private String name = null;
	private String value = null;
	
	public ConstVO(String name,String value){
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return this.name;
	}
	public String getValue(){
		return this.value;
	}
	
}
