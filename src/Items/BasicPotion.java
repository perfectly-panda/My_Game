package Items;

import MainFiles.MainClass;

public class BasicPotion extends Item{
	
	private int hpReturned;
	
	public BasicPotion(){
		this.setItemName("Basic Potion");
		this.setCurrentStack(0);
		this.setMaxStack(99);
		this.setHpReturned(10);
		
		this.setItemImage(this.bil.loadImage("/Resources/itemIcons/glitch-icon-70.png"));
		
		this.setCost(2);
		this.setValue(1);
	}
	
	public void useItem(MainClass mc, Item item){
		
		//System.out.println("use Potion");
		if (this.getHpReturned() >= mc.getPlayer().getTotalHP() - mc.getPlayer().getCurrentHP()){
			mc.getPlayer().resetHP();
			//System.out.println("use Potion");
		}
		else{
			mc.getPlayer().setTotalHP(mc.getPlayer().getCurrentHP() + this.getHpReturned());
			//System.out.println("use Potion");
		}
		this.removePlayerItem(mc, this);
	}

	public int getHpReturned() {
		return hpReturned;
	}

	public void setHpReturned(int hpReturned) {
		this.hpReturned = hpReturned;
	}

}
