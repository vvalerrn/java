package lab2;

public class AbstractBuilding {
    private String address;
    private String name;
    private String owner;
    static private int count;

    public AbstractBuilding(String name, String address, String owner) { //создаем объект, присваем ему имя, адрес и
                                                            // увеличиваем счетчик объектов на 1
        this.name = name;
        this.address = address;
        this.owner = owner;
        count += 1;
    }
    public AbstractBuilding() { //если при создании объекта не были переданы параметры
        this.name = "something";
        this.address = "somewhere";
        this.owner = "somebody";
        count += 1;
    }

    public void output() {
        System.out.println(name);
        System.out.println(address);
        System.out.println(owner);
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public String getOwner() {
        return owner;
    }
    public static int getCount() {
        return count;
    }
    public void setName(String name) { //после создания объекта можно поменять имя, далее адрес
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setOwner(String address) {
        this.owner = owner;
    }

}
