package parser;

import entity.Car;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CarParser {
    public List<Car> parseJsonFile(String filePath) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(filePath);
        Type carListType = new TypeToken<List<Car>>() {}.getType();
        List<Car> cars = gson.fromJson(reader, carListType);
        reader.close();
        return cars;
    }
}
