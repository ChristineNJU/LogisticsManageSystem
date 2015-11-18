package testMain;

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

public class start {

		JFrame frame = null;
		JPanel startPanel = null;
		JTextField barCode = null;
		JButton ok = null;
		LogisticsHistoryVO ligisticsHistory = null;
		ArrayList<JLabel> logisticsInfoLabels = null;
		JLabel error = null;
		InquiryBlService_Stub inquiry = null;
		
		public start(){
			this.instance();
			this.init();
		}
		
		public static void main(String[] args) {
			new start();
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
			startPanel.setLayout(null);
			ok.addActionListener(new myListener(this));
			frame.setVisible(true);
		}
		
		private void showInfo(){
			ArrayList<JLabel> logisticsInfoLabels = new ArrayList<JLabel>();
			for(int i = 0;i < ligisticsHistory.getHistory().size();i++){
				logisticsInfoLabels.add(i, new JLabel(ligisticsHistory.getHistory().get(i)));
				logisticsInfoLabels.get(i).setBounds(10,100*(i+1),100,30);
				this.startPanel.add(logisticsInfoLabels.get(i));
			}
			this.startPanel.repaint();
			
		}
		
		private void showError(){
			error = new JLabel("快递单号非法");
			error.setBounds(10,100,100,30);
			this.startPanel.add(error);
			this.startPanel.repaint();
		}
		
		public class myListener implements ActionListener{
			
			start frame = null;
			public myListener(start frame){
				this.frame = frame;
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String code = barCode.getText();
				int n = code.length();
				boolean legal = true;
				if(n != 10){
					legal = false;
				}
				for(int i = 0;i < n; i++){
					if(code.charAt(i) > '9'||code.charAt(i) < '0')
						legal = false;
				}
				
				if(legal){
					frame.ligisticsHistory  = (LogisticsHistoryVO) inquiry.getLogistics(code);
					frame.showInfo();
				}else{
					System.out.println("error!");
					frame.showError();
				}
			}
		};
		
	

}
