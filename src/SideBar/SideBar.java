package SideBar;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Characters.Player;
import MainFiles.ImageShowingComponent;
import MainFiles.MainClass;

@SuppressWarnings("serial")
public class SideBar extends JPanel{
	
	MainClass mc;
	Image textBox;
	JPanel buttonsCont;
	SideBarControls saveGame;
	SideBarControls loadGame;
	SideBarControls inventory;
	
	
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
		
		//add save game
		saveGame = new SideBarControls(main.getBIL().loadImage("/Resources/SaveGame.png"));
		saveGame.setOpaque(false);
		buttonsCont.add(saveGame);
		saveGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//add load game
		loadGame = new SideBarControls(main.getBIL().loadImage("/Resources/LoadGame.png"));
		loadGame.setOpaque(false);
		buttonsCont.add(loadGame);
		loadGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//add load game
		inventory = new SideBarControls(main.getBIL().loadImage("/Resources/LoadGame.png"));
		inventory.setOpaque(false);
		buttonsCont.add(inventory);
		inventory.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		
		
		
		}
	

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//System.out.println("repainting");
		g.setColor(Color.lightGray);
        g.fillRect(7, 410, 180, 180);
        
		g.setColor(Color.black);
		
		//g.drawImage(textBox, 10, 5, 190, 200, mc);
		g.drawString("Current Level: " + MainClass.getPlayer().getLevel(), 15, 435);
		g.drawString("XP to Level: " + MainClass.getPlayer().currentXPToLevel(), 15, 455);
		
		g.drawString("Attack: " + MainClass.getPlayer().getAttack(), 15, 495);
		g.drawString("Defence: " + MainClass.getPlayer().getDefence(), 15, 515);
		g.drawString("HP: " + MainClass.getPlayer().getCurrentHP() + " of " + MainClass.getPlayer().getTotalHP(), 15, 535);
		g.drawString("Gold: " + MainClass.getPlayer().getCurrentGold(), 15, 575);	
	}
	
	public void update(MainClass mc){
		
		if (saveGame.getClick() == true){
			mc.getWriter().saveGame(mc);
		} else if (loadGame.getClick() == true){
				mc.getReader().loadGame(mc);
		} else if (inventory.getClick() == true){
			Player.getInv().turnOnFrame();
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
