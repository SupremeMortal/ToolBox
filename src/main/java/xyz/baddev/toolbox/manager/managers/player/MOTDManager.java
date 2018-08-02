package xyz.baddev.toolbox.manager.managers.player;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.utils.Utils;
import xyz.baddev.toolbox.ToolBox;
import xyz.baddev.toolbox.manager.Manager;
import xyz.baddev.toolbox.utils.TextUtils;

import java.io.IOException;

public class MOTDManager implements Manager {

    private ToolBox instance;
    private String motd;

    public void onEnable(ToolBox instance) {
        this.instance = instance;
        try {
            this.motd = Utils.readFile(motd);
            instance.register(this);
        } catch (IOException e) {
            instance.getLogger().error(String.format("Failed reading motd file (%s).", e.getMessage()));
        }
    }

    public void onDisable(ToolBox instance) {}

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        player.sendMessage(TextUtils.colorizeText(motd));
    }
}
