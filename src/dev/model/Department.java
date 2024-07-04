package dev.model;

import java.util.Scanner;

public class Department {
    private String departmentName;
    private String manager;

    public Department() {
    }

    public Department(String departmentName, String manager) {
        this.departmentName = departmentName;
        this.manager = manager;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t ----------- Enter information department =========");
        System.out.print("Enter department name: "); this.departmentName = scanner.nextLine();
        System.out.print("Enter manager: "); this.manager = scanner.nextLine();
    }
}
