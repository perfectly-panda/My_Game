package Maps;

import Characters.Bunny;
import Characters.Character;
import Characters.Mouse;
import Items.BasicPotion;
import Items.Inventory;
import MainFiles.MainClass;
import MainFiles.MapHandler;
import Tiles.bDirt;
import Tiles.bGrass;
import Tiles.bStoneBrick;



public class secondMap extends TheMap {

	public secondMap(MainClass mc) {
		reset(mc);
		}
		
	public void reset(MainClass mc){
		int row=0;
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i <= 13 + (row * 32)){
				theTile[i]= new bStoneBrick(mc);
			}
			else if (i>=14 + (row * 32) && i <= 17 + (row * 32)){
				theTile[i]=new bGrass(mc);
				theTile[i].setExitTile(1, i + 32*22);
			}
			else if (i >= 18 + (row * 32)&& i <= 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			//System.out.println(theTile[i]);
		}
	row = 23;
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i <= 13 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=14 + (row * 32) && i <= 17 + (row * 32)){
				theTile[i]=new bGrass(mc);
				theTile[i].setExitTile(1, (i - ((row-1)*32)));
			}
			else if (i >= 18 + (row * 32)&& i <= 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
		}

		
	row = 1;	
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i == 0 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=1 + (row * 32) && i <= 30 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i == 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
		}
	
	row = 2;
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i == 0 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=1 + (row * 32) && i <= 30 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i == 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
		}			
	row = 3;
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i == 0 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=1 + (row * 32) && i <= 30 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i == 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
		}			
	row = 4;
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i == 0 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=1 + (row * 32) && i <= 30 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i == 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
		}
	row = 22;
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i == 0 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=1 + (row * 32) && i <= 30 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i == 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
		}
	row = 21;
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i == 0 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=1 + (row * 32) && i <= 30 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i == 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
		}
	row = 20;
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i == 0 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=1 + (row * 32) && i <= 30 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i == 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
		}
	row = 19;
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i == 0 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=1 + (row * 32) && i <= 30 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i == 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);;
			}
		}
		
	row=5;
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i == 0 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=1 + (row * 32) && i <= 4 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i>=5 + (row * 32) && i <= 13 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=14 + (row * 32) && i <= 17 + (row * 32)){
				theTile[i]=new bDirt(mc);
			}
			else if (i>=18 + (row * 32) && i <= 26 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=27 + (row * 32) && i <= 30 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i == 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
		}
	
	row = 18;
		for (int i = (row * 32); i< (row *32 + 32); i++){
			if (i == 0 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=1 + (row * 32) && i <= 4 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i>=5 + (row * 32) && i <= 13 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=14 + (row * 32) && i <= 17 + (row * 32)){
				theTile[i]=new bDirt(mc);
			}
			else if (i>=18 + (row * 32) && i <= 26 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
			else if (i>=27 + (row * 32) && i <= 30 + (row * 32)){
				theTile[i]=new bGrass(mc);
			}
			else if (i == 31 + (row * 32)){
				theTile[i]=new bStoneBrick(mc);
			}
		}
	
		for (int j = 6; j < 18; j++){
			row = j;
				for (int i = (row * 32); i< (row *32 + 32); i++){
					if (i == 0 + (row * 32)){
						theTile[i]=new bStoneBrick(mc);
					}
					else if (i>=1 + (row * 32) && i <= 4 + (row * 32)){
						theTile[i]=new bGrass(mc);
					}
					else if (i>=5 + (row * 32) && i <= 5 + (row * 32)){
						theTile[i]=new bStoneBrick(mc);
					}
					else if (i>=6 + (row * 32) && i <= 25 + (row * 32)){
						theTile[i]=new bDirt(mc);
					}
					else if (i>=26 + (row * 32) && i <= 26 + (row * 32)){
						theTile[i]=new bStoneBrick(mc);
					}
					else if (i>=27 + (row * 32) && i <= 30 + (row * 32)){
						theTile[i]=new bGrass(mc);
					}
					else if (i == 31 + (row * 32)){
						theTile[i]=new bStoneBrick(mc);
					}
				}
		}
		
		for (int i = 0; i < 32*24; i++){
			theTile[i].clearChar1();
		}
}

public void checkExit(int x, int y, Character c, MapHandler mh, MainClass mc)
{
	//System.out.println("x = " + c.getX() + " y = " + c.getY());
	if (y <= 0 && x>= 350 && x <= 425)
	{
		//System.out.println("jump");
		c.setY(550);
		mh.setCurMap(1, mc);
		System.out.println(mh.getCurMap());
	}
	else if (y >= 570 && x>= 350 && x <= 425)
	{
		//System.out.println("jump");
		c.setY(25);
		mh.setCurMap(1, mc);
		//System.out.println(mh.getCurMap());
	}
}

public void onLoad(MapHandler mh, MainClass mc){
	//System.out.println("map 1");
	Inventory inv = new Inventory(1);
	BasicPotion p = new BasicPotion();
	inv.setInventorySlot(p, 0);
	theTile[33].setChar1(new Bunny(mc));
		theTile[33].getChar1().setCurTile(33);
		mh.setMonster(0, theTile[33].getChar1());
	theTile[475].setChar1(new Mouse(mc));
		theTile[475].getChar1().setCurTile(475);
		mh.setMonster(1, theTile[475].getChar1());
	//mh.npcs[0] = new ShopKeep(inv, "Bob", mc);
}
}
