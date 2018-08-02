package xyz.baddev.toolbox;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import xyz.baddev.toolbox.manager.managers.player.MOTDManager;
import xyz.baddev.toolbox.manager.managers.utils.FileManager;

public class ToolBox extends PluginBase {

    private FileManager fileManager;
    private MOTDManager motdManager;

    @Override
    public void onEnable() {
        fileManager = new FileManager();
        motdManager = new MOTDManager();

        fileManager.onEnable(this);
        motdManager.onEnable(this);
    }

    @Override
    public void onDisable() {
        motdManager.onDisable(this);
        fileManager.onDisable(this);
    }

    public void register(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
