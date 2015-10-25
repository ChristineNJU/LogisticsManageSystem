package test.stub;

import java.util.ArrayList;

import businesslogic.VO.*;

public class InquiryBlService_Stub {
	/*-------------------------------------------
	 查询快递信息
	---------------------------------------------*/
	public VO getLogistics(String bar_code){
		System.out.println("查询成功");
		ArrayList<String> list = null;
		list.add("到达南京");
		list.add("到达苏州");
		list.add("到达上海");
		VO inquiryvo=new LogisticsHistoryVO(bar_code,list);
		return inquiryvo;
	}
}
