package Characters;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import Cards.Block;
import Cards.Kick;
import Cards.Punch;
import Items.Inventory;
import MainFiles.MainClass;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class Player extends Character implements ActionListener, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int keyPress;
	private int cardsPerTurn;
	private int currentXP;
	private int currentGold;
	private Inventory pInventory;
	
	public Player(MainClass mc){
		this.setTotalHP(25);
		this.setCurrentHP(this.getTotalHP());
		this.setAttack(2);
		this.setDefence(1);
		this.setCardsPerTurn(2);
		this.setAlive(true);
		
		this.setLevel(1);
		this.setCurrentGold(100);
		
		this.setTopSpriteX(0);
		this.setTopSpriteY(24);
		this.setBottomSpriteX(24);
		this.setBottomSpriteY(49);
		this.setSpriteSheet(mc.mapTiles);
		
		this.setEImage("/Resources/Player.png");
		
		this.setCExit(true);
		
		pInventory = new Inventory(6);
		
		createNewDeck();
	}
	
	public void createNewDeck()
	{
		this.createDeck(60);		
		//create the cards themselves
		Punch punch = new Punch();
		Kick kick = new Kick();
		Block block = new Block();
		
		for (int a=0; a<=19; a++)
		{
		this.setCard(a, punch);
		this.setCard(a + 20, kick);
		this.setCard(a + 40, block);
		}
		//System.out.println(d.length);

	}


	public void runMap(MainClass mc) {	
		if (keyPress != 0)
		{
			//System.out.println(keyPress);
			this.setCMove(true);
			
			if (keyPress == 68 || keyPress == 39)
			{
				this.moveRight();
				this.setLast(1);
				keyPress = 0;
			}
			else if (keyPress == 65 || keyPress == 37)
			{
				this.moveLeft();
				this.setLast(3);
				keyPress = 0;
			}
			else if (keyPress == 87 || keyPress == 38)
			{
				this.moveUp();
				this.setLast(4);
				keyPress = 0;
			}
			else if (keyPress == 83 || keyPress == 40)
			{
				this.moveDown();
				this.setLast(2);
				keyPress = 0;
			}
			else {keyPress = 0;}
		}
	}

	public void paintMap(Graphics g, MainClass mc) {
    	g.drawImage(this.getSpriteSheet(), this.getX(), this.getY(), this.getX()+25, this.getY()+25,
    				this.getTopSpriteX(), this.getTopSpriteY(),
    				this.getBottomSpriteX(), this.getBottomSpriteY(), null);
	}
	
	
	public int getKeyPress() {
		return keyPress;
	}
	
	public void setKeyPress(int keyPress) {
		this.keyPress = keyPress;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void setCardsPerTurn(int i){
		this.cardsPerTurn = i;
	}
	
	public int getCardsPerTurn(){
		return this.cardsPerTurn;
	}
	
	public int getCurrentXP(){
		return this.currentXP;
	}

	public void setCurrentXP(int currentXP) {
		this.currentXP = currentXP;
	}
	
	public void addXP(int a){
		this.currentXP= this.currentXP + a;
	}
	
	public void levelUp(){
		this.setCurrentXP(this.getCurrentXP() - this.xpToLevel());
		this.nextLevel();
		this.setAttack(this.getAttack() + 1);
		this.setDefence(this.getDefence() + 1);
		this.setTotalHP(this.getTotalHP() + 5);
		this.resetHP();
	}
	
	public int xpToLevel(){
		int xptl;
		xptl = (int)(Math.exp(this.getLevel())/Math.log(this.getLevel()+1));
		return xptl;
	}
	
	public int currentXPToLevel(){
		return this.xpToLevel() - this.getCurrentXP();
	}

	public int getCurrentGold() {
		return currentGold;
	}

	public void setCurrentGold(int gold) {
		this.currentGold = gold;
		//System.out.println(this.currentGold);
	}

	public void addGold(int gold){
		this.currentGold = this.getCurrentGold() + gold;
		//System.out.println(this.currentGold);
	}
	
	public String serializePlayer(){
		String serializedObject = "";

		 // serialize the object
		 try {
		     ByteArrayOutputStream bo = new ByteArrayOutputStream();
		     ObjectOutputStream so = new ObjectOutputStream(bo);
		     so.writeObject(this);
		     so.flush();
		     serializedObject = bo.toString();
		 } catch (Exception e) {
		     System.out.println(e);
		     System.exit(1);
		 }
		// encrypt data on your side using BASE64
		 String  bytesEncoded = Base64.encode(serializedObject.getBytes());
		 return bytesEncoded;
	}
	
	public Player deserializePlayer(String s, MainClass mc){
		try {

		     byte b[]= Base64.decode(s);
		     //byte b[] = valueDecoded.getBytes(); 
		     ByteArrayInputStream bi = new ByteArrayInputStream(b);
		     ObjectInputStream si = new ObjectInputStream(bi);
		     Player valueDecoded = (Player) si.readObject();
		     System.out.println("player decoded");
		     return valueDecoded;
		 } catch (Exception e) {
			 
			 System.out.println("player not decoded");
		     System.out.println(e);
		     System.exit(1);
		     Player obj = new Player(mc);
		     return obj;
		 }

	}
	
	public Inventory getInv(){
		return pInventory;
	}

	
	
}
