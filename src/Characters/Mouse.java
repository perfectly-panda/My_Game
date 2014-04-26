package Characters;

import Cards.Nibble;
import MainFiles.MainClass;
import MainFiles.MapHandler;

public class Mouse extends Monster{
		public Mouse(){}
		
		public Mouse(MainClass mc){
			createMonster(mc);
		}
		
		public void createMonster(MainClass mc) {
			//set stats
			this.setTotalHP(5);
			this.setCurrentHP(this.getTotalHP());
			this.setAttack(1);
			this.setDefence(0);
			this.setAggroArea(0);
			this.setAlive(true);
			
			//spoils of war
			this.setLevel(1);
			this.setXpModifier(1);
			this.setGold(1);
			
			//create character image class
			this.charClass = new CharClass(mc.getMapTiles().getSubimage(75, 25, 25, 25));
			
			this.setEImage("/Resources/Mouse.png");
			
			this.setCExit(false);
			
			//create deck
			this.createDeck(5);
			createBunnyDeck();
		}
		
		private void createBunnyDeck()
		{
			Nibble cards = new Nibble();
			for (int i = 0; i < 5; i++){
				this.setCard(i, cards);
			}
		}
		
		public void regularMove(MapHandler mh, MainClass mc){
			int randomNum = 1 + (int)(Math.random() * ((15 - 1) + 1));
			
			switch(randomNum){
				case 1: this.moveRight();
					mh.checkForCollsion(this);
					break;
				case 2: this.moveLeft();
					mh.checkForCollsion(this);
					break;
				case 3: this.moveUp();
					mh.checkForCollsion(this);
					break;
				case 4: this.moveDown();
					mh.checkForCollsion(this);
					break;
				default: break;
			}
		}
		
}
