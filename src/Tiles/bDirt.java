package Tiles;

import MainFiles.MainClass;


public class bDirt extends Tiles {
	
	
	public bDirt (MainClass mc){
		bName = "dirt";
		imgX = 0;
		imgY = 24;
		bCollision = false;
		tileNum = 1;
		this.block = mc.getMapTiles().getSubimage(25, 0, 25, 25);
		tileClass = new TileClass(block);
		//System.out.println(tileClass);
	}
}
