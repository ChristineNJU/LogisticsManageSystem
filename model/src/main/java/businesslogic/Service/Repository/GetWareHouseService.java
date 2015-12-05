package businesslogic.Service.Repository;

import java.util.ArrayList;

import VO.WareHouseVO;
/**
 * 获取仓库所有快递信息的接口
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public interface GetWareHouseService {
	
	/**
	 * 获取仓库所有快递信息
	 * 
	 * @return ArrayList<WareHouseVO>保存所有快递信息
	 * */
	public ArrayList<WareHouseVO> getWareHouse();
}
