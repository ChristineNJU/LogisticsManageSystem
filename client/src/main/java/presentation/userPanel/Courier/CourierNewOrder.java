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
	
	
	
	class SRInfoPanel extends JPanel {
		JLabel title;
		JLabel name = new JLabel("姓名");
		JLabel city = new JLabel("所在地区");
		JLabel address = new JLabel("详细地址");
		JLabel organization = new JLabel("机构");
		JLabel telephone = new JLabel("电话");
		JLabel mobilephone = new JLabel("手机");
		
		TextField n = new TextField();
		TextField c = new TextField();
		TextField a = new TextField();
		TextField o = new TextField();
		TextField t = new TextField();
		TextField m = new TextField();
		
		public SRInfoPanel(String title) {
			// TODO Auto-generated constructor stub
			this.title = new JLabel(title);
		}
		
		private void init() {
			setSize(320, 300);
			setLayout(null);
			
			title.setOpaque(false);
			title.setBackground(ColorPallet.Purple);
			title.setFont(FontSet.twenty);
			title.setForeground(Color.white);
			title.setBounds(0, 0, 320, 50);
			
			
		}
	}
}
