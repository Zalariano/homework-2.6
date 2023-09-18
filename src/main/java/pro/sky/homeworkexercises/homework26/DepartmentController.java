package pro.sky.homeworkexercises.homework26;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homeworkexercises.homework26.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employe getEmployeWithMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employe getEmployeWithMinSalary(@RequestParam Integer departmentId) {
        return departmentService.getEmployeWithMinSalary(departmentId);
    }
@GetMapping(value = "/all",params = {"departmentId"})
    public Collection<Employe> getEmployes(@RequestParam Integer departmentId) {
        return departmentService.getEmployes(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employe>> getEmployes(){
        return departmentService.getEmploye();
    }
}
