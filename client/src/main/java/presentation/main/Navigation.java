package presentation.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import State.UserRole;
import VO.UserVO;
import presentation.components.ButtonNav;
import presentation.components.PanelNavigation;

public class Navigation {

	UserVO user = new UserVO("141250174","尹子越",UserRole.courier);
	private PanelNavigation navPanel;
	
	private ButtonNav pressed;
	protected  ArrayList<ButtonNav> buttonList = new ArrayList<ButtonNav>();
	
	private NavListener navListener = new NavListener();
	public Navigation(UserVO user) {
		this.user = user;
		navPanel = new PanelNavigation(user);
	}
	
	protected void initNavButtonArray() {
		
	}
	
	protected void addNavButtons(){
		for(int i = 0;i < buttonList.size();i++){
			ButtonNav tempButton = buttonList.get(i);
			tempButton.setLocation(0, 285+40*i);
			tempButton.addMouseListener(navListener);
			navPanel.add(tempButton);
		}
		pressed = buttonList.get(0);
	}
	
	public PanelNavigation getNavPanel(){
		return navPanel;
	}

	protected void changeTask(int index){
	}
	
	public class NavListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			ButtonNav newPressed = (ButtonNav)e.getSource();
			pressed.setUnPressed();
			pressed = newPressed;
			pressed.setPressed();
			int index = 0;
			for(int i = 0; i < buttonList.size();i++){
				if(newPressed.equals(buttonList.get(i)))
					index = i;
			}
			changeTask(index);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
