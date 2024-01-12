package lab2;

public class Library extends Building{
    public int visitors;
    public int books;
    public double average;
    public int sofas;
    public int places;


    public Library(String name, String address, String owner,
                double rating, String phoneNumber, String webSite, int visitors, int books,int sofas){
        super(name, address, owner, rating, phoneNumber, webSite);
        this.visitors = visitors;
        this.books = books;
        this.sofas = sofas;
        seatPlace();
        averageBooks();
    }
    public Library(){
        super();
        this.visitors = 0;
        this.books = 0;
    }
    public void averageBooks(){
        average = (double) books/visitors;
    }
    public void seatPlace(){
        places = sofas * 4;
    }

    public void setSofas(int sofas) {
        this.sofas = sofas;
    }
    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }
    public int getSeatPlace(){
        seatPlace();
        return places;
    }

    public int getVisitors() {
        return visitors;
    }
    public int getBooks() {
        return books;
    }
    public void setBooks(int books) {
        this.books = books;
    }
    public int getSofas() {
        return sofas;
    }




}
