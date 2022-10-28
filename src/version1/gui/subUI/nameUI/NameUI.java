package gui.subUI.nameUI;

import gui.mainUI.roundUI.PlayUI;

import java.awt.*;

import javax.swing.*;

import displayComponent.DisplayComponent;

public class NameUI extends JPanel{
	
	private JPanel namePanel;
	private JPanel levelPanel;
	
	private JLabel nameLabel;
	private JLabel levelLabel;
	
	public NameUI(){

		this.setPreferredSize(new Dimension(190, 35));
		
		this.namePanel = new JPanel();
		this.levelPanel = new JPanel();
		
		this.nameLabel = new JLabel("" + PlayUI.getDisplayComponent().getCharacter().getName());
		this.levelLabel = new JLabel("" + PlayUI.getDisplayComponent().getCharacter().getLv());
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(levelPanel);	//레벨
		levelPanel.setPreferredSize(new Dimension(40, 40));
		levelPanel.setBackground(Color.darkGray);
		levelPanel.add(levelLabel);
		levelLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		levelLabel.setForeground(Color.white);
		
		add(namePanel);	//이름
		namePanel.setPreferredSize(new Dimension(150, 40));
		namePanel.setBackground(Color.darkGray);
		namePanel.add(nameLabel);
		nameLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		nameLabel.setForeground(Color.white);

		setVisible(true);
	}

	public JLabel getLevelLabel() {
		return levelLabel;
	}
	
}
