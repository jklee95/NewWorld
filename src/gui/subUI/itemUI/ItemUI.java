package gui.subUI.itemUI;

import gui.subUI.popUpUI.popSettingUI.popShopUI.PopShopUI;
import item.weapon.monsterWeapon.MonsterWeapon;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import displayComponent.DisplayComponent;

public abstract class ItemUI extends JPanel {
	
	
	protected JList<String> equipList;
	protected JList<String> useList;
	
	protected JTabbedPane itemTabbedPane;
	  
	
	public ItemUI (int x, int y){
		
		equipList = new JList<String>();
		useList = new JList<String>();
		
		equipList.setDragEnabled(true);
		useList.setDragEnabled(true);
		
		
		setPreferredSize(new Dimension(x, y)); //±‚∫ª 190 360
		
		JPanel equipListPanel = new JPanel();
		JPanel useListPanel = new JPanel();
		
		itemTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		itemTabbedPane.addTab("  ¿Â∫Ò  ", equipListPanel);
		itemTabbedPane.addTab("  º“∫Ò  ", useListPanel);
		
		JScrollPane equipListScroll = new JScrollPane(equipList);
		JScrollPane useListScroll = new JScrollPane(useList);
		
		
		add(itemTabbedPane);	//≈«∆“

		equipListPanel.add(equipListScroll); //±‚∫ª 172 295
		equipListScroll.setPreferredSize(new Dimension(x - 18, y - 65));
		useListPanel.add(useListScroll);
		useListScroll.setPreferredSize(new Dimension(x - 18, y - 65));
		
		setVisible(true);
	}

	

}
