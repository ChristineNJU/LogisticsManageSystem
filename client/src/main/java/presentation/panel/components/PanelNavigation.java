package presentation.panel.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import VO.UserVO;
import presentation.frame.MainFrame;
import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class PanelNavigation extends JPanel {

	UserVO user;
	
	
	ButtonFrame mini = new ButtonFrame("mini");
	ButtonFrame close = new ButtonFrame("close");
	JLabel block = new JLabel();
	Icon userIconImage = new ImageIcon("src/graphics/User/userIcon.png");
	JLabel userIcon = new JLabel(userIconImage);
	JLabel userName;
	JLabel userRole;
	JLabel userId;
	LabelOnline online = new LabelOnline();
	
	JFrame frame = MainFrame.getMainFrame();
	private FrameListener frameListener = new FrameListener();
	
	public PanelNavigation(UserVO user){
		super();
		this.user = user;
		initUser();
	}

	private void initUser(){
		this.setLayout(null);
		this.setBackground(new Color(245,245,245));
		this.setBounds(0,0,220,800);
		
		mini.addActionListener(frameListener);
		close.addActionListener(frameListener);
		this.add(mini);
		this.add(close);
		block.setOpaque(true);
		block.setBackground(new Color(240,240,240));
		block.setBounds(0,0,220,110);

		this.add(online);
		userIcon.setBounds(60, 64, 90, 98);
		this.add(userIcon);
		
		
		userName = new JLabel(user.getName());
		userName.setFont(FontSet.fourteen);
		userName.setBounds(65,175,150,25);
		userName.setForeground(ColorPallet.BlueGray);
		this.add(userName);
		
		userRole = new JLabel("身份："+user.getRole());
		userRole.setFont(FontSet.twelve);
		userRole.setBounds(65,200,150,20);
		userRole.setForeground(ColorPallet.BlueGray);
		this.add(userRole);
		
		userId = new JLabel("工号："+user.getId());
		userId.setFont(FontSet.twelve);
		userId.setBounds(65,220,150,20);
		userId.setForeground(ColorPallet.BlueGray);
		this.add(userId);
		

		this.add(block);
	}
	
	public class FrameListener implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mini))
				frame.setExtendedState(1);
			if(e.getSource().equals(close))
				System.exit(0);
		}
		
	}
	
}
