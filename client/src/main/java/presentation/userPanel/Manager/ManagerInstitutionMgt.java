package presentation.userPanel.Manager;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumnModel;

import presentation.components.ButtonNew;
import presentation.components.FlatComboBox;
import presentation.frame.MainFrame;
import presentation.main.FunctionADUS;
import presentation.main.Translater;
import presentation.table.ScrollPaneTable;
import presentation.table.TableADUS;
import presentation.table.TableModelADUS;
import presentation.userPanel.BusinessLb.BusinessLbCarMgt;
import State.AddState;
import State.DeleteState;
import State.ErrorState;
import State.UpdateState;
import VO.InstitutionVO;
import VO.StaffVO;
import VO.VO;
import businesslogic.Impl.Manage.ManageController;

public class ManagerInstitutionMgt extends FunctionADUS{
	ManageController service=new ManageController();
	ArrayList<InstitutionVO> institutions;
	String[] tableH = {"机构ID","机构名称","机构类型","机构所在地"};
	boolean[] isCellEditable = {false,true,true,true};
	
	ArrayList<InstitutionVO> addItems=new ArrayList<InstitutionVO>();
	ArrayList<InstitutionVO> deleteItems=new ArrayList<InstitutionVO>();
	ArrayList<InstitutionVO> searchItems=new ArrayList<InstitutionVO>();
	ArrayList<InstitutionVO> updateItems=new ArrayList<InstitutionVO>();
	
	NavigationManager nav;
	
	public ManagerInstitutionMgt(NavigationManager nav){
//		nav = navigationManager;
		buttonNew = new ButtonNew("新增机构");
		initUI("机构管理");
		
		this.nav = nav;
	}

	@Override
	protected void initTable() {
		// TODO Auto-generated method stub
		institutions=new ArrayList<InstitutionVO>();
		institutions=service.searchInstitution("%%");
		if(institutions==null){
			super.isConnectError=true;
			tableV=new Vector<Vector<String>>();
		}
		else if(institutions.isEmpty()){
			showError(ErrorState.SEARCHERROR);
			tableV=getVector(institutions);
			
		}
		else{
			tableV = getVector(institutions);
		}
		model = new TableModelADUS(tableV, tableH,isCellEditable);
		table = new TableADUS(model);
		
		TableColumnModel tcm = table.getColumnModel(); 
		String[] institution = {"营业厅","中转中心","仓库","总部"};
		JComboBox institutionC = new FlatComboBox(institution);  
        tcm.getColumn(2).setCellEditor(new DefaultCellEditor(institutionC));
        
        String[] city = {"南京","北京","上海","广州"};
 	    JComboBox  cityC = new FlatComboBox(city);  
        tcm.getColumn(3).setCellEditor(new DefaultCellEditor(cityC));
        
        addDeleteColumn();
	    
 	    table.addMouseListener(tableListener);
 	    sPanel = new ScrollPaneTable(table);
 	    panel.add(sPanel);
	}

	@Override
	protected void showSearchResult(String s) {
		// TODO Auto-generated method stub
		institutions=new ArrayList<InstitutionVO>();
		searchItems=service.searchInstitution(s);
		model = new TableModelADUS(getVector(searchItems),tableH,isCellEditable);
		table.setModel(model);
		table.repaint();
	}

	@Override
	public void performConfirm() {
		// TODO Auto-generated method stub
		deleteItems=new ArrayList<InstitutionVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isDelete(i)){
				deleteItems.add(getVO(tableV.get(i)));
			}
		}
		DeleteState deleteState=DeleteState.SUCCESS;
		for(int i=0;i<deleteItems.size();i++){
			deleteState=service.deleteInstitution(deleteItems.get(i));
			if(deleteState==DeleteState.FAIL){
				showError(ErrorState.DELETEERROR);
				break;
			}
			else if(deleteState==DeleteState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
		}
		updateItems=new ArrayList<InstitutionVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isUpdate(i)){
				updateItems.add(getVO(tableV.get(i)));
			}
		}
		UpdateState updateState=UpdateState.SUCCESS;
		for(int i=0;i<updateItems.size();i++){
			updateState=service.UpdateInstitution(updateItems.get(i));
			if(updateState==UpdateState.NOTFOUND){
				showError(ErrorState.UPDATEERROR);
				break;
			}
			else if(updateState==UpdateState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
		}
		
		addItems=new ArrayList<InstitutionVO>();
		for(int i=0;i<tableV.size();i++){
			if(model.isNew(i)){
				addItems.add(getVO(tableV.get(i)));
			}
		}
		AddState addState=AddState.SUCCESS;
		for(int i=0;i<addItems.size();i++){
			addState=service.addInstitution(addItems.get(i));
			if(addState==AddState.FAIL){
				showError(ErrorState.ADDERROR);
				break;
			}
			else if(addState==AddState.CONNECTERROR){
				showError(ErrorState.CONNECTERROR);
				break;
			}
		}
		
		if(deleteState==DeleteState.SUCCESS&&updateState==UpdateState.SUCCESS
				&&addState==AddState.SUCCESS){
			nav.changeTask(3);
		}
	}
	
	protected void newItem() {
		model.addEmptyRow();
		 int lastIndex = table.getRowCount()-1;
         table.changeSelection(lastIndex, 0,false,false);
	}


	@Override
	protected InstitutionVO getVO(Vector<String> vector) {
		// TODO Auto-generated method stub
		InstitutionVO institution=new InstitutionVO(vector.get(1).trim(),Translater.getInstitutionType(vector.get(2).trim()),
				vector.get(3).trim(),vector.get(0).trim());
		return institution;
	}
	
	protected Vector<Vector<String>> getVector(ArrayList<InstitutionVO> voList){
		Vector<Vector<String>> result=new Vector<Vector<String>>();
		for(InstitutionVO temp:voList){
//			System.out.println(temp.getName()+" "+temp.getPosition()+temp.getInsitution());
			Vector<String> vRow=new Vector<String>();
			vRow.add(temp.getCode());
			vRow.add(temp.getName());
			vRow.add(Translater.getChineseForInstitution(temp.getType()));
			vRow.add(temp.getCity());
			
			result.add(vRow);
		}
		return result;
	}

	@Override
	public void performCancel() {
		MainFrame.changeContentPanel(new ManagerInstitutionMgt(nav).getPanel());
		
	}

}
