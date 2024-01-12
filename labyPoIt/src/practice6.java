import java.util.*;

public class practice6 {
    public static void main(String[] args){
        System.out.println("-------1------");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("-------2------");
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
        System.out.println("-------3------");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println("-------4------");
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));
        System.out.println("-------5------");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        System.out.println("-------6------");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println("-------7------");
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println("-------8------");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));
        System.out.println("-------9------");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println("-------10------");
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));




    }

//метод взят из 2 практики
    public static boolean isAnagram(String firstWord, String secondWord){
        char[] firstW = firstWord.toCharArray();
        char[] scndW = secondWord.toCharArray();
        Arrays.sort(firstW);
        Arrays.sort(scndW);
        return Arrays.equals(firstW,scndW);
    }

    //1 Напишите функцию, чтобы найти анаграмму второй строки, вложенную где-то в
    //первую строку.
    public static String hiddenAnagram(String str1, String str2){
        str1 = str1.toLowerCase();
        str1 = str1.replaceAll("[^a-z]", ""); //удаляем все символы кроме букв
        str2 = str2.toLowerCase();
        str2 = str2.replaceAll("[^a-z]", "");
        for (int i = 0; i <= str1.length() - str2.length(); i++) { //перебираем все возможные подтроки длины строки2
            String str = str1.substring(i, i + str2.length());
            if (isAnagram(str2, str)) {
                return str;
            }
        }
        return "not found";
    }



    //2 Напишите функцию, которая возвращает массив строк, заполненных из срезов
    //символов n-длины данного слова
    public static String collect(String string, int count) {
        List<String> list;
        list = collectRec(string, count, new ArrayList<>());
        return list.toString();
    }

    public static List<String> collectRec(String string, int count, List<String> array) {

        if (string.length() >= count) {
            String buffer = string.substring(0, count);
            array.add(buffer);
            array.sort(new Comparator<String>() { //для сортировки срезов символов в алфавитном порядке
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            collectRec(string.substring(count), count, array); //вызывается рекурсивно, передавая в него остаток исходной строки после среза
        }

        return array;
    }



    //3 Создайте функцию, которая принимает два аргумента, message и key, и возвращает
    //закодированное сообщение
    public static String nicoCipher(String message, String key) {
        //каждый символ в ключе преобразуется в цифру, начиная с 1 для a
        int[] keyOrder = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keyOrder[i] = key.charAt(i) - 'a' + 1;
        }

        int numRows = message.length() / key.length() + (message.length() % key.length() == 0 ? 0 : 1); //деление нацело + с учитыванием остатка
        char[][] matrix = new char[numRows][key.length()];
        int index = 0;

        for (int i = 0; i < numRows; i++) { //записываем сообщение в матричной форме
            for (int j = 0; j < key.length(); j++) {
                if (index < message.length()) {
                    matrix[i][j] = message.charAt(index++);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        for (int i = 1; i <= key.length(); i++) { //сортируем матрицу по ключу, меняем столбцы местами
            for (int j = 0; j < key.length() - i; j++) {
                if (keyOrder[j] > keyOrder[j + 1]) {

                    int temp = keyOrder[j];
                    keyOrder[j] = keyOrder[j + 1];
                    keyOrder[j + 1] = temp;

                    for (int k = 0; k < numRows; k++) {
                        char tempChar = matrix[k][j];
                        matrix[k][j] = matrix[k][j + 1];
                        matrix[k][j + 1] = tempChar;
                    }
                }
            }
        }

        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < key.length(); j++) {
                encodedMessage.append(matrix[i][j]);
            }
        }

        return encodedMessage.toString();
    }



    //4 Создайте метод, который принимает массив arr и число n и возвращает массив из
    //двух целых чисел из arr, произведение которых равно числу n
    public static int[] twoProduct(int[] array, int n) {
        int gap = 100000000;
        int[] result = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] * array[j] == n) {
                    if (j - i < gap) { // ищем минимальную разницу по индексам
                        result[0] = array[i];
                        result[1] = array[j];
                        gap = j - i;
                    }
                }
            }
        }
        if (result[0] == 0) {
            return new int[0];
        }
        return result;
    }


    //5 Создайте функцию, которая проверяет, является ли число точной
    //верхней границей факториала n.
    public static int[] isExact(int n) {
        int fact = 0;
        int i = 0;
        int[] res = new int[]{};
        while (fact < n) {
            i++;
            fact = factorial(i);
        }
        if (fact == n) {
            res = new int[]{n, i};
        }
        return res;
    }
    //алгоритм из перых тасков
    public static int factorial(int x) {
        int result = 1;
        for (int i = 1; i <= x; i++) {
            result = result * i;
        }
        return result; }




    //6 Создайте функцию, которая принимает десятичную дробь в строковой форме с
    //повторяющейся частью в круглых скобках и возвращает эквивалентную дробь в
    //строковой форме и в наименьших членах.

    public static String fractions(String str) {
        int[] array = new int[3];
        String[] split = str.split("\\."); //разделяем строку на две части, целую и все, что после точки
        array[0] = Integer.parseInt(split[0]);
        StringBuilder strNum1 = new StringBuilder();
        StringBuilder strNum2 = new StringBuilder();
        char[] chars = split[1].toCharArray(); //то, что было после точки разбиваем на чары
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (flag) {
                if (chars[i] != '(') { //все, что до скобки добавляем в первое число
                    strNum1.append(chars[i]);
                } else {
                    flag = false;
                    if (!strNum1.isEmpty()) {
                        array[1] = Integer.parseInt(strNum1.toString());
                    }
                }
            } else {
                if(chars[i] != ')') {  //все, что после скобки добавляем во второе число
                    strNum2.append(chars[i]);
                } else {
                    if (!strNum2.isEmpty()) {
                        array[2] = Integer.parseInt(strNum2.toString());
                    }
                    break; //на этом этапе мы закончили разбивать число в массив array
                }
            }
        }
        String denominatorStr = "9".repeat(strNum2.length()) +
                "0".repeat(strNum1.length());
        int denominator = Integer.parseInt(denominatorStr);
        int numerator = Integer.parseInt(strNum1.append(strNum2.toString()).toString()) - array[1];
        int[] fraction = simplifyFraction(numerator, denominator);
        fraction[0] += array[0] * fraction[1];
        return fraction[0] + "/" + fraction[1];
    }

    private static int[] simplifyFraction(int numerator, int denominator) {//метод, который выведет упрощенный числитель и знаменатель
        for(;;) {
            int nod = findNOD(denominator, numerator);
            if (nod > 1) {
                denominator /= nod;
                numerator /= nod;
            } else {
                return new int[] {numerator, denominator};
            }
        }
    }

    private static int findNOD(int num1, int num2) {
        int max = Integer.max(num1, num2);
        for (int i = max / 2; i > 1; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                return i;
            }
        }
        return 1;
    }



    //7 преобразуйте строку в серию слов (или последовательности
    //символов), разделенных одним пробелом, причем каждое слово имеет одинаковую
    //длину, заданную первыми 15 цифрами десятичного представления числа Пи
    public static String pilish_string(String string) {
        if (string.isEmpty()) {
            return string;
        }

        ArrayList<String> list = new ArrayList<>();
        double pi = Math.PI;
        char[] piChars = String.valueOf(pi).toCharArray();
        char[] charsOfString = string.toCharArray();
        int startInd = 0;

        for (char i : piChars) {
            if (i != '.') {

                int length = Integer.parseInt(String.valueOf(i)); //определяем длину подстроки
                int counter = 0;
                StringBuilder temp = new StringBuilder();

                if (startInd >= charsOfString.length) {
                    break;
                }

                for (int j = startInd; j < startInd + length; j++) {
                    if (j < charsOfString.length) {
                        temp.append(charsOfString[j]);
                    } else {
                        int lenRep = length - counter; //вычисляется количество символов, которые нужно повторить в подстроке
                        temp.append(temp.substring(temp.length() - 1).repeat(lenRep));
                        break;
                    }
                    counter += 1;
                    if (counter == length) {
                        break;
                    }
                }

                list.add(temp.toString());
                startInd += Integer.parseInt(String.valueOf(i));

            }
        }
        StringBuilder out = new StringBuilder();
        for (String i : list) { //каждая подтрока добавляется  результат с пробелом
            out.append(" ").append(i);
        }
        return out.substring(1); //с 1 чтобы удалить первый пробел
    }

    //8 калькулятор
    public static String generateNonconsecutive(String str) {
        if (str.isEmpty()) return "Строка пустая";
        str = str.replaceAll("\\(", "( ").replaceAll("\\)", " )");
        String[] array = str.split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        list = generateNonList(list);
        return !list.isEmpty() ? String.valueOf(list.get(0)) : "Деление на 0";
    }

    private static ArrayList<String> generateNonList(ArrayList<String> list) {
        boolean flag = false;
        ArrayList<String> subList = new ArrayList<>();
        int first = 0;
        int last;
        while (list.contains("(")) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1).equals("(")) {
                    first = i;
                    flag = true;
                    subList = new ArrayList<>();
                }
                if (list.get(i).equals(")")) {
                    last = i - 1;
                    replaceSubList(list, generateNonList(subList).get(0), first, last);
                    flag = false;
                }
                if (flag) {
                    subList.add(list.get(i));
                }
            }
        }
        if (list.contains("*")) {
            countUp(list, "*");
        }
        if (list.contains("/")) {
            countUp(list, "/");
        }
        if (list.contains("+")) {
            countUp(list, "+");
        }
        if (list.contains("-")) {
            countUp(list, "-");
        }
        return list;
    }

    private static void replaceSubList(ArrayList<String> list, String replaceStr, int firstInd, int lastInd) {
        for (int i = firstInd - 1; i < lastInd + 1; i++) {
            list.remove(firstInd);
        }
        list.set(firstInd - 1, replaceStr);
    }

    private static void countUp(ArrayList<String> list, String ch) {
        while (list.contains(String.valueOf(ch))) {
            int index = list.indexOf(ch);
            int first = Integer.parseInt(list.get(index - 1));
            int second = Integer.parseInt(list.get(index + 1));
            if (ch.equals("*")) {
                replaceSubList(list, String.valueOf(first * second), index, index);
            } else if (ch.equals("/")) {
                if (second == 0) {
                    list.clear();
                    return;
                }
                replaceSubList(list, String.valueOf(first / second), index, index);
            } else if (ch.equals("+")) {
                replaceSubList(list, String.valueOf(first + second), index, index);
            } else if (ch.equals("-")) {
                replaceSubList(list, String.valueOf(first - second), index, index);
            }
        }
    }


    //9 Для данной строки str определите, действительна ли она.
    public static String isValid(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();

        for (char i : chars) { //считаем количество каждого символа в строке
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Integer[] nums = map.values().toArray(new Integer[0]);
        Arrays.sort(nums);
        boolean flag = true;
        Integer first = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (!Objects.equals(first, nums[i])) {
                flag = false;
                break;
            }
        }

        if (!nums[nums.length - 1].equals(first + 1) && !nums[nums.length - 1].equals(first)) {
            flag = false;
        }
        return flag ? "YES" : "NO";
    }

    //10 Создайте функцию, которая будет находить наибольшую общую
    //подпоследовательность (LCS) для двух строк.
    public static String findLCS(String str1, String str2) {
        String[][] matrix = new String[str1.length() + 1][str2.length() + 1];
        for (String[] arr : matrix) {
            Arrays.fill(arr, "");
        }
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = matrix[i].length - 2; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    matrix[i][j] = str1.charAt(i) + matrix[i + 1][j + 1];
                } else {
                    if (matrix[i][j + 1].length() > matrix[i + 1][j].length()) {
                        matrix[i][j] = matrix[i][j + 1];
                    } else {
                        matrix[i][j] = matrix[i + 1][j];
                    }
                }
            }
        }
        return matrix[0][0];
    }












}
