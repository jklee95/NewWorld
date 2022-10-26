package gui.subUI.popUpUI.popSettingUI.popSkillUI;

import gui.mainUI.roundUI.PlayUI;
import gui.mainUI.storeUI.SkillSettingUI;
import gui.subUI.popUpUI.popEtcUI.PopEtcUI;
import gui.subUI.popUpUI.popSettingUI.PopSettingUI;
import item.Nameable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import attackable.skill.Skillable;
import attackable.skill.activeSkill.specialSkill.SpecialActiveSkill;

public class PopSkillUI extends PopSettingUI {
	
	private DefaultListModel<String> model;

	public PopSkillUI(int width, int height, Nameable nameable, int skillNum, SkillSettingUI skillSettingUI) {
		
		super(width, height, nameable, 0);
		
		this.getContentPane().remove(effectPanel);
		this.model = new DefaultListModel<String>();
		
		
		
		Skillable skillable = (Skillable)nameable;
		
		
		// 라벨 설정
		subLabel.setText("적용할 기술치");
		
		
		
		
		// --------- 중심패널
		imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.X_AXIS));
		

		// --- 왼쪽패널
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		imagePanel.add(leftPanel);      
		

		// 빈 패널
		JPanel blankPanel = new JPanel();
		leftPanel.add(blankPanel);
		
		// 이미지 패널
		JPanel imageIconPanel = new JPanel();
		leftPanel.add(imageIconPanel);
		
		// 이미지 세팅
		String s = "image/UI/skill/dagger/skill" + skillNum + ".jpg";
		URL url = getClass().getClassLoader().getResource(s);
		ImageIcon im = new ImageIcon(url);
		
		JButton imageButton = new JButton(im);
		imageButton.setOpaque(false);
		imageButton.setContentAreaFilled(false);
		imageButton.setBorderPainted(false);
		
		imageIconPanel.add(imageButton);
		
		
		// 레벨 세팅
		JPanel levelPanel = new JPanel();
		leftPanel.add(levelPanel);
		
		JLabel levelLabel = new JLabel("단계 : " + skillable.getSkillLevelCurrent());
		levelPanel.add(levelLabel);
		levelLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
		
		// 설명 세팅
		JPanel contentPanel = new JPanel();
		leftPanel.add(contentPanel);
		
		JTextArea contextTextArea = new JTextArea(skillable.getSkillContents());
		contextTextArea.setEditable(false);
		contextTextArea.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
		contextTextArea.setEditable(false); 
		contentPanel.add(contextTextArea);
		
		
		
		// --- 오른쪽패널
		JPanel rightPanel = new JPanel();
		imagePanel.add(rightPanel);
		
		// 리스트 패널
		JPanel listPanel = new JPanel();
		rightPanel.add(listPanel);
     
		
		JList<String> list = new JList<String>(model);
		listPanel.add(list);     
		list.setDragEnabled(true); // 드래그 금지
		list.setCellRenderer(new DefaultListCellRenderer() { // 가운데 정렬
			public int getHorizontalAlignment() {
				return CENTER;
			}
		});
		
		int skillLevel = skillable.getSkillLevelCurrent();
		
		settingModel(skillable, skillLevel);
		
		
		// 스피너 설정
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				settingModel(skillable, skillLevel);
			}
		});
		
		
		// 최대값 재설정
		int skillPoint = PlayUI.getDisplayComponent().getCharacter().getSkillPoint();
		int skillLevelCurrent = skillable.getSkillLevelCurrent();
		int skillLevelMax = skillable.getSkillLevelMax();
		
		((SpinnerNumberModel) spinner.getModel())
				.setMaximum(skillLevelCurrent + skillPoint > skillLevelMax ? 
						skillLevelMax - skillLevelCurrent : skillPoint); 
		
		
		
		
		// ----- 버튼 패널
		button.setText("적용");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int value = (Integer)spinner.getValue();
				
				if (value == 0) {
					PopEtcUI popUpUi = new PopEtcUI("적용 실패", 230, 150, "투자된 기술치가 없습니다.");
					popUpUi.setLocation(220, 250);
				} else {

					skillable.setSkillLevelCurrent(value);
					
					PlayUI.getDisplayComponent().getCharacter().setSkillPoint(-value);
					skillSettingUI.getSubLabel2().setText("현재 사용 가능한 기술치 : " + PlayUI.getDisplayComponent().getCharacter().getSkillPoint() + "   ");
					
					shutUp();
					
				}
				
			}
		});
		
		setVisible(true);
		
	}
	
	
	public void settingModel(Skillable skillable, int skillLevel)  {
		
		String[] abilityTime = new String[]{"이전", "현재", "다음"};
		int value = (Integer)spinner.getValue();
		
		int totalValue = skillLevel + value;
		
		model.removeAllElements();
		
		for (int i = 0; i < 3; i++) {
			
			int totalLevel = totalValue + (i - 1);
			
			Skillable skill = skillable.makeSkill(totalLevel);

			// 레벨에 따른 빈칸
			if ((totalValue == 0 && (i == 0 || i == 1))
					|| (totalValue == 1 && i == 0)
					|| ((totalValue == skill.getSkillLevelMax()) && i == 2)) {

				model.addElement(" ");
				model.addElement(" ");
				model.addElement(" ");
				if (i != 2)
					model.addElement("-");
				continue;

			}

			model.addElement("[ " + abilityTime[i] + " 단계 : " + totalLevel + " ]");
			model.addElement(skill.getSkillAbilityContents_1());
			model.addElement(skill.getSkillAbilityContents_2());
			if (i != 2)
				model.addElement("-");
			
			
		}
	}

}
