package pro.sky.homeworkexercises.homework26.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworkexercises.homework26.Employe;
import pro.sky.homeworkexercises.homework26.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworkexercises.homework26.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkexercises.homework26.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeService {

    private final static int MAX_SIZE = 10;
    private final List<Employe> employes = new ArrayList<>();

    public Employe add(String firstName, String lastName) {
        if (employes.size() > MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
        Employe newEmploye = new Employe(firstName, lastName);
        if (employes.contains(newEmploye)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }
        employes.add(newEmploye);
        return newEmploye;
    }

    public Employe delete(String firstName, String lastName) {
        Employe employeForDelete = new Employe(firstName, lastName);
        if (!employes.contains(employeForDelete)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в списке");
        }
        employes.remove(employeForDelete);
        return employeForDelete;
    }

    public Employe find(String firstName, String lastName) {
        Employe employeLookingFor = new Employe(firstName, lastName);
        Employe result = null;
        for (Employe employe : employes) {
            if (employe.equals(employeLookingFor)) {
                return employe;
            }
        }
        return result;
    }

    public List<Employe> getAll() {
        return employes;
    }
}
