import java.util.Arrays;

public class practice3 {
    public static void main(String[] args) {
        System.out.println(replaceVovels("Even if you did this task not by yourself you have to understand every single line of code."));
        System.out.println(replaceVovels("apple"));
        System.out.println("------");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println("------");
        System.out.println(doesBlockFit(1,3,5,4,5));
        System.out.println(doesBlockFit(1,8,1,1,1));
        System.out.println(doesBlockFit(1,2,2,1,1));
        System.out.println("------");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println("------");
        int[] task5point1 = {1,-3,2};
        System.out.println(countRoots(task5point1));
        int[] task5point2 = {2,5,2};
        System.out.println(countRoots(task5point2));
        int[] task5point3 = {1,-6,9};
        System.out.println(countRoots(task5point3));
        System.out.println("------");
        String[][] task6point1 = {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}};
        System.out.println (Arrays.toString(salesData(task6point1)));
        String[][] task6point2 = {{"Fridge",  "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop",  "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}};
        System.out.println(Arrays.toString(salesData(task6point2)));
        System.out.println("------");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println("------");
        int[] task8point1 = {3,1,4,2,7,5};
        int[] task8point2 = {1,2,3,4,5};
        int[] task8point3 = {1,2,-6,10,3};
        int[] task8point4 = {2,2,2,2,2};
        System.out.println(waveForm(task8point1));
        System.out.println(waveForm(task8point2));
        System.out.println(waveForm(task8point3));
        System.out.println(waveForm(task8point4));
        System.out.println("------");
        System.out.println(commonVovel("Hello World"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println("------");
        int[][] nums = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {5, 5, 5, 5, 5}, {7, 4, 3, 14, 2}, {1, 0, 11, 10, 1}};
        System.out.println(Arrays.deepToString((dataScience(nums))));
        int[][] nums2 =  {{6, 4, 19, 0, 0}, {81, 25, 3, 1, 17}, {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217}, {5, 73, 0, 4, 21}};
        System.out.println(Arrays.deepToString((dataScience(nums2))));


    }

    //1  Создайте функцию, которая принимает строку и заменяет все гласные буквы на
    //символ «*».
    public static String replaceVovels(String str) {
        char[] nsrt = str.toCharArray();
        char[] vovles = {'A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i', 'o', 'u','y'};
        for (int i = 0; i < nsrt.length; i++) {
            for (int j = 0; j < vovles.length; j++) {
                if (nsrt[i] == vovles[j]) {
                    nsrt[i] = '*';
                }
            }
        }
        String result = new String(nsrt); //ко
        return result;
    }

    //2 Напишите функцию, которая принимает строку и заменяет две идущие подряд
    //буквы по шаблону «Double*».
    public static String stringTransform(String str) {
        char[] nstr = str.toCharArray();
        String result = "";
        for (int i = 0; i < str.length()-1; i++) {
            if (nstr[i] == nstr[i + 1]) {
                result += "Double" + String.valueOf(nstr[i]).toUpperCase();
                i++;
            } else {
                result += nstr[i];
            }
        }
        if(nstr[nstr.length-1]!=nstr[nstr.length-2]){
            result = result+ nstr[nstr.length-1];
        }
        return result;
    }

    //3 Помогите ребенку разобраться с игрушкой на развитие - поместится ли
    //параллелепипед в коробку с отверстиями определенных параметров. Напишите
    //функцию, которая принимает три измерения игрушечного блока: высоту(a),
    //ширину(b) и глубину(c) и возвращает true, если этот блок может поместиться в
    //отверстие с шириной(w) и высотой(h).


    // ???
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        int[] blockSize = {a, b, c};
        int[] holeSize = {w, h};
        Arrays.sort(blockSize);
        Arrays.sort(holeSize);
        return(blockSize[0] <= holeSize[0] && blockSize[1] <= holeSize[1]);
    }


    //4 Создайте функцию, которая принимает число в качестве входных данных и
    //возвращает true, если сумма квадратов его цифр имеет ту же четность, что и само
    //число. В противном случае верните false.

    public static boolean numCheck(int num){
        String str = String.valueOf((num));
        char[] nstr = str.toCharArray();
        int sumOfSquares = 0;
        for(int i = 0; i< nstr.length;i++){
            sumOfSquares += Integer.valueOf(nstr[i]);
        }
       // int result = Integer.valueOf(str);
        return(num%2 == sumOfSquares%2 );
    }

    //5 Создайте метод, который берет массив целых чисел-коэффициентов и возвращает
    //количество целочисленных корней квадратного уравнения.
    public static int countRoots(int[] numbers){
        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];
        int count = 0;
        int D = (int) Math.pow(b,2)- 4*a*c;
        if(D>=0){
            if(D == 0) {
                if ((int) (((double) (-b / 2 * a)) * 10) % 10 == 0){ count += 1;}
            }else{
                if ((int) ((((-b + Math.sqrt(D)) / (2 * a))) * 10) % 10 == 0) {count += 1;}
                if ((int) ((((-b - Math.sqrt(D)) / (2 * a))) * 10) % 10 == 0) {count += 1;}
            }
        }
        return count;
    }

