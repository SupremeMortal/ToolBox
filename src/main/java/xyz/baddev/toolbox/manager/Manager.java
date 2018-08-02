package xyz.baddev.toolbox.manager;

import cn.nukkit.event.Listener;
import xyz.baddev.toolbox.ToolBox;

public interface Manager extends Listener {

    void onEnable(ToolBox instance);
    void onDisable(ToolBox instance);
}
