package presentation.userPanel.Courier;

import javax.swing.JPanel;

import presentation.userPanel.start.Inquiry;

public class CourierLogisticsInfoSearch {

	Inquiry inquiry;
	public CourierLogisticsInfoSearch(){
		inquiry = new Inquiry();
	}
	
	public JPanel getPanel(){
		return inquiry.getPanel();
	}
}
