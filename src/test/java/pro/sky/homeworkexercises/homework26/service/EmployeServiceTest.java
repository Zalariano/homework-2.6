package pro.sky.homeworkexercises.homework26.service;

import org.junit.jupiter.api.Test;
import pro.sky.homeworkexercises.homework26.Employe;
import pro.sky.homeworkexercises.homework26.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkexercises.homework26.exceptions.EmployeeStorageIsFullException;
import pro.sky.homeworkexercises.homework26.service.utils.EmployeGenerator;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.homeworkexercises.homework26.service.utils.EmployeGenerator.*;

class EmployeServiceTest {

    private final EmployeService employeService = new EmployeService();

    @Test
    void add_success() {
        String firstName = EmployeGenerator.FIRST_NAME;
        String lastName = EmployeGenerator.LAST_NAME;
        int salary = EmployeGenerator.SALARY;
        int departmentId = EmployeGenerator.FIRSTDEPARTMENT_ID;

        Employe expectedEmploye = getEmploye();

        Employe actualEmloye = employeService.add(firstName, lastName, salary, departmentId);
        assertEquals(expectedEmploye, actualEmloye);
    }

    @Test
    void add_withEmployeeStorageIsFullException() {
        String firstName1 = EmployeGenerator.FIRST_NAME;
        String lastName1 = EmployeGenerator.LAST_NAME;
        int salary1 = EmployeGenerator.SALARY;
        int departmentId1 = EmployeGenerator.FIRSTDEPARTMENT_ID;

        String firstName2 = EmployeGenerator.FIRST_NAME2;
        String lastName2 = EmployeGenerator.LAST_NAME2;
        int salary2 = EmployeGenerator.SALARY2;
        int departmentId2 = EmployeGenerator.FIRSTDEPARTMENT_ID;

        String firstName3 = EmployeGenerator.FIRST_NAME3;
        String lastName3 = EmployeGenerator.LAST_NAME3;
        int salary3 = EmployeGenerator.SALARY3;
        int departmentId3 = EmployeGenerator.SECOND_DEPARTMENT_ID;

        String expectedMessege = "Массив сотрудников переполнен";
        employeService.add(firstName2, lastName2, salary2, departmentId2);
        employeService.add(firstName3, lastName3, salary3, departmentId3);
        Exception exception = assertThrows(EmployeeStorageIsFullException.class,
                () -> employeService.add(firstName1, lastName1, salary1, departmentId1));
        assertEquals(expectedMessege, exception.getMessage());
    }

    @Test
    void delete_success() {
        String firstName = EmployeGenerator.FIRST_NAME;
        String lastName = EmployeGenerator.LAST_NAME;
        int salary = EmployeGenerator.SALARY;
        int departmentId = EmployeGenerator.FIRSTDEPARTMENT_ID;

        Employe expectedEmploye = getEmploye();

        employeService.add(FIRST_NAME, LAST_NAME, SALARY, FIRSTDEPARTMENT_ID);
        Employe actualEmloye = employeService.delete(firstName, lastName,salary,departmentId);
        assertEquals(expectedEmploye, actualEmloye);

    }

    @Test
    void delete_withEmployeeNotFoundException() {
        String firstName1 = EmployeGenerator.FIRST_NAME;
        String lastName1 = EmployeGenerator.LAST_NAME;
        int salary1 = EmployeGenerator.SALARY;
        int departmentId1 = EmployeGenerator.FIRSTDEPARTMENT_ID;

        String firstName2 = EmployeGenerator.FIRST_NAME2;
        String lastName2 = EmployeGenerator.LAST_NAME2;
        int salary2 = EmployeGenerator.SALARY2;
        int departmentId2 = EmployeGenerator.FIRSTDEPARTMENT_ID;

        String expectedMessege = "Такого сотрудника нет в списке";

        employeService.add(firstName2, lastName2, salary2, departmentId2);
        Exception exception = assertThrows(EmployeeNotFoundException.class,
                () -> employeService.delete(firstName1, lastName1,salary1,departmentId1));
        assertEquals(expectedMessege, exception.getMessage());
    }

    @Test
    void find_success() {
        String firstName = EmployeGenerator.FIRST_NAME;
        String lastName = EmployeGenerator.LAST_NAME;
        int salary = EmployeGenerator.SALARY;
        int departmentId = EmployeGenerator.FIRSTDEPARTMENT_ID;

        String firstName2 = EmployeGenerator.FIRST_NAME2;
        String lastName2 = EmployeGenerator.LAST_NAME2;
        int salary2 = EmployeGenerator.SALARY2;
        int departmentId2 = EmployeGenerator.FIRSTDEPARTMENT_ID;


        Employe expectedEmploye = getEmploye();

        employeService.add(firstName, lastName,salary,departmentId);
        Employe actualEmloye = employeService.find(firstName, lastName,salary,departmentId);
        assertEquals(expectedEmploye, actualEmloye);
    }


    @Test
    void find_withEmployeeNotFoundException() {
        String firstName1 = EmployeGenerator.FIRST_NAME;
        String lastName1 = EmployeGenerator.LAST_NAME;
        int salary1 = EmployeGenerator.SALARY;
        int departmentId1 = EmployeGenerator.FIRSTDEPARTMENT_ID;

        String firstName2 = EmployeGenerator.FIRST_NAME2;
        String lastName2 = EmployeGenerator.LAST_NAME2;
        int salary2 = EmployeGenerator.SALARY2;
        int departmentId2 = EmployeGenerator.FIRSTDEPARTMENT_ID;

        String expectedMessege = "Такого сотрудника нет в списке";

        employeService.add(firstName2, lastName2, salary2, departmentId2);
        Exception exception = assertThrows(EmployeeNotFoundException.class,
                () -> employeService.find(firstName1, lastName1,salary1,departmentId1));
        assertEquals(expectedMessege, exception.getMessage());
    }

    @Test
    void getAll_success() {

        List<Employe> expectedList = new ArrayList<>();


        List<Employe> actualList = employeService.getAll();
        assertEquals(expectedList, actualList);




    }
}