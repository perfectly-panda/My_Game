package Items.Potions;

import Items.Item;

public class SmallPotion extends BasicHealthPotion{
	public SmallPotion(){
		this.setItemName("Items.Potions.SmallPotion");
		this.setCurrentStack(0);
		this.setMaxStack(99);
		this.setHpReturned(5);
		invClass = new InventoryClass(this.bil.loadImage("../Resources/itemIcons/glitch-icon-70.png"));		
		this.setCost(2);
		this.setValue(1);
		invClass.setToolTipText("<html>Small Potion<br>HP Returned: 5<br>Cost: 2<br>Resale: 1</html>");
	}
	
	public Item copyItem(){
		return new SmallPotion();
	}
}
