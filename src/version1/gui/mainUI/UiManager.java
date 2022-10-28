package gui.mainUI;

import javax.swing.JFrame;


public abstract class UiManager extends JFrame {

	protected static int uiChange;
	
	public int getUiChange() {
		return uiChange;
	}

	public void setUiChange(int uiChange) {
		UiManager.uiChange = uiChange;
	}

	
}
