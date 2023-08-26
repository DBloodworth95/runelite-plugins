package net.runelite.client.plugins;

import net.runelite.client.plugins.config.ClientConfig;
import net.runelite.client.plugins.config.RuneLiteConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PluginBootstrap {
    private static final Logger logger = LoggerFactory.getLogger(PluginBootstrap.class);

    public static void main(String[] args) {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            Path userHome = Paths.get(System.getProperty("user.home"));

            ClientConfig config = new RuneLiteConfig(osName, userHome);

            PluginBootstrapService.bootstrap(
                    "https://github.com/DBloodworth95/runelite-hijack/releases/download/v1.0.0/runelite-hijack-1.0.jar",
                    config.getJarDestinationPath().toString(),
                    config.getConfigFile().toString(),
                    "com.runelitehijack.ClientHijackLauncher",
                    "PluginInstaller.jar",
                    "RuneLite.jar"
            );
        } catch (IOException e) {
            logger.error("An error occurred during RuneLite installation:", e);
        }
    }
}