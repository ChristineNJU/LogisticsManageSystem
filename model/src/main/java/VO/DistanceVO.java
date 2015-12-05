package VO;

import PO.DistancePO;

/**
 * @author Administrator
 *
 */
public class DistanceVO extends VO {
	
	private String city_1 = "";
	private String city_2 = "";
	private double distance = 0;
	
	public DistanceVO(String city_1, String city_2, double distance) {
		this.city_1 = city_1;
		this.city_2 = city_2;
		this.distance = distance;
	}
	
	public DistanceVO(DistancePO po) {
		this.city_1 = po.getCity_1();
		this.city_2 = po.getCity_2();
		this.distance = po.getDistance();
	}

	public String getCity_1() {
		return city_1;
	}

	public String getCity_2() {
		return city_2;
	}

	public double getDistance() {
		return distance;
	}

}
