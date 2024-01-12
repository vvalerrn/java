package lab3;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer,Employee> firm = new HashTable<>(50);
        firm.put(12345,new Employee("Ivan", "Manager", 45000));
        firm.put(54321,new Employee("Vladimir", "Programmer", 100000));
        firm.put(67835,new Employee("Alice", "Administrator", 40000));
        firm.remove(54321);
        System.out.println((firm.get(12345).getName()));
        System.out.println(firm.get(54321));
        firm.get(67835).setPosition("Manager");
        System.out.println(firm.get(67835).getPosition());



    }
}