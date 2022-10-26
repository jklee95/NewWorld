package displayComponent.displayObject;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;


public abstract class DisplayObject {
	
	public static final int EXTRA_ARRAY = 20;
	
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int UP = 3;
	public static final int DOWN = 0;
	
	protected static final int BLOCK = 5;
	protected static final int BG_BLOCK = 2;
	protected static int[][] hitAreaArray = new int[20 + BG_BLOCK + EXTRA_ARRAY][20 + BG_BLOCK + EXTRA_ARRAY];
	protected int hitAreaCenterX = EXTRA_ARRAY / 2;
	protected int hitAreaCenterY = EXTRA_ARRAY / 2;
	
	
	
	public void areaLimit() {
		// 공간제한
		for (int i = EXTRA_ARRAY / 2; i < hitAreaArray.length - (EXTRA_ARRAY / 2); i++) {
			hitAreaArray[i][EXTRA_ARRAY / 2] += 4;
			hitAreaArray[i][(hitAreaArray[i].length - 1) - EXTRA_ARRAY / 2] += 4;
		}
		
		for (int i = 1 + (EXTRA_ARRAY / 2); i < (hitAreaArray.length - 1) - (EXTRA_ARRAY / 2); i++) {
			hitAreaArray[EXTRA_ARRAY / 2][i] += 4;
			hitAreaArray[(hitAreaArray[i].length - 1) - (EXTRA_ARRAY / 2)][i] += 4;
		}
		
	}
	
	public void hitAreaPlus() {
		hitAreaArray[hitAreaCenterX][hitAreaCenterY] += 4; // 가운데
		hitAreaArray[hitAreaCenterX + 1][hitAreaCenterY]++; // 오른쪽
		hitAreaArray[hitAreaCenterX - 1][hitAreaCenterY]++; // 왼쪽
		hitAreaArray[hitAreaCenterX][hitAreaCenterY + 1]++; // 아래
		hitAreaArray[hitAreaCenterX][hitAreaCenterY - 1]++; // 위
	}
	
	public void hitAreaMinus() {
		hitAreaArray[hitAreaCenterX][hitAreaCenterY] -= 4; // 가운데
		hitAreaArray[hitAreaCenterX + 1][hitAreaCenterY]--; // 오른쪽
		hitAreaArray[hitAreaCenterX - 1][hitAreaCenterY]--; // 왼쪽
		hitAreaArray[hitAreaCenterX][hitAreaCenterY + 1]--; // 아래
		hitAreaArray[hitAreaCenterX][hitAreaCenterY - 1]--; // 위
	}
	
	public static void test() {
		System.out.println("================================================================================");
		for (int i = 0; i < hitAreaArray.length; i++) {
			for (int j = 0; j < hitAreaArray[i].length; j++) {
				if (hitAreaArray[j][i] < 10) {
					System.out.print("0" + hitAreaArray[j][i] + " ");
				} else {
					System.out.print(hitAreaArray[j][i] + " ");
				}
				
			}
			System.out.println();
		}
	}
	

	public int getHitAreaCenterX() {
		return hitAreaCenterX;
	}
	
	public int getHitAreaCenterY() {
		return hitAreaCenterY;
	}
	
	/*
	public void attackAreaPlus(int range, int attackDistance) {
		
		attackAreaDistance(attackDistance);
		
		attackAreaArray[attackAreaCenterX][attackAreaCenterY] += 4;
		for (int i = 1; i <= range; i++) {
			attackAreaArray[attackAreaCenterX + i][attackAreaCenterY]++; // 오른쪽
			attackAreaArray[attackAreaCenterX - i][attackAreaCenterY]++; // 왼쪽
			attackAreaArray[attackAreaCenterX][attackAreaCenterY + i]++; // 아래
			attackAreaArray[attackAreaCenterX][attackAreaCenterY - i]++; // 위
		}
	}
	
	public void attackAreaMinus(int range, int attackDistance) {
		
		attackAreaDistance(attackDistance);
		
		attackAreaArray[attackAreaCenterX][attackAreaCenterY] -= 4;
		for (int i = 1; i <= range; i++) {
			attackAreaArray[attackAreaCenterX + i][attackAreaCenterY]--; // 오른쪽
			attackAreaArray[attackAreaCenterX - i][attackAreaCenterY]--; // 왼쪽
			attackAreaArray[attackAreaCenterX][attackAreaCenterY + i]--; // 아래
			attackAreaArray[attackAreaCenterX][attackAreaCenterY - i]--; // 위
		}
	}
	
	public void attackAreaDistance(int attackDistance) {
		attackAreaCenterX = hitAreaCenterX;
		attackAreaCenterY = hitAreaCenterY;
		
		switch (arrayNum % 4) {
		case DOWN : attackAreaCenterY += attackDistance; break;
		case LEFT : attackAreaCenterX -= attackDistance; break;
		case RIGHT : attackAreaCenterX += attackDistance; break;
		case UP : attackAreaCenterY -= attackDistance; break;
		}
		
	}
	*/

}
