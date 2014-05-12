package MainFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Cards.Cards;
import Cards.Deck;
import Characters.Monster;
import Characters.Player;
import EncounterHandler.MonsterTurn;
import EncounterHandler.PlayerAttack;
import EncounterHandler.PlayerEnergy;
import EncounterHandler.PlayerHand;
import EncounterHandler.ResolveClicks;


@SuppressWarnings("serial")
public class Encounter extends JPanel{
//declare variables
		//Encounter turn variables
		public int deckPlace = 0;
		public Color activeColor;
		public Color passiveColor;
		public Color energyColor;
		public Color attackColor;
	
		//turn variables
		public int cardsPerTurn;
		public int activeArea = 0;
		private int handClick;
		private int keyPress;
		
		private boolean draw = false;
		private boolean attackResolution = false;
		public boolean monsterTurn = false;
		
		
		//board classes
		public PlayerHand ph;
		public PlayerEnergy pe;
		public PlayerAttack pa;
		public ResolveClicks rc;
		public Player p;
		public Monster m;
		private MainClass main;
		
		//player & monster variables
		Cards[] theDeck;
		Deck deck = new Deck();
		public boolean win = false;
		public boolean loose = false;
		public boolean eMouseHandler = true;
		
		Cards[] mDeck;
		
		//image files
		private BufferedImageLoader il;
		
		public Image blankCard;
		private Image blankBuff;
		public Image playerImage;
		public Image monsterImage;
		public Image monsterAttackImage;
		public Image completeImage;
		private Image youWin;
		private Image youLose;
		
		
		//private Image plusAttack;
		public Image turnComplete;
		public Image nextTurn;
		
		//status image variables
		public Image turnOver;
		public String mType;
		
		public Encounter (MainClass mc, MapHandler mh, Player pc, Monster monster)
		{
			
			Dimension preferedSize = new Dimension(800, 600);
			this.setPreferredSize(preferedSize);
			this.setMinimumSize(preferedSize);
			this.setMaximumSize(preferedSize);
			this.setOpaque(false);
			this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
			
			//initialize variables
			activeColor = new Color(176,196,220);
			passiveColor = new Color(220,220,220);
			energyColor = passiveColor;
			attackColor = passiveColor;
			setActiveArea(1);
			
			ph = new PlayerHand();
			pe = new PlayerEnergy();
			pa = new PlayerAttack();
			rc = new ResolveClicks();
			p = pc;
			m = monster;
			main = mc;

			//load character images
			playerImage = p.getEImage();
			monsterImage = m.getEImage();
			

			
			//load in images
				il = new BufferedImageLoader();
				
				blankCard = il.loadImage("/Resources/blankCard.jpg");
				blankBuff = il.loadImage("/Resources/blankBuff.jpg");
				turnComplete = il.loadImage("/Resources/turnOver.jpg");
				nextTurn = il.loadImage("/Resources/nextTurn.jpg");
				completeImage = il.loadImage("/Resources/Complete.png");
				youWin = il.loadImage("/Resources/YouWin.png");
				youLose = il.loadImage("/Resources/YouLose.png");
			
			
			//initialize turn image
			turnOver = turnComplete;
			
		}
		
