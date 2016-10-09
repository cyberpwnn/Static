package org.cyberpwn.statics.layers;

import org.bukkit.entity.Player;

public enum Layer2
{
	COMBAT_KILL_DEATH_RATIO
	{
		public double get(Player p)
		{
			if(Layer1.CD.get(p) == 0)
			{
				return 0;
			}
			
			return Layer1.CK.get(p) / Layer1.CD.get(p);
		}
	},
	
	VOTE_WORTH
	{
		public double get(Player p)
		{
			return Layer1.V.get(p) / (Layer1.T.get(p) / 1000 / 60 / 60 / 24);
		}
	},
	
	COMBAT_DAMAGE_DEALT_TAKEN_RATIO
	{
		@Override
		public double get(Player p)
		{
			if(Layer1.CDT.get(p) == 0)
			{
				return 0;
			}
			
			return Layer1.CDD.get(p) / Layer1.CDT.get(p);
		}
	},
	
	COMBAT_ARROW_DAMAGE_DEALT_TAKEN_RATIO
	{
		@Override
		public double get(Player p)
		{
			if(Layer1.CBDT.get(p) == 0)
			{
				return 0;
			}
			
			return Layer1.CBDD.get(p) / Layer1.CBDT.get(p);
		}
	},
	
	COMBAT_ARROW_HIT_DEALT_TAKEN_RATIO
	{
		@Override
		public double get(Player p)
		{
			if(Layer1.CBHT.get(p) == 0)
			{
				return 0;
			}
			
			return Layer1.CBHD.get(p) / Layer1.CBHT.get(p);
		}
	},
	
	COMBAT_ARROW_MISS
	{
		@Override
		public double get(Player p)
		{
			return Layer1.CBT.get(p) - Layer1.CBHD.get(p);
		}
	},
	
	COMBAT_ARROW_ACCURACY
	{
		@Override
		public double get(Player p)
		{
			if(Layer2.COMBAT_ARROW_MISS.get(p) == 0)
			{
				return 1;
			}
			
			return Layer1.CBHD.get(p) / Layer2.COMBAT_ARROW_MISS.get(p);
		}
	},
	
	COMBAT_HITS_DEALT_TAKEN_RATIO
	{
		@Override
		public double get(Player p)
		{
			if(Layer1.CHT.get(p) == 0)
			{
				return 0;
			}
			
			return Layer1.CHD.get(p) / Layer1.CHT.get(p);
		}
	};
	
	public abstract double get(Player p);
}
