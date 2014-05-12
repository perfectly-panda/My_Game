package Items.Potions;

import Items.Item;
import MainFiles.MainClass;

public class BasicHealthPotion extends Item{
	
	private int hpReturned;
	
	public BasicHealthPotion(){

		//System.out.println(mc.isStoreOpen());
		
		this.setItemName("Items.Potions.BasicPotion");
		this.setCurrentStack(0);
		this.setMaxStack(99);
		this.setHpReturned(5);
		invClass = new InventoryClass(this.bil.loadImage("../Resources/itemIcons/glitch-icon-70.png"));		
		this.setCost(2);
		this.setValue(1);
	}
	
	public void useItem(){
		
		//System.out.println("use Potion");
		if (this.getHpReturned() >= MainClass.getPlayer().getTotalHP() - MainClass.getPlayer().getCurrentHP()){
			MainClass.getPlayer().resetHP();
			//System.out.println("use Potion");
		}
		else{
			MainClass.getPlayer().setTotalHP(MainClass.getPlayer().getCurrentHP() + this.getHpReturned());
			//System.out.println("use Potion");
		}
		//System.out.println(mc.getPlayer());
		//Player play = mc.getPlayer();
		this.removePlayerItem();
		invClass.revalidate();
	}

	public int getHpReturned() {
		return hpReturned;
	}

	public void setHpReturned(int hpReturned) {
		this.hpReturned = hpReturned;
	}
	
	public Item copyItem(){
		return new BasicHealthPotion();
	}

}
