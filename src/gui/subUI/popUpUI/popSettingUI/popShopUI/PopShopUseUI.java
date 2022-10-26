package gui.subUI.popUpUI.popSettingUI.popShopUI;

import item.Item;
import item.useItem.Portion;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class PopShopUseUI<I> extends PopShopUI<I> {
	
	public PopShopUseUI(String tradeType, int listType, I item, int itemMaxNum) {
		super(230, 185, item, itemMaxNum, tradeType, listType);
		this.getContentPane().remove(imagePanel);
		
		JLabel descriptionLabel = new JLabel(((Portion)item).getEffect() + "  " + "+" + ((Portion)item).getAmount());
		
		effectPanel.add(descriptionLabel);
		
	}
	
}
