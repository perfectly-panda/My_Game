package BottomBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import MainFiles.MainClass;

@SuppressWarnings("serial")
public class BottomBar extends JPanel {
	
	Image background;
	
	public BottomBar(MainClass mc){
		background = mc.getBIL().loadImage("/Resources/diffuse.png");
		
		this.setBackground(Color.YELLOW);
		Dimension preferedSize = new Dimension(1000,100);
		this.setPreferredSize(preferedSize);
		this.setMinimumSize(preferedSize);
		this.setMaximumSize(preferedSize);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
	}
	/*
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		//inventory display
		
		//g.drawImage(mc.inv.getInventorySlot(0).getItemImage(), 25, 625, 65, 65,  mc);
		g.setColor(Color.WHITE);
		for(int i = 0; i < 6; i++){
			String s = String.valueOf(mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack());
			
			g.drawImage(mc.getPlayer().getInv().getInventorySlot(i).getItemImage(), 25 + (i*85), 625, 65, 65,  mc);
			if (mc.getPlayer().getInv().getInventorySlot(i).getCurrentStack() != 0){
				g.drawString(s, 75 + (i * 85), 640);
			}
		}

		
	}*/
	
	public void update(MainClass mc){
		
		int x = mc.getXPos();
		int y = mc.getYPos();
		
		//System.out.println(x + " " + y);
		
		for(int i = 0; i < 6; i++){
			if(x >= 25 + (i*85) && x <= 90 + (i*85) && y >= 625 && y <= 690 && mc.clicked == true){
				mc.getPlayer().getInv().getInventorySlot(i).useItem(mc, mc.getPlayer().getInv().getInventorySlot(i));
				mc.clicked = false;
				//System.out.println("clicked inventory 1" + x + " " + y);
			}
		}
	}
}
