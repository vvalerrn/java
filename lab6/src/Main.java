public class Main {
    public static void main(String[] args) {
        System.out.println("Stack task");
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println("StoreSales task");
        StoreSales sales = new StoreSales();
        sales.addSale("bread", 38);
        sales.addSale("milk", 15);
        sales.addSale("bread", 55);
        sales.addSale("apple", 24);
        sales.addSale("cucumber", 32);
        sales.addSale("egg", 50);
        System.out.println(sales.salesList());
        System.out.println(sales.getTotalSales());
        System.out.println(sales.getMostPopularProduct());



    }
}