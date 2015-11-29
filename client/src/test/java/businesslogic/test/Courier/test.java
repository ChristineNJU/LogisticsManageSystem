package businesslogic.test.Courier;

import java.util.ArrayList;

import State.LogisticsType;
import State.PackingCharge;
import businesslogic.Impl.Courier.CourierController;

public class test {
	public static void main(String[] args){
		CourierController courier = new CourierController();
		ArrayList<String> city=courier.getCity();
		for(int i=0;i<city.size();i++){
			System.out.println(city.get(i));
		}
		double amount=courier.getAmount("北京","南京",  LogisticsType.ECONOMIC, PackingCharge.COURISE_BAG, 68, 9);
		System.out.println(amount);
	}
}
