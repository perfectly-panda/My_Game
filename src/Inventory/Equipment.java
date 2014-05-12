package Inventory;

import java.util.HashMap;

import Items.Item;

public class Equipment extends Inventory{

	HashMap<String, Item> equipmentSlots;
	
	public Equipment(){
		equipmentSlots = new HashMap<String, Item>();
	}
	
}
