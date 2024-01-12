import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearch {
    public static void main(String[] args){
        String text = "Process finished with exit code 0 woeiru";
        String letter = "w";
        text = text.toLowerCase();
        Pattern pattern = Pattern.compile("\\b" + letter + "\\w*");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

