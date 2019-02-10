package main.advanced.streams;

public class Employee {

    private String name;
    private int age;
    private City city;
    private Employer employer;
    private TechnicalLevel tehnicalLevel;

    public Employee(String name,
                    int age,
                    City city,
                    Employer employer,
                    TechnicalLevel tehnicalLevel) {

        this.name = name;
        this.age = age;
        this.city = city;
        this.employer = employer;
        this.tehnicalLevel = tehnicalLevel;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public City getCity() {
        return city;
    }

    public Employer getEmployer() {
        return employer;
    }

    public TechnicalLevel getTehnicalLevel() {
        return tehnicalLevel;
    }

    @Override
    public String toString() {

        return String.format(
                "%-10s | %-10d | %-10s | %-10s | %-10s",
                name,
                age,
                city.toString(),
                employer.name(),
                tehnicalLevel.name()
        );
        /*return String.join(" | ",
                name,
                age + "",
                city.toString(),
                employer.name(),
                tehnicalLevel.name());*/
    }
}
