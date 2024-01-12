package lab3;

public class Employee {
    String name;
    String position;
    float salary;

    public Employee(String name, String position, float salary){
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    public String getName() {
        if (name == null) {
            return null;
        } else {
            return name;
        }
    }

    public String getPosition() {
        if (position == null) {
            return null;
        } else {
            return position;
        }
    }
    public float getSalary() {
        return salary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }

}
