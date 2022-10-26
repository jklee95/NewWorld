package gui;

import gui.mainUI.UiManager;
import gui.mainUI.roundUI.PlayUI;
import gui.mainUI.startUI.StartUI;
import gui.mainUI.storeUI.StoreUI;


import displayComponent.DisplayComponent;

public class GuiTotal {
	
	public static final int ROUND_UI_FLAG = 2;
	public static final int STORE_UI_FLAG = 3;
	
	private UiManager uiManager;
	
	private Thread uiThread;
	
	public GuiTotal() {
		
		this.uiManager = new StartUI();
		this.uiManager.setVisible(true);
		
		this.uiThread = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				while (true) {
					
					switch (uiManager.getUiChange()) {
					case ROUND_UI_FLAG :
						
						uiManager.setVisible(false);
						uiManager = new PlayUI();
						uiManager.setVisible(true);
						
						uiManager.setUiChange(0);
						
						break;
						
					case STORE_UI_FLAG :    
						
						uiManager.setVisible(false);
						uiManager = new StoreUI();
						uiManager.setVisible(true);
						  
						uiManager.setUiChange(0);
						
						break;
					}
					   
					
					try {
						uiThread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		uiThread.start();
		
	}
}
