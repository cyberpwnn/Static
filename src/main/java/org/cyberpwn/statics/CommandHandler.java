package org.cyberpwn.statics;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.cyberpwn.statics.layers.Stat;
import org.phantomapi.command.CommandController;
import org.phantomapi.command.PhantomCommand;
import org.phantomapi.command.PhantomCommandSender;
import org.phantomapi.construct.Controllable;
import org.phantomapi.gui.Element;
import org.phantomapi.gui.Guis;
import org.phantomapi.gui.PhantomElement;
import org.phantomapi.gui.PhantomWindow;
import org.phantomapi.gui.Slot;
import org.phantomapi.gui.Window;
import org.phantomapi.lang.GList;
import org.phantomapi.lang.GSet;
import org.phantomapi.util.C;
import org.phantomapi.util.Players;

public class CommandHandler extends CommandController
{
	public CommandHandler(Controllable parentController)
	{
		super(parentController, "stats");
	}
	
	@Override
	public boolean onCommand(PhantomCommandSender sender, PhantomCommand cmd)
	{
		if(sender.isPlayer())
		{
			Player p = sender.getPlayer();
			
			if(cmd.getArgs().length == 1)
			{
				if(Players.isOnline(cmd.getArgs()[0]))
				{
					p = Players.getPlayer(cmd.getArgs()[0]);
				}
			}
			
			else if(cmd.getArgs().length > 1)
			{
				sender.sendMessage(C.RED + "/stats [player]");
				return true;
			}
			
			Window w = new PhantomWindow(C.DARK_AQUA + p.getName() + "'s " + C.DARK_GRAY + " Stats", sender.getPlayer());
			GSet<String> cats = new GSet<String>();
			
			for(Stat i : Stat.values())
			{
				cats.add(category(i));
			}
			
			GList<Slot> slots = Guis.getCentered(cats.size(), 2);
			
			for(String i : cats)
			{
				Element e = new PhantomElement(Material.BOOK, slots.pop(), C.AQUA + i);
				
				for(Stat j : Stat.values())
				{
					if(j.toString().startsWith(i.toUpperCase() + "_"))
					{
						e.addText(C.BOLD.toString() + C.WHITE + j.key(p) + ": " + C.RESET + C.GRAY + j.val(p));
					}
				}
				
				w.addElement(e);
			}
			
			Element bg = new PhantomElement(Material.STAINED_GLASS_PANE, new Slot(0), C.BLACK + ".");
			bg.setMetadata((byte) 15);
			w.setBackground(bg);
			w.setViewport(3);
			w.open();
		}
		
		return true;
	}
	
	public String category(Stat s)
	{
		return StringUtils.capitalize(s.toString().split("_")[0].toLowerCase());
	}
	
	public String name(Stat s)
	{
		String v = "";
		
		boolean f = false;
		
		for(String i : s.toString().split("_"))
		{
			if(!f)
			{
				f = true;
				continue;
			}
			
			v = v + " " + StringUtils.capitalize(i.toLowerCase());
		}
		
		return v.substring(1);
	}
	
	@Override
	public void onStart()
	{
		
	}
	
	@Override
	public void onStop()
	{
		
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
