package businesslogic.Service.Repository;

import java.util.ArrayList;

import State.UpdateState;
import VO.WareHouseVO;
// TODO: Auto-generated Javadoc

/**
 * 获取仓库所有快递信息的接口.
 *
 * @author 尹子越
 * @version 1.0.0
 */
public interface BlWareHouseService {
	
	/**
	 * 获取仓库所有快递信息.
	 *
	 * @return ArrayList<WareHouseVO>保存所有快递信息
	 */
	public ArrayList<WareHouseVO> getWareHouse();
	
	/**
	 * 更新仓库信息.
	 *
	 * @param vo 新仓库信息
	 * @return UpdateState
	 */
	public UpdateState updateWareHouse(WareHouseVO vo);
}
