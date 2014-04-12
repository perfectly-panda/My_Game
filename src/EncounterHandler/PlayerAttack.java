package EncounterHandler;


import java.awt.Graphics;
import java.awt.Image;

import Cards.Blank;
import Cards.Cards;
import Cards.Deck;
import Characters.Character;
import MainFiles.Encounter;
import MainFiles.MainClass;

public class PlayerAttack {
	
	Cards[] playerAttack;
	Blank b = new Blank();
	int currentAttack;
	int currentCost;
	
	public PlayerAttack(){
		playerAttack = new Cards[7];
		currentAttack = 0;
		currentCost = 0;
		for (int i = 0; i < 7; i++){
			setPlayerAttack(i, b);
		}
	}
	
	public boolean addAttack(Cards card, Character p)
	{
		boolean success;
		//find current energy cost
		for(int i=0; i<7; i++)
		{
			if (getPlayerAttack(i) != b)
			{
				currentCost = currentCost + this.getPlayerAttackCost(i);
			}
		}
		//check energy and add
		if (p.getCurrentEnergy() >= card.getCardCost() + currentCost){
			for(int i=0; i<7; i++){
				currentAttack = 0;
				//find the next empty slot
				if (getPlayerAttack(i) == b){
					playerAttack[i] = card;
					//System.out.println(this.getPlayerAttack(i).getCardName());
					i = 10;
				}
			}
			
			//set current total
			for(int i=0; i<7; i++){
				if (getPlayerAttack(i) != b){
					int cardAttack = getPlayerAttackValue(i);
					currentAttack = currentAttack + cardAttack;
				}
			}
			p.setCurrentAttack(currentAttack);
			success = true;
		}
		else{ success = false;}
		
		return success;
	}
	
	public void attackEndTurn(Character p)
	{
		for(int i=0; i<7; i++)
		{
			this.setPlayerAttack(i, b);
		}
		
		p.setCurrentAttack(0);
	}
	
	public void drawAttackHandler(Encounter e, Graphics g, MainClass mc){
		
		//column one
			g.drawImage(this.getPlayerAttackImage(1), 390, 320, 85, 85, mc);
			g.drawImage(this.getPlayerAttackImage(3), 410, 340, 85, 85, mc);
			g.drawImage(this.getPlayerAttackImage(5), 430, 360, 85, 85, mc);
			g.drawImage(this.getPlayerAttackImage(6), 450, 380, 85, 85, mc);
			
		//column two
			g.drawImage(this.getPlayerAttackImage(0), 300, 320, 85, 85, mc);
			g.drawImage(this.getPlayerAttackImage(2), 320, 340, 85, 85, mc);
			g.drawImage(this.getPlayerAttackImage(5), 340, 360, 85, 85, mc);
	}
	
	public Cards getPlayerAttack(int i){
		return this.playerAttack[i];
	}
	
	public void setPlayerAttack(int i, Cards c){
		this.playerAttack[i] = c;
	}
	
	public Image getPlayerAttackImage(int i){
		return this.playerAttack[i].getCardImage();
	}
	
	public int getPlayerAttackValue (int i){
		return this.playerAttack[i].getCardAttack();
	}
	
	public int getPlayerAttackCost(int i){
		return this.playerAttack[i].getCardCost();
	}
	
	
	
	public void resolveDamage(Character m, Character pc, Encounter e, Cards c[], Deck d)
	{
		pc.setCurrentAttack(0);
		for(int i=0; i<7; i++)
		{
			if (getPlayerAttack(i) != b)
			{
				int cardAttack = getPlayerAttackValue(i);
				pc.setCurrentAttack(pc.getCurrentAttack()+cardAttack);
			}
		}
		
		int damage = DamageHandler.calculateDamage(pc.getCurrentAttack(), pc.getAttack(), m.getDefence());
		m.takeDamage(damage);
		e.setWinCondition(pc.getAlive(), m.getAlive());
	}

}
