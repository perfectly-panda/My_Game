package Characters;

import java.awt.Image;

import Cards.Cards;
import MainFiles.BufferedImageLoader;
import MainFiles.ImageShowingComponent;



public class Character {

	//location
		private int curTileX= 0;
		private int curTileY= 0;
		private int lastX = 1;
		private int lastY = 1;
		
	//stats
		private String name;
		private int	currentHP;
		private int totalHP;
		private int attack;
		private int defence;
		private boolean alive;
		private Cards[] deck;
		private int level;
		
	//turn variables
		private int currentEnergy;
		private int currentAttack;
		private int currentDefence;

	//map checks
		private boolean cMove;
		private boolean cExit;
		public CharClass charClass;
		public CharEncounterClass charEncClass;
	
	//spot on spriteSheet
	
		private int topSpriteX;
		private int topSpriteY;
		private int bottomSpriteX;
		private int bottomSpriteY;
		private Image spriteSheet;
		
	//encounter Image
		private Image eImage;
		private BufferedImageLoader il = new BufferedImageLoader();
	
	public int getLastX() {
		return lastX;
	}
	
	public void setLastX(int last) {
		this.lastX = last;
	}
	
	public int getLastY() {
		return lastY;
	}
	
	public void setLastY(int last) {
		this.lastY = last;
	}
	
	public int getCurTileX(){
		return curTileX;
	}
	
	public void setCurTileX(int i){
		this.curTileX = i;
	}
	
	public int getCurTileY(){
		return curTileY;
	}
	
	public void setCurTileY(int i){
		this.curTileY = i;
	}
	
	public int getCurrentHP(){
		return this.currentHP;
	}
	
	public void setCurrentHP(int i){
		this.currentHP = i;
	}
	
	public int getTotalHP(){
		return this.totalHP;
	}
	
	public void setTotalHP(int i){
		this.totalHP = i;
	}
	
	public int getAttack(){
		return this.attack;
	}
	
	public void setAttack(int i){
		this.attack = i;
	}
	
	public int getDefence(){
		return this.defence;
	}
	
	public void setDefence(int i){
		this.defence = i;
	}
	
	public boolean getAlive(){
		return this.alive;
	}
	
	public void setAlive(boolean b){
		this.alive = b;
	}
	
	public int getTopSpriteX(){
		return topSpriteX;
	}
	
	public void setTopSpriteX(int i){
		this.topSpriteX = i;
	}
	
	public int getTopSpriteY(){
		return topSpriteY;
	}
	
	public void setTopSpriteY(int i){
		this.topSpriteY = i;
	}
	
	public int getBottomSpriteX(){
		return bottomSpriteX;
	}
	
	public void setBottomSpriteX(int i){
		this.bottomSpriteX = i;
	}
	
	public int getBottomSpriteY(){
		return bottomSpriteY;
	}
	
	public void setBottomSpriteY(int i){
		this.bottomSpriteY = i;
	}
	
	public Image getSpriteSheet(){
		return spriteSheet;
	}
	
	public void setSpriteSheet(Image ssn){
		this.spriteSheet = ssn;
	}
	
	public Image getEImage(){
		return this.eImage;
	}
	
	public void setEImage(String s){
		eImage = il.loadImage(s);
	}
	
	public boolean getCMove(){
		return cMove;
	}
	
	public void setCMove(boolean move){
		this.cMove = move;
	}
	
	public boolean getCExit(){
		return cExit;
	}
	
	public void setCExit(boolean b){
		this.cExit = b;
	}
	
	public CharClass getCharClass(){
		return charClass;
	}
	
	public void moveDown(){
		this.setLastX(this.getCurTileX());
		this.setLastY(this.getCurTileY());
		this.setCurTileY(this.getCurTileY()+1);
	}
	
	public void moveUp(){
		this.setLastX(this.getCurTileX());
		this.setLastY(this.getCurTileY());
		this.setCurTileY(this.getCurTileY()-1);
		if (this.getCurTileY()< 0){this.setCurTileY(0);}
	}
	
	public void moveRight(){
		this.setLastX(this.getCurTileX());
		this.setLastY(this.getCurTileY());
		this.setCurTileX(this.getCurTileX()+1);
	}
	
	public void moveLeft(){
		this.setLastX(this.getCurTileX());
		this.setLastY(this.getCurTileY());
		this.setCurTileX(this.getCurTileX()-1);
		if (this.getCurTileX()< 0){this.setCurTileX(0);}
	}
	
	public void takeDamage(int d)
	{
		if (d >= 0)
		{
			if (d >= this.getCurrentHP())
			{
				this.setCurrentHP(0);
				this.setAlive(false);
			}
			else
			{
				this.setCurrentHP(this.getCurrentHP()-d);
			}
		}
	}
	
	public void resetHP (){
		this.setCurrentHP(this.getTotalHP());
	}
	
	public void shuffleDeck()
	{
		Cards temp;
		for (int i=1; i<1000; i++)
		{
			int randomInt1 = (int) (Math.random()*(this.getDeckSize()-1));
			int randomInt2 = (int) (Math.random()*(this.getDeckSize()-1));
			//System.out.println(randomInt1); //debug
			temp = this.deck[randomInt1];
			this.deck[randomInt1] = this.deck[randomInt2];
			this.deck[randomInt2] = temp;		
		}
	}
	
	public int getDeckSize()
	{
		int size = this.deck.length;
		//System.out.println(size);
		return size;
	}
	
	public void createDeck(int i){
		this.deck = new Cards[i];
	}
	
	public void setCard(int i, Cards c){
		this.deck[i] = c;
	}
	
	public Cards[] getDeck(){
		return this.deck;
	}
	
	public Image getDeckImage(int i){
		return this.deck[i].getCardImage();
	}
	
	public int getCardDamage(int i){
		return this.deck[i].getCardDamage();
	}
	
	public Cards getCard(int i){
		return this.deck[i];
	}
	
	public int getCurrentEnergy(){
		return this.currentEnergy;
	}
	
	public void setCurrentEnergy(int i){
		this.currentEnergy = i;
	}
	
	public int getCurrentAttack(){
		return this.currentAttack;
	}
	
	public void setCurrentAttack(int i){
		this.currentAttack = i;
	}
	
	public int getCurrentDefence(){
		return this.currentDefence;
	}
	
	public void setCurrentDefence(int i){
		this.currentDefence = i;
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public void setLevel(int i){
		this.level = i;
	}
	public void nextLevel(){
		this.level++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void update(){
		
	}

	@SuppressWarnings("serial")
	public class CharClass extends ImageShowingComponent {
		CharClass(Image i){
			this.setImage(i);
			this.setOpaque(false);
		}
	}
	
	@SuppressWarnings("serial")
	public class CharEncounterClass extends ImageShowingComponent {
		CharEncounterClass(Image i){
			this.setImage(i);
			this.setOpaque(false);
		}
	}
}
