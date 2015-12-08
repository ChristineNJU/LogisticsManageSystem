package presentation.userPanel.Courier;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import presentation.components.FlatScrollPane;
import presentation.components.PanelContent;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.userPanel.start.Inquiry.HistoryLabel;
import VO.LogisticsHistoryVO;
import businesslogic.Impl.Inquiry.InquiryController;
import businesslogic.Service.Inquiry.InquiryService;
import javax.swing.JPanel;

import presentation.userPanel.start.Inquiry;

public class CourierLogisticsInfoSearch {
	
	InquiryMouseListener iN = new InquiryMouseListener();
	InquiryFocusListener iF = new InquiryFocusListener();
	
	private PanelContent panel = new PanelContent("查询快递信息");

	private JScrollPane scrollPane;
	private JPanel scrollPanePanel;
	
	private JLabel error;
	private JLabel notFound;
	
	private JTextField input;
	private JButton confirm;
	
	private LogisticsHistoryVO info;
	private ArrayList<HistoryLabel> historyLabel;
	private ArrayList<String> history;
	
	InquiryService inquiryService = new InquiryController();
	
	private int size = 0;
	
	public CourierLogisticsInfoSearch() {
		panel.setLayout(null);
		componentsInstantiation();
		init();
		initListener();
	}
	
	private void componentsInstantiation(){
		scrollPanePanel = new HistoryPanel();
		scrollPane = new FlatScrollPane(scrollPanePanel);
		Icon iconError = new ImageIcon("src/graphics/Tips/errorBarCode.png");
		error = new JLabel(iconError);
		Icon iconNotFound = new ImageIcon("src/graphics/Tips/notFoundBarCode.png");
		notFound = new JLabel(iconNotFound);
		input = new JTextField("输入订单编号");
		confirm = new JButton();
	}
	
	private void init() {
		input.setFont(FontSet.fourteen);
		input.setForeground(ColorPallet.GrayLight);
		input.setBorder(BorderFactory.createLineBorder(ColorPallet.Pink));
		input.setBounds(116,170,300,40);
		
		confirm.setBorderPainted(false);
		confirm.setContentAreaFilled(false);
		confirm.setFocusPainted(false);
		confirm.setIcon(new ImageIcon("src/graphics/Button/inquiry.png"));
		confirm.setRolloverIcon(new ImageIcon("src/graphics/Button/inquiry2.png"));
		confirm.setPressedIcon(new ImageIcon("src/graphics/Button/inquiry2.png"));
		confirm.setBounds(416, 170,141,40);
		

		
		notFound.setBounds(116, 100, 340, 70);
		error.setBounds(116, 100, 300, 70);
		
		panel.add(input);
		panel.add(confirm);
		
	}
	
	private void initListener() {
		confirm.addMouseListener(iN);
		input.addFocusListener(iF);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	private void show(String bar_code){
		info = inquiryService.getLogistics(bar_code);
		if(info == null){
			showNotFound();
			return;
		}
		history = info.getHistory();		
		
		size = history.size();
		
		System.out.println(size);
		
		scrollPane.setBounds(116, 220, 441, 350);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(new LineBorder(Color.black, 0));
		scrollPanePanel.setLayout(null);
		scrollPanePanel.setOpaque(false);
		
		Dimension d = new Dimension(441, 66*history.size());
		scrollPanePanel.setPreferredSize(d);
		panel.add(scrollPane);
		
		historyLabel = new ArrayList<HistoryLabel>();
		for(int i = 0 ; i < history.size();i++){
			String[] input = history.get(i).split(",");
			if(input.length>=2){				
				historyLabel.add(new HistoryLabel(input[0], input[1],history.size()-i-1));
			}else{
				historyLabel.add(new HistoryLabel(input[0], "",history.size()-i-1));
			}
//			inquiryPanel.add(historyLabel.get(i));
//			scrollPanePanel.add(historyLabel.get(i));
//			System.out.println(i);
		}
		
		int w = 300;
		int h = 0;
		
		for(int i=0;i<history.size();i++){
			
			h = h+66;
			
			scrollPanePanel.add(historyLabel.get(i));
			scrollPanePanel.setSize(w, h);
			
//			System.out.println(h);
		}
		
		scrollPane.repaint();
	}
	
	private void showNotFound(){
		panel.add(notFound);
		panel.repaint();
	}
	
	private void removeNotFound(){
		panel.remove(notFound);
		panel.repaint();
	}
	
	private void showError(){
		panel.add(error);
		panel.repaint();
	}
	
	private void removeError(){
		panel.remove(error);
//		error.setVisible(false);
		panel.repaint();
	}
	
	class HistoryPanel extends JPanel {
		
		public void paint(Graphics g) {
			Color oldColor = g.getColor();
			
			Graphics2D g2d = (Graphics2D)g;
			g2d.setBackground(Color.black);
			Stroke dash = new BasicStroke(1.5f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,
			3.5f,new float[]{5,5},0f);
			g2d.setStroke(dash);
			g2d.setColor(ColorPallet.GrayDark);
//			g2d.drawLine(30, y1, x2, y2);
			
			int h = 40;
			
			System.out.println(this.getHeight());
			for(int i=0;i<size-1;i++){
				g2d.drawLine(15, h, 15, h+26+10);
				h = h+66;
			}
			
			super.paint(g);
		}
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
	
	class HistoryLabel extends JLabel{
		
		JLabel detailL;
		JLabel timeL;
		JLabel node;
		
		public HistoryLabel(String detail,String time,int i) {

			node = new JLabel();
			
			detailL = new JLabel(detail);
			detailL.setBounds(60,6,300,25);
			detailL.setFont(FontSet.twenty);
			
			timeL = new JLabel(time);
			timeL.setBounds(60,30,300,25);
			timeL.setFont(FontSet.twelve);
			
			if(i == 0){
				detailL.setForeground(ColorPallet.Pink);
				timeL.setForeground(ColorPallet.Pink);
				node.setIcon(new ImageIcon("src/graphics/Node/node_first.png"));
			}else{
				detailL.setForeground(ColorPallet.Purple);
				timeL.setForeground(ColorPallet.Purple);
				node.setIcon(new ImageIcon("src/graphics/Node/node_other.png"));
			}
			
			node.setBounds(0, 10, 30, 30);
			
			this.add(detailL);
			this.add(timeL);
			this.add(node);
//			setBounds(300,320+i*66,450,66);
			setBounds(0, i*66, 450, 66);
		}

	}

	class InquiryMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			String bar_code = input.getText();
			if(isLegal(bar_code)){
				show(bar_code);
			}else{
				showError();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
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

	class InquiryFocusListener implements FocusListener {

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
			}
		}
	}
}
