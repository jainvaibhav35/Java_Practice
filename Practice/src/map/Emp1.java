package map;

/**
 * Created by linchpin on 13/7/18.
 */
class Empl{

    private String name;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Empl(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
