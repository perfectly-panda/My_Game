package MainFiles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JPanel;

import Characters.Character;
import Characters.Monster;
import Characters.Player;
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
	//private NPC[] npcs;
	private int curMap=1;
	private int maxMon=10;
	//private int maxNPC=2;
	public boolean checkXP;
	private MainClass main;
	private Player play;
	
	GridBagConstraints c = new GridBagConstraints();
	
	public MapHandler(MainClass mc){
		
		main = mc;
		play = main.getPlayer();
		//set up panel
		Dimension preferedSize = new Dimension(800, 600);
		this.setPreferredSize(preferedSize);
		this.setMinimumSize(preferedSize);
		this.setMaximumSize(preferedSize);
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());
		
		
		checkXP = false;
		
		maps = new HashMap<Integer, TheMap>();
		monsters = new Monster[maxMon];
		//npcs = new NPC[maxNPC];
		
		//implement maps
		firstMap fM = new firstMap(main);
		maps.put(1, fM);
		
		secondMap sM = new secondMap(main);
		maps.put(2, sM);
		
		//start map
		this.setCurMap(1, mc);
		//add pc
		maps.get(curMap).theTile[52].setChar1(play);
			play.setCurTile(52);
		
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	
	public void update(MainClass main)
	{
		if (checkXP == true){
			while(main.getPlayer().currentXPToLevel() <= 0){
				main.getPlayer().levelUp();
			}
			checkXP = false;
			play.setCMove(true);
		}
		
		//player input
		play.runMap(main);
		if (play.getCMove() == true){
			checkForCollsion(play);
			System.out.println(play.getCurTile());
			for (int i = 0; i < maxMon; i++){
				if (monsters[i] != null && monsters[i].getAlive() == true){
					monsters[i].update(play, this, main);
				}
			}
			play.setCMove(false);
		}	
	}

	public void checkForCollsion(Character c) {
		main.setMovable(false);
		int newTile = c.getCurTile();
		Tiles thisTile = maps.get(curMap).getTile(newTile);
		
		if(newTile != c.getLast()){
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
				c.setCurTile(c.getLast());
			}
			//see if character in on an exit tile
			else if (thisTile.isExitTile()){
				if (c.getCExit()){
					int enteranceTile = thisTile.getExitTileNumber();
					for (int i = 0; i < maxMon; i++){
						if (monsters[i] != null){
							monsters[i].setAlive(false);
							maps.get(curMap).getTile(monsters[i].getCurTile()).clearChar1();
						}
					}
					setCurMap(thisTile.getExitMap(), main);
					maps.get(curMap).getTile(enteranceTile).setChar1(c);
					c.setCurTile(enteranceTile);
				}
				else{
					c.setCurTile(c.getLast());
				}
			}
			//check if character is running into a wall
			else if (thisTile.getbCollision()){
				c.setCurTile(c.getLast());
			}
			//character can move
			else{
				maps.get(curMap).getTile(newTile).setChar1(c);
				maps.get(curMap).getTile(c.getLast()).clearChar1();
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
		for(int j = 0; j<24; j++){
			for (int i = 0; i<32; i++){
				c.gridx = i;
				c.gridy = j;
				c.gridwidth =1;
				c.gridheight = 1;
				this.add(maps.get(curMap).theTile[i + (j*32)].tileClass, c);
				//System.out.println(i);
			}
		}
		this.revalidate();
	}
	
	public void setMonster(int i, Character m){
		this.monsters[i] = (Monster) m;
	}
	
	public Monster getMonster(int i){
		return this.monsters[i];
	}
	
	public TheMap getTheMap(){
		return maps.get(curMap);
	}

}
