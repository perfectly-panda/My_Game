package Tiles;

import MainFiles.MainClass;

public class bGrass extends Tiles
{
	public bGrass (MainClass mc){
		bName = "grass";
		bCollision = false;
		this.block = mc.getMapTiles().getSubimage(50, 0, 25, 25);
		tileClass = new TileClass(block);
		tileClass.setPreferredSize(tileClass.getPreferredSize());
	}
}
