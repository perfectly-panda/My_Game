package Items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import Characters.Player;
import MainFiles.BufferedImageLoader;
import MainFiles.ImageShowingComponent;
import MainFiles.MainClass;

public class Item{

	
	
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
		
		//System.out.println(MainClass.isStoreOpen());
		
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
	
	public Item copyItem(){
		return new Item();
	}
	
	public void buyItem(){
		if (MainClass.getPlayer().getCurrentGold() >= this.getCost()){
			MainClass.getPlayer().setCurrentGold(MainClass.getPlayer().getCurrentGold() - this.getCost());
			getItem();
		}
	}
	
	public void getItem(){
		MainClass.getPlayer();
		for (int i = 0; i < Player.getInv().getInventorySize(); i++){
			MainClass.getPlayer();
			if (Player.getInv().getInventorySlotName(i) == "Items.Item"){
				MainClass.getPlayer();
				Player.getInv().setInventorySlot(this.copyItem(), i);
				MainClass.getPlayer();
				Player.getInv().getInventorySlot(i).setCurrentStack(Player.getInv().getInventorySlot(i).getCurrentStack() +1);
				
				i=10000;
			} else {
				MainClass.getPlayer();
				MainClass.getPlayer();
				MainClass.getPlayer();
				if (Player.getInv().getInventorySlotName(i) == this.getItemName() &&
					Player.getInv().getInventorySlot(i).getCurrentStack() < Player.getInv().getInventorySlot(i).getMaxStack()){
					MainClass.getPlayer();
					//System.out.println("adding to slot "+ i);	
					Player.getInv().getInventorySlot(i).setCurrentStack(Player.getInv().getInventorySlot(i).getCurrentStack() +1);
						i=10000;
				}else if ( i == 5){
					System.out.println("purchase failed");
					MainClass.getPlayer().setCurrentGold(MainClass.getPlayer().getCurrentGold() + this.getCost());
					i=100000;
				}
			}
		}
		MainClass.getPlayer();
		if(Player.getInv().getMainFrame() != null){
			MainClass.getPlayer();
			//System.out.println("not null");
			Player.getInv().reloadInventory();
		}
	}
	
	public void removePlayerItem(){
		//System.out.println("remove item" + item);
		Item b = new Item();
		//System.out.println(play);
		if(this.getItemName() != "Items.Item"){
			MainClass.getPlayer();
			//System.out.println(mc.toString());
			for (int i = Player.getInv().getInventorySize()-1; i >= 0; i--){
				MainClass.getPlayer();
				MainClass.getPlayer();
				if (Player.getInv().getInventorySlotName(i) == this.getItemName() &&
						Player.getInv().getInventorySlot(i).getCurrentStack() > 0){
							MainClass.getPlayer();
					//System.out.println(i);
					Player.getInv().getInventorySlot(i).setCurrentStack(Player.getInv().getInventorySlot(i).getCurrentStack() -1);
							MainClass.getPlayer();
							if (Player.getInv().getInventorySlot(i).getCurrentStack() == 0){
								MainClass.getPlayer();
								Player.getInv().setInventorySlot(b, i);
								MainClass.getPlayer();
								Player.getInv().reloadInventory();
							}
							i=-10;
					}
			}
		}
	}
	
	public void useItem(){
		this.removePlayerItem();
		MainClass.getPlayer();
		Player.getInv().reloadInventory();
	}
	
	public void sellItem(){
		this.removePlayerItem();
		MainClass.getPlayer();
		Player.getInv().reloadInventory();
		MainClass.getPlayer().setCurrentGold(MainClass.getPlayer().getCurrentGold() + this.getValue());
	}

	public Image getItemImage() {
		return itemImage;
	}

	public void setItemImage(Image itemImage) {
		this.itemImage = itemImage;
	}
	
	public InventoryClass getInvClass(){
		return invClass;
	}

	@SuppressWarnings("serial")
	public class InventoryClass extends ImageShowingComponent{
		boolean click;
		
		InventoryClass(){
		}
		
		public InventoryClass(Image i){
			this.setImage(i);
			this.setPreferredSize(this.getPreferredSize());
			this.setMaximumSize(this.getPreferredSize());
			this.setLayout(new GridLayout(1,1));
			this.setOpaque(true);
			this.setVisible(true);

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
	  
	  
	  
	  @Override
		public void mousePressed(MouseEvent arg0) {
		  click = true;
		  checkClick();
		}
	  
	  @Override
		public void mouseReleased(MouseEvent arg0) {
			click = false;			
		}
	  
	  private void checkClick(){
		  if (click){
			  //System.out.println(mc);
			  if (getItemName() != "Items.Item"){
				  //use item in the inventory
				  if(SwingUtilities.getAncestorNamed("playerMainInventory", this) != null){
					 if(MainClass.isStoreOpen()){
						 //System.out.println("store open");
						 sellItem();
					 }else{
						 useItem();
					 }
				  }else if(SwingUtilities.getAncestorNamed("storeMainInventory", this) != null){
					  //useItem();
					  buyItem();
					  //System.out.println("in the store");
				  }
				  //System.out.println(SwingUtilities.getAncestorNamed("playerMainInventory", this));
				  click = false;
			  }
		  }
	  }
	}
	
}
