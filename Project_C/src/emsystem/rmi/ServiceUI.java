package emsystem.rmi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ServiceUI extends JFrame{
	public ServiceUI() {
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
