package xyz.baddev.toolbox;

import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import xyz.baddev.toolbox.command.commands.player.*;
import xyz.baddev.toolbox.manager.managers.player.MOTDManager;
import xyz.baddev.toolbox.manager.managers.player.MessagesManager;
import xyz.baddev.toolbox.manager.managers.utils.FileManager;
import xyz.baddev.toolbox.manager.managers.utils.PlaceholderManager;

public class ToolBox extends PluginBase {

    private static ToolBox instance;

    private FileManager fileManager;
    private PlaceholderManager placeholderManager;
    private MessagesManager messagesManager;
    private MOTDManager motdManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        fileManager = new FileManager();
        placeholderManager = new PlaceholderManager();
        messagesManager = new MessagesManager();
        motdManager = new MOTDManager();

        fileManager.onEnable(this);
        placeholderManager.onEnable(this);
        messagesManager.onEnable(this);
        motdManager.onEnable(this);

        final SimpleCommandMap commandMap = getServer().getCommandMap();

        commandMap.register("gmc", new GMCCommand());
        commandMap.register("gms", new GMSCommand());
        commandMap.register("gma", new GMACommand());
        commandMap.register("gmsp", new GMSPCommand());

        commandMap.register("pos", new PosCommand());
    }

    @Override
    public void onDisable() {
        motdManager.onDisable(this);
        messagesManager.onDisable(this);
        placeholderManager.onDisable(this);
        fileManager.onDisable(this);
    }

    public void register(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    public static ToolBox getInstance() {
        return instance;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public PlaceholderManager getPlaceholderManager() {
        return placeholderManager;
    }

    public MOTDManager getMotdManager() {
        return motdManager;
    }
}
