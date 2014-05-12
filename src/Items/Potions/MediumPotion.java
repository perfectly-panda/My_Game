package Items.Potions;

import Items.Item;

public class MediumPotion extends BasicHealthPotion{
	public MediumPotion(){
		this.setItemName("Items.Potions.MediumPotion");
		this.setCurrentStack(0);
		this.setMaxStack(99);
		this.setHpReturned(25);
		invClass = new InventoryClass(this.bil.loadImage("../Resources/itemIcons/glitch-icon-70.png"));
		invClass.setToolTipText("<html>Medium Potion<br>HP Returned: 25<br>Cost: 5<br>Resale: 2</html>");
		this.setCost(5);
		this.setValue(2);
	}
	
	public Item copyItem(){
		return new MediumPotion();
	}
}