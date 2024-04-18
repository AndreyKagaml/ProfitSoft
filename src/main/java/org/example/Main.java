package org.example;

import generate.XmlGenerator;
import parser.FileParser;
import statistic.StatisticsCalculator;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.print("Введіть шлях до папки з JSON-файлами: ");
        String fP = "D:\\Andrey\\ProfitSoft\\untitled";
        String folderPath = fP; //scanner.nextLine();

        System.out.print("Введіть назву атрибута для обчислення статистики: ");
        String attributeName = scanner.nextLine();

        try {
            List<?> objects = new FileParser().parseJsonFiles(folderPath);

            Map<String, Integer> statistics = new StatisticsCalculator().calculateAttributeStatistics(objects, attributeName);

            new XmlGenerator().generateXml(statistics, attributeName);

            System.out.println("Статистика була успішно обчислена та збережена у вигляді XML-файлу.");
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}