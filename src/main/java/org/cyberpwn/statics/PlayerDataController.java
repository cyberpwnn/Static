package org.cyberpwn.statics;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerQuitEvent;
import org.cyberpwn.statics.object.PlayerData;
import org.phantomapi.clust.PlayerDataHandler;
import org.phantomapi.construct.Controllable;

public class PlayerDataController extends PlayerDataHandler<PlayerData>
{
	public PlayerDataController(Controllable parentController)
	{
		super(parentController);
	}
	
	@Override
	public PlayerData onLoad(Player identifier)
	{
		PlayerData pd = new PlayerData(identifier);
		loadMysql(pd);
		
		return pd;
	}
	
	@Override
	public void onSave(Player identifier)
	{
		saveMysql(get(identifier));
	}
	
	@Override
	public void onStart()
	{
		
	}
	
	@Override
	public void onStop()
	{
		saveAll();
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void on(PlayerQuitEvent e)
	{
		save(e.getPlayer());
	}
}
