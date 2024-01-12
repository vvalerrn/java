import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkReplacement {
    public static void main(String[] args){
        String text = "https://translate.google.com";
        Pattern pattern = Pattern.compile("(\\b[\\w-]{1,63}\\.[\\w-]{1,63})[^\\s@]*\\b");
        if (text.contains("https://")){
            text = text.replaceAll("https://", "");
        }
        if (text.contains("http://")) {
            text = text.replaceAll("http://", "");
        }
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String link = matcher.group();
            text = text.replaceAll(link,"<a href=https://" + link + ">https://" + link + "</a>");
        }

        System.out.println(text);
    }
}
