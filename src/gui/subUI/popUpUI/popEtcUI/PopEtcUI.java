package gui.subUI.popUpUI.popEtcUI;

import gui.subUI.popUpUI.PopUpUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopEtcUI extends PopUpUI {
	
	public PopEtcUI(String title, int width, int height, String text) {
		
		super(width, height);
		this.getContentPane().remove(effectPanel);
		
		setTitle(title);
		
		// 내용
		JLabel textLabel = new JLabel(text);
		imagePanel.add(textLabel);
		textLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		
		
		// 버튼
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				shutUp();
			}
		});

		   
		setVisible(true);
	}
}
