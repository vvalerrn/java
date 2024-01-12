import java.util.ArrayList;
import java.util.*;

public class practice4 {
    public static void main(String[] args) {
        System.out.println("-------1------");
        System.out.println(removeDuplicates("abracadabra"));
        System.out.println(removeDuplicates("paparazzi"));
        System.out.println("-------2------");
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println("-------3------");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println("-------4------");
        System.out.println(alphabeticRow("abcdc"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println("-------5------");
        System.out.println(countLetters("aaabbcdd"));
        System.out.println(countLetters("vvvvaajaaaaa"));
        System.out.println("-------6------");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println("-------7------");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println("-------8------");
        int[][] array1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(shortestWay(array1));
        int[][] array2 = {{2,7,3}, {1,4,8}, {4,5,9}};
        System.out.println(shortestWay(array2));
        System.out.println("-------9------");
        System.out.println(reorderWords("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(reorderWords("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println("-------10------");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    //1 Напишите рекурсивную функцию, которая принимает строку и удаляет из неё
    //повторяющиеся символы. Функция должна вернуть строку, в которой каждый
    //символ встречается только один раз.
    public static String removeDuplicates(String string) {
        if (string.length() <= 1) {
            return string;
        }
        char lastChar = string.charAt(string.length() - 1);
        String restOfString = removeDuplicates(string.substring(0, string.length() - 1));

        // Проверяем, содержит ли часть строки последний символ
        if (restOfString.indexOf(lastChar) != -1) {
            return restOfString;
        } else {
            return restOfString + lastChar;
        }
    }

    //2 Напишите функцию, которая генерирует все возможные правильные комбинации
    //пар скобок для заданного числа n.
    public static ArrayList<String> generateBrackets(int n) {
        ArrayList<String> result = new ArrayList<>();
        brackets(n, n, "", result);
        return result;
    }

    public static void brackets(int leftCount, int rightCount, String currentBracket, ArrayList<String> result) {
        if (leftCount == 0 && rightCount == 0) {
            result.add(currentBracket);
            return;
        }

        if (leftCount > 0) {
            brackets(leftCount - 1, rightCount, currentBracket + "(", result);
        }

        if (rightCount > leftCount) {
            brackets(leftCount, rightCount - 1, currentBracket + ")", result);
        }

    }

    //3 Напишите функцию, которая генерирует все возможные бинарные комбинации
    //длины n, в которых не может быть соседствующих нулей.
    public static ArrayList<String> binarySystem(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = (int) Math.pow(2, n); i <= Math.pow(2, n+1) - 1; i++) {
            list.add(Integer.toBinaryString(i).replaceFirst("1", ""));
        }
        ArrayList<String> result = new ArrayList<>();
        for (String i : list) {
            char[] chars = i.toCharArray();
            boolean flag0 = true;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == '0' && chars[j] == chars[j - 1]) {
                    flag0 = false;
                    break;
                }
            }
            if (flag0) {
                result.add(i);
            }
        }
        return result;
    }

    //4 Реализуйте функцию, которая принимает строку и возвращает длину самого
    //длинного последовательного ряда в этом массиве. Последовательный ряд – это
    //список соседних элементов, идущих подряд в алфавитном порядке, который может
    //быть как увеличивающимся, так и уменьшающимся.
    public static String alphabeticRow(String string) {
        ArrayList<String> massive = new ArrayList<>();
        String newStr = "";
        String sequence = "";


        for (int i = 0; i < string.length() - 1; i++){
            char currentChar = string.charAt(i);
            char nextChar = string.charAt(i+1);

            if (newStr.isEmpty()){
                newStr += currentChar;

            }
            if (nextChar - newStr.charAt(newStr.length() - 1) == 1 && !sequence.equals("Последовательность убывает")) {
                newStr += nextChar;
                sequence = "Последовательность возрастает";
            } else if (nextChar - newStr.charAt(newStr.length() - 1) == - 1 && !sequence.equals("Последовательность возрастает")){
                newStr += nextChar;
                sequence = "Последовательность убывает";
            } else {
                newStr = "";
                sequence = "";
            }
            massive.add(newStr);
        }

        String maxString = "";

        for (String elem: massive) {
            if (elem.length() >= maxString.length()) {
                maxString = elem;
            }
        }

        return maxString;
    }


//5 Напишите функцию, которая принимает строку и подсчитывает количество
//идущих подряд символов, заменяя соответствующим числом повторяющиеся
//символы. Отсортируйте строку по возрастанию длины буквенного паттерна.
    public static String countLetters(String str) {
        if (str.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        char currentChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char nextChar = str.charAt(i);
            if (nextChar == currentChar) {
                count++;
            } else {
                result.append(currentChar);
                if (count >= 1) {
                    result.append(count);
                }
                currentChar = nextChar;
                count = 1;
            }
        }
        result.append(str.charAt(str.length() - 1)).append(count); //для последнего символа, который не считается в цикле
        
        ArrayList<String> patterns = new ArrayList<>(Arrays.asList(result.toString().split("(?<=\\d)"))); //разделение происходит после символа,
                                                                                                                // который является цифрой
        char[][] sortingPattern = new char[patterns.size()][2];

        for (int i = 0; i < patterns.size(); i++) {
            sortingPattern[i] = patterns.get(i).toCharArray();
        }

        Arrays.sort(sortingPattern, Comparator.comparingInt(arr -> arr[1])); //  пары сортирует по цифре
        String finalString = "";

        for (int i = 0; i < sortingPattern.length; i++) {
            for (int j = 0; j < 2; j++) {
                finalString += sortingPattern[i][j];
            }
        }

        return finalString;
    }


    //6 Напишите функцию, принимающую положительное целое число в строковом
    //формате, не превышающее 1000, и возвращающую его целочисленное
    //представление
    public static int convertToNum(String word) {
        HashMap<String, Integer> wordToNumberMap = new HashMap<>();
        wordToNumberMap.put("zero", 0);
        wordToNumberMap.put("one", 1);
        wordToNumberMap.put("two", 2);
        wordToNumberMap.put("three", 3);
        wordToNumberMap.put("four", 4);
        wordToNumberMap.put("five", 5);
        wordToNumberMap.put("six", 6);
        wordToNumberMap.put("seven", 7);
        wordToNumberMap.put("eight", 8);
        wordToNumberMap.put("nine", 9);
        wordToNumberMap.put("ten", 10);
        wordToNumberMap.put("eleven", 11);
        wordToNumberMap.put("twelve", 12);
        wordToNumberMap.put("thirteen", 13);
        wordToNumberMap.put("fourteen", 14);
        wordToNumberMap.put("fifteen", 15);
        wordToNumberMap.put("sixteen", 16);
        wordToNumberMap.put("seventeen", 17);
        wordToNumberMap.put("eighteen", 18);
        wordToNumberMap.put("nineteen", 19);
        wordToNumberMap.put("twenty", 20);
        wordToNumberMap.put("thirty", 30);
        wordToNumberMap.put("forty", 40);
        wordToNumberMap.put("fifty", 50);
        wordToNumberMap.put("sixty", 60);
        wordToNumberMap.put("seventy", 70);
        wordToNumberMap.put("eighty", 80);
        wordToNumberMap.put("ninety", 90);
        wordToNumberMap.put("hundred", 100);
        wordToNumberMap.put("thousand", 1000);

        String[] words = word.toLowerCase().split(" ");
        int result = 0;
        int currentNumber = 0;

        for (String w : words) {
            int value = wordToNumberMap.get(w); //по ключу берем значение
            if (value == 100) {
                currentNumber *= value;
            } else if (value == 1000) {
                currentNumber *= value;
                result += currentNumber;
                currentNumber = 0;
            } else {
                currentNumber += value;
            }
        }
        result += currentNumber;

        return result;
    }


    //7 Напишите функцию, принимающую строку цифр, выполняющую поиск подстроки
    //максимальной длины с уникальными элементами. Если найдено несколько
    //подстрок одинаковой длины, верните первую.
    public static String uniqueSubstring(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        String maxSubstring = "";
        String currentSubstring = "";
        int startIndex = 0; //индекс начала текущей подстроки

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int charIndex = currentSubstring.indexOf(currentChar);

            if (charIndex != -1) { //если встретили повторяющийся символ, заходим сюда
                startIndex = startIndex + charIndex + 1; //добавляем к startIndex значение charIndex + 1, чтобы установить новое начальное
                                                        //положение для подстроки, исключив символ, который повторяется.
            }

            currentSubstring = input.substring(startIndex, i + 1); //прибавляем в текущую строку текущий символ, если он уникален

            if (currentSubstring.length() > maxSubstring.length()) {
                maxSubstring = currentSubstring;
            }
        }

        return maxSubstring;
    }


    //8 Напишите функцию поисковик наименьшего матричного пути. На вход поступает
    //двумерный массив, размера n x n, ваша задача найти путь с минимальной суммой
    //чисел, передвигаясь только вправо или вниз.
    public static int shortestWay(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n]; // создаем квадратную матрицу
        newMatrix[0][0] = matrix[0][0];

        for (int i = 1; i < n; i++) {
            newMatrix[i][0] = newMatrix[i - 1][0] + matrix[i][0]; //заполняем первый столбец
        }

        for (int i = 1; i < n; i++) {
            newMatrix[0][i] = newMatrix[0][i - 1] + matrix[0][i]; // заполняем первую строку
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                newMatrix[i][j] = Math.min(newMatrix[i - 1][j], newMatrix[i][j - 1]) + matrix[i][j]; //выбираем минимальное число слева или сверху
            }
        }

