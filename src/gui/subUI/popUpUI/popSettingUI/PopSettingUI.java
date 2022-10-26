package gui.subUI.popUpUI.popSettingUI;

import item.Nameable;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import gui.mainUI.storeUI.StoreUI;
import gui.subUI.popUpUI.PopUpUI;

public class PopSettingUI extends PopUpUI {
	
	protected String name;
	protected JSpinner spinner;
	protected JLabel subLabel;

	public PopSettingUI(int width, int height, Nameable nameable, int maxNum) {
		
		super(width, height);
		

		
		// ------ 중복창 제거
		
		this.name = nameable.getInstanceName();


		for (int i = 0; i < StoreUI.getPopSettingUiVector().size(); i++) {
			if ((StoreUI.getPopSettingUiVector().get(i).getName()).equals(name)) {
				StoreUI.getPopSettingUiVector().get(i).shutUp();
				break;
			}
		}
		
		// ------ 팝업창 벡터에 추가
		StoreUI.getPopSettingUiVector().add(this);

		

		
		// ------ 프레임 설정

		// ---타이틀 지정
		JLabel titleLabel = new JLabel(name);
		titlePanel.add(titleLabel);
		titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		
		// ---변경 패널
		changePanel.setLayout(new BoxLayout(changePanel, BoxLayout.X_AXIS));

		// 서브패널
		JPanel subLabelPanel = new JPanel();
		changePanel.add(subLabelPanel);

		subLabel = new JLabel();
		subLabelPanel.add(subLabel);
		subLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 13));

		// 스피너 패널
		JPanel spinnerPanel = new JPanel();
		changePanel.add(spinnerPanel);
     
		spinner = new JSpinner(new SpinnerNumberModel(0, 0, maxNum, 1));
		JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
		spinnerTextField.setColumns(2);
		spinnerTextField.setEditable(false);
		spinnerPanel.add(spinner);
		
	}

	public String getName() {
		return name;
	}

}
