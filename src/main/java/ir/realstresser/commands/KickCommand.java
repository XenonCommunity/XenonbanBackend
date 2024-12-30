package ir.realstresser.commands;

import ir.realstresser.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class KickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.hasPermission("xenonban.kick")) {
            final StringBuilder sb = new StringBuilder();

            Arrays.stream(strings).forEach(word -> sb.append(word).append(" "));

            Main.instance.getServer().getOnlinePlayers().iterator().next().sendPluginMessage(
                    Main.instance,
                    "xenonban:channel", String.format("kick %s %s %s", strings[0], strings[1], sb.toString().replace(strings[0] , "").replace(strings[1], "").substring(2)).getBytes());
        }
        return false;
    }
}
