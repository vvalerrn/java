package lab2;

public class Cafe extends Building{
    private double price;
    private int goods;
    private double receipt;
    private double bill;

    public Cafe(String name, String address, String owner,
                double rating, String phoneNumber, String webSite, double price, int goods) {
        super(name, address, owner, rating, phoneNumber, webSite);
        this.price = price;
        this.goods = goods;
        cashReceipt();
        averageBill();
    }
    public Cafe() {
        super();
        this.price = 0;
        this.goods = 0;
    }
    public void cashReceipt() {
        receipt = price*goods;
    }
    public void averageBill(){
        bill = receipt/goods;
    }
    public double getCashReceipt() {
        return receipt;
    }
    public double getAverageBill() {
        averageBill();
        return bill;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setGoods(int goods) {
        this.goods = goods;
    }
    public double getPrice() {
        return price;
    }
    public int getGoods() {
        return goods;
    }




}
