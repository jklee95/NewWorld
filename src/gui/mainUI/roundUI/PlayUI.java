package gui.mainUI.roundUI;

import gui.GuiTotal;
import gui.mainUI.UiManager;
import gui.subUI.equipUI.EquipUI;
import gui.subUI.itemUI.HaveItemUI;
import gui.subUI.nameUI.NameUI;
import item.weapon.characterWeapon.dagger.Dagger;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import attackable.AttackArea;
import displayComponent.DisplayComponent;


public class PlayUI extends UiManager {
	
	private static DisplayComponent displayComponent = new DisplayComponent();
	
	private NameUI nameUi;
	private EquipUI equipUi;
	private StatUI statUi;
	private HaveItemUI haveItemUi;
	private Thread roundThread;

	public PlayUI() {
		
		displayComponent.getCharacter().weaponChange(new Dagger("�ʺ��ܰ�", 10, 15, 1));
		
		
		this.nameUi = new NameUI();
		this.equipUi = new EquipUI();
		this.statUi = new StatUI();
		this.haveItemUi = new HaveItemUI(190, 295);
		
		this.setSize(830, 680);
		this.setTitle("New World");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// ------------�г� ����----------------
		JPanel totalPanel = new JPanel();
		add(totalPanel);	//��ü �г�
		totalPanel.setPreferredSize(new Dimension(830, 680));
		totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.X_AXIS));
		
		// ----- ����
		JPanel leftPanel = new JPanel();		
		totalPanel.add(leftPanel);	//���� ��ü �г�
		leftPanel.setPreferredSize(new Dimension(640, 680));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		
		JPanel playPanel = new JPanel();
		leftPanel.add(playPanel);	//���� �÷��� �г�
		playPanel.setPreferredSize(new Dimension(640, 640));
		playPanel.add(displayComponent);
		
		displayComponent.setPreferredSize(new Dimension(640, 640));
		
		playPanel.addKeyListener(displayComponent.getCharacter());
		playPanel.setFocusable(true);
		playPanel.requestFocusInWindow();
		
		leftPanel.add(statUi);	//����UI �г�
		
		
		// ----- ������
		JPanel rightPanel = new JPanel();
		totalPanel.add(rightPanel);
		rightPanel.setPreferredSize(new Dimension(190, 680));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		JPanel blankPanel1 = new JPanel();
		blankPanel1.setSize(190, 33);
		blankPanel1.setBackground(Color.gray);
		
		JPanel blankPanel2 = new JPanel();
		blankPanel2.setSize(190, 33);
		blankPanel2.setBackground(Color.gray);
		
		rightPanel.add(haveItemUi);
		rightPanel.add(blankPanel1);
		rightPanel.add(equipUi);
		rightPanel.add(blankPanel2);
		rightPanel.add(nameUi);
		
		
		displayComponent.makeMonster();
		displayComponent.getCharacter().setXY(DisplayComponent.CHARACTER_X, DisplayComponent.CHARACTER_Y);
		displayComponent.getCharacter().setKeyBooleanReset();
		displayComponent.getCharacter().makeThread();  
		
		roundThread = new Thread(new Runnable() {
			
			private boolean threadFlag = true; 
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				while (threadFlag) {
					//AttackArea.test();
					
					// �����г��� ��Ŀ�� ����
					playPanel.setFocusable(true);
					playPanel.requestFocusInWindow();
					
					// ���� �ʱ�ȭ
					nameUi.getLevelLabel().setText("" + displayComponent.getCharacter().getLv());
					
					// ���� �ʱ�ȭ
					statUi.getHpTextLabel().setText(displayComponent.getCharacter().getHp() + " / " + displayComponent.getCharacter().getMaxHp());
					statUi.getMpTextLabel().setText(displayComponent.getCharacter().getMp() + " / " + displayComponent.getCharacter().getMaxMp());
					statUi.getExpTextLabel().setText(displayComponent.getCharacter().getExp() + " / " + displayComponent.getCharacter().getMaxExp());
					
					if (displayComponent.getMonster().size() <= 0) {
						uiChange = GuiTotal.STORE_UI_FLAG;
						stop();
					}
					
					displayComponent.repaint();
					
					try {
						roundThread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
			public void stop() {
				threadFlag = false;
			}
		});
		
		roundThread.start();

	}
	
	public Thread getThread() {
		return roundThread;
	}

	public static DisplayComponent getDisplayComponent() {
		return displayComponent;
	}
	
}

