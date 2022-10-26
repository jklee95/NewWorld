package displayComponent.displayObject.animal.monster;

import item.weapon.monsterWeapon.Crow;
import displayComponent.DisplayComponent;

public class Lizard extends Monster {
	
	public Lizard(int imageX, int imageY) {
		
		this.level = 2;
		this.maxHp = 100;
		this.hp = maxHp;
		this.exp = 50;
		this.hpBar = DEFAULT_HP_BAR;
		
		this.physicalAttackPower = 7;
		this.physicalDefensePower = 3;
		this.accuracyRate = 60;
		this.evasionRate = 0;
		
		this.gold = 50;
		
		this.weapon = new Crow("µµ∏∂πÏ¿« πﬂ≈È", 15, 20);
		
		setDefault(imageX, imageY);
	}
}
