package pro.sky.homeworkexercises.homework26.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.homeworkexercises.homework26.Employe;
import pro.sky.homeworkexercises.homework26.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworkexercises.homework26.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkexercises.homework26.exceptions.EmployeeStorageIsFullException;
import pro.sky.homeworkexercises.homework26.exceptions.ValidateException;

import java.util.*;

@Service

public class EmployeService {

    private final static int MAX_SIZE = 2;
    private final List<Employe> employes = new ArrayList<>();

    public Employe add(String firstName, String lastName,int salary,int departmentId) {

        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);

        validateFirstAndLastName(firstName, lastName);


        if (employes.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
        Employe newEmploye = new Employe(firstName, lastName, salary, departmentId);

        if (employes.contains(newEmploye)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        employes.add(newEmploye);
        return newEmploye;
    }

    public Employe delete(String firstName, String lastName,int salary,int departmentId) {
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);

        validateFirstAndLastName(firstName, lastName);

        Employe employeForDelete = new Employe(firstName, lastName, salary, departmentId);
        boolean removeResult = employes.remove(employeForDelete);
        if (removeResult) {
            return employeForDelete;
        } else {
            throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
        }
    }

    public Employe find(String firstName, String lastName,int salary,int departmentId) {
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);

        validateFirstAndLastName(firstName, lastName);

        Employe employeeForFound = new Employe(firstName, lastName, salary, departmentId);
        for (Employe e : employes) {
            if (e.equals(employeeForFound)) {
                return e;
            }
        }

        throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
    }

    public List<Employe> getAll() {
        return employes;
    }

    public String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    private void validateFirstAndLastName(String firstName, String lastName){
        if (!StringUtils.isAlpha(firstName)) {
            throw new ValidateException("Имя содержит запрещенные символы");
        }
        if (!StringUtils.isAlpha(lastName)) {
            throw new ValidateException("Фамилия содержит запрещенные символы");
        }
    }
}
