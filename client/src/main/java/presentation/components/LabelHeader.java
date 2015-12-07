package presentation.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.LineBorder;

import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class LabelHeader extends javax.swing.JLabel {
//
//	HeaderBorder border = new HeaderBorder(ColorPallet.Purple,1,false);
	public LabelHeader(String s){
		super(s);
		this.setForeground(ColorPallet.Purple);
		this.setFont(FontSet.eighteen);
//		this.setBorder(border);
	}
	
	public void addInfo(String s){
		setText(getText()+s);
	}
	
//	private class HeaderBorder extends LineBorder{
//
//		Color color;
//		int thickness;
//		boolean roundedCorners;
//		public HeaderBorder(Color color, int thickness, boolean roundedCorners) {
//			super(color, thickness, roundedCorners);
//			this.color = color;
//			this.thickness = thickness;
//			this.roundedCorners = roundedCorners;
//		}
//		
//		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
//	        if ((this.thickness > 0) && (g instanceof Graphics2D)) {
//	            Graphics2D g2d = (Graphics2D) g;
//
//	            Color oldColor = g2d.getColor();
//	            g2d.setColor(this.lineColor);
//
//	            Shape outer;
//	            Shape inner;
//
//	            int offs = this.thickness;
//	            int size = offs + offs;
//	            if (this.roundedCorners) {
//	                int arc = offs + size;
//	                outer = new RoundRectangle2D.Float(x, y, width, height, arc, arc);
//	                inner = new RoundRectangle2D.Float(x + offs, y + offs, width - size, height - size, arc, arc);
//	            }
//	            else {
//	                outer = new Rectangle2D.Float(x, y, width, height);
//	                inner = new Rectangle2D.Float(x + offs, y + offs, width - size, height - size);
//	            }
//	            Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
//	            path.append(outer, false);
//	            path.append(inner, false);
//	            g2d.fill(path);
//	            g2d.setColor(oldColor);
//	        }
//	    }
//	}
	
	
}
