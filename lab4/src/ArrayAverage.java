public class ArrayAverage {
    public static void main(String[] args) {
        int[] array = new int[2];
        try {
            for (int i = 0; i < args.length; i++) {
                array[i] = Integer.parseInt(args[i]);
            }
            double average = calculateAverage(array);
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Array index out of bounds");
        } catch (NumberFormatException e) {
        System.out.println("type error");
        } catch (Exception e) {
        System.out.println("error");
        }
    }

    public static double calculateAverage(int[] array) {
        double sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum / array.length;
    }
}
