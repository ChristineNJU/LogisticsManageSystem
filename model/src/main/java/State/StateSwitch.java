package State;

public class StateSwitch {
	
	public static String switchToStr(LoginState state){
		String result="";
		switch (state){
		
		case CONNECTERROR: result="CONNECTERROR"; break;
		case SUCCESS: result="SUCCESS"; break;
		case WRONGID: result="WRONGID"; break;
		case WRONGPW: result="WRONGPS"; break;
		
		}
		return result;
	}
	
	public static String switchToStr(LogisticsType type){
		String result="";
		switch (type){
		
		case ECONOMIC: result="ECONOMIC"; break;
		case EXPRESS: result="EXPRESS"; break;
		case STANDARD: result="STANDARD"; break;
		
		}
		return result;
	}
	
	public static String switchToStr(PackingCharge type){
		String result="";
		switch (type){
		
		case COURISE_BAG: result="COURISE_BAG"; break;
		case PAPER_CASE: result="PAPER_CASE"; break;
		case WOODEN_CASE: result="WOODEN_CASE"; break;
		case OTHERS: result="OTHERS"; break;
		
		}
		return result;
	}
	
	public static String switchToStr(LogisticsState state){
		String result="";
		
		switch (state){
		case DAMAGED: result="DAMAGED"; break;
		case INTACT: result="INTACT"; break;
		case LOST: result="LOST"; break;
		}
		
		return result;
	}
	
	public static String switchToStr(InstitutionType type){
		String result="";
		
		switch (type){
		case BusinessLobby: result="BusinessLobby"; break;
		case MediumCenter: result="MediumCenter"; break;
		case Repository: result="Repository"; break;
		case Other: result="Other"; break;
		}
		
		return result;
	}
	
	public static String switchToStr(CostType type){
		String result="";
		
		switch (type){
		case freight: result="freight"; break;
		case rent: result="rent"; break;
		case reward: result="reward"; break;
		case salary: result="salary"; break;
		}
		
		return result;
	}
	
	public static String switchToStr(JudgeState state){
		String result="";
		
		switch (state){
		case PASS: result="PASS"; break;
		case UNPASS: result="UNPASS"; break;
		}
		
		return result;
	}
	
	public static String switchToStr(SalaryType type){
		String result="";
		
		switch (type){
		case MONTH: result="MONTH"; break;
		case ONCE: result="ONCE"; break;
		case REWARD: result="REWARD"; break;
		}
		
		return result;
	}
	
	public static String switchToStr(StorageArea type){
		String result="";
		
		switch (type){
		case AIR_TRANSPORTATION: result="AIR_TRANSPORTATION"; break;
		case CAR_TRANSPORTATION: result="CAR_TRANSPORTATION"; break;
		case MANOEUVERING_AREA: result="MANOEUVERING_AREA"; break;
		case RAILWAY_TRANSPORTATION: result="RAILWAY_TRANSPORTATION"; break;
		}
		
		return result;
	}
	
	public static String switchToStr(TransferType type){
		String result="";
		
		switch (type){
		case AIR: result="AIR"; break;
		case CAR: result="CAR"; break;
		case RAILWAY: result="RAILWAY"; break;
		}
		
		return result;
	}
	
	public static String switchToStr(UserRole role){
		String result="";
		
		switch (role){
		case admin: result="admin"; break;
		case businessAgent: result="businessAgent"; break;
		case courier: result="courier"; break;
		case finance: result="finance"; break;
		case manager: result="manager"; break;
		case mediumAgent: result="mediumAgent"; break;
		case repository: result="repository"; break;
		}
		
		return result;
	}
	
	//--------------------------------------------------------------
	
	public static LoginState switchToLoginState(String str){
		LoginState type=LoginState.CONNECTERROR;
		
		switch (str){
		case "CONNECTERROR": type=LoginState.CONNECTERROR; break;
		case "SUCCESS": type=LoginState.SUCCESS; break;
		case "WRONGID": type=LoginState.WRONGID; break;
		case "WRONGPW": type=LoginState.WRONGPW; break;
		}
		
		return type;
	}
	
