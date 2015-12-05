package presentation.userPanel.BusinessLb;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;

import VO.GatheringVO;
import VO.VO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import businesslogic.Service.BusinessLobby.BsLbService;
import presentation.components.ButtonConfirm;
import presentation.components.ButtonNew;
import presentation.components.LabelHeader;
import presentation.main.FunctionAdd;
import presentation.table.ScrollPaneTable;
import presentation.table.TableAddOnly;
import presentation.table.TableModelAddOnly;

public class BusinessLbGathering extends FunctionAdd{

	BsLbService service = new BusinessLobbyController();
	ArrayList<GatheringVO> needGathering;
	
	
	String[] tableH = {"快递单号","收款日期","收款金额","收款快递员"};
	boolean[] isCellEditable = {false,false,false,false};
	
	public BusinessLbGathering(){
		super.buttonNew = new ButtonNew("新增收款单");
		super.confirm = new ButtonConfirm("提交所有订单");
		initUI("收款结算");
	}
	
	@Override
	protected void initHeader() {
		//获取营业厅的id和收款单的id，加入label中显示
		header = new Header();
		panel.add(header);
//		panel.repaint();
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		//首先获得needGathering
		
		needGathering = service.getNeedGathering();
		tableV = getVector(needGathering);
		
		model = new TableModelAddOnly(tableV,tableH,isCellEditable);
		table = new TableAddOnly(model);

		sPanel = new ScrollPaneTable(table);
		sPanel.setLocation(sPanel.getX(),header.getHeight()+120);
		panel.add(sPanel);
	}

	@Override
	protected void confirmAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected VO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		return null;
	}

	protected Vector<Vector<String>> getVector(ArrayList<GatheringVO> vo){
		return null;
	}
	
	private class Header extends JLabel{
		LabelHeader businessLobbyID = new LabelHeader("营业厅编号");
		LabelHeader gatheringId = new LabelHeader("收款单编号");
		public Header(){
			this.setBounds(120,100,680,60);
			this.setBackground(null);
			businessLobbyID.addInfo("");
			gatheringId.addInfo("");
			
			businessLobbyID.setBounds(0,0,400,30);
			gatheringId.setBounds(0,35,400,30);
			
			add(businessLobbyID);
			add(gatheringId);
		}
	}
}
