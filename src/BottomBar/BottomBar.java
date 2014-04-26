package BottomBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Items.Item;
import MainFiles.ImageShowingComponent;
import MainFiles.MainClass;

@SuppressWarnings("serial")
public class BottomBar extends JPanel {
	
	Image background;
	MainClass main;
	InventorySlot[] inventory;
	
	public BottomBar(MainClass mc){
		background = mc.getBIL().loadImage("/Resources/diffuse.png");
		main = mc;
		this.setBackground(Color.YELLOW);
		Dimension preferedSize = new Dimension(1000,100);
		this.setPreferredSize(preferedSize);
		this.setMinimumSize(preferedSize);
		this.setMaximumSize(preferedSize);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 85, 0));
		
		inventory = new InventorySlot[mc.getPlayer().getInv().getInventorySize()];
		
		for(int i = 0; i < 6; i++){
			inventory[i] = new InventorySlot(mc.getPlayer().getInv().getInventorySlot(i), i);
			this.add(inventory[i]);
			inventory[i].setBounds(25 + (i*85), 10, 50, 50);
		}
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);		
	}
	
	public void update(MainClass mc){

		//System.out.println(x + " " + y);
		
		for(int i = 0; i < 6; i++){
			Image curImage = mc.getPlayer().getInv().getInventorySlot(i).getItemImage();
			
			//check if inventory image needs to be updated
			if (inventory[i].getImage() != curImage)
			{
				inventory[i].setImage(curImage);
			}
			
			//check if an inventory item was used
			if(inventory[i].getClick()){
				mc.getPlayer().getInv().getInventorySlot(i).useItem(mc, mc.getPlayer().getInv().getInventorySlot(i));
				inventory[i].setClick(false);
				//System.out.println("clicked inventory 1" + x + " " + y);
			}
		}
	}
	
	
	class InventorySlot extends ImageShowingComponent{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// The image to display
		  private int slotNumber;

		  // Instantiate the panel and perform initialization
		  
		  InventorySlot(Item i, int num){
			  this.addMouseListener(this);
			  this.setImage(i.getItemImage());
			  slotNumber = num;
		  }

		  public void paintComponent(Graphics g) {
			  super.paintComponent(g);
			  g.drawImage(this.getImage(), 0, 0, null);
			  g.setColor(Color.white);
			  String s = String.valueOf(main.getPlayer().getInv().getInventorySlot(slotNumber).getCurrentStack());
					if (main.getPlayer().getInv().getInventorySlot(slotNumber).getCurrentStack() != 0){
						g.drawString(s, 45, 30);
					}
					s = null;
				}
	}
		 
}
