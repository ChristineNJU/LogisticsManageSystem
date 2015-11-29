package presentation.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class EditorDelete extends DefaultCellEditor {

	ButtonDelete delete;
//	ButtonHaveDelete haveDelete;
	ButtonEmpty empty;
	private int initialRowCount;

	Boolean isDelete = false;
	public EditorDelete(int initialRowCount) {
		super(new JTextField());
		delete = new ButtonDelete();
		empty = new ButtonEmpty();
//		haveDelete = new ButtonHaveDelete();
		this.initialRowCount = initialRowCount;
		this.setClickCountToStart(1);
		this.delete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				isDelete = true;
			}
		});
//		this.haveDelete.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				isDelete = false;
//			}
//		});
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table,Object value,boolean isSelected,int row,int column){
		
			if(row < initialRowCount)
				return delete;
			else
				return empty;
	}

	public class ButtonDelete extends JButton{
		public ButtonDelete(){
			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setContentAreaFilled(false);
			setIcon(new ImageIcon("src/graphics/Button/delete.png"));
			setSize(30,30);
			setHorizontalAlignment(CENTER); 
		}
	}
	public class ButtonEmpty extends JButton{
		public ButtonEmpty(){
//			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setContentAreaFilled(false);
			setSize(30,30);
			setOpaque(false);
			setForeground(ColorPallet.Purple);
			setFont(FontSet.fourteen);
			setBorder(BorderFactory.createLineBorder(ColorPallet.Purple));
			setText("取消新增");
			this.setHorizontalAlignment(CENTER);
		}
	}
	
}
