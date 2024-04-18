package parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FileParser {
    public List<?> parseJsonFiles(String folderPath) throws IOException {
        List<Object> objects = new ArrayList<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".json")) {
                    if (file.getName().contains("taxi")) {
                        objects.addAll(new DriverParser().parseJsonFile(file.getAbsolutePath()));
                    } else if (file.getName().contains("car")) {
                        objects.addAll(new CarParser().parseJsonFile(file.getAbsolutePath()));
                    }
                }
            }
        }

        return objects;
    }
}
