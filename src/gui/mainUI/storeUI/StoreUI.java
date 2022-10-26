package gui.mainUI.storeUI;

import gui.GuiTotal;
import gui.mainUI.UiManager;
import gui.subUI.equipUI.EquipUI;
import gui.subUI.itemUI.HaveItemUI;
import gui.subUI.nameUI.NameUI;
import gui.subUI.popUpUI.PopUpUI;
import gui.subUI.popUpUI.popSettingUI.PopSettingUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class StoreUI extends UiManager {

	private static Vector<PopSettingUI> popSettingUiVector = new Vector<PopSettingUI>();
	
	private JButton nextRoundButton;

	private NameUI nameUi;
	private EquipUI equipUi;
	private HaveItemUI haveItemUi;
	
	private ShopUI shopUi;
	private StatSettingUI statSettingUi;
	private SkillSettingUI skillSettingUi;
	
	
	public StoreUI(){
		
		
		this.shopUi = new ShopUI();
		this.statSettingUi = new StatSettingUI();
		this.skillSettingUi = new SkillSettingUI();
		
		this.nameUi = new NameUI();
		this.equipUi = new EquipUI();
		this.haveItemUi = new HaveItemUI(190, 295);
		
		setSize(830, 680);
		setTitle("New World");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel totalPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		JPanel buttonPanel = new JPanel();
		JTabbedPane storeTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		storeTabbedPane.addTab("              ��              ��               ", shopUi);
		storeTabbedPane.addTab("              ��          ��          ġ               ", statSettingUi);
		storeTabbedPane.addTab("              ��              ��               ", skillSettingUi);
		
		// ----- ��ü �г�
		add(totalPanel);
		totalPanel.setPreferredSize(new Dimension(830, 680));
		totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.X_AXIS));
		
		// ����
		totalPanel.add(leftPanel);	
		leftPanel.setPreferredSize(new Dimension(640, 680));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
	
		leftPanel.add(storeTabbedPane);	//����
		storeTabbedPane.setPreferredSize(new Dimension(640, 640));

		leftPanel.add(buttonPanel);	//��ư �г�
		buttonPanel.setPreferredSize(new Dimension(640, 40));
		
		// ������
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
		
		
		this.nextRoundButton = new JButton("���� �����");
		nextRoundButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				uiChange = GuiTotal.ROUND_UI_FLAG; 
				
				// �˾�â ���� ����
				for (int i = 0; i < popSettingUiVector.size(); i++) {
					popSettingUiVector.get(i).dispose();    
				}
				
				popSettingUiVector.removeAllElements();
				
				System.out.println(popSettingUiVector.size());
				

			}
		});

		buttonPanel.add(nextRoundButton);   
		
		setVisible(true);
		

	}
	


	public static Vector<PopSettingUI> getPopSettingUiVector() {
		return popSettingUiVector;
	}

}
