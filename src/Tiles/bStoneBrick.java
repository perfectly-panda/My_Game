package Tiles;

import MainFiles.MainClass;

public class bStoneBrick extends Tiles{
	public bStoneBrick (MainClass mc){
		bName = "stone brick";
		imgX = 0;
		imgY = 0;
		bCollision = true;
		tileNum = 0;
		this.block = mc.getMapTiles().getSubimage(0, 0, 25, 25);
		tileClass = new TileClass(block);
	}
}
