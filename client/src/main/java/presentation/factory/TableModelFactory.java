package presentation.factory;

import java.util.Vector;

import presentation.table.TableModelADUS;
import presentation.table.TableModelAddOnly;
import presentation.table.TableModelSearch;

public class TableModelFactory {

	public static TableModelAddOnly getEntruckingModel(Vector<Vector<String>> tableV){
		String[] tableH = {"快递单号","   "};
		boolean[] isCellEditable = {false,false};
		TableModelAddOnly model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelADUS getUserAccountModel(Vector<Vector<String>> tableV){
		String[] tableH = {"员工编号","姓名","职务","性别","年龄","城市","所属机构","   "};
		boolean[] isCellEditable = {false,true,true,true,true,true,true,false};
		TableModelADUS model = new TableModelADUS(tableV, tableH,isCellEditable);
		return model;
	}
	
	public static TableModelAddOnly getArrivalModel(Vector<Vector<String>> tableV){
		String[] tableH={"快递单号","出发地","快递状态","到达单编号","  "};
		boolean[] isCellEditable = {false,false,false,false};
		TableModelAddOnly model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelADUS getDriverMgtModel(Vector<Vector<String>> tableV){
		String[] tableH = {"司机ID","司机姓名","司机生日","身份证号","司机手机","司机性别","雇佣时间","  "};
		boolean[] isCellEditable = {false,true,true,true,true,true};
		TableModelADUS model = new TableModelADUS(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelADUS getCarMgtModel(Vector<Vector<String>> tableV){
		String[] tableH = {"车辆编号","车辆牌照","运营时间","   "};
		boolean[] isCellEditable = {true,true,true};
		TableModelADUS model = new TableModelADUS(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelAddOnly getDeliveryModel(Vector<Vector<String>> tableV){
		String[] tableH = {"快递单号","日期","派件人",""};
		boolean[] isCellEditable = {false,false,false};
		TableModelAddOnly model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelAddOnly getGatheringModel(Vector<Vector<String>> tableV){
		String[] tableH = {"快递单号","收款日期","收款金额","收款快递员",""};
		boolean[] isCellEditable = {false,false,false,false};
		TableModelAddOnly model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelAddOnly getLogisticsModel(Vector<Vector<String>> tableV){
		String[] tableH = {"快递单号","出发地","目的地","内件品名","体积","重量","费用合计"};
		boolean[] isCellEditable = {false,false,false,false,false,false,false};
		TableModelAddOnly model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelAddOnly getReceiveModel(Vector<Vector<String>> tableV){
		String[] tableH = {"收件编号", "收件人", ""};
		boolean[] isCellEditable = {true, true, false};
		TableModelAddOnly model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelSearch getIncome(Vector<Vector<String>> tableV){
		String[] tableH = {"收款日期","收款金额(￥)","收款快递员","快递单号"};
		TableModelSearch model = new TableModelSearch(tableV,tableH);
		return model;
	}
	
	public static TableModelAddOnly getCostModel(Vector<Vector<String>> tableV){
		String[] tableH = {"付款日期","金额","付款人","付款账目","条目","备注",""};
		boolean[] isCellEditable = {false,false,false,false,false,false};
		TableModelAddOnly model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelSearch getCostSearch(Vector<Vector<String>> tableV){
		String[] tableH = {"付款日期","金额","付款人","付款账户","条目","备注"};
		TableModelSearch model = new TableModelSearch(tableV,tableH);
		return model;
	}
	
	public static TableModelADUS getFinanceModel(Vector<Vector<String>> tableV){
		String[] tableH={"账户名称","账户余额","  "};
		boolean[] isCellEditable={true,false};
		TableModelADUS model = new TableModelADUS(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelSearch getIncomeAndOutcomeModel(Vector<Vector<String>> tableV){
		String[] tableH = {"时间","收入","支出","利润"};
		TableModelSearch model = new TableModelSearch(tableV,tableH);
		return model;
	}
	
	public static TableModelSearch getSystemModel(Vector<Vector<String>> tableV){
		String[] tableH = {"操作日期","操作类型","操作人员"};
		TableModelSearch model = new TableModelSearch(tableV,tableH);
		return model;		
	}
	
	public static TableModelADUS getInstitutionModel(Vector<Vector<String>> tableV){
		String[] tableH = {"机构ID","机构名称","机构类型","机构所在地"};
		boolean[] isCellEditable = {false,true,true,true};
		
		TableModelADUS model = new TableModelADUS(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelADUS getSalaryModel(Vector<Vector<String>> tableV){
		String[] tableH = {"职位","工资类型","工资"};
		boolean[] isCellEditable = {false,false,true};
		TableModelADUS model = new TableModelADUS(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelADUS getStaffMgtModel(Vector<Vector<String>> tableV){
		String[] tableH = {"员工ID","员工姓名","员工性别","员工年龄","员工机构","员工职责","员工所在地","员工密码"};
		boolean[] isCellEditable = {false,true,true,true,true,true,true,true};
		
		TableModelADUS model = new TableModelADUS(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelAddOnly getBalanceModel(Vector<Vector<String>> tableV){
		String[] tableH = {"原区号", "快递编号", "新区号", "排号", "架号", "位号", ""};
		boolean[] isCellEditable = {true, true, true, true, true, false};
		
		TableModelAddOnly model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		return model;
	}
	
	public static TableModelSearch getStorageSearchModel(Vector<Vector<String>> tableV){
		String[] tableH = {"入库记录","   ","   ","   ","   ","  ","   "};
		TableModelSearch model = new TableModelSearch(tableV,tableH);
		return model;
	}
	
	public static TableModelSearch getRemovalSearchModel(Vector<Vector<String>> tableV){
		String[] tableH = {"出库记录","   ","   ","   ","   "};
		TableModelSearch model = new TableModelSearch(tableV,tableH);
		return model;
	}
	
	public static TableModelAddOnly getSorageModel(Vector<Vector<String>> tableV){
		String[]  tableH = {"快递编号",""};
		boolean[] isCellEditable = {false, false};
		TableModelAddOnly table = new TableModelAddOnly(tableV,tableH,isCellEditable);
		return table;
	}
	
	public static TableModelAddOnly getStorageModel(Vector<Vector<String>> tableV){
		String[] tableH = {"快递编号", "到达地", "区号", "排号", "架号", "位号", ""};
		boolean[] isCellEditable = {true, true, true, true, true, true, false};
		TableModelAddOnly table = new TableModelAddOnly(tableV,tableH,isCellEditable);
		return table;
	}
	
	public static TableModelSearch getStockTakingAir(Vector<Vector<String>> tableV){
		String[] tableH = {"航空区","   ","   ","   ","   ","   "};
		TableModelSearch table = new TableModelSearch(tableV,tableH);
		return table;
	}
	
	public static TableModelSearch getStockTakingRailway(Vector<Vector<String>> tableV){
		String[] tableH = {"火车区","   ","   ","   ","   ","   "};
		TableModelSearch table = new TableModelSearch(tableV,tableH);
		return table;
	}
	
	public static TableModelSearch getStockTakingBus(Vector<Vector<String>> tableV){
		String[] tableH = {"汽运区","   ","   ","   ","   ","   "};
		TableModelSearch table = new TableModelSearch(tableV,tableH);
		return table;
	}
}
