package gui.subUI.equipUI;


import gui.mainUI.roundUI.PlayUI;
import gui.mainUI.storeUI.StatSettingUI;
import gui.subUI.itemUI.CharacterItemUI;
import item.weapon.characterWeapon.CharacterWeapon;
import item.weapon.characterWeapon.etc.Blank;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class EquipUI extends JPanel {
	
	private static ImageIcon[] weaponIcon = new ImageIcon[5];
	private static JButton weaponButton;
	
	private Blank blank;
	
	public EquipUI(){
		
		for (int i = 1; i < 5; i++) {
			weaponIcon[i] = new ImageIcon(getClass().getClassLoader().getResource("image/UI/Equip/weapon/weapon" + i + ".png"));
		}
		
		this.blank = new Blank();
		
		setPreferredSize(new Dimension(190, 280));
		setBackground(Color.lightGray);
		
		JButton button1 = new JButton("1");	//갑옷
		button1.setBounds(73, 97, 45, 45);
		weaponButton = new JButton();	//무기
		weaponButton.setBounds(20,  150, 45, 45);
		JButton button3 = new JButton("3");	//악세서리
		button3.setBounds(125, 160, 45, 45);
		JButton button4 = new JButton("4");	//화살
		button4.setBounds(113, 40, 45, 45);
		
		// 장비 무기창 초기화
		equipWeapon(PlayUI.getDisplayComponent().getCharacter().getWeapon());
		
		weaponButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					CharacterItemUI.addEquipListContent(PlayUI.getDisplayComponent().getCharacter().getWeapon());
					equipWeapon(blank);
					
					// 능력 재설정      
					StatSettingUI.statLabelSetting();
				}
			}
		});
		
		setLayout(null);
		
		add(button1);
		add(weaponButton);                   
		add(button3);
		add(button4);
		
		
		// 배경
		Image im = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(
						"image/UI/Equip/back/position11.png"));
		
		JComponent bg = new JComponent() {
			public void paint(Graphics g) {
				g.drawImage(im, 15, 10, this);
			}
		};
		
		add(bg);
		bg.setBounds(25,15,500,300);
		
		
		setVisible(true);
	}
	
	public static void equipWeapon(CharacterWeapon weapon) {
		weaponButton.setIcon(weaponIcon[weapon.getWeaponType()]);
		PlayUI.getDisplayComponent().getCharacter().weaponChange(weapon);
	}
	
	/*
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
				
			if(e.getSource() == button1){
				ItemUI.Alist.addElement(Equiplist.getElementAt(0));
				Equiplist.removeElementAt(0);
			}
				
			if(e.getSource() == button2){
				
				ItemUI.Alist.addElement(Equiplist.getElementAt(1));
				Equiplist.removeElementAt(1);
			}
			
			if(e.getSource() == button3){
				
				ItemUI.Alist.addElement(Equiplist.getElementAt(2));
				Equiplist.removeElementAt(2);
			}
			
			if(e.getSource() == button4){
				System.out.println("button4");
			}
		}
	}
	*/
}
