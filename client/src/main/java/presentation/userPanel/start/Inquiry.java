package presentation.userPanel.start;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import presentation.AnimationEasing.AnimationEasing;
import presentation.components.ButtonFrame;
import presentation.components.FlatScrollPane;
import presentation.frame.MainFrame;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import VO.LogisticsHistoryVO;
import businesslogic.Impl.Inquiry.InquiryController;
import businesslogic.Service.Inquiry.InquiryService;

public class Inquiry{

	private LogIn logInDialog;
	
	private MainFrame mainFrame;
	private JPanel inquiryPanel;
	
	private JScrollPane scrollPane;
	
	private JButton mini;
	private JButton close;
	private JLabel title;
	private JButton logIn;
	
	private JLabel error;
	private JLabel notFound;
	
	private JTextField input;
	private JButton confirm;
	
	private LogisticsHistoryVO info;
	private ArrayList<HistoryLabel> historyLabel;
	private ArrayList<String> history;
	
	InquiryService inquiryService = new InquiryController();
	
	private Listener listener;
	
	public Inquiry(MainFrame frame){
		this.mainFrame = frame;
		componentsInstantiation();
		initComponents();
	}
	
	private void componentsInstantiation(){
		inquiryPanel = new JPanel();
		scrollPane = new FlatScrollPane();
		mini = new ButtonFrame("mini");
		close = new ButtonFrame("close");
		Icon iconTitle = new ImageIcon("src/graphics/Title/logIn.png");
		title = new JLabel(iconTitle);
		Icon iconError = new ImageIcon("src/graphics/Tips/errorBarCode.png");
		error = new JLabel(iconError);
		Icon iconNotFound = new ImageIcon("src/graphics/Tips/notFoundBarCode.png");
		notFound = new JLabel(iconNotFound);
		logIn = new JButton();
		input = new JTextField("输入订单编号");
		confirm = new JButton();
		
		listener = new Listener();
	}
	
	private void initComponents(){
		inquiryPanel.setBounds(0,0,1200,800);
		inquiryPanel.setLayout(null);
		inquiryPanel.setBackground(ColorPallet.backGround);

		mini.addActionListener(listener);
		close.addActionListener(listener);
		inquiryPanel.add(mini);
		inquiryPanel.add(close);
		
		scrollPane.setBounds(300, 320, 450, 500);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(new LineBorder(Color.black, 0));
		inquiryPanel.add(scrollPane);
		
		title.setBounds(300,0,400,63);
		inquiryPanel.add(title);
		
		logIn.setBorderPainted(false);
		logIn.setContentAreaFilled(false);
		logIn.setFocusPainted(false);
		logIn.setIcon(new ImageIcon("src/graphics/Button/logIn1.png"));
		logIn.setRolloverIcon(new ImageIcon("src/graphics/Button/logIn2.png"));
		logIn.setPressedIcon(new ImageIcon("src/graphics/Button/logIn2.png"));
		logIn.setBounds(830, 2, 128, 63);
		logIn.addActionListener(listener);
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
		
		input.setFont(FontSet.fourteen);
		input.setForeground(ColorPallet.GrayLight);
		input.setBorder(BorderFactory.createLineBorder(ColorPallet.Pink));
//		input.setOpaque(false);
		input.setBounds(300,240,300,40);
		input.addActionListener(listener);
		input.addFocusListener(listener);
		inquiryPanel.add(input);
		
		error.setBounds(300, 170, 300, 70);
		notFound.setBounds(300,170,340,70);
//		inquiryPanel.add(error);
		
	}
	
	private void show(String bar_code){
		info = inquiryService.getLogistics(bar_code);
		if(info == null){
			showNotFound();
			return;
		}
//		ArrayList<String> historyString = new ArrayList<String>();
//		historyString.add("已签收，签收是本人");
//		historyString.add("到达仙林营业厅");
//		historyString.add("到达上海中转中心");
//		historyString.add("从浦口营业厅出发");
//		historyString.add("快递员揽件");
//		info = new LogisticsHistoryVO(bar_code, historyString);
		history = info.getHistory();		
		historyLabel = new ArrayList<HistoryLabel>();
		for(int i = 0 ; i < history.size();i++){
			String[] input = history.get(i).split(",");
			if(input.length>=2){				
				historyLabel.add(new HistoryLabel(input[0], input[1],history.size()-i-1));
			}else{
				historyLabel.add(new HistoryLabel(input[0], "",i));
			}
//			inquiryPanel.add(historyLabel.get(i));
			scrollPane.add(historyLabel.get(i));
			System.out.println(i);
		}
//		inquiryPanel.repaint();
		scrollPane.repaint();
	}
	
	private void showLogIn(){
		logInDialog = new LogIn(this);
//		logInDialog.getDialog().setVisible(true);
		JPanel lg = logInDialog.getPanel();
		
		inquiryPanel.add(lg);
		
		lg.setVisible(true);
		logIn.setVisible(false);
		
		Thread t = new Thread(new MovingFunction());
		t.start();
		
		logInDialog.getDialog().setModal(true);
	}
	
	private void showNotFound(){
		inquiryPanel.add(notFound);
		inquiryPanel.repaint();
	}
	
	private void removeNotFound(){
		inquiryPanel.remove(notFound);
		inquiryPanel.repaint();
	}
	
	private void showError(){
		inquiryPanel.add(error);
		inquiryPanel.repaint();
	}
	
	private void removeError(){
		inquiryPanel.remove(error);
//		error.setVisible(false);
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
	
	public JButton getLogin() {
		return logIn;
	}
	
	public class HistoryLabel extends JLabel{
		
		JLabel detailL;
		JLabel timeL;
		public HistoryLabel(String detail,String time,int i) {

			
			detailL = new JLabel(detail);
			detailL.setBounds(60,6,300,25);
			detailL.setFont(FontSet.twenty);
			
			timeL = new JLabel(time);
			timeL.setBounds(60,30,300,25);
			timeL.setFont(FontSet.twelve);
			
			if(i == 0){
				detailL.setForeground(ColorPallet.Pink);
				timeL.setForeground(ColorPallet.Pink);
			}else{
				detailL.setForeground(ColorPallet.Purple);
				timeL.setForeground(ColorPallet.Purple);
			}
			
			this.add(detailL);
			this.add(timeL);
//			setBounds(300,320+i*66,450,66);
			setBounds(0, i*66, 450, 66);
		}
		
	}
	
	public class Listener implements ActionListener, FocusListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mini)){
				mainFrame.getFrame().setExtendedState(1);
			}
			if(e.getSource().equals(close)){
//				System.exit(0);
				mainFrame.frameClose();
			}
			if(e.getSource().equals(confirm)){
				String bar_code = input.getText();
				if(isLegal(bar_code)){
					show(bar_code);
				}else{
					showError();
				}
			}
			if(e.getSource().equals(logIn)){
				showLogIn();
//				System.out.println("in listener");
			}
			
		}

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(input)){
				input.setText("");
				removeError();
				removeNotFound();
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(input)){
				if(input.getText().equals("")){
					input.setText("输入订单编号");
				}
//				removeError();
			}
		}
		
	}

	class MovingFunction implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			double time = 0;
			while(time<=8){
				int i = (int)AnimationEasing.easeInElastic(0, time, 0, LogIn.login_height, 10);
//				System.out.println(i);
				logInDialog.getPanel().setSize(LogIn.login_width, i);
				logInDialog.getLine().setBounds(0, LogIn.login_height-6, LogIn.login_width, i-(LogIn.login_height-6));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				time = time + 0.1;
//				System.out.println("in method");
			}
		}
	}
}
