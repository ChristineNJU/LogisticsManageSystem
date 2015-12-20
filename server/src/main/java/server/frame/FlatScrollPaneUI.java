package server.frame;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;


public class FlatScrollPaneUI extends BasicScrollPaneUI {
	
	public static ComponentUI createUI(JComponent x) {
		return new FlatScrollPaneUI();
	}
	
	public void paint(Graphics g, JComponent c) {
		Border vpBorder = scrollpane.getViewportBorder();
	}
}
