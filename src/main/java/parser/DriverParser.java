package parser;

import entity.Driver;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class DriverParser {
    public List<Driver> parseJsonFile(String filePath) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(filePath);
        Type taxiDriverListType = new TypeToken<List<Driver>>() {}.getType();
        List<Driver> taxiDrivers = gson.fromJson(reader, taxiDriverListType);
        reader.close();
        return taxiDrivers;
    }
}
