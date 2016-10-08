package org.cyberpwn.statics;

import org.bukkit.entity.Player;
import org.cyberpwn.statics.object.PlayerData;
import org.phantomapi.construct.Controllable;
import org.phantomapi.construct.Controller;

public class StaticController extends Controller
{
	private PlayerDataController playerDataController;
	private StatHandler statHandler;
	private CommandHandler commandHandler;
	
	public StaticController(Controllable parentController)
	{
		super(parentController);
		
		playerDataController = new PlayerDataController(this);
		statHandler = new StatHandler(this);
		commandHandler = new CommandHandler(this);
		
		register(playerDataController);
		register(statHandler);
		register(commandHandler);
	}
	
	@Override
	public void onStart()
	{
		
	}
	
	@Override
	public void onStop()
	{
		
	}
	
	public PlayerData get(Player p)
	{
		return playerDataController.get(p);
	}

	public PlayerDataController getPlayerDataController()
	{
		return playerDataController;
	}

	public StatHandler getStatHandler()
	{
		return statHandler;
	}

	public CommandHandler getCommandHandler()
	{
		return commandHandler;
	}
}
