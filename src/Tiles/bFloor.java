package Tiles;

import MainFiles.MainClass;

public class bFloor extends Tiles{
	public bFloor (MainClass mc){
		bName = "floor";
		bCollision = false;
		bInside = true;
		this.block = mc.getMapTiles().getSubimage(75, 0, 25, 25);
		tileClass = new TileClass(block);
		//System.out.println(tileClass);
	}
	
}
