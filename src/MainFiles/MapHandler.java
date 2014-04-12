package MainFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Characters.Character;
import Characters.Monster;
import Characters.NPC;
import Characters.Player;
import Maps.TheMap;
import Maps.firstMap;
import Maps.secondMap;
import Tiles.Tiles;
import Tiles.bDirt;
import Tiles.bGrass;
import Tiles.bStoneBrick;

public class MapHandler extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HashMap<Integer, Tiles> tiles;
	HashMap<Integer, TheMap> maps;
	public Monster[] monsters;
	public NPC[] npcs;
	private int curMap=0;
	private int maxMon=10;
	private int maxNPC=2;
	boolean checkXP;
	MainClass mc;
	Player p;
	
	public MapHandler(MainClass main){
		
		mc= main;
		p = mc.getPlayer();
		//set up panel
		Dimension preferedSize = new Dimension(800, 600);
		this.setPreferredSize(preferedSize);
		this.setMinimumSize(preferedSize);
		this.setMaximumSize(preferedSize);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		
		
		checkXP = false;
		
		maps = new HashMap<Integer, TheMap>();
		tiles = new HashMap<Integer, Tiles>();
		monsters = new Monster[maxMon];
		npcs = new NPC[maxNPC];
		
		//implement tiles
		bStoneBrick bSB = new bStoneBrick();
		tiles.put(0, bSB);
		
		bDirt bD = new bDirt();
		tiles.put(1, bD);
		
		bGrass bG = new bGrass();
		tiles.put(2, bG);
		
		//implement maps
		firstMap fM = new firstMap();
		maps.put(0, fM);
		
		secondMap sM = new secondMap();
		maps.put(1, sM);
		
		//start map
		maps.get(curMap).onLoad(this, mc);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.setColor(getBackground());
       // g.fillRect(0, 0, 800, 600);
		
		int xPos, yPos;
		xPos = 0;
		yPos = 0;
		for (int col = 0; col < maps.get(curMap).getWidth(); col ++)
		{
			for (int row = 0; row < maps.get(curMap).getHeight(); row++)
			{
				g.drawImage(mc.mapTiles, xPos, yPos, xPos + 25, yPos + 25, (maps.get(curMap).getTile(col, row) * 25), 0, ((maps.get(curMap).getTile(col, row) * 25)+ 25), 25, null);
				yPos += 25;
			}
			xPos += 25;
			yPos = 0;
		}
		//render  player
		p.paintMap(g, mc);
		//render monsters
		for (int i = 0; i < maxMon; i++) {
			if (monsters[i] != null && monsters[i].getAlive() == true){
				g.drawImage(monsters[i].getSpriteSheet(), monsters[i].getX(),
						monsters[i].getY(), monsters[i].getX()+25, monsters[i].getY()+25,
						monsters[i].getTopSpriteX(), monsters[i].getTopSpriteY(),
						monsters[i].getBottomSpriteX(), monsters[i].getBottomSpriteY(), null);
			}
		}
		for (int i = 0; i < maxNPC; i++) {
			if (npcs[i] != null && npcs[i].getAlive() == true){
				npcs[i].graphics(g, mc);
				g.drawImage(npcs[i].getSpriteSheet(), npcs[i].getX(),
						npcs[i].getY(), npcs[i].getX()+25, npcs[i].getY()+25,
						npcs[i].getTopSpriteX(), npcs[i].getTopSpriteY(),
						npcs[i].getBottomSpriteX(), npcs[i].getBottomSpriteY(), null);
			}
		}
	}
	
	public void update(Player p, MainClass main)
	{
		if (checkXP == true){
			//System.out.println("xp checked");
			while(main.getPlayer().currentXPToLevel() <= 0){
				main.getPlayer().levelUp();
			}
			checkXP = false;
		}
		//player input
		p.runMap(main);
		if (p.getCMove() == true){
			checkForCollsion(p, main);
		}
		
		//when player moves, the monsters get to move
		if (p.getCMove() == true){
			for (int i = 0; i < maxMon; i++){
				if (monsters[i] != null && monsters[i].getAlive() == true){
					monsters[i].update(p, this, main);
					
					//check for encounter
					if (monsters[i].getX() == p.getX() && monsters[i].getY() == p.getY()){
						//System.out.println("get ready");
						main.setMonster(monsters[i]);
						main.enc = new Encounter(main, this, p, main.m);
						main.enc.shuffleDecks(p, main.m);
						main.setScreen("Encounter");
						checkXP = true;
					}
				}
			}
		}

		
		
		//System.out.println(curMap);
		
	}

	public void checkForCollsion(Character c, MainClass main) {
		
		main.setMovable(false);
		//get player location
		int playerX = (int)(((c.getX())/25));
		int playerY = (int)(((c.getY())/25));
		//get the type that player is trying to move to
		int loc = maps.get(curMap).getTile(playerX, playerY);
		Tiles pTile = tiles.get(loc);
		
		
		//see if player is moving to an exit tile
		if(c.getCExit() == true){
			//System.out.println("its checking exit");
			maps.get(curMap).checkExit(c.getX(), c.getY(), c, this, main);
		}
		
		//check collision and move
		boolean tileCol = pTile.getbCollision();
		//System.out.println(tileCol);
		if (c.getLast() == 1 && tileCol == true)
		{
			c.moveLeft();
			c.setCMove(false);
		}
		
		if (c.getLast() == 2 && tileCol == true)
		{
			c.moveUp();
			c.setCMove(false);
		}
		if (c.getLast() == 3 && tileCol == true)
		{
			c.moveRight();
			c.setCMove(false);
		}
		if (c.getLast() == 4 && tileCol == true)
		{
			c.moveDown();
			c.setCMove(false);
		}
		else{
			c.setCMove(true);
		}
		main.setMovable(true);
	}
	
	public int getCurMap() {
		return curMap;
	}
	
	public void setCurMap(int curMap, MainClass main) {
		this.curMap = curMap;
		maps.get(curMap).onLoad(this, main);
	}
	
	public int mapGrid(int i){
		int newI;
		newI = (i*25);
		return newI;
	}

}
