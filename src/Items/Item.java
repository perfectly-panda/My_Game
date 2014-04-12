package Items;

import java.awt.Image;

import MainFiles.BufferedImageLoader;
import MainFiles.MainClass;

public class Item{
	
	private String itemName;
	private int currentStack;
	private int maxStack;
	private int cost;
	private int value;
	
	private int topSpriteX;
	private int topSpriteY;
	private int bottomSpriteX;
	private int bottomSpriteY;
	private Image itemImage;
	
	public BufferedImageLoader bil = new BufferedImageLoader();
	
	public Item(){
		this.setItemName("Empty Spot");
		this.setCurrentStack(0);
		this.setMaxStack(0);
		
		this.setCost(0);
		this.setValue(0);
		
		this.setItemImage(bil.loadImage("/Resources/itemIcons/blank.png"));
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getCurrentStack() {
		return currentStack;
	}

	public void setCurrentStack(int currentStack) {
		this.currentStack = currentStack;
	}

	public int getMaxStack() {
		return maxStack;
	}

	public void setMaxStack(int maxStack) {
		this.maxStack = maxStack;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void buyItem(MainClass mc){
		if (mc.getPlayer().getCurrentGold() >= this.getCost()){
			mc.getPlayer().setCurrentGold(mc.getPlayer().getCurrentGold() - this.getCost());
			for (int i = 0; i < 6; i++){
				if (mc.getPlayer().getInv().getInventorySlotName(i) == "Empty Spot"){
					mc.getPlayer().getInv().setInventorySlot(this, i);
					mc.getPlayer().getInv().getInventorySlot(i).setCurrentStack(mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() +1);
					i=10;
				}
				else if (mc.getPlayer().getInv().getInventorySlotName(i) == this.getItemName() &&
					mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() < mc.getPlayer().getInv().getInventorySlot(i).getMaxStack()){
						mc.getPlayer().getInv().getInventorySlot(i).setCurrentStack(mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() +1);
						i=10;
				}
			}
		}
	}
	
	public void removePlayerItem(MainClass mc, Item item){
		//System.out.println("remove item");
		Item b = new Item();
		if(item.getItemName() != "Empty Spot"){
			//System.out.println("remove item");
			for (int i = 5; i > -1; i--){
				//System.out.println("inside for loop");
				if (mc.getPlayer().getInv().getInventorySlotName(i) == item.getItemName() &&
						mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() > 0){
							mc.getPlayer().getInv().getInventorySlot(i).setCurrentStack(mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() -1);
							if (mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() == 0){
								mc.getPlayer().getInv().setInventorySlot(b, i);
							}
							i=-10;
					}
			}
		}
	}
	
	public void useItem(MainClass mc, Item item){
		item.removePlayerItem(mc, item);
	}

	public int getTopSpriteX() {
		return topSpriteX;
	}

	public void setTopSpriteX(int topSpriteX) {
		this.topSpriteX = topSpriteX;
	}

	public int getTopSpriteY() {
		return topSpriteY;
	}

	public void setTopSpriteY(int topSpriteY) {
		this.topSpriteY = topSpriteY;
	}

	public int getBottomSpriteX() {
		return bottomSpriteX;
	}

	public void setBottomSpriteX(int bottomSpriteX) {
		this.bottomSpriteX = bottomSpriteX;
	}

	public int getBottomSpriteY() {
		return bottomSpriteY;
	}

	public void setBottomSpriteY(int bottomSpriteY) {
		this.bottomSpriteY = bottomSpriteY;
	}

	public Image getItemImage() {
		return itemImage;
	}

	public void setItemImage(Image itemImage) {
		this.itemImage = itemImage;
	}

}
