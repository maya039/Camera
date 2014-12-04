package client;

import gui.GUI;
import gui.InfoPanel;

public class Updater extends Thread {
	private ClientMonitor mon;
	private GUI gui;

	public Updater(ClientMonitor mon, GUI gui) {
		this.mon = mon;
		this.gui = gui;
	}

	public void run() {
		while (!isInterrupted()) {
			int type = -1;
			try {
				type = mon.checkUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (type == ClientMonitor.IMAGE) {
				Image image = mon.getImageFromBuffer();
				try {
					gui.setImage(image);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (type == ClientMonitor.COMMAND) {
				int command = mon.getCommandFromUpdaterBuffer();
				gui.sendCommandToInfoPanel(command);
				
			}
		}
	}
}
