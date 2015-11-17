package presentation.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import test.Stub.businesslogic.InquiryBlService_Stub;
import VO.LogisticsHistoryVO;
import businesslogic.Service.Inquiry.InquiryService;

public class MainFrame {

	JFrame frame = null;
	JPanel startPanel = null;
	JTextField barCode = null;
	JButton ok = null;
	LogisticsHistoryVO ligisticsHistory = null;
	ArrayList<JLabel> logisticsInfoLabels = null;
	InquiryService inquiry = null;
	
	public MainFrame(){
		this.instance();
		this.init();
	}
	
	public static void main(String[] args) {
		new MainFrame();
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
		frame.setVisible(true);
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
