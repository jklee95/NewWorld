package gui.subUI.itemUI;

import item.Item;
import item.useItem.Portion;
import item.weapon.characterWeapon.CharacterWeapon;
import item.weapon.monsterWeapon.MonsterWeapon;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public abstract class CharacterItemUI extends ItemUI {
	
	public static final int USE_TYPE = 0;
	public static final int ETC_TYPE = 1;
	public static final int EQUIP_TYPE = 2;

    
	// 기본 리스트
	protected static Vector<CharacterWeapon> equipListContent = new Vector<CharacterWeapon>();
	protected static Vector<Portion> useListContent  = new Vector<Portion>();
	protected static Vector<MonsterWeapon> etcListContent = new Vector<MonsterWeapon>();
	
	protected static DefaultListModel<String> equipListContentName = new DefaultListModel<String>();
	protected static Vector<String> useListContentName = new Vector<String>();
	protected static Vector<String> etcListContentName = new Vector<String>();
	
	//protected static Vector<Integer> equipListContentNumber = new Vector<Integer>();
	protected static Vector<Integer> useListContentNumber = new Vector<Integer>();
	protected static Vector<Integer> etcListContentNumber = new Vector<Integer>();
	
	//protected static DefaultListModel<String> equipListContentTotal = new DefaultListModel<String>();
	protected static DefaultListModel<String> useListContentTotal = new DefaultListModel<String>();
	protected static DefaultListModel<String> etcListContentTotal = new DefaultListModel<String>();
	
	
	// 소비, 기타 리스트 묶음
	private static Vector useEtcListContent[] = new Vector[]{useListContent, etcListContent};
	private static Vector useEtcListContentName[] = new Vector[]{useListContentName, etcListContentName};
	private static Vector useEtcListContentNumber[] = new Vector[]{useListContentNumber, etcListContentNumber};
	private static DefaultListModel useEtcListContentTotal[] = new DefaultListModel[]{useListContentTotal, etcListContentTotal};
	
	

	protected JList<String> etcList;
	
	
	public CharacterItemUI (int x, int y) {
		
		super(x, y);
		
		etcList = new JList<String>();
		etcList.setDragEnabled(true);
		
		JPanel etcListPanel = new JPanel();
		
		itemTabbedPane.addTab("  기타  ", etcListPanel);	
		
		JScrollPane etcListScroll = new JScrollPane(etcList);
		
		etcListPanel.add(etcListScroll);
		etcListScroll.setPreferredSize(new Dimension(x - 18, y - 65));
		
		equipList.setModel(equipListContentName);
		useList.setModel(useListContentTotal);
		etcList.setModel(etcListContentTotal);
		
	}
	
	public static void addEquipListContent(CharacterWeapon weapon) {
		equipListContent.addElement(weapon);
		equipListContentName.addElement(weapon.getInstanceName());
	}
	
	public static void removeEquipListContent(CharacterWeapon weapon) {
		equipListContent.removeElement(weapon);
		equipListContentName.removeElement(weapon.getInstanceName());
	}

	@SuppressWarnings("unchecked")
	public static <I> void addUseEtcListContent(I item, int num, int type) {
		
		Item tempItem = (Item) item;
		
		if (useEtcListContentName[type].contains(tempItem.getInstanceName())) {

			int index = useEtcListContentName[type].indexOf(tempItem.getInstanceName());
			int element = (int) useEtcListContentNumber[type].get(index);
			
			useEtcListContentNumber[type].set(index, element + num);
			useEtcListContentTotal[type].set(index, "[개수 : " + useEtcListContentNumber[type].get(index) + "] " + tempItem.getInstanceName());
		} else {
			useEtcListContent[type].add(item);
			useEtcListContentName[type].add(tempItem.getInstanceName());
			useEtcListContentNumber[type].add(num);
			useEtcListContentTotal[type].addElement("[개수 : "
					+ useEtcListContentNumber[type]
							.get(useEtcListContentNumber[type].size() - 1)
					+ "] " + tempItem.getInstanceName());
		}
		
		//resetListData();
	}
	
	@SuppressWarnings("unchecked")
	public static <I> void removeUseEtcListContent(I item, int num, int type) {
		Item tempItem = (Item) item;
		
		int index = useEtcListContentName[type].indexOf(tempItem.getInstanceName());
		int element = (int) useEtcListContentNumber[type].get(index);
		
		if (element - num == 0) {
			useEtcListContentNumber[type].remove(index);
			useEtcListContent[type].remove(index);
			useEtcListContentName[type].remove(index);
			useEtcListContentTotal[type].remove(index);
		} else {
			useEtcListContentNumber[type].set(index, element - num);
			useEtcListContentTotal[type].set(index, "[개수 : " + useEtcListContentNumber[type].get(index) + "] " + tempItem.getInstanceName());
		}
		
	}
	
	public static void test() {

		
		System.out.print("useListContent : ");
		for (int i = 0; i < useListContent.size(); i++)
		System.out.print(useListContent.get(i) + ", ");
		
		System.out.println();
		
		System.out.print("useListContentName : ");
		for (int i = 0; i < useListContentName.size(); i++)
		System.out.print(useListContentName.get(i) + ", ");
		
		System.out.println();
		
		System.out.print("useListContentNumber : ");
		for (int i = 0; i < useListContentNumber.size(); i++)
		System.out.print(useListContentNumber.get(i) + ", ");
		
		System.out.println();
		
		System.out.print("useListContentTotal : ");
		for (int i = 0; i < useListContentTotal.size(); i++)
		System.out.print(useListContentTotal.get(i) + ", ");
		
		System.out.println();
		System.out.println("-----------------------------");
	}
}
