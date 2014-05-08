package Items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.Serializable;

import MainFiles.BufferedImageLoader;
import MainFiles.ImageShowingComponent;
import MainFiles.MainClass;

public class Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String itemName;
	private int currentStack;
	private int maxStack;
	private int cost;
	private int value;
	
	private Image itemImage;
	
	public InventoryClass invClass;
	
	public BufferedImageLoader bil = new BufferedImageLoader();
	
	public Item(){
		this.setItemName("Items.Item");
		this.setCurrentStack(0);
		this.setMaxStack(0);
		
		this.setCost(0);
		this.setValue(0);
		
		this.setItemImage(bil.loadImage("/Resources/itemIcons/blank.png"));
		
		invClass = new InventoryClass(this.getItemImage());
		
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
				if (mc.getPlayer().getInv().getInventorySlotName(i) == "Items.Item"){
					//System.out.println("adding in slot "+ i);
					mc.getPlayer().getInv().setInventorySlot(this, i);
					mc.getPlayer().getInv().getInventorySlot(i).setCurrentStack(mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() +1);
					mc.getBottomBar().updateItem(i, mc);
					i=10;
				}
				else if (mc.getPlayer().getInv().getInventorySlotName(i) == this.getItemName() &&
					mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() < mc.getPlayer().getInv().getInventorySlot(i).getMaxStack()){
					//System.out.println("adding to slot "+ i);	
					mc.getPlayer().getInv().getInventorySlot(i).setCurrentStack(mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() +1);
						i=10;
				}else if ( i == 5){
					System.out.println("purchase failed");
					mc.getPlayer().setCurrentGold(mc.getPlayer().getCurrentGold() + this.getCost());
					i=10;
				}
			}
		}
		invClass.revalidate();
	}
	
	public void removePlayerItem(MainClass mc, Item item){
		//System.out.println("remove item" + item);
		Item b = new Item();
		if(item.getItemName() != "Items.Item"){
			//System.out.println("remove item");
			for (int i = 5; i > -1; i--){
				//System.out.println("inside for loop");
				if (mc.getPlayer().getInv().getInventorySlotName(i) == item.getItemName() &&
						mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() > 0){
							mc.getPlayer().getInv().getInventorySlot(i).setCurrentStack(mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() -1);
							if (mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() == 0){
								mc.getPlayer().getInv().setInventorySlot(b, i);
								mc.getBottomBar().updateItem(i, mc);
							}
							i=-10;
					}
			}
		}
	}
	
	public void useItem(MainClass mc){
		this.removePlayerItem(mc, this);
		invClass.revalidate();
	}

	public Image getItemImage() {
		return itemImage;
	}

	public void setItemImage(Image itemImage) {
		this.itemImage = itemImage;
	}

	@SuppressWarnings("serial")
	public class InventoryClass extends ImageShowingComponent{
		InventoryClass(){
		}
		
		InventoryClass(Image i){
			this.setImage(i);
			this.setPreferredSize(this.getPreferredSize());
			this.setMaximumSize(this.getPreferredSize());
			this.setLayout(new GridLayout(1,1));
			this.setOpaque(true);
			this.setVisible(true);
			this.addMouseListener(this);
			//this.setBorder(BorderFactory.createLineBorder(Color.black));
			//System.out.println(this);
		}
		
		  public void paintComponent(Graphics g) {
			  super.paintComponent(g);
			  g.drawImage(this.getImage(), 0, 0, null);
			  g.setColor(Color.white);
			  String s = String.valueOf(getCurrentStack());
					if (getCurrentStack() != 0){
						g.drawString(s, 45, 30);
					}
		  }
	}
	
}
