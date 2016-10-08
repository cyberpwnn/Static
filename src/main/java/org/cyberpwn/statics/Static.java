package org.cyberpwn.statics;

import org.cyberpwn.statics.layers.Stat;
import org.phantomapi.Phantom;
import org.phantomapi.construct.PhantomPlugin;
import org.phantomapi.lang.GList;
import org.phantomapi.util.DMSRequire;
import org.phantomapi.util.DMSRequirement;

@DMSRequire(DMSRequirement.SQL)
public class Static extends PhantomPlugin
{
	private static Static instance;
	private StaticController staticController;
	
	@Override
	public void enable()
	{
		instance = this;
		staticController = new StaticController(this);
		new PlaceholderHook(this, "stat").hook();
		
		register(staticController);
	}

	@Override
	public void disable()
	{
		
	}
	
	public void onStart()
	{
		GList<String> plx = new GList<String>();
		
		for(Stat i : Stat.values())
		{
			plx.add("%stat_" + i.toString().toLowerCase() + "%");
			plx.add("%stat_" + i.toString().toLowerCase() + "_percent%");
		}
		
		plx.add("%stat_local_time_online%");
		
		Phantom.instance().setEnvironmentData(this, "statistic-placeholders", plx);
		Phantom.instance().saveEnvironment();
	}
	
	public static Static instance()
	{
		return instance;
	}

	public static Static getInstance()
	{
		return instance;
	}

	public StaticController getStaticController()
	{
		return staticController;
	}
}
