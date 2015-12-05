package presentation.userPanel.Repository;

import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import State.StorageArea;
import businesslogic.Impl.Repository.GetAmountImpl;
import businesslogic.Service.Repository.GetAmountService;
import data.RMIHelper.RMIHelper;
import data.Service.Sundry.WareHouseService;
import presentation.components.ProgressBar;
import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class ProgressBarPanel {
	
	GetAmountService gas;
	
	int a = 0;
	int c = 0;
	int r = 0;
	
	private JPanel panel = new JPanel();
	private JLabel air = new JLabel("航空区", JLabel.CENTER);
	private JLabel car = new JLabel("汽运区", JLabel.CENTER);
	private JLabel rail = new JLabel("铁路区", JLabel.CENTER);
	
	private ProgressBar air_actual = new ProgressBar();
	private ProgressBar car_actual = new ProgressBar();
	private ProgressBar rail_actual = new ProgressBar();
	
	private JLabel error = new JLabel("与服务器连接失败", JLabel.CENTER);
	
	public ProgressBarPanel() {
		panel.setBounds(550, 0, 240, 95);
		panel.setOpaque(true);
		panel.setBackground(Color.white);
		try {
			gas = new GetAmountImpl();
			a = gas.getAmount(StorageArea.AIR_TRANSPORTATION);
			c = gas.getAmount(StorageArea.CAR_TRANSPORTATION);
			r = gas.getAmount(StorageArea.RAILWAY_TRANSPORTATION);
			init();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error.setBounds(20, 10, 200, 80);
			error.setForeground(ColorPallet.Pink);
			error.setFont(FontSet.twenty);;
			
			panel.add(error);
		}
	}
	
	private void init() {
		
		air.setBounds(0, 0, 50, 30);
		air.setFont(FontSet.fourteen);
		air.setForeground(ColorPallet.Pink);
		air_actual.setBounds(50, 8, 180, 15);
		air_actual.setMinimum(0);
		air_actual.setMaximum(100);
		air_actual.setStringPainted(true);
		
		car.setBounds(0, 30, 50, 30);
		car.setFont(FontSet.fourteen);
		car.setForeground(ColorPallet.Pink);
		car_actual.setBounds(50, 38, 180, 15);
		car_actual.setMinimum(0);
		car_actual.setMaximum(100);
		car_actual.setStringPainted(true);
		
		rail.setBounds(0, 60, 50, 30);
		rail.setFont(FontSet.fourteen);
		rail.setForeground(ColorPallet.Pink);
		rail_actual.setBounds(50, 68, 180, 15);
		rail_actual.setMinimum(0);
		rail_actual.setMaximum(100);
		rail_actual.setStringPainted(true);
		
		setValue();
		
		panel.add(air);
		panel.add(air_actual);
		panel.add(car);
		panel.add(car_actual);
		panel.add(rail);
		panel.add(rail_actual);
	}
	
	private void setValue() {
		air_actual.setValue(a);
		car_actual.setValue(c);
		rail_actual.setValue(r);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
