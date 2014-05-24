package emsystem.rmi;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ServerUI extends JFrame{
	public ServerUI() {
		this.setVisible(true);
		this.setSize(300, 400);
		JButton button = new JButton("\u7ED3\u675F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(button, BorderLayout.CENTER);
		
		JLabel label = new JLabel("                                             \u542F\u52A8\u4E86 ");
		getContentPane().add(label, BorderLayout.NORTH);
	}

}
