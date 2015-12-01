package presentation.components;

import javax.swing.BorderFactory;

import presentation.listener.RollListener;
import presentation.main.ColorPallet;
import presentation.main.FontSet;

public class ButtonConfirm extends ButtonOk {

	private RollListener listener;
	
	public ButtonConfirm(String s) {
		setText(s);
		setForeground(ColorPallet.Pink);
		setHorizontalAlignment(CENTER);
		setBorder(BorderFactory.createLineBorder(ColorPallet.Pink));

		setFont(FontSet.twenty);
		setSize(s.length()*25+30,30);
		
		listener = new RollListener(this);
		this.addMouseListener(listener);
		System.out.println("button height:"+this.getHeight());
	}

}
