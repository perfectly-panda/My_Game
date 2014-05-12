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
		inventory = new JPanel[MainClass.getPlayer().getInv().getInventorySize()];
		this.setBackground(Color.YELLOW);
		Dimension preferedSize = new Dimension(1000,100);
		this.setPreferredSize(preferedSize);
		this.setMinimumSize(preferedSize);
		this.setMaximumSize(preferedSize);
		this.setOpaque(false);
		//this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 85, 0));

	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);		
	}
	
	public void update(MainClass mc){

	}

		 
}
