package gui.subUI.itemUI;

import gui.mainUI.roundUI.PlayUI;
import gui.mainUI.storeUI.ShopUI;
import gui.mainUI.storeUI.StatSettingUI;
import gui.subUI.equipUI.EquipUI;
import gui.subUI.popUpUI.popSettingUI.popShopUI.PopShopUseUI;
import item.useItem.Portion;
import item.weapon.characterWeapon.CharacterWeapon;
import item.weapon.characterWeapon.dagger.Dagger;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import displayComponent.DisplayComponent;

public class HaveItemUI extends CharacterItemUI {
	
	public HaveItemUI (int x, int y) {
		
		super(x, y);
		setBackground(Color.gray);
		
		
		// 장비창
		equipList.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
					if (equipListContent.size() > 0) {
						
						int index = equipList.locationToIndex(e.getPoint());
						CharacterWeapon weapon = equipListContent.get(index);
						
						if (PlayUI.getDisplayComponent().getCharacter().getWeapon().getWeaponType() != 0) {
							CharacterItemUI.addEquipListContent(PlayUI.getDisplayComponent().getCharacter().getWeapon());
						}
						
						EquipUI.equipWeapon(weapon);
						CharacterItemUI.removeEquipListContent(weapon);
						
						// 능력 재설정
						StatSettingUI.statLabelSetting();
						
					}	
				}
			}
		});
		
		
		
		// 소비창
		useList.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
					if (useListContent.size() > 0) {
						int index = useList.locationToIndex(e.getPoint());
						useListContent.get(index).recovery();
						CharacterItemUI.removeUseEtcListContent(useListContent.get(index), 1, CharacterItemUI.USE_TYPE);
					}   
				}
			}
			
		});
		
	}
	
}
