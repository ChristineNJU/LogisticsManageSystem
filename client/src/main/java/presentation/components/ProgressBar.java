package presentation.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoundedRangeModel;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;

import presentation.main.ColorPallet;

public class ProgressBar extends JProgressBar {
	
	public ProgressBar() {
		super();
		init();
	}
	
	public ProgressBar(BoundedRangeModel b) {
		super(b);
		init();
	}
	
	public ProgressBar(int i) {
		super(i);
		init();
	}
	
	public ProgressBar(int a, int b) {
		super(a, b);
		init();
	}
	
	public ProgressBar(int a, int b, int c) {
		super(a, b, c);
		init();
	}
	
	public void init() {
		setForeground(ColorPallet.Purple);
		setBackground(Color.white);
		setBorder(new LineBorder(ColorPallet.Purple, 1));
		setUI(new ProgressBarUI(this));
	}
	
	class ProgressBarUI extends BasicProgressBarUI {
		private double redOverPercent = 95.0;
		
		private JProgressBar jProgressBar;
		
		private ProgressBarUI(JProgressBar jProgressBar) {
			this.jProgressBar = jProgressBar;
		}
		
		protected void paintDeterminate(Graphics g, JComponent c) {
			double percent = 100.0 * this.jProgressBar.getValue()/(this.jProgressBar.getMaximum());
			
			if(percent >= this.redOverPercent){
				this.jProgressBar.setForeground(Color.red);
				this.jProgressBar.setBorder(new LineBorder(Color.red, 1));
			}else{
				this.jProgressBar.setForeground(ColorPallet.Purple);
				this.jProgressBar.setBorder(new LineBorder(ColorPallet.Purple, 1));
			}
			super.paintDeterminate(g, c);
		}
	}
}
