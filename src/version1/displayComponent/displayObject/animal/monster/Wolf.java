package displayComponent.displayObject.animal.monster;

import item.weapon.monsterWeapon.Crow;
import displayComponent.DisplayComponent;

public class Wolf extends Monster {
	
	public Wolf(int imageX, int imageY) {
		
		this.level = 1;
		this.maxHp = 100;
		this.hp = maxHp;
		this.exp = 20;
		this.hpBar = DEFAULT_HP_BAR;
		
		this.physicalAttackPower = 3;
		this.physicalDefensePower = 2;
		this.accuracyRate = 80;
		this.evasionRate = 0;
		
		this.gold = 40;
		
		this.weapon = new Crow("¥¡¥Î¿« πﬂ≈È", 10, 10);
		
		setDefault(imageX, imageY);
	}

}
