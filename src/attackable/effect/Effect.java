package attackable.effect;

import java.awt.Image;

import displayComponent.displayObject.DisplayObject;
import attackable.AttackGetSetable;

public abstract class Effect implements AttackGetSetable {

	
	protected int attackAreaCenterX = DisplayObject.EXTRA_ARRAY / 2;
	protected int attackAreaCenterY = DisplayObject.EXTRA_ARRAY / 2;
	
	protected int attackDistance;
	

	protected int attackCount;
	protected int attackPowerPer;
	protected int attackPower;
	
	public abstract Image getIm();
	public abstract int getImageX();
	public abstract int getImageY();
	
	
	
	public Effect(int attackPower, int attackPowerPer, int attackCount) {
		this.attackPower = attackPower;
		this.attackPowerPer = attackPowerPer;
		this.attackCount = attackCount;
	}
	
	public int getAttackPower() {
		return attackPower;
	}

	public int getAttackPowerPer() {
		return attackPowerPer;
	}

	
	// ??????
	public int getAttackDistance() {
		return 0;
	}

	// ??????
	public void setAttackAreaCenterX(int attackAreaCenterX) {
		
	}

	// ??????
	public void setAttackAreaCenterY(int attackAreaCenterY) {
		
	}
	
	
}
