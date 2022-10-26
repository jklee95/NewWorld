package attackable.skill;

public interface Skillable {

	public Skillable makeSkill(int skillLevel);
    
    public void setSkillLevelCurrent(int skillLevel);
    
    public int getSkillLevelMax();
    public int getSkillLevelCurrent();
    public String getSkillContents();
    
    public String getSkillAbilityContents_1();
    public String getSkillAbilityContents_2();
    
}
