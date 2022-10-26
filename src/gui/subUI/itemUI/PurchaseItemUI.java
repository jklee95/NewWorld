package gui.subUI.itemUI;

import gui.mainUI.storeUI.ShopUI;
import gui.subUI.popUpUI.popSettingUI.popShopUI.PopShopEquipUI;
import gui.subUI.popUpUI.popSettingUI.popShopUI.PopShopUseUI;
import item.useItem.HpPortion;
import item.useItem.Portion;
import item.weapon.characterWeapon.CharacterWeapon;
import item.weapon.characterWeapon.dagger.Dagger;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultListModel;

public class PurchaseItemUI extends ItemUI {
	
	
	private Vector<CharacterWeapon> equipListContent = new Vector<CharacterWeapon>();
	private static Vector<Portion> useListContent  = new Vector<Portion>();
	
	private DefaultListModel<String> equipListContentName = new DefaultListModel<String>();
	private DefaultListModel<String> useListContentName = new DefaultListModel<String>();

	
	public PurchaseItemUI(int x, int y) {
		super(x, y);
		
		useItemList();
		
		equipList.setModel(equipListContentName);
		useList.setModel(useListContentName);
		
		// 장비창 리스너
		equipList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (useListContent.size() > 0) {
					ShopUI.getPurchasePriceLabel().setText(equipListContent.get(equipList.locationToIndex(e.getPoint())).getGold() + "원");
				}
			}
			
			
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
					if (useListContent.size() > 0) {
						int index = equipList.locationToIndex(e.getPoint());
						PopShopEquipUI<CharacterWeapon> s = new PopShopEquipUI<CharacterWeapon>("구매", CharacterItemUI.EQUIP_TYPE, equipListContent.get(index), 1);
					}
				}
			}
			
		});
		
		// 소비창 리스너
		useList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (useListContent.size() > 0) {
					ShopUI.getPurchasePriceLabel().setText(useListContent.get(useList.locationToIndex(e.getPoint())).getGold() + "원");
				}
			}
			
			
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
					if (useListContent.size() > 0) {
						int index = useList.locationToIndex(e.getPoint());
						PopShopUseUI<Portion> s = new PopShopUseUI<Portion>("구매", CharacterItemUI.USE_TYPE, useListContent.get(index), 99);
					}
				}
			}
			
		});
	}
	
	public void useItemList() {
		addUseList(new HpPortion("빨간물약", 20, 30));
		addUseList(new HpPortion("새빨간물약", 60, 50));
		
		addEquipList(new Dagger("초보단검", 5, 10, 1));
		
	}
	
	public void addUseList(Portion portion) {
		useListContent.add(portion);
		useListContentName.addElement(portion.getInstanceName());
	}
	
	public void addEquipList(CharacterWeapon weapon) {
		equipListContent.add(weapon);
		equipListContentName.addElement(weapon.getInstanceName());
	}

}
