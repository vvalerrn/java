import java.util.Arrays;

public class practice2 {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        int[] task3point1 = {44,32,86,19};
        int[] task3point2 = {22,50,16,63,31,55};
        System.out.println(differenceEvenOdd(task3point1));
        System.out.println(differenceEvenOdd(task3point2));
        int[] task4point1 = {1,2,3,4,5};
        int[] task4point2 = {1,2,3,4,6};
        System.out.println(equalToAvg(task4point1));
        System.out.println(equalToAvg(task4point2));
        int[] task5point1 = {1,2,3};
        int[] task5point2 = {3,3,-2,408,3,31};
        System.out.println(Arrays.toString(indexMult(task5point1)));
        System.out.println(Arrays.toString(indexMult(task5point2)));
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println("''" + pseudoHash(0));
        System.out.println(botHelper("Hello, I am under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));


    }

//1 задача
    public static boolean duplicateChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.toUpperCase().charAt(i) == str.toUpperCase().charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    //2 задача
    public static String getInitials(String name) {
        String[] result = name.split(" ");
        return (""+ result[0].charAt(0) + result[1].charAt(0));
    }

    //3 задача
    public static int differenceEvenOdd(int[] numbers) {
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
            } else {
                oddSum += numbers[i];
            }
        }
        return Math.abs((evenSum - oddSum));
    }

    // 4 задача
    public static boolean equalToAvg(int[] element) {
        int k = 0;
        float sum = 0;
        for (int i = 0; i <element.length; i++){
           sum += element[i];
           k+=1;
        }
        float average = sum/k;
        for (int i = 0; i <element.length; i++) {
            if (element[i] == average){
                return true;
            }
        }

        return false;
    }

    //5 задача
    public static int[] indexMult(int[] numbers){
        for( int i = 0; i < numbers.length;i++){
            numbers[i] = numbers[i]* i;
        }
        return numbers;

    }

    //6 задача
    public static String reverse(String str){
        String newStr = "";
        for (int i = str.length()-1; i>= 0; i--){
            newStr += str.charAt(i);
        }
        return newStr;

    }

    //7 задача
    public static int Tribonacci(int number){
        int[] result = new int[number];
        result[0] = 0;
        result[1] = 0;
        result[2] = 1;
        for (int i = 3; i<number; i++){
            result[i] = result[i-1]+result[i-2]+result[i-3];
        }
        return result[number-1];
    }

    //8 задача
    public static String pseudoHash(int lenStr){
       String symbols = "abcdef0123456789";
       String result = "";
       for (int i =0; i< lenStr; i++){
           result += symbols.toCharArray()[(int) (Math.random()* symbols.toCharArray().length)];
       }
       return result;
    }

    //9 задача
    public static String botHelper(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.charAt(i) == 'h' & str.charAt(i + 1) == 'e' & str.charAt(i + 2) == 'l' & str.charAt(i + 3) == 'p') {
                return "Calling for a staff manager";
            }
        }
        return "Keep waiting";
    }


    //10 задача
    public static boolean isAnagram(String firstWord, String secondWord){
        char[] firstW = firstWord.toCharArray();
        char[] scndW = secondWord.toCharArray();
        Arrays.sort(firstW);
        Arrays.sort(scndW);
        return Arrays.equals(firstW,scndW);
    }

}    