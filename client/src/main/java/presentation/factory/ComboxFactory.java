package presentation.factory;

import javax.swing.JComboBox;

import presentation.components.FlatComboBox;

public class ComboxFactory {

	public static FlatComboBox getPositionComboBox(){
		String[] position = {"管理员","营业厅业务员","快递员","财务人员","总经理","中转中心业务员","仓库管理员"}; 
		FlatComboBox positionC = new FlatComboBox(position);  
		return positionC;
	}
	
	public static FlatComboBox getGenderComboBox(){
		String[] gender = {"男","女"}; 
		FlatComboBox  genderC = new FlatComboBox(gender);  
        return genderC;
	}
	
	public static FlatComboBox getCityComboBox(){
		String[] city = {"南京","北京","上海","广州"};
		FlatComboBox  cityC = new FlatComboBox(city);  
		return cityC;
	}
	
	public static FlatComboBox getAgeComboBox(){
		String[] age = new String[42];
		 for(int i = 0;i < age.length;i++)
	        	age[i] = i+18+"";
		 FlatComboBox ageC = new FlatComboBox(age);  
       return ageC;
	}
	
	public static FlatComboBox getInstitutionComboBox(){
		String[] institution = {"营业厅","中转中心","仓库","总部"};
		FlatComboBox institutionC = new FlatComboBox(institution); 
		return institutionC;
	}
	
	public static FlatComboBox getLogisticsStateComboBox(){
		String[] logisticsState = {"完整","丢失","损坏"}; 
		FlatComboBox  logisticsStateC = new FlatComboBox(logisticsState);  
		return logisticsStateC;
	}
	
	public static FlatComboBox getCostTypeComboBox(){
		String[] costType = {"租金","运费","薪水","奖金"}; 
		FlatComboBox  costTypeC = new FlatComboBox(costType);  
		return costTypeC;
	}
	
	public static FlatComboBox getOldArea(){
		FlatComboBox old_area = new FlatComboBox();
		old_area.addItem("航空区");
		old_area.addItem("汽运区");
		old_area.addItem("铁路区");
		return old_area;
	}

	public static FlatComboBox getNewArea(){
		FlatComboBox new_area = new FlatComboBox();
		new_area.addItem("航空区");
		new_area.addItem("汽运区");
		new_area.addItem("铁路区");
		new_area.addItem("机动区");
		return new_area;
	}
	
	public static FlatComboBox getPosition(){
		FlatComboBox position = new FlatComboBox();
		for(int i=1;i<=10;i++){
			position.addItem(i+"");
		}
		return position;
	}
}

