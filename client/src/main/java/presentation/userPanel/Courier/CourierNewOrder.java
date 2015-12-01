package presentation.userPanel.Courier;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.components.MyComboBox;
import presentation.components.PanelContent;
import presentation.components.TextField;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import presentation.main.Translater;
import State.LogisticsType;
import State.PackingCharge;
import State.StateSwitch;
import State.TransferType;
import businesslogic.Impl.Courier.CourierController;
import businesslogic.Service.Courier.CourierService;

public class CourierNewOrder {
	
	CourierService service = new CourierController();
	Listener listener = new Listener();
	
	private PanelContent panel = new PanelContent("快递信息输入");
	private SRInfoPanel sender = new SRInfoPanel("  寄件人");
	private SRInfoPanel recipient = new SRInfoPanel("  收件人");
	private LogisticsInfoPanel l;
	
	JLabel amount = new JLabel("费  用  合  计 ", JLabel.CENTER);
	JLabel time = new JLabel("预计到达时间", JLabel.CENTER);
	JLabel amount_actual = new JLabel("");
	JLabel time_actual = new JLabel("");
	
	
	public CourierNewOrder() {
		init();
	}
	
	private void init() {
		panel.setLayout(null);
		sender.setBounds(87, 80, sender.getWidth(), sender.getHeight());
		recipient.setBounds(487, 80, recipient.getWidth(), recipient.getHeight());
		l.setBounds(87, 310, l.getWidth(), l.getHeight());
		
		amount.setForeground(ColorPallet.GrayDark);
		amount_actual.setForeground(ColorPallet.GrayDark);
		time.setForeground(ColorPallet.GrayDark);
		time_actual.setForeground(ColorPallet.GrayDark);
		amount.setFont(FontSet.fourteen);
		time.setFont(FontSet.fourteen);
		amount_actual.setFont(FontSet.fourteen);
		time_actual.setFont(FontSet.fourteen);
		amount.setBounds(93, 460, 100, 30);
		amount_actual.setBounds(220, 460, 200, 30);
		time.setBounds(93, 490, 100, 30);
		time_actual.setBounds(220, 490, 200, 30);
		
		panel.add(sender);
		panel.add(recipient);
		panel.add(l);
		panel.add(amount);
		panel.add(time);
		panel.add(amount_actual);
		panel.add(time_actual);
		
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	class SRInfoPanel extends JPanel {
		JLabel title;
		JLabel name = new JLabel("姓       名", JLabel.CENTER);
		JLabel city = new JLabel("所在地区", JLabel.CENTER);
		JLabel address = new JLabel("详细地址", JLabel.CENTER);
		JLabel organization = new JLabel("机       构", JLabel.CENTER);
		JLabel telephone = new JLabel("电       话", JLabel.CENTER);
		JLabel mobilephone = new JLabel("手       机", JLabel.CENTER);
		
		MyComboBox city_actual = new MyComboBox();
		
		TextField n = new TextField();
		TextField c = new TextField();
		TextField a = new TextField();
		TextField o = new TextField();
		TextField t = new TextField();
		TextField m = new TextField();
		
		public SRInfoPanel(String title) {
			// TODO Auto-generated constructor stub
			l = new LogisticsInfoPanel();
			this.title = new JLabel(title);
			init();
			initComboBox();
			initListener();
		}
		
		private void init() {
			setSize(320, 206);
			setLayout(null);
			
			title.setOpaque(true);
			title.setBackground(ColorPallet.Purple);
			title.setFont(FontSet.twenty);
			title.setForeground(Color.white);
			title.setBounds(0, 0, 320, 30);
			add(title);
			
			name.setFont(FontSet.fourteen);
			name.setForeground(ColorPallet.GrayDark);
			name.setBounds(-3, 32, 90, 28);
			n.setBounds(90, 36, 208, 22);
			add(name);
			add(n);
			
			city.setFont(FontSet.fourteen);
			city.setForeground(ColorPallet.GrayDark);
			city.setBounds(-3, 60, 90, 28);
			city_actual.setBounds(90, 64, 70, 22);
			c.setBounds(161, 64, 137, 22);
			add(city);
			add(city_actual);
			add(c);
			
			address.setFont(FontSet.fourteen);
			address.setForeground(ColorPallet.GrayDark);
			address.setBounds(-3, 88, 90, 28);
			a.setBounds(90, 92, 208, 22);
			add(address);
			add(a);
			
			organization.setFont(FontSet.fourteen);
			organization.setForeground(ColorPallet.GrayDark);
			organization.setBounds(-3, 116, 90, 28);
			o.setBounds(90, 120, 208, 22);
			add(organization);
			add(o);
			
			telephone.setFont(FontSet.fourteen);
			telephone.setForeground(ColorPallet.GrayDark);
			telephone.setBounds(-3, 144, 90, 28);
			t.setBounds(90, 148, 208, 22);
			add(telephone);
			add(t);
			
			mobilephone.setFont(FontSet.fourteen);
			mobilephone.setForeground(ColorPallet.GrayDark);
			mobilephone.setBounds(-3, 172, 90, 28);
			m.setBounds(90, 176, 208, 22);
			add(mobilephone);
			add(m);
		}
	
		private void initComboBox() {
			ArrayList<String> c = service.getCity();
			
			for(int i=0;i<c.size();i++){
				city_actual.addItem(c.get(i));
			}
		}
		
		private void initListener() {
			city_actual.addFocusListener(listener);
		}
	}

	class LogisticsInfoPanel extends JPanel {
		
		JLabel title = new JLabel("  货物信息", JLabel.LEFT);
		JLabel o_n = new JLabel("原  件  数", JLabel.CENTER);
		JLabel i_n = new JLabel("内件品名", JLabel.CENTER);
		JLabel s = new JLabel("实际体积", JLabel.CENTER);
		JLabel w = new JLabel("实际重量", JLabel.CENTER);
		JLabel m3 = new JLabel("m3", JLabel.CENTER);
		JLabel kg = new JLabel("kg", JLabel.CENTER);
		JLabel t = new JLabel("快递类型", JLabel.CENTER);
		JLabel p = new JLabel("包装费用", JLabel.CENTER);
		
		MyComboBox original_number = new MyComboBox();
		TextField internal_name = new TextField();
		TextField size = new TextField();
		TextField weight = new TextField();
		MyComboBox type = new MyComboBox();
		MyComboBox pack = new MyComboBox();
		
		public LogisticsInfoPanel() {
			// TODO Auto-generated constructor stub
			init();
			initComboBox();
			initListener();
		}
		
		private void init() {
			setLayout(null);
			setSize(720, 130);
		
			title.setBounds(0, 0, 720, 30);
			title.setOpaque(true);
			title.setForeground(Color.white);
			title.setFont(FontSet.twenty);
			title.setBackground(ColorPallet.Purple);
			add(title);
			
			o_n.setBounds(2, 40, 80, 40);
			o_n.setForeground(ColorPallet.GrayDark);
			o_n.setFont(FontSet.fourteen);
			original_number.setBounds(90, 48, 80, 26);
			original_number.setEditable(true);
			add(o_n);
			add(original_number);
			
			i_n.setBounds(180, 40, 80, 40);
			i_n.setForeground(ColorPallet.GrayDark);
			i_n.setFont(FontSet.fourteen);
			internal_name.setBounds(268, 48, 80, 26);
			add(i_n);
			add(internal_name);
			
			s.setBounds(358, 40, 80, 40);
			s.setForeground(ColorPallet.GrayDark);
			s.setFont(FontSet.fourteen);
			size.setBounds(446, 48, 60, 26);
			m3.setBounds(511, 48, 20, 26);
//			m3.setFont(FontSet.fourteen);
			m3.setForeground(ColorPallet.GrayDark);
			add(s);
			add(size);
			add(m3);
			
			w.setBounds(546, 40, 60, 40);
			w.setForeground(ColorPallet.GrayDark);
			w.setFont(FontSet.fourteen);
			weight.setBounds(624, 48, 60, 26);
			kg.setBounds(687, 48, 20, 26);
			kg.setForeground(ColorPallet.GrayDark);
			add(w);
			add(weight);
			add(kg);
			
			t.setBounds(2, 80, 80, 40);
			t.setForeground(ColorPallet.GrayDark);
			t.setFont(FontSet.fourteen);
			type.setBounds(90, 88, 100, 26);
			type.setEditable(false);
			add(t);
			add(type);
			
			p.setBounds(200, 80, 80, 40);
			p.setForeground(ColorPallet.GrayDark);
			p.setFont(FontSet.fourteen);
			pack.setBounds(288, 88, 80, 26);
			pack.setEditable(false);
			add(p);
			add(pack);
		}
		
		private void initComboBox() {
			for(int i=1;i<6;i++){				
				original_number.addItem(i);
			}
			
			type.addItem("标准快递");
			type.addItem("经济快递");
			type.addItem("特快专递");
			
			pack.addItem("木箱");
			pack.addItem("快递袋");
			pack.addItem("纸箱");
		}
	
		private void initListener() {
			original_number.addFocusListener(listener);
			internal_name.addFocusListener(listener);
			size.addFocusListener(listener);
			weight.addFocusListener(listener);
			type.addFocusListener(listener);
			pack.addFocusListener(listener);
		}
	}

	class Listener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(l.weight)){
				if(!isLegal(l.weight.getText())){
					l.weight.setError();;
//					l.weight.setText("");
				}
			}else if(e.getSource().equals(l.size)){
				if(!isLegal(l.size.getText())){
					l.size.setError();
				}
			}
			
			if(isLegal(l.weight.getText())&&isLegal(l.size.getText())){
				amount_actual.setText(""+getAmount());
			}
		}
	}

	private boolean isLegal(String s) {
		if(s.equals("")){
			return false;
		}
		
		boolean isLegal = true;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)<='9'&&s.charAt(i)>='0'){
				isLegal = true;
			}else{
				isLegal = false;
				break;
			}
		}
		return isLegal;
	}

	private double getAmount() {
		double result = 0;

		LogisticsType type = Translater.getLogisticsType((String)l.type.getSelectedItem());
		PackingCharge pack = Translater.getPackingCharge((String)l.pack.getSelectedItem());
		
		double weight = Double.parseDouble(l.weight.getText());
		double size = Double.parseDouble(l.size.getText());
		
		System.out.println(weight+" "+size+" "+type+" "+pack+" "+(String)sender.city_actual.getSelectedItem()
				+(String)recipient.city_actual.getSelectedItem());
		
		result = service.getAmount((String)sender.city_actual.getSelectedItem(), 
				(String)recipient.city_actual.getSelectedItem(),
				type, pack, weight, size);
		
		return result;
	}
}
