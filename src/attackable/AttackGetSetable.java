package attackable;

public interface AttackGetSetable extends Attackable {

	// getter setter �Լ���
	public int getAttackDistance();
	public int getAttackPower();
	public int getAttackPowerPer();
	
	public void setAttackAreaCenterX(int attackAreaCenterX);
	public void setAttackAreaCenterY(int attackAreaCenterY);
	
}
