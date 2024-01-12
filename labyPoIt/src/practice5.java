import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class practice5 {
    public static void main(String[] args){
        System.out.println("-------1------");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println("-------2------");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println("-------3------");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println("-------4------");
        System.out.println(totalPoints(new String[] {"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println("-------5------");
        System.out.println(Arrays.deepToString(sumsUp(new int[] {1, 2, 3, 4, 5})));
        System.out.println(Arrays.deepToString(sumsUp(new int[] {1, 2, 3, 7, 9})));
        System.out.println(Arrays.deepToString(sumsUp(new int[] {10, 9, 7, 2, 8})));
        System.out.println(Arrays.deepToString(sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7})));
        System.out.println("-------6------");
        System.out.println(takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[] {"10%"}));
        System.out.println(takeDownAverage(new String[] {"53%", "79%"}));
        System.out.println("-------7------");
        System.out.println(caesarCipher("hello world",3, "encode" ));
        System.out.println(caesarCipher("EPQSWX PEWX XEWO!",4, "decode" ));
        System.out.println("-------8------");
        System.out.println(setSetup(5,3));
        System.out.println(setSetup(7,3));
        System.out.println("-------9------");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"  ));
        System.out.println("-------10------");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));

        

    }



    ///1 Создайте функцию, которая возвращает true, если две строки имеют один и тот же
    //буквенный шаблон, и false в противном случае.
    public static boolean sameLetterPattern(String str1, String str2){
        String newFirst = stringToNumber(str1);
        String newSecond = stringToNumber(str2);
        return newFirst.equals(newSecond);
    }

    public static String stringToNumber(String input) {
        ArrayList<Character> letters = new ArrayList<>();
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if (letters.contains(input.charAt(i))) { //мы храним индекс каждой новой буквы, если такая уже была,
                                                    // просто вставляем ее первый индекс. таким образом проверяется шаблон
                result += letters.indexOf(input.charAt(i));
            } else {
                letters.add(input.charAt(i));
                result += letters.indexOf(input.charAt(i));
            }
        }

        return result;
    }

    //2
    public static String spiderVsFly(String position1, String position2) {

        int spiderX = position1.charAt(0) - 65;
        int spiderY = Integer.parseInt("" + position1.charAt(1));

        int flyX = position2.charAt(0) - 65;
        int flyY = Integer.parseInt("" + position2.charAt(1));

        StringBuilder way = new StringBuilder();
        if (Math.abs(spiderX - flyX) > 2 ) {
            for (int i = spiderY; i > 0; i--) {
                way.append((char) (spiderX + 65)).append(i).append("-"); //спускаем паука низ по ветке
            }
            for (int i = 0; i <= flyY; i++) {
                way.append((char) (flyX + 65)).append(i).append("-");
            }
        } else {
            if (spiderY > flyY) {
                for (int i = spiderY; i >= flyY; i--) {
                    way.append((char) (spiderX + 65)).append(i).append("-"); //если паук выше мухи, спускаемся до уровня мухи
                                                                            // и идем до нее по дуге
                }
                for (int i = spiderX; i != flyX;) {
                    if (spiderX - flyX > 0) { //можно пойти по часовой стрелке или против часовой
                        i--;
                    } else {
                        i++;
                    }
                    way.append((char) (i + 65)).append(flyY).append("-");
                }
            } else {
                for (int i = spiderX; i != flyX; ) { //если муха выше, то сначала по дуге, потом поднимаемся вверх
                    way.append((char) (i + 65)).append(spiderY).append("-");
                    if (spiderX - flyX > 0) {
                        i--;
                    } else {
                        i++;
                    }
                }
                for (int i = spiderY; i <= flyY; i++) {
                    way.append((char) (flyY + 65)).append(i).append("-");
                }
            }
        }
        way.delete(way.length() - 1, way.length());
        return way.toString();
    }


