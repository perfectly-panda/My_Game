package Maps;

import Characters.Bunny;
import Characters.Mouse;
import Items.BasicPotion;
import Items.Inventory;
import MainFiles.MainClass;
import MainFiles.MapHandler;
import Tiles.Tiles;
import Tiles.bDirt;
import Tiles.bGrass;
import Tiles.bStoneBrick;



public class secondMap extends TheMap {

	public secondMap(MainClass mc) {
		mWidth = 32;
		mHeight = 24;
		theTile = new Tiles[mWidth][mHeight];
		reset(mc);
	}
	
	public void reset(MainClass mc){
		int row=0;
			for (int i = 0; i < 32; i++){
				if (i <= 13){
					theTile[i][row]= new bStoneBrick(mc);
					//System.out.println(theTile[i][row]);
				}
				else if (i >= 14&& i <= 17){
					theTile[i][row]=new bGrass(mc);
					theTile[i][row].setExitTile(1, i, 22);
				}
				else if (i >= 18 && i <= 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
				//System.out.println(theTile[i]);
			}
		row = 23;
			for (int i = 0; i< 32; i++){
				if (i <= 13){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=14 && i <= 17){
					theTile[i][row]=new bGrass(mc);
					theTile[i][row].setExitTile(1, i, 1);
				}
				else if (i >= 18 && i <= 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
			}

			
		row = 1;	
			for (int i = 0; i< 32; i++){
				if (i == 0){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=1 && i <= 30){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i == 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
			}
		
		row = 2;
			for (int i = 0; i< 32; i++){
				if (i == 0){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=1 && i <= 30){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i == 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
			}			
		row = 3;
			for (int i = 0; i< 32; i++){
				if (i == 0){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=1 && i <= 30){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i == 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
			}			
		row = 4;
			for (int i = 0; i< 32; i++){
				if (i == 0){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=1 && i <= 30){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i == 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
			}
		row = 22;
			for (int i = 0; i< 32; i++){
				if (i == 0){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=1 && i <= 30){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i == 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
			}
		row = 21;
			for (int i = 0; i< 32; i++){
				if (i == 0){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=1 && i <= 30){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i == 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
			}
		row = 20;
			for (int i = 0; i< 32; i++){
				if (i == 0){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=1 && i <= 30){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i == 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
			}
		row = 19;
			for (int i = 0; i< 32; i++){
				if (i == 0){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=1 && i <= 30){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i == 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
			}
			
		row=5;
			for (int i = 0; i< 32; i++){
				if (i == 0){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=1 && i <= 4){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i>=5&& i <= 13){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=14 && i <= 17 ){
					theTile[i][row]=new bDirt(mc);
				}
				else if (i>=18 && i <= 26){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=27 && i <= 30){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i == 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
			}
		
		row = 18;
			for (int i = 0; i< 32; i++){
				if (i == 0){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=1 && i <= 4){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i>=5&& i <= 13){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=14 && i <= 17 ){
					theTile[i][row]=new bDirt(mc);
				}
				else if (i>=18 && i <= 26){
					theTile[i][row]=new bStoneBrick(mc);
				}
				else if (i>=27 && i <= 30){
					theTile[i][row]=new bGrass(mc);
				}
				else if (i == 31){
					theTile[i][row]=new bStoneBrick(mc);
				}
			}
		
			for (int j = 6; j < 18; j++){
				row = j;
					for (int i = 0; i< 32; i++){
						if (i == 0){
							theTile[i][row]=new bStoneBrick(mc);
						}
						else if (i>=1 && i <= 4){
							theTile[i][row]=new bGrass(mc);
						}
						else if (i>=5 && i <= 5){
							theTile[i][row]=new bStoneBrick(mc);
						}
						else if (i>=6&& i <= 25){
							theTile[i][row]=new bDirt(mc);
						}
						else if (i>=26 && i <= 26){
							theTile[i][row]=new bStoneBrick(mc);
						}
						else if (i>=27 && i <= 30){
							theTile[i][row]=new bGrass(mc);
						}
						else if (i == 31){
							theTile[i][row]=new bStoneBrick(mc);
						}
					}
			}	
			
		for (int i = 0; i < 32; i++){
			for (int j = 0; j < 24; j++){
				theTile[i][j].clearChar1();
			}
		}
	}

	public void onLoad(MapHandler mh, MainClass mc){
		//System.out.println("map 1");
		Inventory inv = new Inventory(1);
		BasicPotion p = new BasicPotion();
		inv.setInventorySlot(p, 0);
		theTile[2][2].setChar1(new Bunny(mc));
			theTile[2][2].getChar1().setCurTileX(2);
			theTile[2][2].getChar1().setCurTileY(2);
			mh.setMonster(0, theTile[2][2].getChar1());
		theTile[10][2].setChar1(new Mouse(mc));
			theTile[10][2].getChar1().setCurTileX(10);
			theTile[10][2].getChar1().setCurTileY(2);
			mh.setMonster(1, theTile[10][2].getChar1());
		//mh.npcs[0] = new ShopKeep(inv, "Bob", mc);
	}
}
