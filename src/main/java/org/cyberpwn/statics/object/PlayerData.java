package org.cyberpwn.statics.object;

import org.bukkit.entity.Player;
import org.phantomapi.clust.Tabled;
import org.phantomapi.statistics.Analytical;

@Tabled("statistics_playerdata")
public class PlayerData extends Analytical
{
	private Player player;
	
	public PlayerData(Player player)
	{
		this.player = player;
	}
	
	@Override
	public void onNewConfig()
	{
		
	}

	@Override
	public void onReadConfig()
	{
		
	}

	@Override
	public String getCodeName()
	{
		return player.getUniqueId().toString();
	}
}
