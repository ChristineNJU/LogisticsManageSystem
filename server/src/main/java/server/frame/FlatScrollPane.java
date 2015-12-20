package server.frame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;


public class FlatScrollPane extends JScrollPane {
	
	private LineBorder lb = new LineBorder(new Color(200, 200, 200), 1, false);
	
	public FlatScrollPane() {
		super();
		init();
	}
	public FlatScrollPane(Component view) {
		super(view);
		init();
	}
	public FlatScrollPane(int vsbPolicy, int hsbPolicy) {
		super(vsbPolicy, hsbPolicy);
		init();
	}
	public FlatScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
		super(view, vsbPolicy, hsbPolicy);
		init();
	}	
	
	protected void init() {
		getVerticalScrollBar().setUI(new FlatScrollBarUI());
		getHorizontalScrollBar().setUI(new FlatScrollBarUI());
		setBorder(lb);
		getVerticalScrollBar().setUI(new FlatScrollBarUI());
		getHorizontalScrollBar().setUI(new FlatScrollBarUI());
	}
}
