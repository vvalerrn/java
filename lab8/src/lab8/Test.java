package lab8;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        DataManager manager = new DataManager();
        manager.loadData("src/lab8/text.csv");
        manager.registerDataProcessor(new NametoUpperCase());
        manager.registerDataProcessor(new FilterChina());
        manager.registerDataProcessor(new CountryCount());
        manager.processData();
        manager.saveData("src/lab8/text2.csv");
    }
}
