package de.wartungsarbeiten.main;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public class Main extends JavaPlugin implements Listener {

	private boolean _wartung = false;
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getCommand("wartung").setExecutor(this);
	}
	
	@EventHandler
	public void LogIn(PlayerLoginEvent e) {
		if(e.getPlayer().isOp() == false && _wartung) {
			e.disallow(null, "�4WARTUNGSARBEITEN \n �cmomentan wird der Server gewartet");
		}
	}

	@EventHandler
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.isOp()) _wartung = true;
		}
		return false;
	}

}
