package gui.subUI.popUpUI.popSettingUI.popShopUI;

import gui.mainUI.roundUI.PlayUI;
import gui.mainUI.storeUI.ShopUI;
import gui.mainUI.storeUI.StoreUI;
import gui.subUI.itemUI.CharacterItemUI;
import gui.subUI.itemUI.ItemUI;
import gui.subUI.popUpUI.popSettingUI.PopSettingUI;
import item.Item;
import item.Nameable;
import item.weapon.characterWeapon.CharacterWeapon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class PopShopUI<I> extends PopSettingUI {
	
	
	
	public PopShopUI(int width, int height, I item, int maxNum,
			String tradeType, int listType) {
		
		super(width, height, (Item)item, maxNum);
		
		
		
		// ----- ������ ����
		
		
		// �� ����
		subLabel.setText(tradeType + "�� ����");
		
		
		
		// ---��ư ����
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Item tempItem = (Item) item;
				
				// ����?? �Ǹ�??
				if (tradeType.equals("����")) {
					
					switch (listType) {
					case CharacterItemUI.USE_TYPE :
					case CharacterItemUI.ETC_TYPE :
						
						CharacterItemUI.<I>addUseEtcListContent(item, (Integer)spinner.getValue(), listType);
						PlayUI.getDisplayComponent().getCharacter().setGold(-tempItem.getGold() * (Integer)spinner.getValue());
						
						break; 
					case CharacterItemUI.EQUIP_TYPE :  
						
						CharacterItemUI.addEquipListContent((CharacterWeapon)item);
						PlayUI.getDisplayComponent().getCharacter().setGold(-tempItem.getGold());
						
						break;
					}
					
				} else if ((tradeType.equals("�Ǹ�"))){
					switch (listType) {
					case CharacterItemUI.USE_TYPE :
					case CharacterItemUI.ETC_TYPE :
						
						CharacterItemUI.<I>removeUseEtcListContent(item, (Integer)spinner.getValue(), listType);
						PlayUI.getDisplayComponent().getCharacter().setGold(tempItem.getGold() * (Integer)spinner.getValue());
						
						break; 
					case CharacterItemUI.EQUIP_TYPE :  
						
						CharacterItemUI.removeEquipListContent((CharacterWeapon)item);
						PlayUI.getDisplayComponent().getCharacter().setGold(tempItem.getGold());
						
						break;
					}
					
				}
				
				
				ShopUI.getManualLabel2().setText("���� ��差 : " + PlayUI.getDisplayComponent().getCharacter().getGold() + "��� / ");
				ShopUI.getSalePriceLabel().setText("");
				//CharacterItemUI.test();
				
				// ������ ����
				
				shutUp();
				/*
				Container com = ((javax.swing.JButton) e.getSource()).getParent();
				while (!com.getClass().getSimpleName().equals("PopShopUI")) {
					com = com.getParent();
				}
				((PopShopUI)com).dispose();
				*/
			}
			
		});
		
		
		setVisible(true);
	}
	
	public void shutUp() {
		StoreUI.getPopSettingUiVector().remove(this);
		this.dispose();
	}


}
