package lab8;
import java.util.ArrayList;

@DataProcessor
public class FilterChina {
    @DataProcessor
    public String filterData(ArrayList<Human> data) {
        String result = "";
        ArrayList<String> map = new ArrayList<>();
        data.stream().toList().forEach((elem) -> {
            if (elem.getCountry().equalsIgnoreCase("Китай")) {
                map.add(elem.getName() + ',' + elem.getAge());
            }
        });
        for (String elem : map) {
            result += elem + '\n';
        }
        return result;
    }
}
