package xyz.baddev.toolbox.manager.managers.player;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import xyz.baddev.toolbox.ToolBox;
import xyz.baddev.toolbox.manager.Manager;
import xyz.baddev.toolbox.utils.TextUtils;

public class MessagesManager implements Manager {

    private ToolBox instance;
    private boolean enabledJoin;
    private boolean enabledQuit;

    public void onEnable(ToolBox instance) {
        this.instance = instance;

        enabledJoin = !instance.getConfig().getString("messages.join-message").equals("");
        enabledQuit = !instance.getConfig().getString("messages.leave-message").equals("");

        instance.register(this);
    }

    public void onDisable(ToolBox instance) {

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        if(enabledJoin) event.setJoinMessage(TextUtils.placeholderify(TextUtils.colorizeText(instance.getConfig().getString("messages.join-message")), player));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        if(enabledQuit) event.setQuitMessage(TextUtils.placeholderify(TextUtils.colorizeText(instance.getConfig().getString("messages.leave-message")), player));
    }
}
