package gui.subUI.popUpUI;

import gui.mainUI.storeUI.StoreUI;
import gui.subUI.itemUI.ItemUI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class PopUpUI extends JFrame {
	
	protected JPanel titlePanel;
	protected JPanel imagePanel;
	protected JPanel effectPanel;
	protected JPanel changePanel;
	protected JPanel buttonPanel;
	
	protected JButton button;
	
	public PopUpUI(int width, int height) {
		
		setBounds(100, 100, width, height);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		// Ÿ��Ʋ
		titlePanel = new JPanel();
		getContentPane().add(titlePanel);
		
		// �̹���
		imagePanel = new JPanel();
		getContentPane().add(imagePanel);
		
		// ȿ��
		effectPanel = new JPanel();
		getContentPane().add(effectPanel);
		
		// ����
		changePanel = new JPanel();
		getContentPane().add(changePanel);
		
		// ��ư
		buttonPanel = new JPanel();
		getContentPane().add(buttonPanel);
		

		button = new JButton(" Ȯ�� ");
		buttonPanel.add(button);
		
	}

	
	public void shutUp() {
		this.dispose();
	}

}
