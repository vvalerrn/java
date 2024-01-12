public class ElemSum {
    public static void main(String[] args) {
        final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] sum = {0};

//мы создаем два экземпляра потоков. анонимный класс, который реализует интерфейс Runnable и переопределяет метод run(), который будет выполняться в отдельном потоке.
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array.length / 2; i++) {
                    sum[0] += array[i];
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = array.length / 2; i < array.length; i++) {
                    sum[0] += array[i];
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            // ждем завершения потоков
            thread1.join(); //метод join() блокирует выполнение основного потока до тех пор, пока два потока не завершатся.
            thread2.join();
        } catch (InterruptedException e) { //возникает, когда поток, в котором выполняется код, прерывается или прерывается другим потоком.
            e.printStackTrace();
        }

        int totalSum = sum[0];
        System.out.println("Total sum: " + totalSum);
    }
}