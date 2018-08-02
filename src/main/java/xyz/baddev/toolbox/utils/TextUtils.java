package xyz.baddev.toolbox.utils;

import cn.nukkit.Player;
import cn.nukkit.utils.TextFormat;
import xyz.baddev.toolbox.ToolBox;

public class TextUtils {

    public static String colorizeText(String text) {
        return TextFormat.colorize('&', text);
    }

    public static String placeholderify(String text, Player player) {
        final ToolBox instance = ToolBox.getInstance();
        return instance.getPlaceholderManager().isAvailable() ? instance.getPlaceholderManager().getPlaceholderAPI().translateString(text, player) : text;
    }

    public static String placeholderify(String text) {
        final ToolBox instance = ToolBox.getInstance();
        return instance.getPlaceholderManager().isAvailable() ? instance.getPlaceholderManager().getPlaceholderAPI().translateString(text) : text;
    }
}
