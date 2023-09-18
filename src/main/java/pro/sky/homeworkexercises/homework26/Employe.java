package pro.sky.homeworkexercises.homework26;

import java.util.Objects;
import java.util.Random;

public class Employe {
    private final String firsName;
    private final String lastName;
    private final int department;
    private int salary;

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employe(String firsName, String lastName) {
        Random random = new Random();
        this.firsName = firsName;
        this.lastName = lastName;
        this.salary = random.nextInt(10000) + 1000;
        this.department = random.nextInt(2) + 1;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(firsName, employe.firsName) && Objects.equals(lastName, employe.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firsName, lastName);
    }

    @Override
    public String toString() {
        return "Employe{" +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
