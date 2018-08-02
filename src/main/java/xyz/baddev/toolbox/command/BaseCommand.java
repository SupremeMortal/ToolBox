package xyz.baddev.toolbox.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;

public class BaseCommand extends Command {

    public BaseCommand(String name, String description, String usage, String[] aliasses) {
        super(name, description, usage, aliasses);
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if(commandSender instanceof Player) {
            if(!commandSender.hasPermission(String.format("toolkit.command.%s", getName()))) {
                commandSender.sendMessage(String.format("%sYou don't have permissions to execute this command.", TextFormat.RED));
                return false;
            }
            return true;
        } else {
            commandSender.sendMessage(String.format("%sOnly players can execute this command.", TextFormat.RED));
            return false;
        }
    }
}
