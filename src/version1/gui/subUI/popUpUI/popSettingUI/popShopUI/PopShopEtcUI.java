package gui.subUI.popUpUI.popSettingUI.popShopUI;

public class PopShopEtcUI<I> extends PopShopUI<I> {
	
	public PopShopEtcUI(String tradeType, int listType, I item, int itemMaxNum) {
		super(230, 170, item, itemMaxNum, tradeType, listType);
		
		this.getContentPane().remove(effectPanel);
		this.getContentPane().remove(imagePanel);
	}
}
