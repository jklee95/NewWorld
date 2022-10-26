package item.useItem;

import item.Item;

public abstract class Portion extends Item {
	
	protected int amount;
	protected String effect;
	
	public Portion(String name, int amount, int gold) {
		this.name = name;
		this.amount = amount;
		this.gold = gold;
	}
	
	public abstract void recovery();

	public String getEffect() {
		return effect;
	}

	public int getAmount() {
		return amount;
	}
	
	

}
