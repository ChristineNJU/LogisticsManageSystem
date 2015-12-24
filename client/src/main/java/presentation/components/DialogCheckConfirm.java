package presentation.components;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JPanel;

import presentation.frame.MainFrame;
import presentation.main.Function;

public class DialogCheckConfirm {

	JDialog dialog = new JDialog();
	JPanel pane = new JPanel();
	LabelHeader label = new LabelHeader("你确定提交所有操作吗？");
	ButtonOk ok = new ButtonOk("确定");
	ButtonCancel cancel = new ButtonCancel();
	
	Function function = new Function();
	
	public DialogCheckConfirm(final Function function){
		this.function = function;
		dialog.setBounds(MainFrame.FRAME_X +  MainFrame.FRAME_WIDTH/2,
				MainFrame.FRAME_Y + MainFrame.FRAME_HEIGHT/2,350,200);
		label.setBounds(30, 20, 350, 40);
		ok.setLocation(30,60);
		cancel.setLocation(120, 60);
		
		dialog.setContentPane(pane);
		pane.setBackground(Color.white);
		pane.setLayout(null);
		
		pane.add(label);
		pane.add(ok);
		pane.add(cancel);
		
		
		ok.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				function.performConfirm();
				dialog.dispose();
			}
			
		});
		
		cancel.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				dialog.dispose();
			}
			
		});
		
		dialog.setAlwaysOnTop(true); 
		dialog.setVisible(true);
	}
}
