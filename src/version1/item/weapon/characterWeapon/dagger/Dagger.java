package item.weapon.characterWeapon.dagger;

import attackable.skill.Skillable;
import attackable.skill.activeSkill.specialSkill.SpecialActiveSkill;
import attackable.skill.characterSkill.daggerSkill.DaggerNormal;
import attackable.skill.characterSkill.daggerSkill.DaggerSkill1;
import attackable.skill.characterSkill.daggerSkill.DaggerSkill2;
import attackable.skill.characterSkill.daggerSkill.DaggerSkill3;
import attackable.skill.characterSkill.daggerSkill.SkillManager;
import displayComponent.displayObject.animal.Animal;
import gui.mainUI.roundUI.PlayUI;
import item.weapon.characterWeapon.CharacterWeapon;

public class Dagger extends CharacterWeapon {

	private SkillManager dsm;
	private DaggerNormal dn;
	
	private static DaggerSkill1 dk1 = new DaggerSkill1(0);
	private static DaggerSkill2 dk2 = new DaggerSkill2(0);
	private static DaggerSkill3 dk3 = new DaggerSkill3(0);
	
	private static Skillable[] skillArray = new Skillable[]{dk1, dk2, dk3};
	
	public Dagger(String name, int physicalAttackPower, int magicalAttackPower, int requiredLevel) {
		this.name = name;
		this.requiredLevel = requiredLevel;
		this.weaponSpeed = 0;
		this.physicalAttackPower = physicalAttackPower;
		this.magicalAttackPower = magicalAttackPower;

		this.dn = new DaggerNormal(this.physicalAttackPower);
		this.dsm = dn;
		 
		// 스킬 공격력 재설정
		// 공격력을 생성자로 받은 후 스킬에 넣어줘야하는데 
		// 스킬 객체 생성이 위에 보듯이 먼저이기 떄문에 메소드를 따로 만들어줌a
		dk1.setAttackPower(this.magicalAttackPower);
		dk2.setAttackPower(this.physicalAttackPower);
		
		
		this.weaponType = DAGGER;
		this.gold = 100;
	}
	

	public void attackAreaPlus(Animal animal) {
		
		dsm.attackAreaPlus(animal);
		
	}

	public void attackAreaMinus(Animal animal) {
		
		dsm.attackAreaMinus(animal);
	}
	
	
	public void attackAreaHitTest(Animal attacker) {
		
		displayComponent.displayObject.animal.Character ch = PlayUI.getDisplayComponent().getCharacter();
		
		dsm.attackAreaMinus(ch);
		skillChange(ch.getSkillNum());
		dsm.attackAreaPlus(ch);
		
		dsm.attackAreaHitTest(attacker);
	}
	
	
	public void skillChange(int skillNum) {
		switch (skillNum) {
			case 0 : dsm = dn; break;
			case 1 : dsm = dk1;	break;
			case 2 : dsm = dk2; break;
		}

	}
	
	public SkillManager smChange(int skillNum) {
		switch (skillNum) {
		case 0 : return dn;
		case 1 : return dk1;
		case 2 : return dk2;
		}
		return null;
	}
	
	public static Skillable[] getSkillArray() {
		return skillArray;
	}
	
}
