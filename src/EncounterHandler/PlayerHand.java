package EncounterHandler;

import java.awt.Graphics;
import java.awt.Image;

import Cards.Blank;
import Cards.Cards;
import Characters.Character;
import Characters.Player;
import MainFiles.Encounter;
import MainFiles.MainClass;



public class PlayerHand {
	public Cards[] pHand = new Cards[7];
	private Blank b = new Blank();
	
	public PlayerHand(){
		for (int i = 0; i < 7; i++){
			setPlayerHand(i, b);
		}
	}
	public void cardHandler(Encounter e, PlayerEnergy pe, PlayerAttack pa, Character p)
	{
		int n = e.getHandClick();
		if (this.getPlayerHand(n) != b)
		{
			if (e.activeArea == 1)
			{
				pe.addEnergy(this.getPlayerHand(n), p);
				playCard(n);
			}
			if (e.activeArea == 2)
			{
				boolean result = pa.addAttack(this.getPlayerHand(n), p);
				if (result == true)
				{
					playCard(n);
				}
			}	
			
		}
	}
	
	public void playCard(int n)
	{
		for (int i = n; i < 6; i++){
			this.setPlayerHand(i, this.getPlayerHand(i+1));
		}
		this.setPlayerHand(6, b);
		
		//System.out.println(this.getPlayerHand(n).getCardName());
		
	}
	
	public void drawCard (MainClass mc, Player p, Encounter e)
	{
		int cpt = p.getCardsPerTurn();
		//System.out.println("made it into drawCard"); //debug
		for (int i=0; i < cpt; i++){
			if (e.getDeckPlace() <= p.getDeckSize()+1){
				//System.out.println("inside first if"); //debug
				for (int n=0; n<7; n++){
					if (this.getPlayerHand(n) == b){
						this.setPlayerHand(n, p.getCard(e.getDeckPlace()));
						//System.out.println(e.getDeckPlace()); //debug
						e.nextDeckPlace();
						break;
					}
				}
			}
			else{
				System.out.println("out of cards");
			}	
		}
	}
	
	public void drawHandHandler(Encounter e, Graphics g, MainClass mc){
		g.drawImage(this.getHandImage(0), 050, 500, 85, 85, mc);
		g.drawImage(this.getHandImage(1), 150, 500, 85, 85, mc);
		g.drawImage(this.getHandImage(2), 250, 500, 85, 85, mc);
		g.drawImage(this.getHandImage(3), 350, 500, 85, 85, mc);
		g.drawImage(this.getHandImage(4), 450, 500, 85, 85, mc);
		g.drawImage(this.getHandImage(5), 550, 500, 85, 85, mc);
		g.drawImage(this.getHandImage(6), 650, 500, 85, 85, mc);
	}
	
	public void setPlayerHand(int i, Cards c){
		pHand[i] = c;
	}
	
	public Cards getPlayerHand(int i){
		return pHand[i];
	}
	
	public Image getHandImage(int i){
		return pHand[i].getCardImage();
	}

}
