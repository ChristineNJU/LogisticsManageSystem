package presentation.userPanel.Courier;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.components.PanelContent;
import presentation.components.TextField;
import presentation.main.ColorPallet;
import presentation.main.FontSet;
import businesslogic.Impl.Courier.CourierController;
import businesslogic.Service.Courier.CourierService;

public class CourierNewOrder {
	
	CourierService service = new CourierController();
	
	private PanelContent panel = new PanelContent("快递信息输入");
	private SRInfoPanel sender = new SRInfoPanel("  寄件人");
	private SRInfoPanel recipient = new SRInfoPanel("  收件人");
	
	public CourierNewOrder() {
		init();
	}
	
	private void init() {
		panel.setLayout(null);
		sender.setBounds(87, 80, sender.getWidth(), sender.getHeight());
		recipient.setBounds(487, 80, recipient.getWidth(), recipient.getHeight());
		panel.add(sender);
		panel.add(recipient);
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
		
		TextField n = new TextField();
		TextField c = new TextField();
		TextField a = new TextField();
		TextField o = new TextField();
		TextField t = new TextField();
		TextField m = new TextField();
		
		public SRInfoPanel(String title) {
			// TODO Auto-generated constructor stub
			this.title = new JLabel(title);
			init();
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
			c.setBounds(90, 64, 208, 22);
			add(city);
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
	}
}
