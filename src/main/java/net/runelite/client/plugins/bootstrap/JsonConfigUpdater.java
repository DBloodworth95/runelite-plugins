package net.runelite.client.plugins.bootstrap;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class JsonConfigUpdater {
    public static void updateConfig(String filePath, String mainClass, String... additionalClassPaths) throws IOException {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            JSONTokener tokener = new JSONTokener(inputStream);
            JSONObject object = new JSONObject(tokener);

            object.put("mainClass", mainClass);
            object.remove("classPath");
            for (String classPath : additionalClassPaths) {
                object.append("classPath", classPath);
            }

            try (FileWriter fileWriter = new FileWriter(filePath)) {
                fileWriter.write(object.toString());
            }
        }
    }
}
