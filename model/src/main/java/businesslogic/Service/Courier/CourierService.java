package businesslogic.Service.Courier;

import java.util.ArrayList;

import State.AddState;
import State.LogisticsType;
import State.PackingCharge;
import State.UpdateState;
import VO.VO;

/**
 * 快递员业务接口
 * 
 * @author 张斯栋
 * @version 1.0.0
 * */
public interface CourierService {
	
	/**
	 * 添加快递
	 * 
	 * @param logistics_info VO快递信息
	 * @return 添加状态
	 * */
	public AddState addLogistics(VO logistics_info);
	
	/**
	 * 计算快递费用
	 * 
	 * @param starting 出发地
	 * @param destination 到达地
	 * @param type 快递类型
	 * @param charge 包装类型
	 * @param weight 重量
	 * @param height 体积
	 * @return 快递费用
	 * */
	public double getAmount(String starting, String destination, 
			LogisticsType type, PackingCharge charge, double weight, double height);
	
	/**
	 * 获取城市
	 * 
	 * @return 所有城市名
	 * */
	public ArrayList<String> getCity();
	
	/**
	 * 确认收件
	 * 
	 * @param logistics_info 收件信息
	 * @return 更新状态
	 * */
	public UpdateState receiveConfirm(VO logistics_info);
}
