package presentation.components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.SwingConstants;


public class FlatArrowButton extends JButton implements SwingConstants {
	
	protected int direction;
	
	private Color shadow = Color.gray;
	private Color darkShadow = Color.black;
	private Color highlight = Color.red;
	
	private Color background_common = new Color(240, 240, 240);
	private Color background_rollover = new Color(200, 200, 200);
	private Color background_pressed = new Color(108, 108, 108);
	private Color arrow_common = new Color(52, 73, 94);
	private Color arrow_rollover = new Color(44, 62, 80);
	private Color arrow_pressed = new Color(255, 255, 255);
	private Color arrow_unabled = new Color(200, 200, 200);
	
	public FlatArrowButton(int direction, Color background_common, Color background_rollover,
			Color background_pressed, Color arrow_common, Color arrow_rollover, Color arrow_pressed,
			Color arrow_unabled) {
		super();
		setRequestFocusEnabled(false);
		setDirection(direction);
		setBackground(background_common);
		this.background_common = background_common;
		this.background_rollover = background_rollover;
		this.background_pressed = background_pressed;
		this.arrow_common = arrow_common;
		this.arrow_rollover = arrow_rollover;
		this.arrow_pressed = arrow_pressed;
		this.arrow_unabled = arrow_unabled;
	}
	
	public FlatArrowButton(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public void paint(Graphics g) {
		Color origColor;
		boolean isPressed, isEnabled, isRollover;
		int w, h, size;
		
		w = getSize().width;
		h = getSize().height;
		origColor = g.getColor();
		isPressed = getModel().isPressed();
		isEnabled = isEnabled();
		isRollover = getModel().isRollover();
		
		g.setColor(background_common);
		g.fillRect(0, 0, w, h);
		
		if(h<5||w<5){
			g.setColor(origColor);
			return ;
		}
		
		size = Math.min((h-4)/3, (w-4)/3);
		size = Math.max(size, 2);
				
		if(isEnabled){	
			if(isPressed){
				g.setColor(background_pressed);
				g.fillRect(0, 0, w, h);
				g.setColor(arrow_pressed);
				paintTriangle(g, (w-size)/2, (h-size)/2, size, direction, background_pressed);
			}else if(isRollover){
				g.setColor(background_rollover);
				g.fillRect(0, 0, w, h);
				g.setColor(arrow_rollover);
				paintTriangle(g, (w-size)/2, (h-size)/2, size, direction, background_rollover);
			}else{
				g.setColor(background_common);
				g.fillRect(0, 0, w, h);
				g.setColor(arrow_common);
				paintTriangle(g, (w-size)/2, (h-size)/2, size, direction, background_common);
			}		
		}else{
			g.setColor(background_common);
			g.fillRect(0, 0, w, h);
			g.setColor(arrow_unabled);
			paintTriangle(g, (w-size)/2, (h-size)/2, size, direction, background_common);
		}
		
		g.setColor(origColor);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(16, 16);
	}
	
	public Dimension getMinimumSize() {
		return new Dimension(5, 5);
	}
	
	public Dimension getMaximumSize(){
		return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isFocusTraversable() {
		return false;
	}
	
	public void paintTriangle(Graphics g, int x, int y, int size, int direction, Color tmp) {
		Color oldColor = g.getColor();	
//		System.out.println(g.getColor());
		int mid, i, j;
	
		j = 0;
		size = Math.max(size, 2);
		mid = (size / 2);
	
		g.translate(x, y);

		Color temp;
		
		switch(direction){
		case NORTH:
			for(i = 0; i < size; i++){
				g.drawLine(mid-i, i-2, mid+i, i-2);
				j++;
			}
			
			j = j-2;
			
			i--;
			
			for(int m=0; m<=2; m++){
				g.drawLine(mid-i, j, mid+i, j);
				j++;
			}
			
			temp = g.getColor();
			g.setColor(tmp);
			
			for(i = 0; i < size; i++){
				g.drawLine(mid-i, i+1, mid+i, i+1);
				j++;
			}
			break;
		case SOUTH:
			j = 0;
			i = size-1;
			
			for(int m=0; m<=2; m++){
				g.drawLine(mid-i, j, mid+i, j);
				j++;
			}
			
			for(i = size-1; i >= 0; i--){
				g.drawLine(mid-i, j, mid+i, j);
				j++;
			}
			
			temp = g.getColor();
			g.setColor(tmp);
			
			j = 0;
			
			for(i = size-1; i >= 0; i--){
				g.drawLine(mid-i, j, mid+i, j);
				j++;
			}
			
			g.setColor(temp);
			break;
		case WEST:
			for(i = 0; i < size; i++){
				g.drawLine(i-2, mid-i, i-2, mid+i);
				j++;
			}
			
			j = j-2;
			i--;
			
			for(int m=0; m<=2; m++){
				g.drawLine(j, mid-i, j, mid+i);
				j++;
			}
			
			temp = g.getColor();
			g.setColor(tmp);
			
			for(i = 0; i < size; i++){
				g.drawLine(i+1, mid-i, i+1, mid+i);
				j++;
			}

			break;
		case EAST:
			j = 0;
			i = size-1;
			
			for(int m=0; m<=2; m++){
				g.drawLine(j, mid-i, j, mid+i);
				j++;
			}
			
			for(i = size-1; i >= 0; i--){
				g.drawLine(j, mid-i, j, mid+i);
				j++;
			}
			
			temp = g.getColor();
			g.setColor(tmp);
			
			j = 0;
			
			for(i = size-1; i >= 0; i--){
				g.drawLine(j, mid-i, j, mid+i);
				j++;
			}
			break;
		}
		g.translate(-x, -y);
		g.setColor(oldColor);
	}
}
