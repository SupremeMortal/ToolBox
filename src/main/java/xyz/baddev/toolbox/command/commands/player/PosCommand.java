package xyz.baddev.toolbox.command.commands.player;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;
import xyz.baddev.toolbox.command.BaseCommand;
import xyz.baddev.toolbox.utils.TextUtils;

public class PosCommand extends BaseCommand {

    public PosCommand() {
        super("pos", "Get your current position coordinates", "/pos", new String[]{"getpos"});
        this.commandParameters.clear();
        this.commandParameters.put("default", new CommandParameter[]{});
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] args) {
        if(super.execute(commandSender, s, args)) {
            Player player = (Player) commandSender;
            player.sendMessage(TextUtils.placeholderify(TextUtils.colorizeText(String.format("&6Your current position: &c%s&6/&c%s&6/&c%s &6in level &c%s&6.", (int) player.getX(), (int) player.y, (int) player.z, player.level.getName()))));
        }
        return true;
    }
}
