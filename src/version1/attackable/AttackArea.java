package attackable;

import gui.mainUI.roundUI.PlayUI;
import gui.subUI.itemUI.CharacterItemUI;
import gui.subUI.itemUI.HaveItemUI;

import java.util.Timer;
import java.util.TimerTask;

import displayComponent.damage.TotalDamageNumber;
import displayComponent.displayObject.DisplayObject;
import displayComponent.displayObject.animal.Animal;


public abstract class AttackArea {

	public static final int MISS = -1;
	
	public static final int PHYSICAL = 0;
	public static final int MAGICAL = 1;
	
	
	public static int[][] attackAreaArray = new int[20 + 2 + DisplayObject.EXTRA_ARRAY][20 + 2 + DisplayObject.EXTRA_ARRAY];
	public static Animal[][] attackAnimalArray = new Animal[20 + 2 + DisplayObject.EXTRA_ARRAY][20 + 2 + DisplayObject.EXTRA_ARRAY];

	
	// 데미지 계산용
	private static int totalDamage[];
	
	
	public static void areaLimit() {
		// 공간제한
		for (int i = DisplayObject.EXTRA_ARRAY / 2; i < attackAreaArray.length - (DisplayObject.EXTRA_ARRAY / 2); i++) {
			attackAreaArray[i][DisplayObject.EXTRA_ARRAY / 2] += Attackable.ATTACK_VALUE;
			attackAreaArray[i][(attackAreaArray[i].length - 1) - DisplayObject.EXTRA_ARRAY / 2] += Attackable.ATTACK_VALUE;
		}
		
		for (int i = 1 + (DisplayObject.EXTRA_ARRAY / 2); i < (attackAreaArray.length - 1) - (DisplayObject.EXTRA_ARRAY / 2); i++) {
			attackAreaArray[DisplayObject.EXTRA_ARRAY / 2][i] += Attackable.ATTACK_VALUE;
			attackAreaArray[(attackAreaArray[i].length - 1) - (DisplayObject.EXTRA_ARRAY / 2)][i] += Attackable.ATTACK_VALUE;
		}
		
	}
	
	public static void test() {

		for (int i = 0; i < attackAreaArray.length; i++) {
			for (int j = 0; j < attackAreaArray[i].length; j++) {
				if (attackAreaArray[j][i] < 10) {
					System.out.print("0" + attackAreaArray[j][i] + " ");
				} else {
					System.out.print(attackAreaArray[j][i] + " ");
				}
				
			}
			System.out.println();
		}
	}
	
	
	
	/*
	 **************  공격 거리 계산   **********
	 */

	public static void attackAreaDistance(Animal animal, AttackGetSetable attackgsable) {
		int attackAreaCenterX = animal.getHitAreaCenterX();
		int attackAreaCenterY = animal.getHitAreaCenterY();
		
		int attackDistance = attackgsable.getAttackDistance();
		
		switch (animal.getPositionNum()) {
			case DisplayObject.DOWN : attackAreaCenterY += attackDistance; break;
			case DisplayObject.LEFT : attackAreaCenterX -= attackDistance; break;
			case DisplayObject.RIGHT : attackAreaCenterX += attackDistance; break;
			case DisplayObject.UP : attackAreaCenterY -= attackDistance; break;
		}
		
		// 설정
		attackgsable.setAttackAreaCenterX(attackAreaCenterX);
		attackgsable.setAttackAreaCenterY(attackAreaCenterY);
		
	}

	
	
	
	/*
	 ***************************************
	 **************  공격 함수들   **************
	 ***************************************
	 */
	
	public static void attack(Animal attacker, Animal attacked, AttackGetSetable attackgsable, int attackType, int count) {
		if (attacked != null) {
			
			// 동물 구별
			String animalName = attacked.getClass().getSimpleName().toLowerCase();
			if (!animalName.equals("character")) animalName = "monster";
			
			// 데미지 계산
			totalDamage = new int[count];
			
			for (int i = 0; i < totalDamage.length; i++) {
				totalDamage[i] = damageCalculation(attacker, attacked, attackgsable, attackType);
			}
			
			if (attacked.getHp() <= 0) {
				attacked.death();
			}
			
			// 데미지 개수
			Timer timer = new Timer();
			DamageTimerTask task = new DamageTimerTask(attacked, timer, animalName, count);
			 
			timer.schedule(task, 0, 130);
			
		}
	}

	// -------- 데미지 계산
	public static int damageCalculation(Animal attacker, Animal attacked, AttackGetSetable attackgsable, int attackType) {
		   
		int totalDamage, attackPower, defensePower;
																								// Magical Attackable 인터페이스 필요??
		if (attackType == PHYSICAL) {
			attackPower = attacker.getPhysicalAttackPower();
			defensePower = attacked.getPhysicalDefensePower();
		} else {
			attackPower = attacker.getMagicalAttackPower();
			defensePower = attacked.getMagicalDefensePower();
		}
		
		totalDamage = (int)( (attackPower + attackgsable.getAttackPower()) * (double)attackgsable.getAttackPowerPer() / 100 ) 
				- defensePower;

		if ((int)(Math.random()*100 + 1) <= attacker.getAccuracyRate() - attacked.getEvasionRate()) {
			
			if (totalDamage > 0) {

				attacked.setHp(-totalDamage);
				attacked.setHpBar();
				
			} else {
				totalDamage = 0;
				
			}
			
		} else {
			totalDamage = MISS; 
		}
		
		return totalDamage;
	}
	
	

	private static class DamageTimerTask extends TimerTask {
		
		private Animal attacked;
		private Timer timer;
		private String animalName;
		private int tempCount;
		private int count;
		
		public DamageTimerTask(Animal attacked, Timer timer, String animalName,int count) {
			this.attacked = attacked;
			this.timer = timer;
			this.animalName = animalName;
			this.count = count;
		}
		
		public void run() {
			
			if (tempCount < count) {
				
				TotalDamageNumber damage = new TotalDamageNumber(totalDamage[tempCount], animalName, attacked.getImageX(), attacked.getImageY());
				damage.makeDamageNumber(tempCount);
				
				tempCount++; 
				
			} else {
				timer.cancel();  
				tempCount = 0;    

				// 사망 테스트
				if (attacked.getHp() <= 0) {
					PlayUI.getDisplayComponent().getMonster().remove(attacked);
					PlayUI.getDisplayComponent().getCharacter().setExp(attacked.getExp());
					PlayUI.getDisplayComponent().getCharacter().setGold(attacked.getGold());
					HaveItemUI.addUseEtcListContent(attacked.getWeapon(), 1, CharacterItemUI.ETC_TYPE); //ItemUI.test();
				}
			}
			
			
		}
	}
}
