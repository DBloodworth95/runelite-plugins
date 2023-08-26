package net.runelite.client.plugins.bootstrap;

import java.nio.file.Path;

public interface ClientConfig {
    Path getJarDestinationPath();
    Path getConfigFile();
}
