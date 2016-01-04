package presentation.main;

import data.RMIHelper.RMIHelper;
import presentation.frame.MainFrame;

public class Starter {
	
	public static void main(String[] args) {
		new RMIHelper();
		MainFrame mainFrame = new MainFrame();
		mainFrame.getFrame().setVisible(true);		
	}
}
