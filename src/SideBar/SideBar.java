package SideBar;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Items.BasicPotion;
import MainFiles.ImageShowingComponent;
import MainFiles.MainClass;

@SuppressWarnings("serial")
public class SideBar extends JPanel{
	
	MainClass mc;
	Image textBox;
	JPanel buttonsCont;
	SideBarControls buyPotion;
	
	
	public SideBar(MainClass main){
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));	
		
		//setup main panel
		Dimension preferedSize = new Dimension(200,600);
		this.setPreferredSize(preferedSize);
		this.setMinimumSize(preferedSize);
		this.setMaximumSize(preferedSize);
		this.setOpaque(false);

		//make a copy of mainclass to use later
		mc = main;
		
		//create the button interface
		buttonsCont = new JPanel();	
		preferedSize = new Dimension(200, 200);
		buttonsCont.setPreferredSize(preferedSize);
		buttonsCont.setLayout(new BoxLayout(buttonsCont, BoxLayout.PAGE_AXIS));
		buttonsCont.setOpaque(false);
		this.add(buttonsCont);
		
		
		//add buy potion
		buyPotion = new SideBarControls(main.getBIL().loadImage("/Resources/buyPotion.png"));
		buyPotion.setOpaque(false);
		buttonsCont.add(buyPotion);
		buyPotion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		
		
		
		}
	

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//System.out.println("repainting");
		g.setColor(Color.lightGray);
        g.fillRect(7, 410, 180, 180);
        
		g.setColor(Color.black);
		g.setFont(mc.myFont2);
		
		//g.drawImage(textBox, 10, 5, 190, 200, mc);
		g.drawString("Current Level: " + mc.getPlayer().getLevel(), 15, 435);
		g.drawString("XP to Level: " + mc.getPlayer().currentXPToLevel(), 15, 455);
		
		g.drawString("Attack: " + mc.getPlayer().getAttack(), 15, 495);
		g.drawString("Defence: " + mc.getPlayer().getDefence(), 15, 515);
		g.drawString("HP: " + mc.getPlayer().getCurrentHP() + " of " + mc.getPlayer().getTotalHP(), 15, 535);
		g.drawString("Gold: " + mc.getPlayer().getCurrentGold(), 15, 575);
		
		//shop
		//g.drawImage(buttons, 10, 400, 180, 162, mc);

		
	}
	
	public void update(MainClass mc){
		int x = mc.getXPos();
		int y = mc.getYPos();

		//System.out.println(x + " " + y);
		
		BasicPotion bp = new BasicPotion();
		
		if(buyPotion.getClick() == true){
			bp.buyItem(mc);
			//System.out.println(x + " " + y);
			buyPotion.setClick(false);
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
	
	class SideBarControls extends ImageShowingComponent{
		
		SideBarControls(Image i){
			this.setImage(i);
			this.setPreferredSize(this.getPreferredSize());
			this.setMaximumSize(this.getPreferredSize());
			this.addMouseListener(this);
		}
	}
}
