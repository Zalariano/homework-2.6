package pro.sky.homeworkexercises.homework26.service;

import pro.sky.homeworkexercises.homework26.Employe;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employe getEmployeWithMaxSalary(Integer departmentId);

    Employe getEmployeWithMinSalary(Integer departmentId);

    Collection<Employe> getEmployes(Integer departmentId);

    Map<Integer, List<Employe>> getEmploye();
}