	public static LogisticsType switchToLogisticsType(String str){
		LogisticsType type=LogisticsType.ECONOMIC;
		
		switch (str){
		case "ECONOMIC": type=LogisticsType.ECONOMIC; break;
		case "EXPRESS": type=LogisticsType.EXPRESS; break;
		case "STANDARD": type=LogisticsType.STANDARD; break;
		}
		
		return type;
	}
	
	public static PackingCharge switchToPackCharge(String str){
		PackingCharge type=PackingCharge.COURISE_BAG;
		
		switch (str){
		case "COURISE_BAG": type=PackingCharge.COURISE_BAG; break;
		case "PAPER_CASE": type=PackingCharge.PAPER_CASE; break;
		case "WOODEN_CASE": type=PackingCharge.WOODEN_CASE; break;
		case "OTHERS": type=PackingCharge.OTHERS; break;
		}
		
		return type;
	}
	
	public static LogisticsState switchToLogisticsState(String str){
		LogisticsState state=LogisticsState.DAMAGED;
		
		switch (str){
		case "DAMAGED": state=LogisticsState.DAMAGED; break;
		case "INTACT": state=LogisticsState.INTACT; break;
		case "LOST": state=LogisticsState.LOST; break;
		}
		
		return state;
	}
	
	public static InstitutionType switchToInstitutionType(String str){
		InstitutionType type=InstitutionType.BusinessLobby;
		
		switch (str){
		case "BusinessLobby": type=InstitutionType.BusinessLobby; break;
		case "MediumCenter": type=InstitutionType.MediumCenter; break;
		case "Repository": type=InstitutionType.Repository; break;
		case "Other": type=InstitutionType.Repository; break;
		}
		
		return type;
	}
	
	public static CostType switchToCostType(String str){
		CostType type=CostType.freight;
		
		switch(str){
		case "freight": type=CostType.freight; break;
		case "rent": type=CostType.rent; break;
		case "reward": type=CostType.reward; break;
		case "salary": type=CostType.salary; break;
		}
		
		return type;
	}
	
	public static JudgeState switchToJudgeState(String str){
		JudgeState state=JudgeState.PASS;
		
		switch (str){
		case "PASS": state=JudgeState.PASS; break;
		case "UNPASS": state=JudgeState.UNPASS; break;
		}
		
		return state;
	}
	
	public static SalaryType switchToSalaryType(String str){
		SalaryType type=SalaryType.MONTH;
		
		switch (str){
		case "MONTH": type=SalaryType.MONTH; break;
		case "ONCE": type=SalaryType.ONCE; break;
		case "REWARD": type=SalaryType.REWARD; break;
		}
		
		return type;
	}
	
	public static StorageArea switchToStorageArea(String str){
		StorageArea type=StorageArea.AIR_TRANSPORTATION;
		
		switch (str){
		case "AIR_TRANSPORTATION": type=StorageArea.AIR_TRANSPORTATION; break;
		case "CAR_TRANSPORTATION": type=StorageArea.CAR_TRANSPORTATION; break;
		case "MANOEUVERING_AREA": type=StorageArea.MANOEUVERING_AREA; break;
		case "RAILWAY_TRANSPORTATION": type=StorageArea.RAILWAY_TRANSPORTATION; break;
		}
		
		return type;
	}
	
	public static TransferType switchToTransferType(String str){
		TransferType type=TransferType.AIR;
		
		switch (str){
		case "AIR": type=TransferType.AIR; break;
		case "CAR": type=TransferType.CAR; break;
		case "RAILWAY": type=TransferType.RAILWAY; break;
		}
		
		return type;
	}
	
	public static UserRole switchToUserRole(String str){
		UserRole role=UserRole.admin;
		
		switch (str){
		case "admin": role=UserRole.admin; break;
		case "businessAgent": role=UserRole.businessAgent; break;
		case "courier": role=UserRole.courier; break;
		case "finance":role=UserRole.finance; break;
		case "manager": role=UserRole.manager; break;
		case "mediumAgent": role=UserRole.mediumAgent; break;
		case "repository": role=UserRole.repository; break;
		}
		
		return role;
	}
}
