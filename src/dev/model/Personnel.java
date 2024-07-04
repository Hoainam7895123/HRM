package dev.model;

import java.util.Scanner;

public abstract class Personnel {
    protected static int id = 0;
    protected String surname;
    protected String firstname;
    protected int yearOfBirth;
    protected String sex;

    public Personnel() {}

    public Personnel(String surname, String firstname, int yearOfBirth, String sex) {
        this.id++;
        this.surname = surname;
        this.firstname = firstname;
        this.yearOfBirth = yearOfBirth;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter ID: "); this.id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter surname: "); this.surname = scanner.nextLine();
        System.out.print("Enter firstname: "); this.firstname = scanner.nextLine();
        System.out.print("Enter year of birth: "); this.yearOfBirth = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter sex: "); this.sex = scanner.nextLine();
    };
    public abstract void output();
    public abstract double salary();
}
