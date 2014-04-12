package Characters;

import java.awt.Graphics;
import java.awt.Image;

import Items.Inventory;
import MainFiles.BufferedImageLoader;
import MainFiles.MainClass;

public class ShopKeep extends NPC{
	
	private Inventory sInventory;
	private boolean showStore;
	public Image storeBackground;
	public BufferedImageLoader il;
	
	public ShopKeep(){
		this.setAlive(true);	
		storeBackground = il.loadImage("/Resources/Complete.png");
	}
	
	public ShopKeep(Inventory i, String s, MainClass mc){
		this.setAlive(true);
		this.sInventory = i;
		this.setName(s);
		this.showStore=true;
		storeBackground = mc.getBIL().loadImage("/Resources/storeBackground.png");
		
	}

	public Inventory getSInventory() {
		return sInventory;
	}
	
	public void graphics(Graphics g, MainClass mc){
		if (showStore){
			g.drawImage(storeBackground, 100, 50, 600, 500, null);
			drawStore(mc, g);
		}
	}
	
	public void drawStore(MainClass mc, Graphics g){
		

	}
	

	public boolean getShowStore(){
		return this.showStore;
	}
	
	public void setShowStore(boolean b){
		this.showStore = b;
	}
	
}
