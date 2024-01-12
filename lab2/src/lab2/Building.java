package lab2;

import java.util.StringJoiner;

public class Building extends AbstractBuilding {
    private double rating;
    private String phoneNumber;
    private String webSite;
    private String inf;
    private String methods;

    public Building(String name, String address, String owner, double rating, String phoneNumber,String webSite) {
        super(name, address,owner);
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.webSite= webSite;
        information();
        communicationMethods();
    }
    public Building(){
        super();
        this.rating = 0;
        this.phoneNumber = " ";
        this.webSite = "Something";
    }
    @Override
    public void output() {
        super.output();
        System.out.println(rating);
        System.out.println(phoneNumber);
        System.out.println(webSite);
    }
    public String getInformation() {
        return inf;
    }
    public String getCommunicationMethods() {
        return methods;
    }
    public void information() {
        inf = getName() + " " + getOwner() + " " + getRating();
    }
    public void communicationMethods() {
        methods = getPhoneNumber() + " " + getWebSite();
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public double getRating() {
        return rating;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getWebSite() {
        return webSite;
    }
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
