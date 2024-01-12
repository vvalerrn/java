package lab2;

public class Main {
    public static void main(String[] args) {

        Cafe cafe = new Cafe("cafe1", "address1","owner1",4.5,"89933","cafe@mail.ru",25,2);
        cafe.setPrice(30);
        System.out.println(cafe.getPrice());
        System.out.println(cafe.getAverageBill());
        Library library = new Library("library1", "address2","owner2",5.0,"70004","fhgkf@inbox.ru",30,60,15);
        System.out.println(library.getSeatPlace());

    }
}
