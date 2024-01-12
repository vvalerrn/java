import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIP {
    public static void main(String[] args){
        String ip = "5.233.09.255";
        Pattern pattern = Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-9]|[1-9][0-9]|1[0-9][0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[0-9]|[1-9][0-9]|1[0-9][0-9])");
        Matcher matcher = pattern.matcher(ip);
        if (matcher.matches()) {
            System.out.println("Valid IP.");
        } else {
            System.out.println("You have entered an incorrect IP.");
        }
    }
}
