package main.advanced.objectOverrides;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static main.advanced.objectOverrides.Employer.AZETS;

public class EmployeeTest {

    // EQUALS

    @Test
    public void same_object_test(){
        Employee employee1 = new Employee(null, 0, null);

        System.out.println(employee1.equals(employee1));
        Assertions.assertEquals(employee1, employee1);
    }

    @Test
    public void null_other_object_test(){
        Employee employee1 = new Employee("Dan", 38, AZETS);
        Employee nullEmployee2 = null;

        System.out.println(employee1.equals(nullEmployee2));
        Assertions.assertFalse(employee1.equals(nullEmployee2));
    }

    @Test
    public void null_fields_test(){
        Employee nullEmployee1 = new Employee(null, 0, null);
        Employee nullEmployee2 = new Employee(null, 0, null);

        System.out.println(nullEmployee1.equals(nullEmployee2));
        Assertions.assertEquals(nullEmployee1, nullEmployee2);
    }

    @Test
    public void same_field_values_employees_test(){
        Employee employee1 = new Employee("Dan", 37, AZETS);
        Employee employee2 = new Employee("Dan", 37, AZETS);

        System.out.println(employee1.equals(employee2));
        Assertions.assertEquals(employee1, employee2);
    }

    @Test
    public void equals_clone_test(){
        Employee employee = new Employee("Dan", 37, AZETS);
        Employee employeeClone = (Employee)employee.clone();

        Assertions.assertEquals(employee, employeeClone);
    }

    @Test
    public void equal_operator_test1(){
        Employee employee1 = new Employee("Dan", 37, AZETS);
        Employee employee2 = new Employee("Dan", 37, AZETS);

        System.out.println(employee1 == employee2);
        Assertions.assertFalse(employee1 == employee2);
    }

    @Test
    public void equal_operator_test2(){
        Employee employee1 = new Employee("Dan", 37, AZETS);
        Employee employee2 = employee1;

        System.out.println(employee1 == employee2);
        Assertions.assertTrue(employee1 == employee2);
    }

    @Test
    public void equal_operator_test3(){
        Employee employee = new Employee("Dan", 37, AZETS);
        Employee employeeClone = (Employee)employee.clone();

        System.out.println(employee == employeeClone);
        Assertions.assertFalse(employee == employeeClone);
    }

    // HASHCODE

    @Test
    public void hashcode_test(){
        Employee employee1 = new Employee("Dan", 37, AZETS);
        Employee employee2 = new Employee("Dan", 37, AZETS);

        System.out.println("employee1 hashcode: " + employee1.hashCode());
        System.out.println("employee2 hashcode: " + employee2.hashCode());

        Assertions.assertEquals(
                employee1.hashCode(),
                employee2.hashCode());
    }

    @Test
    public void hashcode_clone_test(){
        Employee employee = new Employee("Dan", 37, AZETS);
        Employee employeeClone = (Employee)employee.clone();

        System.out.println("employee1 hashcode: " + employee.hashCode());
        System.out.println("employee2 hashcode: " + employeeClone.hashCode());

        Assertions.assertEquals(
                employee.hashCode(),
                employeeClone.hashCode());
    }
}
