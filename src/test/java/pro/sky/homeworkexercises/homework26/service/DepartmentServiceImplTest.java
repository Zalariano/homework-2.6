package pro.sky.homeworkexercises.homework26.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homeworkexercises.homework26.Employe;
import pro.sky.homeworkexercises.homework26.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkexercises.homework26.service.utils.EmployeGenerator;

import java.util.*;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.homeworkexercises.homework26.service.utils.EmployeGenerator.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeService employeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void getEmployeWithMaxSalary_success() {
        Integer departmentId = FIRSTDEPARTMENT_ID;

        when(employeService.getAll()).thenReturn(getAllEmploye());

        Employe expectedEmploye = getEmploye2();

        Employe actualEmploye = departmentService.getEmployeWithMaxSalary(departmentId);
        assertEquals(expectedEmploye, actualEmploye);
        assertTrue(expectedEmploye.getSalary() > EmployeGenerator.getEmploye().getSalary());
    }

    @Test
    void getEmployeWithMaxSalary_withEmployeeNotFoundException() {
        Integer departmentId = FIRSTDEPARTMENT_ID;

        when(employeService.getAll()).thenReturn(Collections.emptyList());

        String expectedMessege = "Такого сотрудника нет в списке";

        Exception exception = assertThrows(
                EmployeeNotFoundException.class,
                () -> departmentService.getEmployeWithMaxSalary(departmentId)
        );
        assertEquals(expectedMessege, exception.getMessage());

    }

    @Test
    void getEmployeWithMinSalary_success() {
        Integer departmentId = FIRSTDEPARTMENT_ID;

        when(employeService.getAll()).thenReturn(getAllEmploye());

        Employe expectedEmploye = EmployeGenerator.getEmploye();

        Employe actualEmploye = departmentService.getEmployeWithMinSalary(departmentId);
        assertEquals(expectedEmploye, actualEmploye);
        assertTrue(expectedEmploye.getSalary() < getEmploye2().getSalary());
    }

    @Test
    void getEmployeWithMinSalary_withEmployeeNotFoundException() {
        Integer departmentId = FIRSTDEPARTMENT_ID;

        when(employeService.getAll()).thenReturn(Collections.emptyList());

        String expectedMessege = "Такого сотрудника нет в списке";

        Exception exception = assertThrows(
                EmployeeNotFoundException.class,
                () -> departmentService.getEmployeWithMinSalary(departmentId)
        );
        assertEquals(expectedMessege, exception.getMessage());
    }

    @Test
    void getEmployes_withDepId() {
        Integer departmentId = FIRSTDEPARTMENT_ID;

        when(employeService.getAll()).thenReturn(getAllEmploye());

        Map<Integer, List<Employe>> expectedMap = new HashMap<>();
        expectedMap.put(FIRSTDEPARTMENT_ID, Arrays.asList(getEmploye(), getEmploye2()));

        Map<Integer, List<Employe>> actualMap = departmentService.getEmployesByDepartment(departmentId);
        assertEquals(expectedMap, actualMap);
    }

    @Test
    void getEmployes_withoutDepId() {
        Integer departmentId = null;

        when(employeService.getAll()).thenReturn(getAllEmploye());

        Map<Integer, List<Employe>> expectedMap = new HashMap<>();
        expectedMap.put(FIRSTDEPARTMENT_ID, Arrays.asList(getEmploye(), getEmploye2()));
        expectedMap.put(SECOND_DEPARTMENT_ID, Collections.singletonList(getEmploye3()));

        Map<Integer, List<Employe>> actualMap = departmentService.getEmployesByDepartment(departmentId);
        assertEquals(expectedMap, actualMap);
    }
}
