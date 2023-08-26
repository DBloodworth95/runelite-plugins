package net.runelite.client.plugins.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RuneLiteConfig implements ClientConfig {
    private final Path jarDestinationPath;
    private final Path configFile;

    public RuneLiteConfig(String osName, Path userHome) {
        if (osName.contains("mac")) {
            jarDestinationPath = Paths.get("/Applications/RuneLite.app/Contents/Resources/PluginInstaller.jar");
            configFile = Paths.get("/Applications/RuneLite.app/Contents/Resources/config.json");
        } else if (osName.contains("linux")) {
            jarDestinationPath = userHome.resolve(".local/share/RuneLite/PluginInstaller.jar");
            configFile = userHome.resolve(".config/RuneLite/config.json");
        } else {
            jarDestinationPath = userHome.resolve("AppData/Local/RuneLite/PluginInstaller.jar");
            configFile = userHome.resolve("AppData/Local/RuneLite/config.json");
        }
    }

    public Path getJarDestinationPath() {
        return jarDestinationPath;
    }

    public Path getConfigFile() {
        return configFile;
    }
}
