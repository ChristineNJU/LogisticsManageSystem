package VO;

import PO.DistancePO;

// TODO: Auto-generated Javadoc
/**
 * The Class DistanceVO.
 *
 * @author Administrator
 */
public class DistanceVO extends VO {
	
	/** The city_1. */
	private String city_1 = "";
	
	/** The city_2. */
	private String city_2 = "";
	
	/** The distance. */
	private double distance = 0;
	
	/**
	 * Instantiates a new distance vo.
	 *
	 * @param city_1 the city_1
	 * @param city_2 the city_2
	 * @param distance the distance
	 */
	public DistanceVO(String city_1, String city_2, double distance) {
		this.city_1 = city_1;
		this.city_2 = city_2;
		this.distance = distance;
	}
	
	/**
	 * Instantiates a new distance vo.
	 *
	 * @param po the po
	 */
	public DistanceVO(DistancePO po) {
		this.city_1 = po.getCity_1();
		this.city_2 = po.getCity_2();
		this.distance = po.getDistance();
	}

	/**
	 * Gets the city_1.
	 *
	 * @return the city_1
	 */
	public String getCity_1() {
		return city_1;
	}

	/**
	 * Gets the city_2.
	 *
	 * @return the city_2
	 */
	public String getCity_2() {
		return city_2;
	}

	/**
	 * Gets the distance.
	 *
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

}
