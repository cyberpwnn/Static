package org.cyberpwn.statics.layers;

import org.bukkit.entity.Player;
import org.cyberpwn.statics.Static;
import org.phantomapi.Phantom;

public enum Layer1
{
	/**
	 * Block Break
	 */
	BB,
	
	/**
	 * Block Place
	 */
	BP,
	
	/**
	 * Time online
	 */
	T,
	
	/**
	 * Combat Kills
	 */
	CK,
	
	/**
	 * Combat Deaths
	 */
	CD,
	
	/**
	 * Combat Damage Dealt
	 */
	CDD,
	
	/**
	 * Combat Damage Taken
	 */
	CDT,
	
	/**
	 * Combat Hits Dealt
	 */
	CHD,
	
	/**
	 * Combat Hits Taken
	 */
	CHT,
	
	/**
	 * Combat Bow Criticals
	 */
	CBC,
	
	/**
	 * Combat Bow Total
	 */
	CBT,
	
	/**
	 * Combat Bow Cheap Shot (Non Critical)
	 */
	CBS,
	
	/**
	 * Combat Bow Hits Dealt
	 */
	CBHD,
	
	/**
	 * Combat Bow Hits Taken
	 */
	CBHT,
	
	/**
	 * Combat Bow Damage Dealt
	 */
	CBDD,
	
	/**
	 * Combat Bow Damage Taken
	 */
	CBDT,
	
	/**
	 * Chat
	 */
	CC,
	
	/**
	 * Commands
	 */
	CCO,
	
	/**
	 * Movement Walk
	 */
	MW,
	
	/**
	 * Movement Sneak
	 */
	MS,
	
	/**
	 * Movement Sprint
	 */
	MR,
	
	/**
	 * Movement Total
	 */
	MT,
	
	/**
	 * Movement Flown
	 */
	MFL,
	
	/**
	 * Movement Fell
	 */
	MF,
	
	/**
	 * Movement Swam
	 */
	MWA,
	
	/**
	 * Votes
	 */
	V,
	
	/**
	 * Joins
	 */
	J,
	
	/**
	 * Quits
	 */
	Q;
	
	public double get(Player p)
	{
		return Static.instance().getStaticController().get(p).get(toString().replaceAll("_", ".").toLowerCase());
	}
	
	public double getLocal(Player p)
	{
		String name = Phantom.getServerName();
		return Static.instance().getStaticController().get(p).get(name.replaceAll("_", ".").toLowerCase() + "." + toString().replaceAll("_", ".").toLowerCase());
	}
	
	public void add(Player p)
	{
		add(p, 1.0);
	}
	
	public void set(Player player, double d)
	{
		Static.instance().getStaticController().get(player).set(toString().replaceAll("_", ".").toLowerCase(), d);
	}
	
	public void add(Player player, double d)
	{
		Static.instance().getStaticController().get(player).add(toString().replaceAll("_", ".").toLowerCase(), d);
		
		if(Phantom.instance().isBungeecord())
		{
			String name = Phantom.getServerName();
			Static.instance().getStaticController().get(player).add(name.replaceAll("_", ".").toLowerCase() + "." + toString().replaceAll("_", ".").toLowerCase(), d);
		}
	}
}
