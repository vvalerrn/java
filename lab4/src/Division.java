import java.io.FileWriter;
import java.io.IOException;




public class Division {
    public static void main(String[] args){
        double firstNum = Integer.parseInt(args[0]);
        double secondNum = Integer.parseInt(args[1]);
        try{
            ifDivision(secondNum);
            System.out.println(firstNum + "/" + secondNum + "="+ firstNum/secondNum);
        }catch (CustomDivisionException e) {
        System.out.println(e.getMessage());
        try (FileWriter writer = new FileWriter("error.txt", true)) {
            writer.write(e.getMessage() + "\n");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        }

    }
    public static void ifDivision(double s) throws CustomDivisionException {
        if (s == 0) {
            throw new CustomDivisionException("Division by zero is not allowed ");
        }
    }
}

class CustomDivisionException extends Exception {
    public CustomDivisionException(String message) {
        super(message);
    }
}
