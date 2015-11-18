package businesslogic.Impl.Courier;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.DistancePO;
import PO.LogisticsInfoPO;
import VO.LogisticsInputVO;
import VO.VO;
import PO.ConstPO;
import State.AddState;
import State.LogisticsType;
import State.PackingCharge;
import State.StateSwitch;
import State.UpdateState;
import businesslogic.Service.Courier.AddLogisticsService;
import businesslogic.Service.Courier.GetAmountService;
import businesslogic.Service.Courier.GetCityService;
import businesslogic.Service.Courier.ReceiveConfirmService;
import data.RMIHelper.RMIHelper;
import data.Service.Search.SearchConstService;
import data.Service.Search.SearchDistanceService;
import data.Service.Search.SearchLogisticsService;
import data.Service.Update.UpdateService;

public class CourierImpl implements AddLogisticsService,GetAmountService,GetCityService,ReceiveConfirmService{

	@Override
	public UpdateState receiveConfirm(VO logistics_info, String field,
			String value) {
		UpdateState state=UpdateState.SUCCESS;
		// TODO Auto-generated method stub
		try{
			SearchLogisticsService searchLogistics=(SearchLogisticsService) Naming.lookup(RMIHelper.SEARCH_LOGISTICS_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("bar_code="+((LogisticsInputVO)logistics_info).getBar_code());
			ArrayList<LogisticsInfoPO> result=searchLogistics.searchLogisticsInfo(requirement);
			if(result.isEmpty()){
				state=UpdateState.NOTFOUND;
			}
			else {
				UpdateService update=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
				for(int i=0;i<result.size();i++){
					update.update(result.get(i), field, value);
				}
				
				state=UpdateState.SUCCESS;
			}
		} catch(Exception ex){
			state=UpdateState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

	@Override
	public ArrayList<String> getCity() {
		// TODO Auto-generated method stub
		ArrayList<String> city=new ArrayList<String>();
		try{
			SearchDistanceService distance=(SearchDistanceService) Naming.lookup(RMIHelper.SEARCH_DISTANCE_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("city1 like '%%'");
			ArrayList<DistancePO> result=distance.searchDistance(requirement);
			
			for(int i=0;i<result.size();i++){
				String temp1=result.get(i).getCity_1();
				String temp2=result.get(i).getCity_2();
				if(!city.contains(temp1))
					city.add(temp1);
				if(!city.contains(temp2))
					city.add(temp2);
				
			}
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return city;
	}

	@Override
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight,
			double height) {
		double Amount=0;
		// TODO Auto-generated method stub
		try{
			SearchConstService constSearch=(SearchConstService) Naming.lookup(RMIHelper.SEARCH_CONST_IMPL);
			SearchDistanceService distanceSearch=(SearchDistanceService) Naming.lookup(RMIHelper.SEARCH_DISTANCE_IMPL);
			ArrayList<String> requirementDis=new ArrayList<String>();
			requirementDis.add("city1="+starting+" AND "+"city2="+destination);
			
			ArrayList<DistancePO> distanceResult=distanceSearch.searchDistance(requirementDis);
			
			double distance=distanceResult.get(0).getDistance();
			//----------------------------------------------------------
			ArrayList<String> requirementLogisCons=new ArrayList<String>();
			requirementLogisCons.add("name="+StateSwitch.switchToStr(type));
			ArrayList<ConstPO> constResult=constSearch.searchConst(requirementLogisCons);
			double fee=constResult.get(0).getValue();
			
			
			
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return Amount;
	}

	@Override
	public AddState addLogistics(VO logistics_info) {
		// TODO Auto-generated method stub
		return null;
	}

}
