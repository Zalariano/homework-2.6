package pro.sky.homeworkexercises.homework26;

import java.util.Objects;

public class Employe {
    String firsName;
    String lastName;

    public Employe(String firsName, String lastName) {
        this.firsName = firsName;
        this.lastName = lastName;
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
