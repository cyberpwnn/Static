package org.cyberpwn.statics.layers;

import org.bukkit.entity.Player;

public enum Stat
{
	BLOCK_BREAK(Layer1.BB),
	BLOCK_PLACE(Layer1.BP),
	TIME_ONLINE(Layer1.T),
	COMBAT_KILL(Layer1.CK),
	COMBAT_DEATH(Layer1.CD),
	COMBAT_DAMAGE_DEALT(Layer1.CDD),
	COMBAT_DAMAGE_TAKEN(Layer1.CDT),
	COMBAT_HITS_DEALT(Layer1.CHD),
	COMBAT_HITS_TAKEN(Layer1.CHT),
	COMBAT_KILL_DR(Layer2.COMBAT_KILL_DEATH_RATIO),
	COMBAT_DAMAGE_DR(Layer2.COMBAT_DAMAGE_DEALT_TAKEN_RATIO),
	COMBAT_HITS_DR(Layer2.COMBAT_HITS_DEALT_TAKEN_RATIO),
	COMBAT_BOW_DAMAGE_DR(Layer2.COMBAT_ARROW_DAMAGE_DEALT_TAKEN_RATIO),
	COMBAT_BOW_HIT_DR(Layer2.COMBAT_ARROW_HIT_DEALT_TAKEN_RATIO),
	COMBAT_BOW_MISS(Layer2.COMBAT_ARROW_MISS),
	COMBAT_BOW_ACCURACY(Layer2.COMBAT_ARROW_ACCURACY),
	COMBAT_BOW_CRITICAL(Layer1.CBC),
	COMBAT_BOW_TOTAL(Layer1.CBT),
	COMBAT_BOW_CHEAP(Layer1.CBS),
	COMBAT_BOW_HITS_DEALT(Layer1.CBHD),
	COMBAT_BOW_HITS_TAKEN(Layer1.CBHT),
	COMBAT_BOW_DAMAGE_DEALT(Layer1.CBDD),
	COMBAT_BOW_DAMAGE_TAKEN(Layer1.CBDT),
	CHAT_CHAT(Layer1.CC),
	CHAT_COMMAND(Layer1.CCO),
	MOVEMENT_WALK(Layer1.MW),
	MOVEMENT_SNEAK(Layer1.MS),
	MOVEMENT_SPRINT(Layer1.MR),
	MOVEMENT_TOTAL(Layer1.MT),
	MOVEMENT_FLOWN(Layer1.MFL),
	MOVEMENT_FALLEN(Layer1.MF),
	MOVEMENT_SWAM(Layer1.MWA),
	VOTES(Layer1.V),
	VOTE_WORTH(Layer2.VOTE_WORTH),
	CONNECTION_JOIN(Layer1.J),
	CONNECTION_QUIT(Layer1.Q);
	
	private Enum<?> dest;
	
	private Stat(Enum<?> dest)
	{
		this.dest = dest;
	}
	
	public double get(Player p)
	{
		if(dest.getClass().equals(Layer1.class))
		{
			return ((Layer1)dest).get(p);
		}
		
		if(dest.getClass().equals(Layer2.class))
		{
			return ((Layer2)dest).get(p);
		}
		
		return 0;
	}
}
