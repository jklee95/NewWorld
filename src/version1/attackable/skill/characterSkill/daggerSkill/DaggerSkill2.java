package attackable.skill.characterSkill.daggerSkill;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import attackable.effect.daggerEffect.Slash;
import attackable.skill.Skillable;
import attackable.skill.activeSkill.specialSkill.PhysicalActiveSkill;
import displayComponent.background.Dark;
import displayComponent.displayObject.animal.Animal;
import displayComponent.displayObject.animal.monster.Monster;
import gui.mainUI.roundUI.PlayUI;
import item.weapon.characterWeapon.dagger.Dagger;

public class DaggerSkill2 extends PhysicalActiveSkill implements SkillManager {
	
	private int count;
	private final int MAX = 10;
	
	// �ִ� ������ ������
	private int attackedEnemyNum;
	private int attackedEnemyValue;
	private int attackedEnemyTerm;
	
	
	private Slash slash;
	private Dark dark;
	
	public DaggerSkill2(int skillLevel) {
		
		this.skillName = "�ϻ�";
		this.skillLevelMax = MAX;
		this.skillContents = "���������� ���� ���� ���� �����Ѵ�.";
		
		this.slash = new Slash(attackPower, attackPowerPer, attackCount, 0);
		this.dark = new Dark(0, 0);
		

		setSkillLevelCurrent(skillLevel); 
		
	}
	
	// �⺻ �ɷ�ġ ����
	protected void resetAbility() {

		// �⺻��
		this.attackPowerPer = 10;
		this.decreaseMp = 0;
		this.attackCount = 1;

		this.attackedEnemyNum = 4; // ������ slash monsterNum ���� ���� �ʿ�
		this.attackedEnemyContent = "�ִ� " + attackedEnemyNum + "��";

		// ������
		this.attackPowerValue = 90;
		this.attackCountValue = 1;
		this.decreaseMpValue = 7;
		this.attackedEnemyValue = 1;

		// ������
		this.attackPowerTerm = 1;
		this.attackCountTerm = MAX + 1;
		this.decreaseMpTerm = 3;
		this.attackedEnemyTerm = 4;
	}
	
	public void setSkillLevelCurrent(int skillLevelCurrent) {
		super.setSkillLevelCurrent(skillLevelCurrent);
		
		for (int i = 1; i <= this.skillLevelCurrent; i++) {
			if (i % attackedEnemyTerm == 0) {
				attackedEnemyContent = "�ִ� " + (attackedEnemyNum += attackedEnemyValue) + "��";
			}
		}
		
		setSkillAbilityContents();
	}

	public void attackAreaPlus(Animal animal) {
		
		slash.attackAreaPlus(animal);
		
	}

	public void attackAreaMinus(Animal animal) {
		
		slash.attackAreaMinus(animal);
		
	}

	public void attackAreaHitTest(Animal attacker) {
		int motionNum = attacker.getMotionNum();

		Vector<Monster> monsterVector = PlayUI.getDisplayComponent().getMonster();
		int size = monsterVector.size();


		if (motionNum == 1) {

			for (int i = 0; i < size; i++) {
				Timer timer = monsterVector.get(i).getTimer();
				timer.cancel();
			}
			
			PlayUI.getDisplayComponent().getBackGround().add(dark);
			dark.makeDark();
			
		} else if (motionNum == 10) {

			makeSlash(attacker, attackedEnemyNum);

			try {
				
				Timer characterTimer = PlayUI.getDisplayComponent().getCharacter().getAttackTimer();

				synchronized (characterTimer) {
					characterTimer.wait();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} else if (motionNum == 17) {
			
			size = monsterVector.size();

			for (int i = 0; i < size; i++) {
				Monster monster = monsterVector.get(i);
				monster.makeThread();
			}
		}
	}

	
	public void makeSlash(Animal attacker, int slashCount) {
		Timer characterTimer = PlayUI.getDisplayComponent().getCharacter().getAttackTimer();
		
		
		Timer timer = new Timer();
    	TimerTask task = new TimerTask() {
    		
    		private int size = PlayUI.getDisplayComponent().getMonster().size();
			
			public void run() {
										// ���� �ߺ� ���� ����
				if (count < slashCount && count < size) {
					addSlash(attacker);
					count++;
				} else {
					Slash.tempMonsterArray = new Monster[6]; // ��ȣ�� �ް� ����ȭ �ʿ� ������
					timer.cancel();

					dark.setDarkFlag(true);
					
					synchronized (characterTimer) {
						characterTimer.notify();
					}
					
					
				}
				
			}
    	};
    	
    	count = 0;
    	timer.schedule(task, 0, 240);
    	
	}
	
	
	public void addSlash(Animal attacker) {
		
		DaggerSkill3 dk3 = (DaggerSkill3)Dagger.getSkillArray()[2];
		
		int slashNum = 0;
		if ( (int)(Math.random()*100 + 1) <= dk3.getVitalSkillPer() 
				&& dk3.getSkillLevelCurrent() != 0 ) slashNum = 1;
		
		
		this.slash = new Slash(attackPower, attackPowerPer + (slashNum * dk3.getAttackPowerPer()), attackCount, slashNum);
		PlayUI.getDisplayComponent().getEffect().add(slash);
		slash.attackAreaHitTest(attacker);
	}
	
	
	
	
	public Skillable makeSkill(int skillLevel) {
		return new DaggerSkill2(skillLevel);
	}

}
