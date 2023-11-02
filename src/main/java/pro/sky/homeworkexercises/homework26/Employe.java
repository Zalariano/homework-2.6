package pro.sky.homeworkexercises.homework26;

import java.util.Objects;

public class Employe {
    private final String firsName;
    private final String lastName;
    private final int departmentId;
    private int salary;

    public Employe(String firsName, String lastName,int salary,int departmentId) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
