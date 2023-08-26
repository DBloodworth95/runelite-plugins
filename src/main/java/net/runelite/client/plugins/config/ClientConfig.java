package net.runelite.client.plugins.config;

import java.nio.file.Path;

public interface ClientConfig {
    Path getJarDestinationPath();
    Path getConfigFile();
}
