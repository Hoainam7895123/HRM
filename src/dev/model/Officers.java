package dev.model;

import java.util.Scanner;

public class Officers extends Personnel {
    private Department department;
    private String position;
    private double coefficientsSalary;
    private String grading;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading;
    }

    public Officers() {

    }

    public Officers(Department department, String position, double coefficientsSalary, String grading) {
        this.department = department;
        this.position = position;
        this.coefficientsSalary = coefficientsSalary;
        this.grading = grading;
    }

    public Officers(String surname, String firstname, int yearOfBirth, String sex, Department department, String position, double coefficientsSalary, String grading) {
        super(surname, firstname, yearOfBirth, sex);
        this.department = department;
        this.position = position;
        this.coefficientsSalary = coefficientsSalary;
        this.grading = grading;
    }

    @Override
    public void input() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\t =========== Enter information officers ==========.");
        super.input();
        System.out.print("Enter position: "); this.position = scanner.nextLine();
        System.out.print("Enter coefficientsSalary: "); this.coefficientsSalary = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Enter grading: "); this.grading = scanner.nextLine();

    }

    @Override
    public void output() {

    }

    @Override
    public double salary() {
        double salaryOfOfficer = 0.0;

        if (this.grading.equalsIgnoreCase("A")) {
            salaryOfOfficer = this.coefficientsSalary * 1150000 + 1000000;
        } else if (this.grading.equalsIgnoreCase("B")) {
            salaryOfOfficer = this.coefficientsSalary * 1150000;
        } else if (this.grading.equalsIgnoreCase("C")) {
            salaryOfOfficer = this.coefficientsSalary * 1150000 - 400000;
        } else {
            salaryOfOfficer = this.coefficientsSalary * 1150000 - 1000000;
        }
        return salaryOfOfficer;
    }
}
