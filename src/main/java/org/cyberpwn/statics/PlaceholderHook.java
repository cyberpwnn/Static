package org.cyberpwn.statics;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.cyberpwn.statics.layers.Stat;
import org.phantomapi.lang.GTime;
import org.phantomapi.util.F;
import me.clip.placeholderapi.external.EZPlaceholderHook;

public class PlaceholderHook extends EZPlaceholderHook
{
	public PlaceholderHook(Plugin plugin, String placeholderName)
	{
		super(plugin, placeholderName);
	}

	@Override
	public String onPlaceholderRequest(Player p, String s)
	{
		try
		{
			if(s.equalsIgnoreCase("time_online"))
			{
				return new GTime((long) Stat.TIME_ONLINE.get(p)).to("Online");
			}
			
			if(s.endsWith("_percent"))
			{
				return String.valueOf(F.pc(Stat.valueOf(s.replaceAll("_percent", "").toUpperCase()).get(p)));
			}
			
			return String.valueOf(F.f(Stat.valueOf(s.toUpperCase()).get(p)));
		}
		
		catch(Exception e)
		{
			if(s.equalsIgnoreCase("local_time_online"))
			{
				return new GTime(Static.instance().getStaticController().getStatHandler().timeOnlineLocal(p)).to("Online");
			}
						
			return null;
		}
	}
}
