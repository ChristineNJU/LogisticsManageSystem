package presentation.userPanel.BusinessLb;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import VO.ArrivalVO;

/**
 * 营业厅到达单的列表
 * 
 * @author 张馨中
 * @version 1.0.0
 * */
public class BusinessLbArrival {

	//新建controller
	//类型的中英转换
	//vo的arraylist
	//panel
	//新增的按钮
	//表格的监听
	//功能按钮的监听
	
	//表头的名字tableH
	//可编辑性isCellEditable
	//表格的内容tableV
	//表格的数据模型model
	//表格的显示table
	//显示表格所需要的滚动界面sPanel
	//
	//确定按钮
	//取消按钮
	public BusinessLbArrival(){
		initUI();
	}
	
	protected void initUI() {
		//panel 的布局为null
		
		//对于除了表格之外的每一个控件，执行以下三个操作
		//setBounds x，y，w，h
		//增加功能监听
		//panel.add（）
		
		//初始化表格
		//初始化确定和取消按钮
	}
	
	protected void initTable() {
		//VO Arraylist的初始化（空或者调用search方法）
		
		//初始化model
		//初始化table
		
		//增加最后一列删除按钮
		
		//table增加监听
		//新建panel
		//panel。add（jscrollpanel）
	}
	
	private Vector<Vector<String>> getVector(ArrayList<ArrivalVO> logistics) {
		//VO转显示
		return null;
	}
	
	protected void confirm() {
		// TODO 生成达到单
		//和逻辑层相关
	}
	
	protected void solveDelete(int i) {
		//处理删除
	}

	protected void newItem() {
		// TODO 新增一行新的表格
	}
	public class TableListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
//			Point p = table.getMousePosition();
//			int row = table.rowAtPoint(p);
//			int column = table.columnAtPoint(p);
//			System.out.println("position clicked :   row"+row+"   column"+column);
//			if(column == table.getColumnCount() -2){
//				solveDelete(row);
//			}
//			if(column == table.getColumnCount() -1){
//				solveRevise(row);
//			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	}
}
