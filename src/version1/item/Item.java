package item;
public abstract class Item implements Nameable {
	
    protected String name;
    protected int gold;
    
	public String getInstanceName() {
		return name;
	}

	public int getGold() {
		return gold;
	}
    
}