    //6 Создайте метод, который принимает двумерный массив, представляющий
    //информацию о продажах разных товаров в различных магазинах, и возвращает
    //товары, которые были проданы в каждом из магазинов.

    public static String[] salesData(String[][] sales) {
        int maxim = 0;
        String result = "";
        for (int i = 0; i < sales.length; i++) {
            if (sales[i].length > maxim){
                maxim = sales[i].length;
            }
        }
        for (int i = 0; i < sales.length; i++) {
            if (sales[i].length == maxim){
                result += sales[i][0] + " ";
            }
        }
        String[] result1 = result.split(" ");
        return result1;
    }


    //7 Создайте функцию, которая определяет, можно ли разбить заданное предложение
    //на слова так, чтобы каждое слово начиналось с последней буквы предыдущего
    //слова.

    public static boolean validSplit(String str){
        str = str.toLowerCase();
        String[] nstr = str.split(" ");
        for (int i = 0; i < nstr.length - 1; i++) {
            char[] letters = nstr[i].toCharArray();
            char[] let2 = nstr[i+1].toCharArray();
            if (letters[(letters.length)-1] != let2[0])
                return false;
        }
        return true;
    }

    //8 Напишите метод, который определяет, является ли заданный массив
    //«волнообразным». Последовательность чисел считается волнообразной, если
    //разница между соседними элементами чередуется между убыванием и
    //возрастанием.

    public static boolean waveForm(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i] <= nums[i + 1] && nums[i + 1] <= nums[i + 2]) ||
                    (nums[i] >= nums[i + 1] && nums[i + 1] >= nums[i + 2])) {
                return false;
            }
        }
        return true;
    }

    //9 Напишите функцию, которая находит наиболее часто встречающуюся гласную в
    //предложении.

    public static char commonVovel(String str){
        int[] count = new int[6];
        str = str.toLowerCase();
        char[] nstr = str.toCharArray();
        char[] vovels = {'a', 'e', 'i', 'o', 'u','y'};
        for(int i = 0; i<nstr.length;i++){
            for(int j = 0; j< vovels.length;j++){
                if(nstr[i] == vovels[j]){
                    count[j] += 1;
                }
            }
        }
        int c = 0;
        char result = ' ';
        for (int i = 0; i < count.length; i++) {
            if (count[i] > c) {
                c = count[i];
                result = vovels[i];
            }
        }
        return result;
    }

    //10 Создайте функцию, которая принимает n целочисленных массивов длины n, а
    //затем изменяет каждый n-ый элемент n-го массива на среднее арифметическое
    //элементов n-го столбца остальных массивов.

    public static int[][] dataScience(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    sum += nums[j][i]; //сначала строка, потом столбец
                }
            }
            nums[i][i] = (int) (Math.round((double) sum / (nums.length - 1)));
        }
        return nums;
    }
}

