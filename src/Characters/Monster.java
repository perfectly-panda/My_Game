package Characters;

import MainFiles.MainClass;
import MainFiles.MapHandler;

public class Monster extends Character{
	
	private int aggroArea;
	private boolean aggroed;
	private double xpModifier;
	private int gold;
	
	public Monster(){
		
	}
	
	public void createMonster(MainClass mc) {
		this.setAggroArea(0);
		this.setAggroed(false);
		
	}

	
	public int getAggroArea(){
		return aggroArea;
	}
	
	public void setAggroArea(int i){
		this.aggroArea = i;
	}
	
	public boolean getAggroed(){
		return this.aggroed;
	}
	
	public void setAggroed(boolean b){
		this.aggroed = b;
	}
	
	public void checkAggro(MapHandler mh, Player p){		
		/*int ca, upCa, downCa, rightCa, leftCa;
		
		for(int i = 0; i <= getAggroArea(); i++){
			
		}
		
		/*ca = mh.mapGrid(this.getAggroArea()) + 1;
		int pX = p.getX();
		int pY = p.getY();
		int tX = this.getX();
		int tY = this.getY();
		if (pX-tX < ca && pX-tX > -ca && pY-tY < ca && pY-tY > -ca){
			this.setAggroed(true);
		}
		else{
			this.setAggroed(false);
		}
*/
	}
	
	public void update(Player p, MapHandler mh, MainClass mc){
		//System.out.println("monsters turn");
		p.setCMove(false);
		if (this.getAlive()== false){
			this.charClass.setVisible(false);
		}
		
		if (aggroArea != 0){
			
			//check aggro range
			this.checkAggro(mh, p);
			
			//move if not aggroed
			if (this.getAggroed() == false){
				this.regularMove(mh, mc);
			}
				
			//move if aggroed
			else if (this.getAggroed() == true){
				this.aggroMove(p, mh, mc);
			}
		}
		else{
			this.regularMove(mh, mc);
		}
	}
	
	public void regularMove(MapHandler mh, MainClass mc){	
	}
	
	public void aggroMove(Player p, MapHandler mh, MainClass mc){
		//load variables
		int pX = p.getCurTileX();
		int pY = p.getCurTileY();
		int tX = this.getCurTileX();
		int tY = this.getCurTileY();
		
		int randomNum = 1 + (int)(Math.random() * ((2 - 1) + 1));
		int ca = this.getAggroArea() + 1;
		
		//pX-tX < ca && pX-tX > -ca && pY-tY < ca && pY-tY > -ca
		if(pX-tX < ca && pX-tX > 0 && pY-tY < ca && pY-tY > 0){
			if (randomNum == 1){
				this.moveDown();
				this.setAggroed(false);
			}
			else{
				this.moveRight();
				this.setAggroed(false);
			}
		}
		else if(pX-tX < ca && pX-tX > 0 && pY-tY == 0){
				this.moveRight();
				this.setAggroed(false);
		}
		else if(pX-tX < ca && pX-tX > 0 && pY-tY < 0 && pY-tY > -ca){
			if (randomNum == 1){
				this.moveUp();
				this.setAggroed(false);
			}
			else{
				this.moveRight();
				this.setAggroed(false);
			}
		}
		else if(pX-tX == 0 && pY-tY < ca && pY-tY > 0){
			this.moveDown();
			this.setAggroed(false);
		}
		else if(pX-tX == 0 && pY-tY < ca && pY-tY < 0){
			this.moveUp();
			this.setAggroed(false);
		}
		else if(pX-tX < 0 && pX-tX > -ca && pY-tY < ca && pY-tY > 0){
			if (randomNum == 1){
				this.moveDown();
				this.setAggroed(false);
			}
			else{
				this.moveLeft();
				this.setAggroed(false);
			}
		}
		else if(pX-tX < 0 && pX-tX > -ca && pY-tY == 0){
				this.moveLeft();
				this.setAggroed(false);
		}
		else if(pX-tX < 0 && pX-tX > -ca && pY-tY < 0 && pY-tY > -ca){
			if (randomNum == 1){
				this.moveUp();
				this.setAggroed(false);
			}
			else {
				this.moveLeft();
				this.setAggroed(false);
			}
		}
		
		mh.checkForCollsion(this);
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
	
	public double getXpModifier(){
		return this.xpModifier;
	}
	
	public void setXpModifier(double i){
		this.xpModifier = i;
	}
	
	public int calculateXP(){
		int temp = (int)(this.getXpModifier()*this.getLevel());
		return temp;
	}


	public int getGold() {
		return gold;
	}


	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public int getLoot(){
		return this.getGold();
	}
	
	
}
