public class Main {
    public static void main(String[] args) { //принимает массив из строк
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println(fitCalc(15,1));
        System.out.println(fitCalc(24,2));
        System.out.println(fitCalc(41,3));
        System.out.println(containers(3,4,2));
        System.out.println(containers(5,0,2));
        System.out.println(containers(4,1,4));
        System.out.println(triangleType(5,5,5));
        System.out.println(triangleType(5,4,5));
        System.out.println(triangleType(4,3,5));
        System.out.println(triangleType(5,1,1));
        System.out.println(ternaryEvaluation(8,4));
        System.out.println(ternaryEvaluation(1,11));
        System.out.println(ternaryEvaluation(5,9));
        System.out.println(howManyItems(22,1.4f,2));
        System.out.println(howManyItems(45,1.8f,1.9f));
        System.out.println(howManyItems(100,2,2));
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println(gcd(48,18));
        System.out.println(gcd(52,8));
        System.out.println(gcd(259,28));
        System.out.println(ticketSaler(70,1500));
        System.out.println(ticketSaler(24,950));
        System.out.println(ticketSaler(53,1250));
        System.out.println(tables(5,2));
        System.out.println(tables(31,20));
        System.out.println(tables(123,58));


    }

    // задача 1
    public static float convert(int gallons) {return gallons * 3.785f;}

    // 2 задача
    public static int fitCalc(int minutes, int intensity) {return intensity * minutes;}


    //3 задача
    public static int containers(int boxes, int bags, int barrels) {
        return boxes * 20 + bags * 50 + barrels * 100;
    }

    //4 задача
    public static String triangleType(int x, int y, int z) {
        if ((x + y) > z & (x + z) > y & (z + y) > x) {
            if ((x == y) & (x == z)) {
                return "isosceles";
            } else if ((x == y) | (x == z) | (y == z)) {
                return "equilateral";
            } else {
                return "different-sided";
            }
        } else {
            return "not a triangle";
        }
    }

    //5 задача
    public static int ternaryEvaluation(int a, int b) {return (a>b) ? a : b; }

    //6 задача
    public static int howManyItems(int n, float w, float h) {
        return (int) (n / (w * h * 2));
    }

    // 7 задача
    public static int factorial(int x) {
        int result = 1;
        for (int i = 1; i <= x; i++) {
            result = result * i;
        }
        return result; }

    // 8 задача
    public static int gcd(int a, int b) {
        int result = 0;
        for (int i = 1000 ; i > 0; i--) {
            if ((a % i == 0) & (b % i == 0)) {
                result = i;
                break;
            }
        }
        return result;
    }

    //9 задача
    public static int ticketSaler(int number, int price) {
        return (int) (number * price * 0.72);
    }

    //10 задача
    public static int tables(int students, int tables) {
        if (tables * 2 > students) {
            return 0;
        } else return (students - tables * 2) / 2 + (students - tables * 2) % 2;
        }

}


