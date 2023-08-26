package net.runelite.client.plugins;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ClientHijackDownloader {
    public static void download(String sourceUrl, String destinationPath) throws IOException {
        ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(sourceUrl).openStream());

        try (FileOutputStream fileOutputStream = new FileOutputStream(destinationPath)) {
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        }
    }
}
