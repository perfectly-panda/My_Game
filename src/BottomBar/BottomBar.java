package BottomBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import MainFiles.MainClass;

@SuppressWarnings("serial")
public class BottomBar extends JPanel {
	
	Image background;
	MainClass main;
	JPanel[] inventory;
	
	public BottomBar(MainClass mc){
		background = mc.getBIL().loadImage("/Resources/diffuse.png");
		main = mc;
		inventory = new JPanel[mc.getPlayer().getInv().getInventorySize()];
		this.setBackground(Color.YELLOW);
		Dimension preferedSize = new Dimension(1000,100);
		this.setPreferredSize(preferedSize);
		this.setMinimumSize(preferedSize);
		this.setMaximumSize(preferedSize);
		this.setOpaque(false);
		//this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 85, 0));
		
		
		for(int i = 0; i < 1; i++){
			inventory[i] = new JPanel();
			inventory[i].setOpaque(false);
			inventory[i].setVisible(true);
			inventory[i].add(mc.getPlayer().getInv().getInventorySlot(i).invClass);
			this.add(inventory[i]);
		}
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);		
	}
	
	public void update(MainClass mc){

		//System.out.println(x + " " + y);
		
		for(int i = 0; i < 1; i++){
			if(mc.getPlayer().getInv().getInventorySlot(i).invClass.getClick()){
				mc.getPlayer().getInv().getInventorySlot(i).useItem(mc);
			}
		}
	}
	
	public void updateItem(int theItem, MainClass mc){
		//System.out.println("updating");
		inventory[theItem].removeAll();
		inventory[theItem].add(mc.getPlayer().getInv().getInventorySlot(theItem).invClass);
		//System.out.println(mc.getPlayer().getInv().getInventorySlot(theItem));
		inventory[theItem].revalidate();
		//this.add(inventory[i].invClass);
		//this.revalidate();
	}
		 
}
