package presentation.userPanel.Courier;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import State.UpdateState;
import VO.LogisticsHistoryVO;
import VO.LogisticsInputVO;
import VO.VO;
import businesslogic.Impl.Courier.CourierController;
import businesslogic.Impl.Inquiry.InquiryController;
import businesslogic.Service.Courier.CourierService;
import businesslogic.Service.Inquiry.InquiryService;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.LabelHeader;
import presentation.factory.TableFactory;
import presentation.factory.TableModelFactory;
import presentation.frame.MainFrame;
import presentation.main.FontSet;
import presentation.main.FunctionAdd;
import presentation.table.ScrollPaneTable;

public class CourierReceive  extends FunctionAdd{
	
	InquiryService inquiry = new InquiryController();
	CourierService service = new CourierController();
	
	Listener listener = new Listener();
	
	Vector<Vector<String>> result = new Vector<Vector<String>>();
		

	
	NavigationCourier nav;
	public CourierReceive() {
		super.buttonNew = new ButtonNew("新增收件");
		super.confirm = new ButtonConfirm("确认收件");
		
//		this.nav = nav;
		
		initUI("收件信息输入");
	}
	
	
	@Override
	protected void initHeader() {
		// TODO Auto-generated method stub
		header = new Header();
		panel.add(header);
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		model = TableModelFactory.getReceiveModel(result);
		table = TableFactory.getReceive(model);
		
		model.addTableModelListener(listener);
		
		sPanel = new ScrollPaneTable(table);
		
		panel.add(sPanel);
	}

	@Override
	public void performConfirm() {
		// TODO Auto-generated method stub
		if(table.getRowCount()==0){
			info.setText("空的提交信息");
			return;
		}
		
		UpdateState update = UpdateState.SUCCESS;
		
		for(int i=0;i<table.getRowCount();i++){
			LogisticsInputVO vo = (LogisticsInputVO) getVO(model.getRow(i));
			update = service.receiveConfirm(vo);
		}
		
		if(update==UpdateState.SUCCESS){
			info.setText("保存成功");
		}else{
			info.setText("保存失败");
		}
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		LogisticsInputVO vo = new LogisticsInputVO("", "", "", "", "", "", "", "", 
				"", "", vector.get(0), 0, 0, 0, "", null, null, 0, "", "", null, null, "");
		vo.setActual_recipient_name(vector.get(1));
		
		return vo;
	}
	
	class Header extends JLabel {
		LabelHeader date = new LabelHeader("收件日期：");
		Header() {
			setBounds(120, 100, 400,30);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date.addInfo(sdf.format(Calendar.getInstance().getTime()));
			
			date.setBounds(0, 0, 400, 30);
			add(date);
		}
	}
	
	class Listener implements TableModelListener {

		@Override
		public void tableChanged(TableModelEvent e) {
			// TODO Auto-generated method stub
			int row = e.getLastRow();
			int column = e.getColumn();
			
//			System.out.println(row+" "+column);
			
			if(column==0){
				String bar_code = table.getValueAt(row, 0).toString();
//				System.out.println(bar_code);
				buttonNew.setEnabled(true);
				confirm.setEnabled(true);
				if(isLegal(bar_code)){
					info.setText("");
					LogisticsHistoryVO tmp = inquiry.getLogistics(bar_code);
					if(tmp==null){
						info.setText("快递"+bar_code+"不存在");
						buttonNew.setEnabled(false);
						confirm.setEnabled(false);
					}
				}else{
					info.setText("请输入10位数字");
					buttonNew.setEnabled(false);
					confirm.setEnabled(false);
				}
			}
		}
	}
	
	public boolean isLegal(String bar_code) {
		if(bar_code.length()!=10){
			return false;
		}else{
			for(int i=0;i<bar_code.length();i++){
				if(bar_code.charAt(i)>='0'&&bar_code.charAt(i)<='9'){
					
				}else{
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void performCancel() {
		MainFrame.changeContentPanel(new CourierReceive().getPanel());		
	}
}
