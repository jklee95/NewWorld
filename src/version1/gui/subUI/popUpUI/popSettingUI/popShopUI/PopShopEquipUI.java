package gui.subUI.popUpUI.popSettingUI.popShopUI;

import gui.mainUI.roundUI.PlayUI;
import item.weapon.characterWeapon.CharacterWeapon;

import java.awt.Font;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PopShopEquipUI<I> extends PopShopUI<I> {
	
	public PopShopEquipUI(String tradeType, int listType, I item, int itemMaxNum) {
		super(230, 220, item, itemMaxNum, tradeType, listType);
		super.getContentPane().remove(changePanel);
		
		
		String s = "image/UI/Equip/weapon/weapon" + ((CharacterWeapon)item).getWeaponType() + ".png";
		URL url = getClass().getClassLoader().getResource(s);
		ImageIcon im = new ImageIcon(url);
		
		button.setText(" " + tradeType + " ");
		
		JButton button = new JButton(im);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		
		imagePanel.add(button);
		
		
		
		JLabel descriptionLabel = new JLabel("물리공격력" + "  " + "+" + ((CharacterWeapon)item).getPhysicalAttackPower());
		JLabel descriptionLabel2 = new JLabel("마법공격력" + "  " + "+" + ((CharacterWeapon)item).getMagicalAttackPower());
		JLabel descriptionLabel3 = new JLabel(" ");
		descriptionLabel3.setFont(new Font("Malgun Gothic", Font.BOLD, 5));
		effectPanel.setLayout(new BoxLayout(effectPanel, BoxLayout.Y_AXIS));
		effectPanel.add(descriptionLabel);
		effectPanel.add(descriptionLabel2);
		effectPanel.add(descriptionLabel3);
		
	}
	
}