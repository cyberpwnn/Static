package org.cyberpwn.statics;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.cyberpwn.statics.layers.Layer1;
import org.phantomapi.Phantom;
import org.phantomapi.construct.Controllable;
import org.phantomapi.construct.Controller;
import org.phantomapi.construct.ControllerMessage;
import org.phantomapi.event.PlayerMoveBlockEvent;
import org.phantomapi.lang.GMap;
import org.phantomapi.util.M;
import com.vexsoftware.votifier.model.VotifierEvent;

@SuppressWarnings("deprecation")
public class StatHandler extends Controller
{
	private GMap<Player, Long> msx;
	
	public StatHandler(Controllable parentController)
	{
		super(parentController);
		
		msx = new GMap<Player, Long>();
	}
	
	public long timeOnlineLocal(Player p)
	{
		return Static.instance().getStaticController().get(p).get(Phantom.getServerName() + "-ti").longValue();
	}
	
	@Override
	public void onStart()
	{
		for(Player i : Phantom.instance().onlinePlayers())
		{
			msx.put(i, M.ms());
		}
	}
	
	@Override
	public void onStop()
	{
		
	}
	
	@EventHandler
	public void on(BlockBreakEvent e)
	{
		try
		{
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().toString().contains("SWORD"))
			{
				return;
			}
			
			Layer1.BB.add(e.getPlayer());
		}
		
		catch(Exception ex)
		{
			
		}
	}
	
	@EventHandler
	public void on(BlockPlaceEvent e)
	{
		try
		{
			Layer1.BP.add(e.getPlayer());
		}
		
		catch(Exception ex)
		{
			
		}
	}
	
	@EventHandler
	public void on(PlayerDeathEvent e)
	{
		try
		{
			if(e.getEntity().getKiller() == null)
			{
				return;
			}
			
			Layer1.CD.add(e.getEntity());
			Layer1.CK.add(e.getEntity().getKiller());
		}
		
		catch(Exception ex)
		{
			
		}
	}
	
	@EventHandler
	public void on(ProjectileLaunchEvent e)
	{
		try
		{
			if(e.getEntity().getType().equals(EntityType.ARROW))
			{
				Arrow a = (Arrow) e.getEntity();
				
				if(a.getShooter() instanceof Player)
				{
					Player shooter = (Player) a.getShooter();
					
					if(a.isCritical())
					{
						Layer1.CBC.add(shooter);
					}
					
					else
					{
						Layer1.CBS.add(shooter);
					}
					
					Layer1.CBT.add(shooter);
				}
			}
		}
		
		catch(Exception ex)
		{
			
		}
	}
	
	@EventHandler
	public void on(EntityDamageByEntityEvent e)
	{
		try
		{
			if(e.getEntity().getType().equals(EntityType.PLAYER) && e.getDamager().getType().equals(EntityType.PLAYER))
			{
				Layer1.CDD.add((Player) e.getDamager(), e.getDamage());
				Layer1.CDT.add((Player) e.getEntity(), e.getDamage());
				Layer1.CHD.add((Player) e.getDamager());
				Layer1.CHT.add((Player) e.getEntity());
				
			}
			
			else if(e.getEntity().getType().equals(EntityType.PLAYER) && e.getDamager().getType().equals(EntityType.ARROW))
			{
				Arrow a = (Arrow) e.getDamager();
				Player p = (Player) e.getEntity();
				
				if(a.getShooter() instanceof Player)
				{
					Layer1.CBHD.add((Player) a.getShooter());
					Layer1.CBHT.add(p);
					Layer1.CBDT.add(p, e.getDamage());
					Layer1.CBDD.add((Player) a.getShooter(), e.getDamage());
				}
			}
		}
		
		catch(Exception ex)
		{
			
		}
	}
	
	@EventHandler
	public void on(PlayerChatEvent e)
	{
		try
		{
			Layer1.CC.add(e.getPlayer());
		}
		
		catch(Exception ex)
		{
			
		}
	}
	
	@EventHandler
	public void on(PlayerMoveBlockEvent e)
	{
		try
		{
			Layer1.MT.add(e.getPlayer());
			
			if(e.getPlayer().isFlying())
			{
				Layer1.MFL.add(e.getPlayer());
				
				return;
			}
			
			if(e.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.AIR))
			{
				Layer1.MF.add(e.getPlayer());
				
				return;
			}
			
			if(e.getPlayer().getLocation().getBlock().getType().equals(Material.WATER) || e.getPlayer().getLocation().getBlock().getType().equals(Material.STATIONARY_WATER))
			{
				Layer1.MWA.add(e.getPlayer());
				
				return;
			}
			
			if(e.getPlayer().isSprinting())
			{
				Layer1.MR.add(e.getPlayer());
			}
			
			if(e.getPlayer().isSneaking())
			{
				Layer1.MS.add(e.getPlayer());
			}
			
			if(!e.getPlayer().isSprinting() && !e.getPlayer().isSneaking())
			{
				Layer1.MW.add(e.getPlayer());
			}
		}
		
		catch(Exception ex)
		{
			
		}
	}
	
	@EventHandler
	public void on(PlayerCommandPreprocessEvent e)
	{
		try
		{
			Layer1.CCO.add(e.getPlayer());
		}
		
		catch(Exception ex)
		{
			
		}
	}
	
	@EventHandler
	public void on(PlayerJoinEvent e)
	{
		try
		{
			Layer1.J.add(e.getPlayer());
			msx.put(e.getPlayer(), M.ms());
		}
		
		catch(Exception ex)
		{
			
		}
	}
	
	@EventHandler
	public void on(VotifierEvent e)
	{
		try
		{
			ControllerMessage cm = new ControllerMessage(this);
			cm.set("e.player", e.getVote().getUsername());
			sendMessage("SkillVoter", cm);
			Player p = Phantom.instance().findPlayer(e.getVote().getUsername());
			
			if(p != null)
			{
				Layer1.V.add(p);
			}
		}
		
		catch(Exception ex)
		{
			
		}
	}
	
	@EventHandler
	public void on(PlayerQuitEvent e)
	{
		try
		{
			Layer1.Q.add(e.getPlayer());
			
			if(msx.contains(e.getPlayer()))
			{
				Long ms = msx.get(e.getPlayer());
				Long time = M.ms() - ms;
				Layer1.T.add(e.getPlayer(), time);
				Static.instance().getStaticController().get(e.getPlayer()).add(Phantom.getServerName() + "-ti", time.doubleValue());
			}
		}
		
		catch(Exception ex)
		{
			
		}
	}
}
