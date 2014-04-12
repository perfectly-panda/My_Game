package Items;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import Items.Item;

public class Inventory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Item[] slots;
	
	public Inventory(){
		this.slots = new Item[6];
		//System.out.println("inventory constructor");
		this.emptyInventory();
	}
	
	public Inventory(int i){
		this.slots = new Item[i];
		//System.out.println("inventory constructor");
		this.emptyInventory();
	}
	
	public void emptyInventory(){
		for (int i = 0; i < this.getInventorySize(); i++){
			slots[i] = new Item();
		}
		//System.out.println("inventory created");
	}
	
	public Item getInventorySlot(int i){
		return this.slots[i];
	}
	
	public void setInventorySlot(Item item, int i){
		this.slots[i] = item;
	}
	
	public String getInventorySlotName(int i){
		return this.slots[i].getItemName();
	}
	
	public int getInventorySize(){
		return this.slots.length;
	}
	
	public String serializeInventory(){
		String serializedObject = "";

		 // serialize the object
		 try {
		     ByteArrayOutputStream bo = new ByteArrayOutputStream();
		     ObjectOutputStream so = new ObjectOutputStream(bo);
		     so.writeObject(this);
		     so.flush();
		     serializedObject = bo.toString();
		 } catch (Exception e) {
		     System.out.println(e);
		     System.exit(1);
		 }
		 String  bytesEncoded = Base64.encode(serializedObject.getBytes());
		 return bytesEncoded;
	}
	
	public Inventory deserializeInventory(String s){
		try {
		     byte b[] = s.getBytes(); 
		     ByteArrayInputStream bi = new ByteArrayInputStream(b);
		     ObjectInputStream si = new ObjectInputStream(bi);
		     Inventory obj = (Inventory) si.readObject();
		     return obj;
		 } catch (Exception e) {
		     System.out.println(e);
		     System.exit(1);
		     Inventory obj = new Inventory();
		     return obj;
		 }
	}

}
