package MainFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JPanel;

import Characters.Character;
import Characters.Monster;
import Characters.NPC;
import Characters.Player;
import Characters.ShopKeep;
import Maps.TheMap;
import Maps.firstMap;
import Maps.secondMap;
import Tiles.Tiles;

public class MapHandler extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HashMap<Integer, TheMap> maps;
	private Monster[] monsters;
	private NPC[] npcs;
	private int curMap=1;
	private int maxMon=10;
	private int maxNPC=2;
	public boolean checkXP;
	private MainClass main;
	private Player play;
	public Tiles blankTile;
	
	GridBagConstraints c = new GridBagConstraints();
	
	public MapHandler(MainClass mc){
		
		main = mc;
		play = MainClass.getPlayer();
		blankTile = new Tiles(main);
		
		//set up panel
		Dimension preferedSize = new Dimension(800, 600);
		this.setPreferredSize(preferedSize);
		this.setMinimumSize(preferedSize);
		this.setMaximumSize(preferedSize);
		this.setOpaque(true);
		this.setBackground(Color.black);
		this.setLayout(new GridBagLayout());
		
		
		checkXP = false;
		
		maps = new HashMap<Integer, TheMap>();
		monsters =new Monster[maxMon];
		setNpcs(new NPC[maxNPC]);
		
		//implement maps
		firstMap fM = new firstMap(main);
		maps.put(1, fM);
		
		secondMap sM = new secondMap(main);
		maps.put(2, sM);
		
		//start map
		this.setCurMap(1, mc);
		//add pc
		maps.get(curMap).theTile[16][12].setChar1(play);
			play.setCurTileX(16);
			play.setCurTileY(12);
			updateCamera(play);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	public void update(MainClass main)
	{
		if (checkXP == true){
			while(MainClass.getPlayer().currentXPToLevel() <= 0){
				MainClass.getPlayer().levelUp();
			}
			checkXP = false;
			play.setCMove(true);
		}
		
		//player input
		play.runMap(main);
		if (play.getCMove() == true){
			checkForCollsion(play);
			for (int i = 0; i < maxMon; i++){
				if (getMonster(i) != null && getMonster(i).getAlive() == true){
					getMonster(i).update(play, this, main);
				}
			}
			play.setCMove(false);
		}	
	}

	public void checkForCollsion(Character c) {
		main.setMovable(false);
		int newTileX = c.getCurTileX();
		int newTileY = c.getCurTileY();
		Tiles thisTile = maps.get(curMap).getTile(newTileX, newTileY);
		
		if(newTileX != c.getLastX() || newTileY != c.getLastY()){
			//check if there is another character in the space
			if (thisTile.getChar1() != null){
				if (thisTile.getChar1() instanceof Monster && c instanceof Player){
					main.setMonster((Monster) thisTile.getChar1());
					main.setEncounter(new Encounter(main, this, play, main.getMonster()));
					main.getEncounter().shuffleDecks(play, main.getMonster());
					main.setScreen("Encounter");
				}
				else if (thisTile.getChar1() instanceof Player && c instanceof Monster){
					main.setMonster((Monster) c);
					main.setEncounter(new Encounter(main, this, play, main.getMonster()));
					main.getEncounter().shuffleDecks(play, main.getMonster());
					main.setScreen("Encounter");
				}
				if (thisTile.getChar1() instanceof ShopKeep && c instanceof Player){
					((ShopKeep) thisTile.getChar1()).getSInventory().turnOnFrame();
					Player.getInv().turnOnFrame();
				}
				c.setCurTileX(c.getLastX());
				c.setCurTileY(c.getLastY());
			}
			//see if character in on an exit tile
			else if (thisTile.isExitTile()){
				if (c.getCExit()){
					int enteranceTileX = thisTile.getExitTileNumberX();
					int enteranceTileY = thisTile.getExitTileNumberY();
					for (int i = 0; i < maxMon; i++){
						if (getMonster(i) != null){
							getMonster(i).setAlive(false);
							maps.get(curMap).getTile(getMonster(i).getCurTileX(), getMonster(i).getCurTileY()).clearChar1();
						}
					}
					setCurMap(thisTile.getExitMap(), main);
					maps.get(curMap).getTile(enteranceTileX, enteranceTileY).setChar1(c);
					c.setCurTileX(enteranceTileX);
					c.setCurTileY(enteranceTileY);
					updateCamera(play);
				}
				else{
					c.setCurTileX(c.getLastX());
					c.setCurTileY(c.getLastY());
				}
			}
			//check if character is running into a wall
			else if (thisTile.getbCollision()){
				c.setCurTileX(c.getLastX());
				c.setCurTileY(c.getLastY());
			}
			//character can move
			else{
				maps.get(curMap).getTile(newTileX, newTileY).setChar1(c);
				maps.get(curMap).getTile(c.getLastX(), c.getLastY()).clearChar1();
				if(c instanceof Player){
					updateCamera((Player) c);
				}
			}
		}
		main.setMovable(true);
	}
	
	public int getCurMap() {
		return curMap;
	}
	
	public void setCurMap(int cm, MainClass main) {
		this.curMap = cm;
		this.maps.get(curMap).reset();
		this.removeAll();
		maps.get(curMap).onLoad(this, main);
		updateCamera(MainClass.getPlayer());
		this.revalidate();
	}
	
	public void updateCamera(Player play){
		this.removeAll();
		int playerI, playerJ;
		for(int i = 0; i < 24; i++){
			for(int j = 0; j < 32; j++){
				playerI = play.getCurTileY()+i-12;
				playerJ = play.getCurTileX()+j-16;
				if(playerI > -1 && playerI < maps.get(curMap).getHeight() && playerJ >= 0 && playerJ < maps.get(curMap).getWidth()){
					//System.out.println("i: " + i + " j: " + j + " true");
					c.gridx = j;
					c.gridy = i;
					c.gridwidth =1;
					c.gridheight = 1;
					
					//System.out.println(j + " " + i + " " + maps.get(curMap).theTile[j][i]);
					this.add(maps.get(curMap).theTile[playerJ][playerI].tileClass, c);
					//System.out.println(i);
				}else{
					//System.out.println("i: " + i + " j: " + j + " False");
					c.gridx = j;
					c.gridy = i;
					c.gridwidth =1;
					c.gridheight = 1;
					
					this.add(new Tiles(main).tileClass, c);
				}
			}
		}
		this.revalidate();
	}
	
	public void setMonster(int i, Monster m){
		monsters[i] = m;
	}
	
	public Monster getMonster(int i){
		return this.monsters[i];
	}
	
	public TheMap getTheMap(){
		return maps.get(curMap);
	}

	public int getMaxMon() {
		return maxMon;
	}

	public NPC[] getNpcs() {
		return npcs;
	}

	public void setNpcs(NPC[] npcs) {
		this.npcs = npcs;
	}

	public void setNPC(int i, NPC m){
		getNpcs()[i] = m;
	}
	
	public NPC getNPC(int i){
		return this.npcs[i];
	}

}
