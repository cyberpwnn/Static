package org.cyberpwn.statics;

import org.phantomapi.command.CommandController;
import org.phantomapi.command.PhantomCommand;
import org.phantomapi.command.PhantomCommandSender;
import org.phantomapi.construct.Controllable;
import org.phantomapi.lang.GList;
import org.phantomapi.util.C;

public class CommandHandler extends CommandController
{
	public CommandHandler(Controllable parentController)
	{
		super(parentController, "stats");
	}

	@Override
	public boolean onCommand(PhantomCommandSender sender, PhantomCommand cmd)
	{
		
		
		return true;
	}

	@Override
	public void onStart()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getChatTag()
	{
		return C.DARK_GRAY + "[" + C.AQUA + "Stats" + C.DARK_GRAY + "]: " + C.WHITE;
	}

	@Override
	public String getChatTagHover()
	{
		return C.AQUA + "View Statistics";
	}

	@Override
	public GList<String> getCommandAliases()
	{
		return new GList<String>().qadd("stat").qadd("leaderboard").qadd("leaderboards");
	}
}
