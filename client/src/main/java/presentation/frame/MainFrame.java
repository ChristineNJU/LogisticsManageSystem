package presentation.frame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.Service.Inquiry.InquiryService;
import businesslogic.VO.LogisticsHistoryVO;
import presentation.userPanel.start.Inquiry;
import test.Stub.businesslogic.InquiryBlService_Stub;

public class MainFrame {
	public static final int FRAME_WIDTH = 1200;
	public static final int FRAME_HEIGHT = 800;
	
	public static final int FRAME_X = (Toolkit.getDefaultToolkit().getScreenSize().width - FRAME_WIDTH) / 2;
	public static final int FRAME_Y = (Toolkit.getDefaultToolkit().getScreenSize().height - FRAME_HEIGHT) / 2 - 32;

	private JFrame frame = new JFrame();
	private Inquiry inquiry;
	public MainFrame(){
		frame.setTitle("Logistics Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setLocation(FRAME_X,FRAME_Y);
		
		inquiry = new Inquiry(this);
		frame.setContentPane(inquiry.getPanel());
	}
	
	public JFrame getFrame(){
		return frame;
	}
}
