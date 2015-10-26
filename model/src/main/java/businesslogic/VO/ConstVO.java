package businesslogic.VO;

import businesslogic.PO.ConstPO;

public class ConstVO extends VO {

	private String name = null;
	private double value = 0;
	
	public ConstVO(String name,double value){
		this.name = name;
		this.value = value;
	}
	public ConstVO(ConstPO po) {
		this.name = po.getName();
		this.value = po.getValue();
	}
	
	public String getName(){
		return this.name;
	}
	public double getValue(){
		return this.value;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setValue(double value){
		this.value = value;
	}
	
}
