package GUI.RoundUI;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DisplayObject.DisplayComponent;
import GUI.UiManager;


public class PlayUI extends UiManager{
	
	private NameUI nameUi;
	private StatUI statUi;
	private Thread roundThread;

	public PlayUI(DisplayComponent dc){
		
		this.nameUi = new NameUI(dc);
		this.statUi = new StatUI(dc);
		
		this.setSize(640, 680);
		this.setTitle("New World");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// ------------�г� ����----------------
		JPanel totalPanel = new JPanel();
		add(totalPanel);	//��ü �г�
		totalPanel.setPreferredSize(new Dimension(830, 680));
		totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.X_AXIS));
		
		JPanel leftPanel = new JPanel();		
		totalPanel.add(leftPanel);	//���� ��ü �г�
		leftPanel.setPreferredSize(new Dimension(640, 680));
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		
		
		JPanel playPanel = new JPanel();
		leftPanel.add(playPanel);	//���� �÷��� �г�
		playPanel.setPreferredSize(new Dimension(640, 640));
		playPanel.add(dc);
		
		dc.setPreferredSize(new Dimension(640, 640));
		
		playPanel.addKeyListener(dc.getCh());
		playPanel.setFocusable(true);
		playPanel.requestFocusInWindow();
		
		leftPanel.add(statUi);	//����UI �г�
		leftPanel.add(nameUi);	//����, �̸�UI �г�
		
		
		
		roundThread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					
					// �����г��� ��Ŀ�� ����
					playPanel.setFocusable(true);
					playPanel.requestFocusInWindow();
					
					// ���� �ʱ�ȭ
					nameUi.getLevelLabel().setText("" + dc.getCh().getLv());
					
					// ���� �ʱ�ȭ
					statUi.getHpTextLabel().setText(dc.getCh().getHp() + " / " + dc.getCh().getDefaultHp());
					statUi.getMpTextLabel().setText(dc.getCh().getMp() + " / " + dc.getCh().getDefaultMp());
					statUi.getExpTextLabel().setText(dc.getCh().getExp() + " / " + dc.getCh().getDefaultExp());
					
					if (dc.getMonster().size() <= 0) uiChange = true;
					
					try {
						roundThread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		roundThread.start();

	}
	
	public Thread getThread() {
		return roundThread;
	}
	
}

