package pro.sky.homeworkexercises.homework26.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import pro.sky.homeworkexercises.homework26.Employe;
import pro.sky.homeworkexercises.homework26.service.EmployeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employe")

public class EmployeController {

    @ExceptionHandler({HttpStatusCodeException.class})
    public String handleException(HttpStatusCodeException e){
        return " Code: " + e.getStatusCode() + ". Error: " + e.getMessage();
    }
    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public Collection<Employe> getAll() {
        return employeService.getAll();
    }

    @GetMapping("/add")
    public Employe add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int departmentId) {
        return employeService.add(firstName, lastName,salary,departmentId);
    }

    @GetMapping("/remove")
    public Employe delete(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int departmentId) {
        return employeService.delete(firstName, lastName,salary,departmentId);
    }

    @GetMapping("/find")
    public Employe find(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int departmentId) {
        return employeService.find(firstName, lastName,salary,departmentId);
    }
}
