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
		
		
		
		// ----- 프레임 설정
		
		
		// 라벨 설정
		subLabel.setText(tradeType + "할 개수");
		
		
		
		// ---버튼 설정
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Item tempItem = (Item) item;
				
				// 구매?? 판매??
				if (tradeType.equals("구매")) {
					
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
					
				} else if ((tradeType.equals("판매"))){
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
				
				
				ShopUI.getManualLabel2().setText("소지 골드량 : " + PlayUI.getDisplayComponent().getCharacter().getGold() + "골드 / ");
				ShopUI.getSalePriceLabel().setText("");
				//CharacterItemUI.test();
				
				// 프레임 종료
				
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
