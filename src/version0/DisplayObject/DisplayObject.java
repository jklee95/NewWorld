package DisplayObject;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;


public abstract class DisplayObject {
	
	public static final int extraArray = 20;
	
	protected static final int BLOCK = 5;
	protected static final int BG_BLOCK = 2;
	protected static int[][] hitAreaArray = new int[20 + BG_BLOCK + extraArray][20 + BG_BLOCK + extraArray];
	protected int hitAreaCenterX = extraArray / 2;
	protected int hitAreaCenterY = extraArray / 2;
	
	protected static final int LEFT = 1;
	protected static final int RIGHT = 2;
	protected static final int UP = 3;
	protected static final int DOWN = 0;
	
	
	public void areaLimit() {
		// ��������
		for (int i = extraArray / 2; i < hitAreaArray.length - (extraArray / 2); i++) {
			hitAreaArray[i][extraArray / 2] += 4;
			hitAreaArray[i][(hitAreaArray[i].length - 1) - extraArray / 2] += 4;
		}
		
		for (int i = 1 + (extraArray / 2); i < (hitAreaArray.length - 1) - (extraArray / 2); i++) {
			hitAreaArray[extraArray / 2][i] += 4;
			hitAreaArray[(hitAreaArray[i].length - 1) - (extraArray / 2)][i] += 4;
		}
		
	}
	
	public void hitAreaPlus() {
		hitAreaArray[hitAreaCenterX][hitAreaCenterY] += 4; // ���
		hitAreaArray[hitAreaCenterX + 1][hitAreaCenterY]++; // ������
		hitAreaArray[hitAreaCenterX - 1][hitAreaCenterY]++; // ����
		hitAreaArray[hitAreaCenterX][hitAreaCenterY + 1]++; // �Ʒ�
		hitAreaArray[hitAreaCenterX][hitAreaCenterY - 1]++; // ��
	}
	
	public void hitAreaMinus() {
		hitAreaArray[hitAreaCenterX][hitAreaCenterY] -= 4; // ���
		hitAreaArray[hitAreaCenterX + 1][hitAreaCenterY]--; // ������
		hitAreaArray[hitAreaCenterX - 1][hitAreaCenterY]--; // ����
		hitAreaArray[hitAreaCenterX][hitAreaCenterY + 1]--; // �Ʒ�
		hitAreaArray[hitAreaCenterX][hitAreaCenterY - 1]--; // ��
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
	/*
	public void attackAreaPlus(int range, int attackDistance) {
		
		attackAreaDistance(attackDistance);
		
		attackAreaArray[attackAreaCenterX][attackAreaCenterY] += 4;
		for (int i = 1; i <= range; i++) {
			attackAreaArray[attackAreaCenterX + i][attackAreaCenterY]++; // ������
			attackAreaArray[attackAreaCenterX - i][attackAreaCenterY]++; // ����
			attackAreaArray[attackAreaCenterX][attackAreaCenterY + i]++; // �Ʒ�
			attackAreaArray[attackAreaCenterX][attackAreaCenterY - i]++; // ��
		}
	}
	
	public void attackAreaMinus(int range, int attackDistance) {
		
		attackAreaDistance(attackDistance);
		
		attackAreaArray[attackAreaCenterX][attackAreaCenterY] -= 4;
		for (int i = 1; i <= range; i++) {
			attackAreaArray[attackAreaCenterX + i][attackAreaCenterY]--; // ������
			attackAreaArray[attackAreaCenterX - i][attackAreaCenterY]--; // ����
			attackAreaArray[attackAreaCenterX][attackAreaCenterY + i]--; // �Ʒ�
			attackAreaArray[attackAreaCenterX][attackAreaCenterY - i]--; // ��
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
