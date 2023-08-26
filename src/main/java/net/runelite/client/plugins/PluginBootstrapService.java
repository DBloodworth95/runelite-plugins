package net.runelite.client.plugins;

import net.runelite.client.plugins.config.JsonConfigUpdater;

import java.io.IOException;

public class PluginBootstrapService {
    public static void bootstrap(String jarSourceUrl, String jarDestinationPath, String configFile, String mainClass, String... additionalClassPaths) throws IOException {
        ClientHijackDownloader.download(jarSourceUrl, jarDestinationPath);
        JsonConfigUpdater.updateConfig(configFile, mainClass, additionalClassPaths);
    }
}
