import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Warehouse {
    private final List<Integer> products;
    private int totalWeight;

    public Warehouse(List<Integer> products) {
        this.products = products;
    }

    public synchronized int takeProduct() {
        if (products.isEmpty() || totalWeight >= 150) {
            return 0;
        }
        int productWeight = products.get(0);
        if (totalWeight + productWeight > 150) {
            return 0;
        }
        products.remove(0);
        totalWeight += productWeight;
        return productWeight;
    }

    public static void main(String[] args) {
        List<Integer> products = new ArrayList<>();
        products.add(56);
        products.add(65);
        products.add(10);

        Warehouse warehouse = new Warehouse(products);

        CountDownLatch startSignal = new CountDownLatch(1); //счетчик устанавливается в 1, чтобы все потоки начали работу одновременно
        CountDownLatch finishSignal = new CountDownLatch(3); //счетчик устанавливается в 3, чтобы дождаться завершения работы всех потоков

        Thread worker1 = new Thread(new Worker("Грузчик 1", warehouse, startSignal, finishSignal));
        Thread worker2 = new Thread(new Worker("Грузчик 2", warehouse, startSignal, finishSignal));
        Thread worker3 = new Thread(new Worker("Грузчик 3", warehouse, startSignal, finishSignal));

        worker1.start();
        worker2.start();
        worker3.start();

        System.out.println("Начало переноса товаров.");
        startSignal.countDown(); // счетчик с 1 обращается в 0 и запускается механизм переноса

        try {
            finishSignal.await(); // пока счетчик с 3 не станет 0, ожидаем конца переноса товаров
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Перенос товаров завершен.");
    }
}

