package businesslogic.Impl.Courier;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import PO.ConstPO;
import PO.DistancePO;
import PO.LogisticsInfoPO;
import State.AddState;
import State.CodeState;
import State.LogisticsType;
import State.PackingCharge;
import State.StateSwitch;
import State.UpdateState;
import VO.LogisticsInputVO;
import VO.VO;
import businesslogic.Service.Courier.CourierService;
import businesslogic.SystemLog.SystemLog;
import businesslogic.URLHelper.URLHelper;
import data.RMIHelper.RMIHelper;
import data.Service.Add.AddService;
import data.Service.Search.SearchConstService;
import data.Service.Search.SearchDistanceService;
import data.Service.Search.SearchLogisticsService;
import data.Service.Sundry.GatheringStorageService;
import data.Service.Update.UpdateService;

// TODO: Auto-generated Javadoc
/**
 * The Class CourierImpl.
 * 快递员业务的实现
 * 
 * @see SearchLogisticsService
 * @see UpdateService
 * @see SearchDistanceService
 * @see SearchConstService
 */
public class CourierImpl implements CourierService{

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#receiveConfirm(VO.VO)
	 */
	@Override
	public UpdateState receiveConfirm(VO logistics_info) {
		UpdateState state=UpdateState.SUCCESS;
		// TODO Auto-generated method stub
		try{
			SearchLogisticsService searchLogistics=(SearchLogisticsService) Naming.lookup(RMIHelper.SEARCH_LOGISTICS_IMPL);
			SearchDistanceService searchDistance = (SearchDistanceService) Naming.lookup(RMIHelper.SEARCH_DISTANCE_IMPL);
			
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("bar_code='"+((LogisticsInputVO)logistics_info).getBar_code()+"'");
			ArrayList<LogisticsInfoPO> result=searchLogistics.searchLogisticsInfo(requirement);
			if(result.isEmpty()){
				state=UpdateState.NOTFOUND;
			}
			else {
				UpdateService update=(UpdateService) Naming.lookup(RMIHelper.UPDATE_IMPL);
			
//				for(int i=0;i<result.size();i++){
//					state=update.update(new LogisticsInfoPO((LogisticsInputVO)logistics_info));
//				}
				result.get(0).setActualRecipientName(((LogisticsInputVO)logistics_info).getActual_recipient_name());
				result.get(0).setReceived(true);
				result.get(0).setReceiveDate(Calendar.getInstance().getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				result.get(0).addHistory("收件人已收件,"+sdf.format(Calendar.getInstance().getTime()));
				
				state = update.update(result.get(0));
				
				String city1 = result.get(0).getStarting();
				String city2 = result.get(0).getDestination();
				
				ArrayList<DistancePO> cityList = new ArrayList<DistancePO>();
				
				ArrayList<String> distanceRe = new ArrayList<String>();
				distanceRe.add("city_1 = '"+city1+"' AND city_2 = '"+city2+"'");
				
				cityList = searchDistance.searchDistance(distanceRe);
				
				if(cityList.isEmpty()){
					distanceRe = new ArrayList<String>();
					distanceRe.add("city_1 = '"+city2+"' AND city_2 = '"+city1+"'");
					
					cityList = searchDistance.searchDistance(distanceRe);
				}
				
				if(!cityList.isEmpty()){
					Date date_start = result.get(0).getSendDate();
					Date date_end = result.get(0).getSendDate();
					
					double hour = ((double)(date_end.getTime()-date_start.getTime()))/(1000*60*60);
					
					cityList.get(0).setTime(hour);
					
					update.update(cityList.get(0));
				}
			}
		} catch(Exception ex){
			state=UpdateState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#getCity()
	 */
	@Override
	public ArrayList<String> getCity() {
		// TODO Auto-generated method stub
		ArrayList<String> city=new ArrayList<String>();
		try{
			SearchDistanceService distance=(SearchDistanceService) Naming.lookup(RMIHelper.SEARCH_DISTANCE_IMPL);
			ArrayList<String> requirement=new ArrayList<String>();
			requirement.add("city_1 like '%%'");
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

	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#getAmount(java.lang.String, java.lang.String, State.LogisticsType, State.PackingCharge, double, double)
	 */
	@Override
	public double getAmount(String starting, String destination,
			LogisticsType type, PackingCharge charge, double weight,
			double size) {
		
		//weight: kg; size: m^3
		
		double Amount=0;
		// TODO Auto-generated method stub
		try{
			SearchConstService constSearch=(SearchConstService) Naming.lookup(RMIHelper.SEARCH_CONST_IMPL);
			SearchDistanceService distanceSearch=(SearchDistanceService) Naming.lookup(RMIHelper.SEARCH_DISTANCE_IMPL);
			ArrayList<String> requirementDis=new ArrayList<String>();
			double distance=0;
			if(starting.equals(destination)){
				distance=30;
			}
			else {
				requirementDis.add("city_1='"+starting+"' AND "+"city_2='"+destination+"'");
	//			requirementDis.add("city_2='"+starting+"' AND "+"city_1='"+destination+"'");
				ArrayList<DistancePO> distanceResult=distanceSearch.searchDistance(requirementDis);
				if(distanceResult.isEmpty()){
					requirementDis.clear();
					System.out.println("empty");
					requirementDis.add("city_2='"+starting+"' AND "+"city_1='"+destination+"'");
	//				distanceSearchceResult.clear();
					distanceResult=distanceSearch.searchDistance(requirementDis);
				}
				distance=distanceResult.get(0).getDistance();
			}
			//----------------------------------------------------------
			
			ArrayList<String> requirementType=new ArrayList<String>();
//			System.out.println(type);
			requirementType.add("name='"+StateSwitch.switchToStr(type)+"'");
			ArrayList<ConstPO> constResult=constSearch.searchConst(requirementType);
			double fee=constResult.get(0).getValue();
			
			double density=weight/size;
			
//			System.out.println(density);
//			System.out.println(fee);
//			System.out.println(distance);
//			System.out.println()
			if(density>=10){
				//define: object whose density is less than 10kg/m^3 is considered to be light
				Amount+=fee*distance*weight/1000;
			}
			else {
				Amount+=Math.min(fee*distance*weight/1000,fee*distance*size/5000);
			}
			
			//----------------------------------------------------------
//			System.out.println(Amount);
			ArrayList<String> requirementPack=new ArrayList<String>();
			requirementPack.add("name='"+StateSwitch.switchToStr(charge)+"'");
			constResult=constSearch.searchConst(requirementPack);
			double packFee=constResult.get(0).getValue();
			
			Amount+=packFee;
//			System.out.println(Amount);
		} catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			Amount=-1;
		}
		return Amount;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#addLogistics(VO.VO)
	 */
	@Override
	public AddState addLogistics(VO logistics_info) {
		// TODO Auto-generated method stub
		AddState state=AddState.SUCCESS;
		try{
			
			AddService addService=(AddService) Naming.lookup(RMIHelper.ADD_IMPL);
			LogisticsInfoPO result = new LogisticsInfoPO((LogisticsInputVO)logistics_info);
			result.addHistory("快递员收件");
			state=addService.add(result);
			GatheringStorageService gstorageService=(GatheringStorageService) Naming.lookup(RMIHelper.GATHERING_STORAGE_IMPL);
			gstorageService.addGatheringStorage(result.getBarCode(), result.getTotalCost(), SystemLog.getOperatorID(), 
					sdf.format(Calendar.getInstance().getTime()), URLHelper.getGatheringStorage(SystemLog.getInstitutionId()));
			
			//AddState is depended in the data level. Can not give all AddStates here;
			
		} catch(Exception ex){
			state=AddState.CONNECTERROR;
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return state;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#getDayLength(java.lang.String, java.lang.String)
	 */
	@Override
	public double getDayLength(String starting, String destination) {
		// TODO Auto-generated method stub
		SearchDistanceService distanceSearch;
		double dayLength = 0;
		try {
			distanceSearch = (SearchDistanceService) Naming.lookup(RMIHelper.SEARCH_DISTANCE_IMPL);
			ArrayList<String> requirementDis=new ArrayList<String>();
			if(starting.equals(destination)){
				return dayLength;
			}
			else {
				requirementDis.add("city_1='"+starting+"' AND "+"city_2='"+destination+"'");
//			requirementDis.add("city_2='"+starting+"' AND "+"city_1='"+destination+"'");
				ArrayList<DistancePO> distanceResult=distanceSearch.searchDistance(requirementDis);
				if(distanceResult.isEmpty()){
					requirementDis.clear();
//					System.out.println("empty");
					requirementDis.add("city_2='"+starting+"' AND "+"city_1='"+destination+"'");
//				distanceSearchceResult.clear();
					distanceResult=distanceSearch.searchDistance(requirementDis);
				}
				dayLength=distanceResult.get(0).getTime();
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dayLength;
	}

	/* (non-Javadoc)
	 * @see businesslogic.Service.Courier.CourierService#isLegal(java.lang.String)
	 */
	@Override
	public CodeState isLegal(String bar_code) {
		// TODO Auto-generated method stub
		try {
			SearchLogisticsService service = (SearchLogisticsService) Naming.lookup(RMIHelper.SEARCH_LOGISTICS_IMPL);
			ArrayList<String> requirement = new ArrayList<String>();
			requirement.add("bar_code = '"+bar_code+"'");
			ArrayList<LogisticsInfoPO> tmp = service.searchLogisticsInfo(requirement);
			
			if(tmp.isEmpty()){
				return CodeState.WELL;
			}else{
				return CodeState.REPEAT;
			}
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return CodeState.CONNECTION_ERROR;
		}
	}
}
