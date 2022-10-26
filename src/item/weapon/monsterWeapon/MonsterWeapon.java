package item.weapon.monsterWeapon;

import item.weapon.Weapon;
import displayComponent.displayObject.animal.Animal;
import displayComponent.displayObject.animal.monster.Monster;

public abstract class MonsterWeapon extends Weapon {

	public abstract boolean attackAreaBooleanTest(Animal animal);
}
