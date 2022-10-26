package displayComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

import javax.swing.JComponent;

import attackable.effect.Effect;
import displayComponent.background.BackGround;
import displayComponent.background.Rock;
import displayComponent.damage.DamageNumber;
import displayComponent.displayObject.animal.Character;
import displayComponent.displayObject.animal.monster.Lizard;
import displayComponent.displayObject.animal.monster.Monster;
import displayComponent.displayObject.animal.monster.Wolf;


public class DisplayComponent extends JComponent {

	
	public static final int CHARACTER_X = 320 - 32;
	public static final int CHARACTER_Y = 320 - 64;
	
	private static final int DEFAULT_COORDINATE = -304;
	
	private static final int MONSTER_LEVEL_LIMIT = 5;
	

	private Character character = new Character(CHARACTER_X, CHARACTER_Y);
	
	private Vector<Monster> monster = new Vector<Monster>();
	private Vector<Effect> effect = new Vector<Effect>();
	private Vector<DamageNumber> damageNumber = new Vector<DamageNumber>();
	private Vector<BackGround> background = new Vector<BackGround>();
	
	
	Image buffImage;
	Graphics buffg;
	
	public DisplayComponent() {
		background.add(new Rock(0, 0));
	}
	
	public void paint(Graphics g) {
		buffImage = createImage(640, 640);
		buffg = buffImage.getGraphics();

		update(g);
		buffg.clearRect(0, 0, 640, 640);
	}
	
	public void update(Graphics g) {
		int i;
		
		buffg.drawImage(background.get(0).getIm(), background.get(0).getImageX(), background.get(0).getImageY(), this);
		
		for (i = 0; i < monster.size(); i++) {
			buffg.drawImage(monster.get(i).getIm(), DEFAULT_COORDINATE + monster.get(i).getImageX(), DEFAULT_COORDINATE + monster.get(i).getImageY(), this);
			buffg.setColor(Color.black);
			buffg.drawRect(monster.get(i).getImageX(), monster.get(i).getImageY(), 50, 6);
			buffg.setColor(Color.red);
			buffg.fillRect(monster.get(i).getImageX(), monster.get(i).getImageY(), monster.get(i).getHpBar(), 6);
		}
		

		buffg.drawImage(character.getIm(), DEFAULT_COORDINATE + character.getImageX(), DEFAULT_COORDINATE + character.getImageY(), this); 
		
		
		for (i = 1; i < background.size(); i++) {
			buffg.drawImage(background.get(i).getIm(), background.get(i).getImageX(), background.get(i).getImageY(), this);
		}
		
		for (i = 0; i < effect.size(); i++) {
			buffg.drawImage(effect.get(i).getIm(), DEFAULT_COORDINATE + effect.get(i).getImageX(), DEFAULT_COORDINATE + effect.get(i).getImageY(), this);
		}
		
		for (i = 0; i < damageNumber.size(); i++) {
			buffg.drawImage(damageNumber.get(i).getIm(), DEFAULT_COORDINATE + damageNumber.get(i).getImageX(), DEFAULT_COORDINATE + damageNumber.get(i).getImageY(), this);
		}
		
		
		
		g.drawImage(buffImage, 0, 0, this);
	}

	public Character getCharacter() {
		return character;
	}

	public Vector<Effect> getEffect() {
		return effect;
	}

	public Vector<Monster> getMonster() {
		return monster;
	}
	
	public Vector<DamageNumber> getDamageNumber() {
		return damageNumber;
	}

	public Vector<BackGround> getBackGround() {
		return background;
	}

	public void makeMonster() {		
	
			int i = 0;
			while (i++ < 1 ) {
				monster.add(new Wolf(32 + (32 * i++), 320));
				monster.add(new Wolf(32 + (32 * i), 320));
				monster.add(new Lizard(64 + (32 * i++), 320));
				monster.add(new Lizard(64 + (32 * i++), 320));
				monster.add(new Lizard(64 + (32 * i), 320));
			}   
			
		
	}


}
