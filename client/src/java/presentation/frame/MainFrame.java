package presentation.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.VO.LogisticsHistoryVO;
import test.Driver.businesslogic.BusinessLb_Driver;
import test.Stub.businesslogic.BusinessLobbyBlService_Stub;
import test.Stub.businesslogic.InquiryBlService_Stub;

public class MainFrame {

	JFrame frame = null;
	JPanel startPanel = null;
	JTextField barCode = null;
	JButton ok = null;
	LogisticsHistoryVO ligisticsHistory = null;
	ArrayList<JLabel> logisticsInfoLabels = null;
	InquiryBlService_Stub inquiry = null;
	
	public static void main(String [] args){
		MainFrame frame = new MainFrame();
	  }
	
	public MainFrame(){
		this.instance();
		this.init();
	}
	
	private void instance(){
		frame = new JFrame();
		startPanel = new JPanel();
		barCode = new JTextField();
		ok = new JButton("确定");
		
		inquiry = new InquiryBlService_Stub();
	}
	
	private void init(){
		frame.setBounds(100, 100, 800, 600);
		frame.add(startPanel);
		barCode.setBounds(10, 10, 100, 20);
		startPanel.add(barCode);
		ok.setBounds(10,50,100,20);
		startPanel.add(ok);
		ok.addActionListener(new myListener(this));
		
	}
	
	private void showInfo(){
		ArrayList<JLabel> logisticsInfoLabels = new ArrayList<JLabel>();
		for(int i = 0;i < ligisticsHistory.getHistory().size();i++){
			logisticsInfoLabels.set(i, new JLabel(ligisticsHistory.getHistory().get(i)));
			logisticsInfoLabels.get(i).setBounds(10,100,100,30);
			this.startPanel.add(logisticsInfoLabels.get(i));
		}
		this.startPanel.repaint();
		
	}
	
	public class myListener implements ActionListener{
		
		MainFrame frame = null;
		public myListener(MainFrame frame){
			this.frame = frame;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.ligisticsHistory  = (LogisticsHistoryVO) inquiry.getLogistics(barCode.getText());
			frame.showInfo();
		}
	};
	
}
