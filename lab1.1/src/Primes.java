public class Primes{
    public static void main(String[] args){
        for (int i = 2; i <= 100; i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean isPrime(int n){
        if (n % 2 == 0 && n % 5 == 0) {
            return true;
        }

        return false;
    }
}