package item.useItem;

import gui.mainUI.roundUI.PlayUI;

public class HpPortion extends Portion {
	
	public HpPortion(String name, int amount, int gold) {
		super(name, amount, gold);
		
		this.effect = "Ã¼·Â";
	}
	
	@Override
	public void recovery() {
		// TODO Auto-generated method stub
		PlayUI.getDisplayComponent().getCharacter().setHp(amount);
	}
}
