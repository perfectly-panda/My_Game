package SideBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Items.BasicPotion;
import MainFiles.MainClass;

@SuppressWarnings("serial")
public class SideBar extends JPanel{
	
	MainClass mc;
	JButton buttons;
	Image textBox;
	
	public SideBar(MainClass main){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));	
		buttons = new JButton("testing");
		//this.add(buttons);
		Dimension preferedSize = new Dimension(200,600);
		this.setPreferredSize(preferedSize);
		this.setMinimumSize(preferedSize);
		this.setMaximumSize(preferedSize);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

		this.setVisible(true);
		mc = main;
		}
	

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//System.out.println("repainting");
		g.setColor(Color.lightGray);
        g.fillRect(10, 5, 180, 200);
        
		g.setColor(Color.black);
		g.setFont(mc.myFont2);
		
		//g.drawImage(textBox, 10, 5, 190, 200, mc);
		g.drawString("Current Level: " + mc.getPlayer().getLevel(), 40, 40);
		g.drawString("XP to Level: " + mc.getPlayer().currentXPToLevel(), 40, 60);
		
		g.drawString("Attack: " + mc.getPlayer().getAttack(), 40, 100);
		g.drawString("Defence: " + mc.getPlayer().getDefence(), 40, 120);
		g.drawString("HP: " + mc.getPlayer().getCurrentHP() + " of " + mc.getPlayer().getTotalHP(), 40, 140);
		g.drawString("Gold: " + mc.getPlayer().getCurrentGold(), 40, 180);
		
		//shop
		//g.drawImage(buttons, 815, 400, 180, 162, mc);

		
	}
	
	public void update(MainClass mc){
		int x = mc.getXPos();
		int y = mc.getYPos();

		//System.out.println(x + " " + y);
		
		BasicPotion bp = new BasicPotion();
		
		if(x >= 815 && x <= 995 && y >= 400 && y <= 454 && mc.clicked == true){
			bp.buyItem(mc);
			//System.out.println(x + " " + y);
			mc.clicked = false;
		}
		else if(x >= 815 && x <= 995 && y >= 454 && y <= 508 && mc.clicked == true){
			//mc.sg.saveGame(mc);
			mc.clicked = false;
		}
		else if(x >= 815 && x <= 995 && y >= 508 && y <= 562 && mc.clicked == true){
			//mc.sg.loadGame(mc);
			mc.clicked = false;
		}
	}
}
