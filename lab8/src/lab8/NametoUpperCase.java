package lab8;

import java.util.ArrayList;

@DataProcessor
public class NametoUpperCase {
    @DataProcessor
    public String transformData(ArrayList<Human> data) {
        String result = "";
        ArrayList<String> resultArray = new ArrayList<>();
        data.stream().toList().forEach((elem) ->
        {
            resultArray.add(elem.getName().toUpperCase());
        });
        for (String elem: resultArray){
            result += elem + '\n';
        }
        return result;
    }
}
