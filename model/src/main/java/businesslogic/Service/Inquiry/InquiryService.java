package businesslogic.Service.Inquiry;


import VO.LogisticsHistoryVO;


/**
 * 查询快递信息接口
 * 
 * @author 尹子越
 * @version 1.0.0
 * */
public interface InquiryService {
	
	/**
	 * 通过快递编号获取快递信息
	 * 
	 * @param bar_code 快递编号
	 * @return 快递历史信息
	 * */
	public LogisticsHistoryVO getLogistics(String bar_code);
}