		public void update(MainClass mc, MapHandler lh, Monster m, Player pc)
		{
		 
		 //System.out.println("inside encounter"); //debug
		 
		 if (win == false && loose == false)
		 {
			 
		 //Player's turn
		 if (turnOver == turnComplete){ 
			// System.out.println("Players turn"); //debug
			 monsterAttackImage = null;
			 
			 // check which play area is active
			 if (getActiveArea() == 1){
				 energyColor = activeColor;
				 attackColor = passiveColor;
			 }
			 else if (getActiveArea() == 2){
				 attackColor = activeColor;
				 energyColor = passiveColor;
			 }
			 else{
				 attackColor = passiveColor;
				 energyColor = passiveColor;
			 }
			 
			 // draw cards
			 if (draw == false)
			 {
				 //System.out.println("draw new cards"); //debug
				 ph.drawCard(mc, pc, this);
				 setActiveArea(1);
				 draw = true;
			 }
			 
			 if (mc.clicked == true){
				 rc.rc(this, mc);
				 mc.setMovable(true);
			 }
			 monsterTurn = false;
			 //end of player's turn
		 }
		 }
		 
		 if (win == false && loose == false)
		 {
		 //enemy's turn
		 if (turnOver == nextTurn)
		 {
			 
			 //resolve Player turn
			 energyColor = passiveColor;
			 attackColor = passiveColor;
			 
			 if (attackResolution == false)
			 {
				//System.out.println("resolving attack"); //debug
				pa.resolveDamage(m, pc, this, theDeck, deck);
				pe.energyEndTurn(p);
				pa.attackEndTurn(p);
				attackResolution = true;
			 }
		 
	//monster's turn
		 if (win == false && loose == false)
		 { 
			 if (monsterTurn == false){
				MonsterTurn mt = new MonsterTurn();
				mt.resolveMonsterTurn(this, m, pc);
				//System.out.println("monsters turn"); //debug
				monsterTurn = true;
			 }
			 draw = false;
			 //System.out.println(draw);
			 if (mc.clicked == true){
				// System.out.println("next turn");
				 rc.mt(mc.getXPos(), mc.getYPos(), this, mc);
			 }
			//end monster's turn
		 }}
	}
		if (win==true)
		 {
			//System.out.println("you win");
			 monsterImage = completeImage;
			 //pc.resetHP();
			rc.wc(mc, this);
		 }
		 if (loose == true)
		 {
			//System.out.println("you lose");
			 playerImage = completeImage;
			 pc.resetHP();
			 //mc.setScreen("Map");
		 }
		 
		}
		
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			
			//System.out.println("Painting encounter");
			
			g.drawImage(playerImage, 100, 40, 200, 200, main);
			g.drawImage(monsterImage, 500, 40, 200, 200, main);
			g.drawImage(monsterAttackImage, 300, 40, main);
			
			//Draw Areas
			g.setColor(energyColor);
			g.fillRect(40, 285, 250, 190);
			g.setColor(attackColor);
			g.fillRect(295, 285, 250, 190);
			g.setColor(Color.black);
			g.drawString("Energy: " + p.getCurrentEnergy(), 50, 300);
			g.drawString("Attacks: " + p.getCurrentAttack(), 300, 300);
			
			//Area Handlers
			pe.drawEnergyHandler(this, g, main);
			pa.drawAttackHandler(this, g, main);
			ph.drawHandHandler(this, g, main);

			
			//buffs
			g.drawString("Buffs", 550, 300);
			g.drawImage(blankBuff, 550, 320, main);
			g.drawImage(blankBuff, 600, 320, main);
			g.drawImage(blankBuff, 650, 320, main);
			g.drawImage(blankBuff, 700, 320, main);
			
			//items
			g.drawString("Items", 550, 400);
			g.drawImage(blankBuff, 550, 420, main);
			g.drawImage(blankBuff, 600, 420, main);
			g.drawImage(blankBuff, 650, 420, main);
			g.drawImage(blankBuff, 700, 420, main);
			
			//Opponent Stats Display
			g.setColor(Color.WHITE);
			g.drawString("HP: " + m.getCurrentHP() + " of " + m.getTotalHP(), 700, 55);
			
			//turn over
			g.drawImage(turnOver, 680,255, main);
			
			if (win == true){
				g.drawImage(youWin, 300, 40, main);
			}
			if (loose == true){
				g.drawImage(youLose, 300, 40, main);
			}
			
		}

		public void shuffleDecks(Player p, Monster m){
			p.shuffleDeck();
			m.shuffleDeck();
		}
		
		public void setHandClick(int i){
			this.handClick = i;
		}
		
		public int getHandClick(){
			return this.handClick;
		}

		public Image getTurnOver(){
			return this.turnOver;
		}
		
		public void changeTurnOver(Image i){
			if (i == turnComplete)
			{
				turnOver = nextTurn;
				attackResolution = false;
				activeArea = 0;
				//System.out.println("change turns");
			}
			else
			{
				turnOver = turnComplete;
			}
		}
		
		public int getActiveArea(){
			return this.activeArea;
		}
		
		public void setActiveArea(int i){
			this.activeArea = i;
		}
		
		public int getDeckPlace(){
			return this.deckPlace;
		}
		
		public void setDeckPlace(int i){
			this.deckPlace = i;
		}
		
		public void nextDeckPlace(){
			this.deckPlace++;
		}
		
		public void setWinCondition(boolean p, boolean m){
			if (p == false){
				this.loose = true;
			}
			else if(m == false){
				this.win = true;
			}
			else{
				this.loose = false;
				this.win = false;
			}
		}
		
		public void setKeyPress(int i){
			this.keyPress = i;
		}
		
		public int getKeyPress(){
			return this.keyPress;
		}
}