        return newMatrix[n - 1][n - 1];
    }

//9 Создайте функцию, принимающую строку, содержащую числа внутри слов. Эти
//числа представляют расположение слова для новой строящейся строки.
    public static String reorderWords(String input) {
        String[] words = input.split(" ");
        Map<Integer, String> wordMap = new HashMap<>();

        for (String word : words) {
            StringBuilder wordWithoutNumbers = new StringBuilder();
            StringBuilder numbers = new StringBuilder();

            for (char c : word.toCharArray()) {
                if (Character.isDigit(c)) {
                    numbers.append(c);
                } else {
                    wordWithoutNumbers.append(c);
                }
            }

            if (numbers.length() > 0) { //если в слове находим число, превращаем число в позишн и добавляем в хэшмап
                int position = Integer.parseInt(numbers.toString());
                wordMap.put(position, wordWithoutNumbers.toString());
            }
        }

        // Собираем перестроенную строку
        StringJoiner result = new StringJoiner(" ");
        for (int i = 1; i <= wordMap.size(); i++) {
            result.add(wordMap.get(i));
        }

        return result.toString();
    }


    //10 Напишите функцию, принимающую два числа, которая делает второе число
    //максимально возможным за счет замены своих элементов элементами первого
    //числа. Брать цифру можно только один раз.
    public static int switchNums(Integer num1, Integer num2) {
        char[] chars1 = num1.toString().toCharArray();
        char[] chars2 = num2.toString().toCharArray();
        for (int j = 0; j < chars2.length; j++) {
            char max = '0';
            int maxInd = 0;
            for (int i = 0; i < chars1.length; i++) { //ищем максимальную цифру среди 1 числа
                if (chars1[i] > max) {
                    max = chars1[i];
                    maxInd = i;
                }
            }
            if (chars1[maxInd] > chars2[j]) {
                chars2[j] = chars1[maxInd]; //заменяем второе число элементом первого
                chars1[maxInd] = '0'; //заменяем на ноль элемент 1 числа, чтобы к нему больше не возвращаться
            }
        }
        return Integer.parseInt(String.valueOf(chars2));
    }

}




