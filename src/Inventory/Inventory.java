package Inventory;

import Items.Item;
import MainFiles.MainClass;

public class Inventory{

	private Item[] slots;
	public MainClass mc;
	
	public Inventory(){}
	
	public Inventory(MainClass main){
		this.setSlots(new Item[6]);
		//System.out.println("inventory constructor");
		this.emptyInventory();
		mc = main;
	}
	
	public Inventory(int i){
		this.setSlots(new Item[i]);
		//System.out.println("inventory constructor");
		this.emptyInventory();
	}
	
	public void emptyInventory(){
		for (int i = 0; i < this.getInventorySize(); i++){
			getSlots()[i] = new Item();
		}
		//System.out.println("inventory created");
	}
	
	public Item getInventorySlot(int i){
		return this.getSlots()[i];
	}
	
	public void setInventorySlot(Item item, int i){
		this.getSlots()[i] = item;
	}
	
	public String getInventorySlotName(int i){
		return this.getSlots()[i].getItemName();
	}
	
	public int getInventorySize(){
		return this.getSlots().length;
	}

	public Item[] getSlots() {
		return slots;
	}

	public void setSlots(Item[] slots) {
		this.slots = slots;
	}
	
	
	

}
