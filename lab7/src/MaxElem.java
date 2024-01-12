public class MaxElem {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 122},
                {7, 55, 1}
        };

        int rowCount = matrix.length;

        Thread[] threads = new Thread[rowCount];
        int[] maxElements = new int[rowCount];
        for (int i = 0; i < rowCount; i++) {
            final int row = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    maxElements[row] = findMaxElementInRow(matrix, row);
                }
            });
            threads[i].start();
        }


        for (Thread thread : threads) {
            try {
                thread.join(); //главный поток вызывает метод join для каждого потока, чтобы дождаться их завершения
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int maxElement = 0;
        for (int element : maxElements) {
            if (element > maxElement) {
                maxElement = element;
            }
        }
        System.out.println("Наибольший элемент: " + maxElement);
    }

    public static int findMaxElementInRow(int[][] matrix, int row) {
        int[] currentRow = matrix[row];
        int maxInRow = 0;
        for (int element : currentRow) {
            if (element > maxInRow) {
                maxInRow = element;
            }
        }
        return maxInRow;
    }
}