//3 Создайте функцию, которая будет рекурсивно подсчитывать количество цифр
//числа. Преобразование числа в строку не допускается, поэтому подход является
//рекурсивным.
    public static int digitsCount(int num) {
        int count = 0;
        num = num / 10;
        if (num != 0) {
            count += 1;
            count += digitsCount(num);
        } else {
            count += 1;
        }
        return count;
    }

    //4 Создайте функцию, которая принимает в массив уже угаданных слов расшифрованное 6-
    //буквенное слово и возвращает общее количество очков, набранных игроком в
    //определенном раунде
    public static int totalPoints(String[] guessedWords, String decryptedWord) {
        char[] chars = decryptedWord.toCharArray();
        Arrays.sort(chars);
        int points = 0;
        for (String i : guessedWords) {
            char[] chars1 = i.toCharArray();
            char[] chars2 = Arrays.copyOf(chars, chars.length); //создаем копию, чтобы заменять
                                                                // символы на пустоту
            Arrays.sort(chars1);
            boolean flag = true;
            for (char j : chars1) {
                boolean ifLetter_flag = false;
                for (int a = 0; a < chars.length; a++) {
                    if (j == chars2[a]) {
                        chars2[a] = ' ';
                        ifLetter_flag = true;
                    }
                }
                if (!ifLetter_flag) {
                    flag = false;
                }
            }
            if (flag) {
                points += i.length() - 2;
                if (i.length() == 6) {
                    points += 50;
                }
            }
        }
        return points;
    }


    //5 Создайте функцию, которая получает каждую пару чисел из массива, который
    //суммирует до восьми, и возвращает его как массив пар (отсортированный по
    //возрастанию).
    public static int[][] sumsUp(int[] numbers) {
        ArrayList<Integer> massive = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            massive.add(numbers[i]);
        }

        ArrayList<int[]> resList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] + numbers[i] == 8) { //составляем пары из тех, что в сумме дают 8, сортируем пару по возрастанию
                    int min = Math.min(numbers[i], numbers[j]);
                    int max = Math.max(numbers[i], numbers[j]);
                    resList.add(new int[]{min, max});
                }
            }
        }
        String result = "";

        for (int i = 0; i < resList.size(); i++) {
            for (int j = 0; j < resList.size() - 1; j++) {
                int[] cur= resList.get(j);
                int[] next = resList.get(j + 1);
                int firstDif = Math.abs(massive.indexOf(cur[0]) - massive.indexOf(cur[1]));
                int secondDif = Math.abs(massive.indexOf(next[0]) - massive.indexOf(next[1]));
                if (firstDif > secondDif) { // сравниваем две пары чисел по разности индексов, пару с меньшей разностью переставляем вперед
                    resList.set(j + 1, cur);
                    resList.set(j, next);
                } else if (firstDif == secondDif) {
                    if (cur[0] > next[0]) { //при одинаковой разности сравниваем первые элементы пар
                        resList.set(j + 1, cur);
                        resList.set(j, next);
                    }
                }
            }
        }
        return resList.toArray(new int[resList.size()][2]);
    }


    //6 Какой процент вы можете набрать на тесте, который в одиночку снижает средний
    //балл по классу на 5%? Учитывая массив оценок ваших одноклассников, создайте
    //функцию, которая возвращает ответ.
    public static String takeDownAverage(String[] resultsString) {
        double summ = 0;
        double averageSumm = 0;
        for (String result : resultsString) {
            summ += Integer.parseInt(result.substring(0, result.length() - 1)); //берем до предпоследнего символа, то есть до процента
            averageSumm = summ/resultsString.length;
        }
        int addedResult = (int) Math.round(averageSumm * (resultsString.length + 1) - 5 * (resultsString.length + 1) - summ);
        return addedResult + "%";
    }




    //7 Создайте функцию, которая будет шифровать и дешифровать сообщения с
    //использованием шифра Цезаря. Шифр Цезаря – это метод шифрования, в котором
    //каждая буква в сообщении сдвигается на фиксированное количество позиций в
    //алфавите. Например, если сдвиг составляет 3 позиции, то буква 'A' будет
    //зашифрована как 'D', 'B' как 'E' и так далее

    public static String caesarCipher(String str, int shift, String mode) {
        StringBuilder result = new StringBuilder();
        str = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Проверяем, является ли символ буквой алфавита
            if (Character.isLetter(ch)) {
                // Вычисляем сдвиг
                int shiftedValue;
                if (mode.equals("encode")) {
                    shiftedValue = (ch - 'A' + shift) % 26; //сначала из символа ch вычитается символ 'A',добавляется значение shift, то есть количество позиций, на которое нужно сдвинуть символы.
                                                            // результат делится на 26 для того, чтобы вернуться в пределы алфавита, если результат выходит за его пределы.
                } else {
                    shiftedValue = (ch - 'A' - shift + 26) % 26; //добавляется 26, сдвиг был положительным
                }

                // Преобразуем сдвинутое значение обратно в символ
                char shiftedChar = (char) ('A' + shiftedValue);


                result.append(shiftedChar);
            } else {
                //Если символ не является буквой, оставляем
                result.append(ch);
            }
        }

        return result.toString();
    }



    ///8 Создайте метод для рекурсивного вычисления количества различных способов как
    //можно разместить k элементов из множества из n элементов без повторений. Это
    //задача комбинаторики, и она часто используется в комбинаторных оптимизациях,
    //таких как размещение задач на стеллажах или распределение ресурсов.
    //Метод принимает два параметра, где n - количество элементов в множестве, а k -
    //количество элементов, которые нужно разместить (n >= k) и рассчитывает
    //количество размещений по формуле размещений без повторений: n! / (n - k)!

    public static int setSetup(int n, int k) {
        if (n < k) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        return n * setSetup(n - 1, k - 1);
    }



    //9 В этой задаче цель состоит в том, чтобы вычислить, сколько времени сейчас в двух
    //разных городах.
    public static String timeDifference (String cityA, String timeA, String cityB) {

        HashMap<String, int[] > city = new HashMap<>();
        HashMap<String, Integer> months = new HashMap<>();
        HashMap<String, Integer> daysInMonths = new HashMap<>();

        String[] monthsArray = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        city.put("Los Angeles", new int[] {-8, 0});
        city.put("New York", new int[] {-5, 0});
        city.put("Caracas", new int[] {-4, 30});
        city.put("Buenos Aires", new int[] {-3, 0});
        city.put("London", new int[] {0, 0});
        city.put("Rome", new int[] {1, 0});
        city.put("Moscow", new int[] {3, 0});
        city.put("Tehran", new int[] {3, 30});
        city.put("New Delhi", new int[] {5, 30});
        city.put("Beijing", new int[] {8, 0});
        city.put("Canberra", new int[] {10, 0});

        daysInMonths.put("January", 31);
        daysInMonths.put("February", 28);
        daysInMonths.put("March", 31);
        daysInMonths.put("April", 30);
        daysInMonths.put("May", 31);
        daysInMonths.put("June", 30);
        daysInMonths.put("July", 31);
        daysInMonths.put("August", 31);
        daysInMonths.put("September", 30);
        daysInMonths.put("October", 31);
        daysInMonths.put("November", 30);
        daysInMonths.put("December", 31);

        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);


        // 0-месяц, 1 - число, 2 - год,3 - время
        String[] time = timeA.split(" ");
        time[1] = time[1].replaceAll(",", "");


        int[] timeInCityA = city.get(cityA);
        int[] timeInCityB = city.get(cityB);

        int[] timeDifference = new int[] {timeInCityB[0] - timeInCityA[0],
                timeInCityB[1] - timeInCityA[1]};

        //  разбиваем время на часы и минуты, по двоеточию
        String[] currentTimeInString = time[3].split(":");
        int[] currentTime = {Integer.parseInt(currentTimeInString[0]),
                Integer.parseInt(currentTimeInString[1])};

        // время с учетом изменения часовых поясов
        int[] newTime = new int[] {currentTime[0] + timeDifference[0],
                currentTime[1] + timeDifference[1]};

        int month = months.get(time[0]);
        int date = Integer.parseInt(time[1]);
        int year = Integer.parseInt(time[2]);

        if (newTime[1] < 0) {
            newTime[1] = 60 + newTime[1];
            newTime[0] -= 1;
            if (newTime[0] < 0) {
                newTime[0] = 24 - newTime[0];
                date -= 1;
                if (date == 0) {
                    month -= 1;
                    if (month >= 1) {
                        date = daysInMonths.get(monthsArray[month - 1]);
                    }
                    else {
                        year -= 1;
                        month = 12;
                        date = 31;
                    }
                }
            }
        }

        if (newTime[1] >= 60) {
            newTime[1] = newTime[1] % 60;
            newTime[0] += 1;
        }

        if (newTime[0] >= 24) {
            newTime[0] -= 24;
            date += 1;
            if (date > daysInMonths.get(monthsArray[month - 1])) {
                month += 1;
                date = 1;
                if (month > 12) {
                    month = 1;
                    year += 1;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(year);
        ans.append("-");
        ans.append(month);
        ans.append("-");
        ans.append(date);
        ans.append(" ");
        if (newTime[0] <= 9) {
            ans.append("0");
        }
        ans.append(newTime[0]);
        ans.append(":");
        if (newTime[1] <= 9) {
            ans.append("0");
        }
        ans.append(newTime[1]);

        return ans.toString();
    }


    //10 Напишите функцию, которая принимает неотрицательное целое число и возвращает true,
    //если целое число является новым числом, и false, если это не так.
    public static boolean isNew(int num) {
        ArrayList<Integer> array = new ArrayList<>();
        int copyNum = num;
        while (num != 0) {
            array.add(num % 10);
            num /= 10;
        }

        if (array.size() > 1) {
            if (array.size() == 2 && array.contains(0)) {
                return true;
            } else {
                Collections.sort(array);
            }
        } else {
            return true;
        }

        while (array.get(0) == 0) {
            array.add(0);
            array.remove(0);
        }

        int i = 1;

        while (array.get(array.size() - 1) == 0) {
            array.add(i, 0);
            array.remove(array.size() - 1);
            i += 1;
        }

        String result = "";
        while (!array.isEmpty()) {
            result += array.get(0);
            array.remove(0);
        }

        return Integer.parseInt(result) == copyNum;
    }
}
