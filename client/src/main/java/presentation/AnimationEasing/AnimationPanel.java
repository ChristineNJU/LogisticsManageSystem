package presentation.AnimationEasing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class AnimationPanel extends JPanel implements Runnable {

	int size = 5;
	private double[] ang = new double[size];
	private double[] t = new double[size];
	private int[] isPaint = new int[size];
	
	private static final int s_r = 15;
	private static final int core_r = 50;
	private static final int core_x = 80;
	private static final int core_y = 80;
	
	double a = 0.125;
	double v = 0.08;
	double mid = (-v+Math.sqrt(v*v+2*a))/a;
	double dt = mid/600;
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, 200, 200);
		
		g2d.setColor(Color.gray);
		
		for(int i=0;i<ang.length;i++){
			if(isPaint[i]<=3&&isPaint[i]>=1){
				g2d.fillOval(getTheX(i), getTheY(i), s_r, s_r);
			}
		}
	}
	
	private int getTheX(int i) {
		double arg = Math.PI*ang[i];
		int tmp = (int)(core_x - core_r*Math.sin(arg));
		return tmp;
	}

	private int getTheY(int i) {
		double arg = Math.PI*ang[i];
		int tmp = (int)(core_y - core_r*Math.cos(arg));
		return tmp;
	}
	
	private double getValue(double t) {
		if(t>mid){
			return 1+(v+a*mid)*(t-mid)-(t-mid)*(t-mid)*a/2;
		}else{
			return v*t+a*t*t/2;
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			for(int i=0;i<t.length;i++){
				t[i] = -dt*i*150;
				isPaint[i] = 4;
			}
			while(isPaint[isPaint.length-1]>=1){
				for(int i=0;i<t.length;i++){
					t[i] = t[i] + dt;
					if(t[i]>0&&isPaint[i]==4){
						isPaint[i]--;
					}
					if(t[i]>=2*mid){
						t[i] = 0;
						isPaint[i]--;
					}
					ang[i] = getValue(t[i]);
				}
				
				repaint();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
