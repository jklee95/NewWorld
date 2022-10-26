package item.weapon.characterWeapon.hammer;

import displayComponent.DisplayComponent;
import displayComponent.displayObject.animal.Animal;

public interface HammerSkillManager {
	
	public void attackAreaPlus(Animal animal, int positionNum, int hitAreaCenterX, int hitAreaCenterY);
	public void attackAreaMinus(int positionNum, int hitAreaCenterX, int hitAreaCenterY);
	public void attackAreaHitTest(DisplayComponent dc, int physicalAttackPower);
	
	public int getDecreaseMp();

}
