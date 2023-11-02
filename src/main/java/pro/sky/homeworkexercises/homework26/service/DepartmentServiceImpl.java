package pro.sky.homeworkexercises.homework26.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworkexercises.homework26.Employe;
import pro.sky.homeworkexercises.homework26.exceptions.EmployeeNotFoundException;


import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentServiceImpl {

    private final EmployeService employeService;

    public DepartmentServiceImpl(EmployeService employeeService) {
        this.employeService = employeeService;
    }

    public Employe getEmployeWithMaxSalary(Integer departmentId) {
        return employeService.getAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employe :: getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Такого сотрудника нет в списке"));
    }

    public Employe getEmployeWithMinSalary(Integer departmentId) {
        return employeService.getAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employe :: getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Такого сотрудника нет в списке"));
    }

    public Map<Integer, List<Employe>> getEmployesByDepartment(Integer departmentId) {
        return employeService.getAll().stream()
                .filter(e -> departmentId == null || e.getDepartmentId() == departmentId)
                .collect(groupingBy(Employe::getDepartmentId, toList()));
    }
}
