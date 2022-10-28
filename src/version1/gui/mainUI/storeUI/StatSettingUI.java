package gui.mainUI.storeUI;

import gui.mainUI.roundUI.PlayUI;
import gui.subUI.popUpUI.popEtcUI.PopEtcUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class StatSettingUI extends JPanel {

	private static JLabel[] labelArray = new JLabel[8];
	private JSpinner[] spinnerArray = new JSpinner[6];
	private int[] arrayCount = new int[2];
	private int tempAp;
	
	
	public StatSettingUI(){
		
		setPreferredSize(new Dimension(640,640));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.GRAY);
		
		
		// ====== Ÿ��Ʋ �г�
		JPanel titlePanel = new JPanel();
		add(titlePanel);
		
		JLabel titleLabel = new JLabel("�ɷ�ġ");
		titlePanel.add(titleLabel);
		titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		titleLabel.setForeground(Color.BLACK);
		
		
		// ====== �ɷ�ġ �г�
		JPanel statTotalPanel = new JPanel();
		add(statTotalPanel);	//�ɷ�ġ â
		statTotalPanel.setPreferredSize(new Dimension(640, 480));
		statTotalPanel.setLayout(new BoxLayout(statTotalPanel, BoxLayout.X_AXIS));
		
		// ---- ���� 
		JPanel statLeftPanel = new JPanel();
		statTotalPanel.add(statLeftPanel);
		statLeftPanel.setLayout(new BoxLayout(statLeftPanel, BoxLayout.Y_AXIS));
		
		settingStatPanel(statLeftPanel, "ü��");
		settingStatPanel(statLeftPanel, "����");
		settingStatPanel(statLeftPanel, "�������ݷ�");
		settingStatPanel(statLeftPanel, "������ݷ�");
		settingStatPanel(statLeftPanel, "�������ݷ�");
		settingStatPanel(statLeftPanel, "������ݷ�");
		settingStatPanel(statLeftPanel, "���߷�");
		settingStatPanel(statLeftPanel, "ȸ����");
		
		
		// ---- �߰�
		JPanel statMiddlePanel = new JPanel();
		statTotalPanel.add(statMiddlePanel);
		statMiddlePanel.setLayout(new BoxLayout(statMiddlePanel, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < 8; i++) {
			settingStatPanel(statMiddlePanel);
		}
		
		statLabelSetting();  
		
		// ---- ������
		JPanel statRightPanel = new JPanel();
		statTotalPanel.add(statRightPanel);
		statRightPanel.setLayout(new BoxLayout(statRightPanel, BoxLayout.Y_AXIS));
		
		settingStatSpinner(statRightPanel);
		settingStatSpinner(statRightPanel);
		settingStatSpinner(statRightPanel);
		settingStatSpinner(statRightPanel);
		settingStatSpinner(statRightPanel);
		settingStatSpinner(statRightPanel);
		
		// ��ĭ��
		JPanel tempPanel1 = new JPanel();
		statRightPanel.add(tempPanel1);

		JPanel tempPanel2 = new JPanel();
		statRightPanel.add(tempPanel2);
		
		JPanel tempPanel3 = new JPanel();
		statRightPanel.add(tempPanel3);
		
		
		// ====== �ϴ� �г�
		JPanel subPanel = new JPanel();
		add(subPanel);
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
		
		
		JPanel subLabel1Panel = new JPanel();
		subPanel.add(subLabel1Panel);
		
		JLabel subLabel1 = new JLabel("�ɷ�ġ�� �Է��� �� �����ư�� �����ּ���. ");
		subLabel1Panel.add(subLabel1);
		subLabel1.setFont(new Font("Malgun Gothic", Font.BOLD, 17));
		
		JPanel subLabel2Panel = new JPanel();
		subPanel.add(subLabel2Panel);
		
		JLabel subLabel2 = new JLabel("���� ��� ������ �ɷ�ġ : " + PlayUI.getDisplayComponent().getCharacter().getAbilityPoint() + "   ");
		subLabel2Panel.add(subLabel2);
		subLabel2.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		
		
		// ��ư
		JButton statButton = new JButton("����");
		subLabel2Panel.add(statButton);
		statButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				if (tempAp != 0) {
					PlayUI.getDisplayComponent().getCharacter().setAbilityPoint(-tempAp);
					subLabel2.setText("���� ��� ������ AP : " + PlayUI.getDisplayComponent().getCharacter().getAbilityPoint() + "   ");
					
					statSetting();
					statLabelSetting(); 
					  
					tempAp = 0;
					 
					
					for (JSpinner spinner : spinnerArray) {
						StatChangeHandler handler = (StatChangeHandler) spinner.getChangeListeners()[0];
						handler.setPreviousValue(0);
						
						spinner.setValue(0);
						
					}
					System.out.println("����Ϸ�");
					PopEtcUI popUpUi = new PopEtcUI("���� �Ϸ�", 230, 150, "�ɷ�ġ ������ �Ϸ�Ǿ����ϴ�.");
					popUpUi.setLocation(220, 200);
				
				} else {
					System.out.println("�������");
					PopEtcUI popUpUi = new PopEtcUI("���� ����", 230, 150, "���ڵ� �ɷ�ġ�� �����ϴ�.");
					popUpUi.setLocation(220, 200);
				}
			}
		});
		
	}
	
	public void settingStatPanel(JPanel panel, String labelString) {
		
		JPanel tempPanel = new JPanel();
		panel.add(tempPanel);
		
		JLabel tempLabel = new JLabel(labelString);
		tempLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 17));
		tempPanel.add(tempLabel);
		
	}
	
	public void settingStatPanel(JPanel panel) {
		
		JPanel tempPanel = new JPanel();
		panel.add(tempPanel);
		
		JLabel tempLabel = new JLabel();
		tempLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 17));
		tempPanel.add(tempLabel);
		
		labelArray[arrayCount[1]++] = tempLabel;
		
	}
	
	public void settingStatSpinner(JPanel panel) {
		
		JPanel spinnerPanel = new JPanel();
		panel.add(spinnerPanel);
		
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, PlayUI.getDisplayComponent().getCharacter().getAbilityPoint(), 1));
		JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
		spinnerTextField.setColumns(2);
		spinnerTextField.setEditable(false);
		spinnerPanel.add(spinner);
		spinnerArray[arrayCount[0]++] = spinner;
		
		spinner.addChangeListener(new StatChangeHandler());
		
	}
	

	private class StatChangeHandler implements ChangeListener {

		private int previousValue = 0;
		
		public void stateChanged(ChangeEvent e) {
			
			JSpinner spinner = (JSpinner)e.getSource();
			
			
			if ((int)spinner.getValue() > previousValue) tempAp++;
			else if ((int)spinner.getValue() < previousValue)  tempAp--;
			
			
			if (tempAp > PlayUI.getDisplayComponent().getCharacter().getAbilityPoint()) {
				tempAp--;
				spinner.setValue((int)spinner.getValue() - 1);
			}
			
			previousValue = (int)spinner.getValue();
			
			System.out.println("tempAp = " + tempAp);
		}

		public void setPreviousValue(int previousValue) {
			this.previousValue = previousValue;
		}
		
	}
	
	public static void statLabelSetting() {
		
		displayComponent.displayObject.animal.Character ch = PlayUI.getDisplayComponent().getCharacter();
		
		labelArray[0].setText(ch.getHp() + " / " + (ch.getMaxHp()) + "   (" + ch.getMaxHp() + " + " + "0" + ")");
		labelArray[1].setText(ch.getMp() + " / " + (ch.getMaxMp()) + "   (" + ch.getMaxMp() + " + " + "0" + ")");
		labelArray[2].setText(ch.getPhysicalAttackPower() + ch.getWeapon().getPhysicalAttackPower() + "   (" + ch.getPhysicalAttackPower() + " + " + ch.getWeapon().getPhysicalAttackPower() + ")"); 
		labelArray[3].setText(ch.getPhysicalDefensePower() + "   (" + ch.getPhysicalDefensePower() + " + " + "0" + ")");
		labelArray[4].setText(ch.getMagicalAttackPower() + ch.getWeapon().getMagicalAttackPower() + "   (" + ch.getMagicalAttackPower() + " + " + ch.getWeapon().getMagicalAttackPower() + ")");
		labelArray[5].setText(ch.getMagicalDefensePower() + "   (" + ch.getMagicalDefensePower() + " + " + "0" + ")");
		labelArray[6].setText(ch.getAccuracyRate() + "   (" + ch.getAccuracyRate() + " + " + "0" + ")");
		labelArray[7].setText(ch.getEvasionRate() + "   (" + ch.getEvasionRate() + " + " + "0" + ")");
		
	}
	
	
	public void statSetting() {
		
		displayComponent.displayObject.animal.Character ch = PlayUI.getDisplayComponent().getCharacter();
		
		ch.setMaxHp((int)spinnerArray[0].getValue());
		ch.setMaxMp((int)spinnerArray[1].getValue());
		ch.setPhysicalAttackPower((int)spinnerArray[2].getValue());
		ch.setPhysicalDefensePower((int)spinnerArray[3].getValue());
		ch.setMagicalAttackPower((int)spinnerArray[4].getValue());
		ch.setMagicalDefensePower((int)spinnerArray[5].getValue());
	}
	
}
