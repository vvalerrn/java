import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class TopWords {
    public static void main(String[] args){
        String filePath = "src/text.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();
        char[] punctuationMarks = {'.', ',', '!', '?', ';', ':'};
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                for (char punctuation : punctuationMarks) {
                    word = word.replaceAll(Pattern.quote(String.valueOf(punctuation)), ""); //метод Pattern.quote() экранирует все специальные символы в строке.
                    // обрабатываем знаки как обычные символы, а не как специальный в регулярном выражении
                }

                // содержит ли Map уже данное слово
                if (wordCountMap.containsKey(word)) {
                    int count = wordCountMap.get(word);
                    wordCountMap.put(word, count + 1);
                } else {
                    wordCountMap.put(word, 1);
                }
            }
            scanner.close();

            //список пар
            List<Map.Entry<String, Integer>> wordCountList = new ArrayList<>(wordCountMap.entrySet());

            // cортируем список по убыванию количества повторений
            wordCountList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            for (int i = 0; i < 10 && i < wordCountList.size(); i++) {
                String word = wordCountList.get(i).getKey();
                int count = wordCountList.get(i).getValue();
                System.out.println(word + ": " + count);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
