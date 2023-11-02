package pro.sky.homeworkexercises.homework26.service.utils;

import pro.sky.homeworkexercises.homework26.Employe;

import java.util.Arrays;
import java.util.List;

public class EmployeGenerator {
    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanov";
    public static final int SALARY = 10000;
    public static final int FIRSTDEPARTMENT_ID = 1;

    public static final String FIRST_NAME2 = "IvanSec";
    public static final String LAST_NAME2 = "IvanovSec";
    public static final int SALARY2 = 40000;
    public static final int SECOND_DEPARTMENT_ID = 2;

    public static final String FIRST_NAME3 = "IvanTh";
    public static final String LAST_NAME3 = "IvanovTh";
    public static final int SALARY3 = 15000;

    public static Employe getEmploye(){
        return new Employe(FIRST_NAME,LAST_NAME,SALARY,FIRSTDEPARTMENT_ID);
    }
    public static Employe getEmploye2(){
        return new Employe(FIRST_NAME2,LAST_NAME2,SALARY2,FIRSTDEPARTMENT_ID);
    }
    public static Employe getEmploye3(){
        return new Employe(FIRST_NAME3,LAST_NAME3,SALARY3,SECOND_DEPARTMENT_ID);
    }

    public static List<Employe> getAllEmploye(){
        return Arrays.asList(getEmploye(),getEmploye2(),getEmploye3());
    }
}
