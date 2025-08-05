package Structural;

import java.util.ArrayList;
import java.util.List;

// 1. Component
interface Employee {
    void showEmployeeDetails();
}

// 2. Leaf
class Developer implements Employee {
    private String name;
    private long empId;
    private String position;

    public Developer(long empId, String name, String position) {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " (" + position + ")");
    }
}

// 3. Another Leaf
class Designer implements Employee {
    private String name;
    private long empId;

    public Designer(long empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " (Designer)");
    }
}

// 4. Composite
class Manager implements Employee {
    private List<Employee> team = new ArrayList<>();

    public void addEmployee(Employee emp) {
        team.add(emp);
    }

    public void removeEmployee(Employee emp) {
        team.remove(emp);
    }

    public void showEmployeeDetails() {
        for (Employee emp : team) {
            emp.showEmployeeDetails();
        }
    }
}

// 5. Client
public class CompositePatternExample {
    public static void main(String[] args) {
        Developer dev1 = new Developer(101, "Alice", "Frontend Dev");
        Developer dev2 = new Developer(102, "Bob", "Backend Dev");
        Designer designer1 = new Designer(103, "Charlie");

        Manager manager = new Manager();
        manager.addEmployee(dev1);
        manager.addEmployee(dev2);
        manager.addEmployee(designer1);

        System.out.println("---- Manager's Team ----");
        manager.showEmployeeDetails();

        // Nested Composite
        Manager generalManager = new Manager();
        Developer dev3 = new Developer(104, "David", "Fullstack Dev");
        generalManager.addEmployee(manager);
        generalManager.addEmployee(dev3);

        System.out.println("---- General Manager's Team ----");
        generalManager.showEmployeeDetails();
    }
}

