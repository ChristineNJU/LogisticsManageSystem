package server.frame;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerFrame {
	private static JFrame frame = new JFrame("server");
	private static JTextArea textArea  =new JTextArea();
	private static FlatScrollPane scrollPane = new FlatScrollPane(textArea);
	
	public ServerFrame() {
		frame.setBounds(20, 20, 300, 500);
		frame.getContentPane().add(scrollPane);
		frame.setLayout(null);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textArea.setBounds(0, 0, 285, 465);
		scrollPane.setBounds(0, 0, 285, 465);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		frame.add(scrollPane);
		
		frame.setVisible(true);
		
		textArea.append("Server start\n");
	}
	
	public static void addInfo(String info) {
		textArea.append(info+"\n");
		textArea.setCaretPosition(textArea.getText().length());
	}
}
