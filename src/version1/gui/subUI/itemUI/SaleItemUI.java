package gui.subUI.itemUI;

import gui.mainUI.storeUI.ShopUI;
import gui.subUI.popUpUI.popSettingUI.popShopUI.PopShopEquipUI;
import gui.subUI.popUpUI.popSettingUI.popShopUI.PopShopEtcUI;
import gui.subUI.popUpUI.popSettingUI.popShopUI.PopShopUseUI;
import item.useItem.Portion;
import item.weapon.characterWeapon.CharacterWeapon;
import item.weapon.monsterWeapon.MonsterWeapon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SaleItemUI extends CharacterItemUI {
	
	public SaleItemUI (int x, int y) {	
		
		super(x, y);
		
		// 장비창 리스너
		equipList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (useListContent.size() > 0) {
					ShopUI.getSalePriceLabel().setText(equipListContent.get(useList.locationToIndex(e.getPoint())).getGold() + "원");
				}
			}
					
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
					if (equipListContent.size() > 0) {
						int index = equipList.locationToIndex(e.getPoint());
						PopShopEquipUI<CharacterWeapon> s = new PopShopEquipUI<CharacterWeapon>("판매", CharacterItemUI.EQUIP_TYPE, equipListContent.get(index), 1);
					}
				}
			}
		});
		
		// 소비창 리스너
		useList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (useListContent.size() > 0) {
					ShopUI.getSalePriceLabel().setText(useListContent.get(useList.locationToIndex(e.getPoint())).getGold() + "원");
				}
			}
			
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
					if (useListContent.size() > 0) {
						int index = useList.locationToIndex(e.getPoint());
						PopShopUseUI<Portion> s = new PopShopUseUI<Portion>("판매", CharacterItemUI.USE_TYPE, useListContent.get(index), useListContentNumber.get(index));
					}
				}
			}
		});
		
		// 기타창 리스너
		etcList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (etcListContent.size() > 0) {
					ShopUI.getSalePriceLabel().setText(etcListContent.get(etcList.locationToIndex(e.getPoint())).getGold() + "원");
				}
			}
			
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
					if (etcListContent.size() > 0) {
						int index = etcList.locationToIndex(e.getPoint());
						PopShopEtcUI<MonsterWeapon> s = new PopShopEtcUI<MonsterWeapon>("판매", CharacterItemUI.ETC_TYPE, etcListContent.get(index), etcListContentNumber.get(index));
					}
				}
			}
		});
    
	}
	
}
