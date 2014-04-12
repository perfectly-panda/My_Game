package EncounterHandler;
public class DamageHandler {
	
	public DamageHandler(){}
	
	public static int calculateDamage(int cardAttack, int statAttack, int statDefence)
	{
		int damage;
		double prelimDamage;
		prelimDamage =((cardAttack * statAttack)-(statDefence * .01));
		damage = (int) Math.round(prelimDamage);
		return damage;
	}

}
