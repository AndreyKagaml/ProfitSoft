package statistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsCalculator {
    public Map<String, Integer> calculateAttributeStatistics(List<?> objects, String attributeName) {
        Map<String, Integer> statistics = new HashMap<>();
        for (Object obj : objects) {
            try {
                String attributeValue = (String) obj.getClass().getMethod("get" + attributeName).invoke(obj);
                statistics.put(attributeValue, statistics.getOrDefault(attributeValue, 0) + 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return statistics;
    }
}
