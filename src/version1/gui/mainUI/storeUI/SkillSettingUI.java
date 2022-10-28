package gui.mainUI.storeUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.mainUI.roundUI.PlayUI;
import gui.subUI.popUpUI.popSettingUI.popSkillUI.PopSkillUI;
import item.Nameable;
import item.weapon.characterWeapon.dagger.Dagger;

public class SkillSettingUI extends JPanel {
	
	private JLabel subLabel2;
	
	public SkillSettingUI() {
		
		setPreferredSize(new Dimension(640,640));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.GRAY);
		
		ImageIcon im = new ImageIcon(getClass().getClassLoader().getResource("image/UI/skill/dagger/skill" + 1 + ".jpg"));
		JButton button = new JButton(im);
		ImageIcon im2 = new ImageIcon(getClass().getClassLoader().getResource("image/UI/skill/dagger/skill" + 2 + ".jpg"));
		JButton button2 = new JButton(im2);
		ImageIcon im3 = new ImageIcon(getClass().getClassLoader().getResource("image/UI/skill/dagger/skill" + 3 + ".jpg"));
		JButton button3 = new JButton(im3);
		
												
		subLabel2 = new JLabel("현재 사용 가능한 기술치 : " +  PlayUI.getDisplayComponent().getCharacter().getSkillPoint() + "   ");
		add(subLabel2);
		subLabel2.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		
		add(button);
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
					makeSkillSettingUI(0);
				}
			}
		});
		
		add(button2);
		button2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
					makeSkillSettingUI(1);
				}
			}
		});
		
		add(button3);
		button3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
					makeSkillSettingUI(2);
				}
			}
		});
	}  
	
	public void makeSkillSettingUI(int skillNum) {
			
		PopSkillUI p = new PopSkillUI(520, 400, ((Nameable)Dagger.getSkillArray()[skillNum]), skillNum + 1, this);
	}

	public JLabel getSubLabel2() {
		return subLabel2;
	}

}
