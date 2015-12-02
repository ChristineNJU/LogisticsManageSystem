package presentation.userPanel.BusinessLb;

import java.util.Vector;

import VO.VO;
import presentation.components.ButtonNew;
import presentation.main.FunctionADUS;

public class BusinessLbCarMgt  extends FunctionADUS{

	//新建controller
	//vo的arraylist
	
	//表头的名字tableH
	//可编辑性isCellEditable
	
	public BusinessLbCarMgt(){
		buttonNew = new ButtonNew("新增车辆");
		initUI("车辆管理");
	}
	
	@Override
	protected void initTable() {
		//VO Arraylist的初始化（调用search方法）
		
				//初始化model
				//初始化table
				
		//设置编辑器
		
				//增加最后一列删除按钮
				
				//table增加监听
				//新建panel
				//panel。add（jscrollpanel）
	}

	@Override
	protected void showSearchResult(String s) {
		
	}

	@Override
	protected void confirmRevise() {
		
	}


	@Override
	protected void solveDelete(int i) {
		
	}



	@Override
	protected VO getVO(Vector<String> vector) {
		return null;
	}

}
