package hash;

import java.util.HashMap;
import java.util.HashSet;

public class Algorithms {
    public static void main(String[] args) {

        Employee employee = new Employee("Robby", 3827,
                "Technology");
        Employee employee2 = new Employee("Bobby", 9612,
                "Marketing");
        Employee employee3 = new Employee("Sally", 2519,
                "Sales");

        HashMap<Integer, Employee> employeesById = new HashMap<>();
        employeesById.put(employee.id, employee);
        employeesById.put(employee2.id, employee2);
        employeesById.put(employee3.id, employee3);

        Employee retrievedEmployee = employeesById.get(9612); // get value by key, if not found, will return null

        if(retrievedEmployee != null) {
            System.out.println(retrievedEmployee.name + " : " + retrievedEmployee.department);
        }

        // working with data set where each item is unique
        HashSet<String> productCodes = new HashSet<>();
        productCodes.add("2T26B");
        productCodes.add("9K42P");
        productCodes.add("H5J781");

        // can check whether a given code is valid using the contains method
        System.out.println(productCodes.contains("H5J781"));
        System.out.println(productCodes.contains("Hwef"));



    }
}
