package pro.sky.homeworkexercises.homework26;

import org.springframework.stereotype.Service;
import pro.sky.homeworkexercises.homework26.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkexercises.homework26.service.DepartmentService;
import pro.sky.homeworkexercises.homework26.service.EmployeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeService employeService;

    public DepartmentServiceImpl(EmployeService employeService) {
        this.employeService = employeService;
    }

    @Override
    public Employe getEmployeWithMaxSalary(Integer departmentId) {
        return employeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employe :: getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Такого сотрудника нет в списке"));
    }

    @Override
    public Employe getEmployeWithMinSalary(Integer departmentId) {
        return employeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employe :: getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Такого сотрудника нет в списке"));
    }

    @Override
    public Collection<Employe> getEmployes(Integer departmentId) {
        return employeService.getAll()
                .stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employe>> getEmploye() {
        return employeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employe::getDepartment));
    }
}
