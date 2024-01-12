import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheck {
    public static void main(String[] args){
        String password = "pfjsjajsdR777";
        Pattern pattern = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*[^a-zA-Z\\d]).{8,16}");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println("Сorrect password");
        } else {
            System.out.println("You have entered an incorrect password");
        }
    }
}
