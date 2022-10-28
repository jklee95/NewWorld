package attackable;

import displayComponent.displayObject.animal.Animal;

public interface Attackable {
	
	public static final int ATTACK_VALUE = 20;
	public static final int ATTACK = 50;
	
	public void attackAreaPlus(Animal animal);
	public void attackAreaMinus(Animal animal);
	
	public void attackAreaHitTest(Animal attacker);
	
	

}
