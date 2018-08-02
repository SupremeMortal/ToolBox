package xyz.baddev.toolbox.manager.managers.utils;

import cn.nukkit.plugin.Plugin;
import com.creeperface.nukkit.placeholderapi.PlaceholderAPIIml;
import com.creeperface.nukkit.placeholderapi.api.PlaceholderAPI;
import xyz.baddev.toolbox.ToolBox;
import xyz.baddev.toolbox.manager.Manager;

public class PlaceholderManager implements Manager {

    private boolean available;
    private PlaceholderAPI placeholderAPI;

    public void onEnable(ToolBox instance) {
        Plugin plugin = instance.getServer().getPluginManager().getPlugin("PlaceholderAPI");
        available = plugin != null && plugin.isEnabled();

        if (available) {
            placeholderAPI = PlaceholderAPIIml.getInstance();
            instance.getLogger().info("Enabled PlaceholderAPI support.");
        }
    }

    public void onDisable(ToolBox instance) {

    }

    public boolean isAvailable() {
        return available;
    }

    public PlaceholderAPI getPlaceholderAPI() {
        return available ? placeholderAPI : null;
    }
}
