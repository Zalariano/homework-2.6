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

    private final static int MAX_SIZE = 10;
    private final Map<String, Employe> employes = new HashMap<>();

    public Employe add(String firstName, String lastName) {

        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);

        validateFirstAndLastName(firstName, lastName);


        if (employes.size() > MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
        String key = getKey(firstName, lastName);
        if (employes.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        Employe newEmploye = new Employe(firstName, lastName);
        employes.put(key, newEmploye);
        return newEmploye;
    }

    public Employe delete(String firstName, String lastName) {
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);

        validateFirstAndLastName(firstName, lastName);

        String key = getKey(firstName, lastName);
        Employe employeForDelete = employes.get(key);
        if (!employes.containsKey(key)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
        }
        employes.remove(key);
        return employeForDelete;
    }

    public Employe find(String firstName, String lastName) {
        firstName = StringUtils.capitalize(firstName);
        lastName = StringUtils.capitalize(lastName);

        validateFirstAndLastName(firstName, lastName);

        String key = getKey(firstName, lastName);
        if (!employes.containsKey(key)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
        }
        return employes.get(key);
    }

    public Collection<Employe> getAll() {
        return employes.values();
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
