package presentation.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import presentation.main.ColorPallet;

public class TextFieldHeader extends JTextField{



	HeaderBorder border = new HeaderBorder(ColorPallet.Purple,1,false);
	public TextFieldHeader(){
//		setBorder(BorderFactory.createEmptyBorder());

		setBorder(border);
		setOpaque(false);
		setForeground(ColorPallet.Purple);
	}
	
	private class HeaderBorder extends LineBorder{

		Color color;
		int thickness;
		boolean roundedCorners;
		TextFieldHeader textfield;
		
		public HeaderBorder(Color color, int thickness, boolean roundedCorners) {
			super(color, thickness, roundedCorners);
			this.color = color;
			this.thickness = thickness;
			this.roundedCorners = roundedCorners;
		}
		
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        if ((this.thickness > 0) && (g instanceof Graphics2D)) {
	        	g.setColor(ColorPallet.Purple);
	        	g.drawLine(0, height-thickness, 200, height);

	        }
	    }
		
	}
}
