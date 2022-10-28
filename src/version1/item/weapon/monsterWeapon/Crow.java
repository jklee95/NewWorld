package item.weapon.monsterWeapon;

import attackable.AttackArea;
import attackable.skill.monsterSkill.crowSkill.CrowNormal;
import displayComponent.DisplayComponent;
import displayComponent.displayObject.DisplayObject;
import displayComponent.displayObject.animal.Animal;

public class Crow extends MonsterWeapon {
	
	private CrowNormal cn;
	
	public Crow(String name, int physicalAttackPower, int gold){
		this.name = name;
		this.physicalAttackPower = physicalAttackPower;
		this.gold = gold;
		this.weaponSpeed = 0;
		
		this.cn = new CrowNormal(this.physicalAttackPower);

	}
	   
	public void attackAreaPlus(Animal animal) {
		
		cn.attackAreaPlus(animal);
		
	}

	public void attackAreaMinus(Animal animal) {

		cn.attackAreaMinus(animal);
	}
	
	public void attackAreaHitTest(Animal attacker) {

		cn.attackAreaHitTest(attacker);
	}
	
	@Override
	public boolean attackAreaBooleanTest(Animal animal) {
		// TODO Auto-generated method stub
		return cn.attackAreaBooleanTest(animal);
	}
}
