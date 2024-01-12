import java.util.concurrent.CountDownLatch;

class Worker implements Runnable {
    private final String name;
    private final Warehouse warehouse; //позволяет каждому экземпляру класса Worker иметь доступ к одному и тому же объекту Warehouse,
    // чтобы грузчики могли брать товары с одного и того же склада.
    private final CountDownLatch startSignal;
    private final CountDownLatch finishSignal;

    public Worker(String name, Warehouse warehouse, CountDownLatch startSignal, CountDownLatch finishSignal) {
        this.name = name;
        this.warehouse = warehouse;
        this.startSignal = startSignal;
        this.finishSignal = finishSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await(); // Ожидаем начала переноса товаров
            int totalWeight = 0;

            while (totalWeight < 150) {
                int productWeight = warehouse.takeProduct();
                if (productWeight == 0) {
                    break;
                }

                totalWeight += productWeight;
                System.out.println(name + " взял товар весом " + productWeight + " кг.");
            }

            System.out.println(name + " переносит товары общим весом " + totalWeight + " кг.");
            Thread.sleep(1000); // Имитируем разгрузку
            System.out.println(name + " закончил разгрузку.");
            finishSignal.countDown(); // Сообщаем, что завершили разгрузку
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
