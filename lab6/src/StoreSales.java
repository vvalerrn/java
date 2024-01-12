import java.util.HashMap;
import java.util.Map;

public class StoreSales {
    private Map<String, Integer> sales;

    public StoreSales() {
        sales = new HashMap<>();
    }

    public void addSale(String product, int quantity) {
        if (sales.containsKey(product)) {
            int currentQuantity = sales.get(product);
            sales.put(product, currentQuantity + quantity);
        } else {
            sales.put(product, quantity);
        }
    }
    public String salesList() {
        StringBuilder list = new StringBuilder();
        ///перебираем все ключи
        for (String product : sales.keySet()) {
            list.append(product).append(", ");
        }
        String resList = list.toString();
        if (!resList.isEmpty()) {
            resList = resList.substring(0, resList.length() - 2); // удаляем последнюю запятую и пробел
        }
        return resList;

    }
    //подсчет общей суммы продаж
    public int getTotalSales() {
        int totalSales = 0;
        for (int quantity : sales.values()) {
            totalSales += quantity;
        }
        return totalSales;
    }

    public String getMostPopularProduct() {
        String PopularProduct = null;
        int maxQuantity = 0;
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                PopularProduct = entry.getKey();
                maxQuantity = entry.getValue();
            }
        }
        return PopularProduct;
    }
}
