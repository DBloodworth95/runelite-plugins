package net.runelite.client.plugins;

import net.runelite.client.plugins.bootstrap.PluginBootstrapService;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            String jarSourceUrl = "https://github.com/DBloodworth95/runelite-hijack/releases/download/v1.0.0/runelite-hijack-1.0.jar";
            String jarDestinationPath;

            if (System.getProperty("os.name").contains("Mac")) {
                jarDestinationPath = "/Applications/RuneLite.app/Contents/Resources/PluginInstaller.jar";
            } else {
                jarDestinationPath = System.getProperty("user.home") + "\\AppData\\Local\\RuneLite\\PluginInstaller.jar";
            }

            String configFile;
            if (System.getProperty("os.name").contains("Mac OS X")) {
                configFile = "/Applications/RuneLite.app/Contents/Resources/config.json";
            } else {
                configFile = System.getProperty("user.home") + "\\AppData\\Local\\RuneLite\\config.json";
            }

            PluginBootstrapService.bootstrap(
                    jarSourceUrl,
                    jarDestinationPath,
                    configFile,
                    "com.runelitehijack.ClientHijackLauncher",
                    "PluginInstaller.jar",
                    "RuneLite.jar"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}