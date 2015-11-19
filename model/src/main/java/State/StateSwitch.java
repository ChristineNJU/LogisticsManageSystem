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
	
	public static String switchToStr(LogisticsType state){
		String result="";
		switch (state){
		
		case ECONOMIC: result="ECONOMIC"; break;
		case EXPRESS: result="EXPRESS"; break;
		case STANDARD: result="STANDARD"; break;
		
		}
		return result;
	}
	
	public static String switchToStr(PackingCharge state){
		String result="";
		switch (state){
		
		case COURISE_BAG: result="COURISE_BAG"; break;
		case PAPER_CASE: result="PAPER_CASE"; break;
		case WOODEN_CASE: result="WOODEN_CASE"; break;
		case OTHERS: result="OTHERS"; break;
		
		}
		return result;
	}
	
	//--------------------------------------------------------------
	
	public static LoginState switchLoginStateToState(String str){
		LoginState state=LoginState.CONNECTERROR;
		
		switch (str){
		case "CONNECTERROR": state=LoginState.CONNECTERROR; break;
		case "SUCCESS": state=LoginState.SUCCESS; break;
		case "WRONGID": state=LoginState.WRONGID; break;
		case "WRONGPW": state=LoginState.WRONGPW; break;
		}
		
		return state;
	}
	
	public static LogisticsType switchLogisticsTypeToState(String str){
		LogisticsType state=LogisticsType.ECONOMIC;
		
		switch (str){
		case "ECONOMIC": state=LogisticsType.ECONOMIC; break;
		case "EXPRESS": state=LogisticsType.EXPRESS; break;
		case "STANDARD": state=LogisticsType.STANDARD; break;
		}
		
		return state;
	}
	
	public static PackingCharge switchPackChargeToState(String str){
		PackingCharge state=PackingCharge.COURISE_BAG;
		
		switch (str){
		case "COURISE_BAG": state=PackingCharge.COURISE_BAG;
		case "PAPER_CASE": state=PackingCharge.PAPER_CASE;
		case "WOODEN_CASE": state=PackingCharge.WOODEN_CASE;
		case "OTHERS": state=PackingCharge.OTHERS;
		}
		
		return state;
	}
}
