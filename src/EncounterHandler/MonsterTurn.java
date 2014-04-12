package EncounterHandler;

import Characters.Character;
import Characters.Monster;
import MainFiles.Encounter;

public class MonsterTurn {
	
	public int monsterDeckPlace = 0;
	
	public MonsterTurn(){}

	public void resolveMonsterTurn(Encounter e, Monster m, Character pc)
	{
		int currentCard;
		int monsterAttack;
		currentCard = drawMonsterCard(e, m);
		e.monsterAttackImage = m.getDeckImage(currentCard);
		monsterAttack = m.getCardDamage(currentCard);
		pc.takeDamage(DamageHandler.calculateDamage(monsterAttack, m.getAttack(), pc.getDefence()));
		e.setWinCondition(pc.getAlive(), m.getAlive());
	}
	
	public int drawMonsterCard(Encounter e, Character m)
	{
		int nc;
		if (monsterDeckPlace <= m.getDeckSize())
		{
			nc = monsterDeckPlace;
			monsterDeckPlace++;
		}
		else
		{
			monsterDeckPlace = 0;
			m.shuffleDeck();
			nc = monsterDeckPlace;
			monsterDeckPlace++;
			
		}
		return nc;
	}
}
