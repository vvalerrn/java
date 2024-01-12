package lab2;

public class Shop extends Building{
    private double price;
    private int buyers;
    private int goods;
    private double receipt;
    private double bill;
    private int serviceTime;
    private int queue;


    public Shop(String name, String address, String owner,
                double rating, String phoneNumber, String webSite, double price, int goods,int buyers) {
        super(name, address, owner, rating, phoneNumber, webSite);
        this.price = price;
        this.goods = goods;
        cashReceipt();
        averageBill();
        queue();
    }
    public Shop() {
        super();
        this.price = 0;
        this.goods = 0;
        this.buyers = 0;
    }
    public void cashReceipt() {
        receipt = price*goods;
    }
    public void averageBill(){
        bill = receipt/goods;
    }
    public void queue(){
        queue = buyers*serviceTime;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setGoods(int goods) {
        this.goods = goods;
    }
    public void setBuyers(int buyers) {
        this.buyers = buyers;
    }
    public double getAverageBill() {
        return bill;
    }
    public double getPrice() {
        return price;
    }
    public int getGoods() {
        return goods;
    }
    public int getBuyers() {
        return buyers;
    }

}
