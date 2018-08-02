package xyz.baddev.toolbox.manager.managers.utils;

import xyz.baddev.toolbox.ToolBox;
import xyz.baddev.toolbox.manager.Manager;

import java.io.File;

public class FileManager implements Manager {

    private File baseDir;

    private File motdFile;

    public void onEnable(ToolBox instance) {
        baseDir = instance.getDataFolder();

        instance.saveResource("motd.txt");
        motdFile = new File(baseDir, "motd.txt");
    }

    public void onDisable(ToolBox instance) {}

    public File getBaseDir() {
        return baseDir;
    }

    public File getMotdFile() {
        return motdFile;
    }
}
