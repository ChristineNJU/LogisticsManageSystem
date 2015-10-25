package businesslogic.VO;

public class AccountVO extends VO {

	private String name = null;
	private double money = 0;
	
	public AccountVO(String name,double money){
		this.name = name;
		this.money = money;
	}
	
	public String getName(){
		return this.name;
	}
	public double getMoney(){
		return this.money;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setMoney(double money){
		this.money = money;
	}
}
