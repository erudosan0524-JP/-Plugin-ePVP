package ePVP.plugin;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EPVP extends JavaPlugin {

	World world = null;
	Player player = null;

	@Override
	public void onDisable() {
		getLogger().info("プラグインが停止しました");
	}

	@Override
	public void onEnable() {
		getLogger().info("プラグインが読み込まれました");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


		player = (Player) sender;

		Location playerLoc = player.getLocation().clone();
		World Loc = playerLoc.getWorld();

		if (args.length != 0) {
			if (args[0].equalsIgnoreCase("on")) {

				Loc.playSound(playerLoc, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

				Loc.setPVP(true);
				sender.sendMessage("§aPVPがonになりました");

				return true;

			} else if (args[0].equalsIgnoreCase("off")) {

				Loc.playSound(playerLoc, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

				Loc.setPVP(false);
				sender.sendMessage("§aPVPがoffになりました");

				return true;

			}

		}
		sender.sendMessage("§c使い方： /epvp on/off");
		return false;

	}
}
