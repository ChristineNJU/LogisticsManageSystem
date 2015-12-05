package presentation.main;

import State.InstitutionType;
import State.LogisticsState;
import State.LogisticsType;
import State.PackingCharge;
import State.StorageArea;
import State.UserRole;

public class Translater {

	public static String getChineseForInstitution(InstitutionType type){
		switch(type){
		case BusinessLobby:
			return "营业厅";
		case MediumCenter:
			return "中转中心";
		case Repository:
			return "仓库";
		case Other:
			return "总部";
		default:
			return "总部";
		}
	}
	
	public static String getChineseLogisticsState(LogisticsState state){
		switch(state){
		case INTACT:
			return "完整";
		case LOST:
			return "丢失";
		case DAMAGED:
			return "损坏";
		default:
			return "完整";
			
		}
		
	}
	public static InstitutionType getInstitutionType(String s){
		switch(s){
		case "营业厅":
			return InstitutionType.BusinessLobby;
		case "中转中心":
			return InstitutionType.MediumCenter;
		case "仓库":
			return InstitutionType.Repository;
		case "总部":
			return InstitutionType.Other;
		default:
			return InstitutionType.Other;
		}
	}
	
 	public static String getChineseForUserRole(UserRole role){
		switch(role){
		case admin:
			return "管理员";
		case businessAgent:
			return "营业厅业务员";
		case courier:
			return "快递员";
		case finance:
			return "财务人员";
		case manager:
			return "总经理";
		case mediumAgent:
			return "中转中心业务员";
		case repository:
			return "仓库管理员";
		default:
			return "职业";
		}
	}
	
 	public static UserRole getUserRole(String s){
		switch(s){
		case "管理员":
			return UserRole.admin;
		case "营业厅业务员":
			return UserRole.businessAgent;
		case "快递员":
			return UserRole.courier;
		case "财务人员":
			return UserRole.finance;
		case "总经理":
			return UserRole.manager;
		case "中转中心业务员":
			return UserRole.mediumAgent;
		case "仓库管理员":
			return UserRole.repository;
		default:
			return UserRole.uninit;
		}
	}
 	
 	public static LogisticsType getLogisticsType(String s) {
 		switch(s){
 		case "标准快递":
 			return LogisticsType.STANDARD;
 		case "经济快递":
 			return LogisticsType.ECONOMIC;
 		case "次晨特快":
 			return LogisticsType.EXPRESS;
 		default:
 			return LogisticsType.STANDARD;
 		}
 	}
 	
 	public static PackingCharge getPackingCharge(String s) {
 		switch(s){
 		case "木箱":
 			return PackingCharge.WOODEN_CASE;
 		case "纸箱":
 			return PackingCharge.PAPER_CASE;
 		case "快递袋":
 			return PackingCharge.COURISE_BAG;
 		default:
 			return PackingCharge.PAPER_CASE;
 		}
 	}
 	public static LogisticsState getLogisticsState(String s){
 		switch(s){
 		case "完整":
 			return LogisticsState.INTACT;
 		case "丢失":
 			return LogisticsState.LOST;
 		case "损坏":
 			return LogisticsState.DAMAGED;
 		default:
 			return LogisticsState.INTACT;
 		}
 	}
 	
 	public static StorageArea getStorageArea(String s) {
 		switch(s){
 		case "航空区":
 			return StorageArea.AIR_TRANSPORTATION;
 		case "汽运区":
 			return StorageArea.CAR_TRANSPORTATION;
 		case "铁路区":
 			return StorageArea.RAILWAY_TRANSPORTATION;
 		case "机动区":
 			return StorageArea.MANOEUVERING_AREA;
 		default:
 			return StorageArea.MANOEUVERING_AREA;
 		}
 	}
}
