package xyz.baddev.toolbox.command.commands.player;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.utils.TextFormat;
import xyz.baddev.toolbox.command.BaseCommand;

public class GMACommand extends BaseCommand {

    public GMACommand(){
        super("gma", "Sets your game mode to Adventure", "/gma <player>", new String[]{"gamemodea"});
        this.commandParameters.clear();
        this.commandParameters.put("default", new CommandParameter[]{
                new CommandParameter("player", CommandParamType.STRING, true)
        });
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] args) {
        if(super.execute(commandSender, s, args)) {

            Player target = (Player) commandSender;

            if(args.length>0) {
                target = target.getServer().getPlayer(args[0]);
            }

            if(target == null) {
                commandSender.sendMessage(String.format("%sCould not find that player!", TextFormat.RED));
                return true;
            }
            target.setGamemode(2);
            commandSender.sendMessage(String.format("%sUpdated your gamemode to Adventure.", TextFormat.GREEN));
        }
        return true;
    }
}
