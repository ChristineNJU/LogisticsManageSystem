package presentation.userPanel.start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.frame.MainFrame;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.panel.components.ButtonFrame;
import test.Stub.businesslogic.InquiryBlService_Stub;
import VO.LogisticsHistoryVO;

public class Inquiry{

	private MainFrame mainFrame;
	private JPanel inquiryPanel;
	
	private JButton mini;
	private JButton close;
	private JLabel title;
	private JButton logIn;
	
	private JLabel error;
	
	private JTextField input;
	private JButton confirm;
	
	private LogisticsHistoryVO info;
	private ArrayList<JLabel> history;
	
	InquiryBlService_Stub inquiryService = new InquiryBlService_Stub();
	
	private Listener listener;
	
	public Inquiry(MainFrame frame){
		this.mainFrame = frame;
		componentsInstantiation();
		initComponents();
	}
	
	private void componentsInstantiation(){
		inquiryPanel = new JPanel();
		mini = new ButtonFrame("mini");
		close = new ButtonFrame("close");
		Icon iconTitle = new ImageIcon("src/graphics/Title/logIn.png");
		title = new JLabel(iconTitle);
		Icon iconError = new ImageIcon("src/graphics/Tips/errorBarCode.png");
		error = new JLabel(iconError);
		logIn = new JButton();
		input = new JTextField("输入订单编号");
		confirm = new JButton();
		
		listener = new Listener();
	}
	
	private void initComponents(){
		inquiryPanel.setLayout(null);
		inquiryPanel.setBackground(ColorPallet.backGround);

		mini.addActionListener(listener);
		close.addActionListener(listener);
		inquiryPanel.add(mini);
		inquiryPanel.add(close);
		
		
		title.setBounds(300,0,400,63);
		inquiryPanel.add(title);
		
		logIn.setBorderPainted(false);
		logIn.setContentAreaFilled(false);
		logIn.setFocusPainted(false);
		logIn.setIcon(new ImageIcon("src/graphics/Button/logIn1.png"));
		logIn.setRolloverIcon(new ImageIcon("src/graphics/Button/logIn2.png"));
		logIn.setPressedIcon(new ImageIcon("src/graphics/Button/logIn2.png"));
		logIn.setBounds(830, 2, 128, 63);
		inquiryPanel.add(logIn);
		
		confirm.setBorderPainted(false);
		confirm.setContentAreaFilled(false);
		confirm.setFocusPainted(false);
		confirm.setIcon(new ImageIcon("src/graphics/Button/inquiry.png"));
		confirm.setRolloverIcon(new ImageIcon("src/graphics/Button/inquiry2.png"));
		confirm.setPressedIcon(new ImageIcon("src/graphics/Button/inquiry2.png"));
		confirm.setBounds(600,240,141,40);
		confirm.addActionListener(listener);
		inquiryPanel.add(confirm);
		
		input.setFont(FontSet.fontTips);
		input.setForeground(ColorPallet.GrayLight);
		input.setBorder(BorderFactory.createLineBorder(ColorPallet.Pink));
//		input.setOpaque(false);
		input.setBounds(300,240,300,40);
		input.addActionListener(listener);
		inquiryPanel.add(input);
		
		error.setBounds(300, 170, 300, 70);
//		inquiryPanel.add(error);
		
	}
	
	private void show(String bar_code){
		info = inquiryService.getLogistics(bar_code);
		for(int i = 0 ; i < info.size();i++){
			history.add(new JLabel());
		}
	}
	
	private void showError(){
		inquiryPanel.add(error);
		inquiryPanel.repaint();
	}
	
	private void removeError(){
//		inquiryPanel.remove(error);
		error.setVisible(false);
		inquiryPanel.repaint();
	}
	
	private boolean isLegal(String s){
		if(s.length() != 10)
			return false;
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) > '9' ||s.charAt(i) <'0')
				return false;
		}
		return true;
	}
	
	public JPanel getPanel(){
		return inquiryPanel;
	}
	
	public class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mini)){
				mainFrame.getFrame().setExtendedState(1);
			}
			if(e.getSource().equals(close)){
				System.exit(0);
			}
			if(e.getSource().equals(confirm)){
				String bar_code = input.getText();
				if(isLegal(bar_code)){
					show(bar_code);
				}else{
					showError();
				}
			}
			if(e.getSource().equals(input)){
				removeError();
			}
		}
		
	}
}
