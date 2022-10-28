package attackable;

public interface AttackGetSetable extends Attackable {

	// getter setter ÇÔ¼öµé
	public int getAttackDistance();
	public int getAttackPower();
	public int getAttackPowerPer();
	
	public void setAttackAreaCenterX(int attackAreaCenterX);
	public void setAttackAreaCenterY(int attackAreaCenterY);
	
}
