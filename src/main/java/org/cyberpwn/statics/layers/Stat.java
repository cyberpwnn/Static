package org.cyberpwn.statics.layers;

import org.bukkit.entity.Player;
import org.phantomapi.lang.GTime;
import org.phantomapi.util.F;

public enum Stat
{
	BLOCK_BREAK(Layer1.BB)
	{
		@Override
		public String key(Player p)
		{
			return "Blocks Broken";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	
	BLOCK_PLACE(Layer1.BP)
	{
		@Override
		public String key(Player p)
		{
			return "Blocks Placed";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	TIME_ONLINE(Layer1.T)
	{
		@Override
		public String key(Player p)
		{
			return "Time Online";
		}
		
		@Override
		public String val(Player p)
		{
			return new GTime((long) get(p)).to();
		}
	},
	COMBAT_KILL(Layer1.CK)
	{
		@Override
		public String key(Player p)
		{
			return "Kills";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_DEATH(Layer1.CD)
	{
		@Override
		public String key(Player p)
		{
			return "Deaths";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_DAMAGE_DEALT(Layer1.CDD)
	{
		@Override
		public String key(Player p)
		{
			return "Damage Dealt";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_DAMAGE_TAKEN(Layer1.CDT)
	{
		@Override
		public String key(Player p)
		{
			return "Damage Taken";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_HITS_DEALT(Layer1.CHD)
	{
		@Override
		public String key(Player p)
		{
			return "Hits Dealt";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_HITS_TAKEN(Layer1.CHT)
	{
		@Override
		public String key(Player p)
		{
			return "Hits Taken";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_KILL_DR(Layer2.COMBAT_KILL_DEATH_RATIO)
	{
		@Override
		public String key(Player p)
		{
			return "K/D";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f(get(p), 3);
		}
	},
	COMBAT_DAMAGE_DR(Layer2.COMBAT_DAMAGE_DEALT_TAKEN_RATIO)
	{
		@Override
		public String key(Player p)
		{
			return "Damage D/T";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f(get(p), 3);
		}
	},
	COMBAT_HITS_DR(Layer2.COMBAT_HITS_DEALT_TAKEN_RATIO)
	{
		@Override
		public String key(Player p)
		{
			return "Hits D/T";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f(get(p), 3);
		}
	},
	COMBAT_BOW_DAMAGE_DR(Layer2.COMBAT_ARROW_DAMAGE_DEALT_TAKEN_RATIO)
	{
		@Override
		public String key(Player p)
		{
			return "Bow Damage D/T";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f(get(p), 3);
		}
	},
	COMBAT_BOW_HIT_DR(Layer2.COMBAT_ARROW_HIT_DEALT_TAKEN_RATIO)
	{
		@Override
		public String key(Player p)
		{
			return "Shots D/T";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f(get(p), 3);
		}
	},
	COMBAT_BOW_MISS(Layer2.COMBAT_ARROW_MISS)
	{
		@Override
		public String key(Player p)
		{
			return "Shots Missed";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_BOW_ACCURACY(Layer2.COMBAT_ARROW_ACCURACY)
	{
		@Override
		public String key(Player p)
		{
			return "Accuracy";
		}
		
		@Override
		public String val(Player p)
		{
			return F.pc(get(p), 2);
		}
	},
	COMBAT_BOW_CRITICAL(Layer1.CBC)
	{
		@Override
		public String key(Player p)
		{
			return "Critical Shots";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_BOW_TOTAL(Layer1.CBT)
	{
		@Override
		public String key(Player p)
		{
			return "Shots";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_BOW_CHEAP(Layer1.CBS)
	{
		@Override
		public String key(Player p)
		{
			return "Cheap Shots";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_BOW_HITS_DEALT(Layer1.CBHD)
	{
		@Override
		public String key(Player p)
		{
			return "Shots Dealt";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_BOW_HITS_TAKEN(Layer1.CBHT)
	{
		@Override
		public String key(Player p)
		{
			return "Shots Taken";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_BOW_DAMAGE_DEALT(Layer1.CBDD)
	{
		@Override
		public String key(Player p)
		{
			return "Bow Damage Dealt";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	COMBAT_BOW_DAMAGE_TAKEN(Layer1.CBDT)
	{
		@Override
		public String key(Player p)
		{
			return "Bow Damage Taken";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	CHAT_CHAT(Layer1.CC)
	{
		@Override
		public String key(Player p)
		{
			return "Chat Messages";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	CHAT_COMMAND(Layer1.CCO)
	{
		@Override
		public String key(Player p)
		{
			return "Commands Executed";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	MOVEMENT_WALK(Layer1.MW)
	{
		@Override
		public String key(Player p)
		{
			return "Walked";
		}
		
		@Override
		public String val(Player p)
		{
			String suf = " m";
			double dist = get(p);
			
			if(dist > 500)
			{
				suf = " km";
				dist /= 1000.0;
			}
			
			return F.f(dist, 1) + suf;
		}
	},
	MOVEMENT_SNEAK(Layer1.MS)
	{
		@Override
		public String key(Player p)
		{
			return "Crouched";
		}
		
		@Override
		public String val(Player p)
		{
			String suf = " m";
			double dist = get(p);
			
			if(dist > 500)
			{
				suf = " km";
				dist /= 1000.0;
			}
			
			return F.f(dist, 1) + suf;
		}
	},
	MOVEMENT_SPRINT(Layer1.MR)
	{
		@Override
		public String key(Player p)
		{
			return "Sprinted";
		}
		
		@Override
		public String val(Player p)
		{
			String suf = " m";
			double dist = get(p);
			
			if(dist > 500)
			{
				suf = " km";
				dist /= 1000.0;
			}
			
			return F.f(dist, 1) + suf;
		}
	},
	MOVEMENT_TOTAL(Layer1.MT)
	{
		@Override
		public String key(Player p)
		{
			return "Traveled";
		}
		
		@Override
		public String val(Player p)
		{
			String suf = " m";
			double dist = get(p);
			
			if(dist > 500)
			{
				suf = " km";
				dist /= 1000.0;
			}
			
			return F.f(dist, 1) + suf;
		}
	},
	MOVEMENT_FLOWN(Layer1.MFL)
	{
		@Override
		public String key(Player p)
		{
			return "Flown";
		}
		
		@Override
		public String val(Player p)
		{
			String suf = " m";
			double dist = get(p);
			
			if(dist > 500)
			{
				suf = " km";
				dist /= 1000.0;
			}
			
			return F.f(dist, 1) + suf;
		}
	},
	MOVEMENT_FALLEN(Layer1.MF)
	{
		@Override
		public String key(Player p)
		{
			return "Fell";
		}
		
		@Override
		public String val(Player p)
		{
			String suf = " m";
			double dist = get(p);
			
			if(dist > 500)
			{
				suf = " km";
				dist /= 1000.0;
			}
			
			return F.f(dist, 1) + suf;
		}
	},
	MOVEMENT_SWAM(Layer1.MWA)
	{
		@Override
		public String key(Player p)
		{
			return "Swam";
		}
		
		@Override
		public String val(Player p)
		{
			String suf = " m";
			double dist = get(p);
			
			if(dist > 500)
			{
				suf = " km";
				dist /= 1000.0;
			}
			
			return F.f(dist, 1) + suf;
		}
	},
	VOTE_VOTES(Layer1.V)
	{
		@Override
		public String key(Player p)
		{
			return "Votes";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	VOTE_WORTH(Layer2.VOTE_WORTH)
	{
		@Override
		public String key(Player p)
		{
			return "Rate";
		}
		
		@Override
		public String val(Player p)
		{
			return F.pc(get(p));
		}
	},
	CONNECTION_JOIN(Layer1.J)
	{
		@Override
		public String key(Player p)
		{
			return "Joins";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	},
	CONNECTION_QUIT(Layer1.Q)
	{
		@Override
		public String key(Player p)
		{
			return "Quits";
		}
		
		@Override
		public String val(Player p)
		{
			return F.f((long) get(p));
		}
	};
	
	private Enum<?> dest;
	
	private Stat(Enum<?> dest)
	{
		this.dest = dest;
	}
	
	public double get(Player p)
	{
		if(dest.getClass().equals(Layer1.class))
		{
			return ((Layer1) dest).get(p);
		}
		
		if(dest.getClass().equals(Layer2.class))
		{
			return ((Layer2) dest).get(p);
		}
		
		return 0;
	}
	
	public abstract String key(Player p);
	
	public abstract String val(Player p);
}
