package Characters;

import Inventory.StoreInventory;
import MainFiles.MainClass;

public class ShopKeep extends NPC{
	
	private StoreInventory sInventory;
	
	public ShopKeep(){
		this.setAlive(true);	
	}
	
	public ShopKeep(StoreInventory i, String s, MainClass mc){
		this.setAlive(true);
		this.sInventory = i;
		this.setName(s);
		this.charClass = new CharClass(mc.getMapTiles().getSubimage(0, 50, 25, 25));
		//mc.getATW().add(sInventory.getMainFrame());
	}

	public StoreInventory getSInventory() {
		return sInventory;
	}
	
}
