package presentation.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;

import presentation.userPanel.Admin.AdminUserAccount;

public class EditorDelete extends DefaultCellEditor {

	ButtonDelete button = new ButtonDelete();
	AdminUserAccount task;
	public EditorDelete(final AdminUserAccount task) {
		super(new JTextField());
		this.setClickCountToStart(1);
		this.task = task;
		System.out.println("create delete editor");
		this.button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table,Object value,boolean isSelected,int row,int column){
		
		return button;
		
	}

}
