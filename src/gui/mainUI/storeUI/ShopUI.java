package gui.mainUI.storeUI;

import gui.mainUI.roundUI.PlayUI;
import gui.subUI.itemUI.PurchaseItemUI;
import gui.subUI.itemUI.SaleItemUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShopUI extends JPanel{
	
	private static JLabel manualLabel2;

	private static JLabel purchasePriceLabel;
	private static JLabel salePriceLabel;	
	
	private SaleItemUI saleItemUi;
	private PurchaseItemUI purchaseItemUi;
	
	
	public ShopUI() {
		
		setPreferredSize(new Dimension(640, 640));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		purchasePriceLabel = new JLabel();
		salePriceLabel = new JLabel();
		
		manualLabel2 = new JLabel();
		
		
		// ----타이틀
		JPanel titlePanel = new JPanel();
		add(titlePanel);
		titlePanel.setPreferredSize(new Dimension(640, 60));
		
		JLabel titleLabel = new JLabel("상점");
		titlePanel.add(titleLabel);
		titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 30));
		titleLabel.setForeground(Color.BLACK);
		
		
		// ----보조 타이틀
		JPanel subTitlePanel = new JPanel();
		add(subTitlePanel);
		subTitlePanel.setPreferredSize(new Dimension(640, 40));
		subTitlePanel.setLayout(new BoxLayout(subTitlePanel, BoxLayout.X_AXIS));
		
		JPanel subLeftTitlePanel = new JPanel();
		subTitlePanel.add(subLeftTitlePanel);
		subLeftTitlePanel.setPreferredSize(new Dimension(320, 40));
		
		JLabel subLeftTitleLabel = new JLabel("구매 창");
		subLeftTitlePanel.add(subLeftTitleLabel);
		subLeftTitleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		
		JPanel subRightTitlePanel = new JPanel();
		subTitlePanel.add(subRightTitlePanel);
		subRightTitlePanel.setPreferredSize(new Dimension(320, 40));
		
		JLabel subRightTitleLabel = new JLabel("판매 창");
		subRightTitlePanel.add(subRightTitleLabel);
		subRightTitleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		
		
		// ----상점
		JPanel shopPanel = new JPanel();
		add(shopPanel);
		shopPanel.setPreferredSize(new Dimension(640, 440));
		shopPanel.setLayout(new BoxLayout(shopPanel, BoxLayout.X_AXIS));
		
		// 왼쪽 구매
		JPanel purchaseListPanel = new JPanel(); 
		shopPanel.add(purchaseListPanel);
		purchaseListPanel.setPreferredSize(new Dimension(320, 440));
		purchaseListPanel.setLayout(new BoxLayout(purchaseListPanel, BoxLayout.Y_AXIS));
		this.purchaseItemUi = new PurchaseItemUI(300, 390);
		purchaseListPanel.add(purchaseItemUi);
		
		JPanel purchaseLabelPanel = new JPanel();
		purchaseListPanel.add(purchaseLabelPanel);
		purchaseLabelPanel.setPreferredSize(new Dimension(320, 40));
		
		JLabel purchaseLabel = new JLabel("가격: "); 
		purchaseLabelPanel.add(purchaseLabel);
		purchaseLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		purchaseLabelPanel.add(purchasePriceLabel);
		purchasePriceLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		
		// 오른쪽 구매
		JPanel saleListPanel = new JPanel();
		shopPanel.add(saleListPanel);
		saleListPanel.setPreferredSize(new Dimension(320, 440));
		saleListPanel.setLayout(new BoxLayout(saleListPanel, BoxLayout.Y_AXIS));
		this.saleItemUi = new SaleItemUI(300, 390);
		saleListPanel.add(saleItemUi);
		
		JPanel saleLabelPanel = new JPanel();
		saleListPanel.add(saleLabelPanel);
		saleLabelPanel.setPreferredSize(new Dimension(320, 40));
		
		JLabel saleLabel = new JLabel("가격 :");
		saleLabelPanel.add(saleLabel);
		saleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		saleLabelPanel.add(salePriceLabel);
		salePriceLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		
		
		// ----설명
		JPanel manualPanel = new JPanel();
		add(manualPanel);
		manualPanel.setLayout(new BoxLayout(manualPanel, BoxLayout.Y_AXIS));

		JPanel manualTopPanel = new JPanel();
		manualPanel.add(manualTopPanel);
		
		JLabel manualLabel1 = new JLabel("아이템을 선택하세요.");
		manualTopPanel.add(manualLabel1);
		manualLabel1.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
		
		JPanel manualBottomPanel = new JPanel();
		manualPanel.add(manualBottomPanel);
		manualBottomPanel.add(manualLabel2);
		manualLabel2.setText("소지 골드량 : " + PlayUI.getDisplayComponent().getCharacter().getGold() + "골드 / ");
		manualLabel2.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		
		JLabel jl3 = new JLabel("한번 클릭: 가격 확인, 두번클릭: 구매및 판매");
		manualBottomPanel.add(jl3);
		jl3.setFont(new Font("Malgun Gothic", Font.BOLD, 15));  
		
		
	}
	

	public static JLabel getSalePriceLabel() {
		return salePriceLabel;
	}
	
	public static JLabel getPurchasePriceLabel() {
		return purchasePriceLabel;
	}


	public static JLabel getManualLabel2() {
		return manualLabel2;
	}

}
