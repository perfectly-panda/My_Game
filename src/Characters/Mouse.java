package Characters;

import Cards.Nibble;
import MainFiles.MainClass;
import MainFiles.MapHandler;

public class Mouse extends Monster{
		public Mouse(){}
		
		public void createMonster(int i, int j, MainClass mc) {
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
			
			//set sprite
			this.setTopSpriteX(75);
			this.setTopSpriteY(25);
			this.setBottomSpriteX(99);
			this.setBottomSpriteY(49);
			this.setSpriteSheet(mc.mapTiles);
			
			this.setEImage("/Resources/Mouse.png");
			
			this.setCExit(false);
			
			//set starting location
			this.setX(i);
			this.setY(j);
			
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
					this.setLast(1);
					break;
				case 2: this.moveLeft();
					this.setLast(3);
					break;
				case 3: this.moveUp();
					this.setLast(4);
					break;
				case 4: this.moveDown();
					this.setLast(2);
					break;
				default: break;
			}
			
			mh.checkForCollsion(this, mc);
		}
		
}
