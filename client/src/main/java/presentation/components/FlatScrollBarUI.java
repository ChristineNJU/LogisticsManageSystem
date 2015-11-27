package presentation.components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

import presentation.main.ColorPallet;


public class FlatScrollBarUI extends BasicScrollBarUI {
	
	public static ComponentUI createUI(JComponent c) {
		return new FlatScrollBarUI();
	}
	
	public Dimension getRerferredSize(JComponent c) {
		Insets insets = c.getInsets();
		int dx = insets.left + insets.right;
		int dy = insets.top + insets.bottom;
		return (scrollbar.getOrientation()==JScrollBar.VERTICAL)
				?new Dimension(dx+11, dy+33)
				:new Dimension(dx+33, dy+11);
	}
	
	protected JButton createDecreaseButton(int orientation) {
		boolean isFocusable = scrollbar.isFocusable();
		
		FlatArrowButton fb = new FlatArrowButton(orientation);
		fb.setFocusable(isFocusable);
		fb.setVisible(true);
		return fb;
	}
	
	protected JButton createIncreaseButton(int orientation) {
		boolean isFocusable = scrollbar.isFocusable();
//		System.out.println(isFocusable);
		FlatArrowButton fb = new FlatArrowButton(orientation);
		fb.setFocusable(isFocusable);
		fb.setVisible(true);
		return fb;
	}
	
	public void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
//		g.setColor(trackColor);
//		g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
	}
	
	public void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		if(thumbBounds.isEmpty()||!scrollbar.isEnabled()){
			return ;
		}
		
		int w = thumbBounds.width;
		int h = thumbBounds.height;
				
		g.translate(thumbBounds.x, thumbBounds.y);
			
		g.setColor(ColorPallet.GrayLight);
//		g.fillRect(0, 0, w, h);
		g.fillRect(5, 0, w-5, h);
		
		g.translate(-thumbBounds.x, -thumbBounds.y);
	}
}

