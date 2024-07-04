package dev.model;

import java.util.Scanner;

public class Worker extends Personnel {

    private Factory factory;
    private String job;
    private int numberOfWorkdays;

    public Worker() {}

    public Worker(Factory factory, String job, int numberOfWorkdays) {
        this.factory = factory;
        this.job = job;
        this.numberOfWorkdays = numberOfWorkdays;
    }

    public Worker(String surname, String firstname, int yearOfBirth, String sex, Factory factory, String job, int numberOfWorkdays) {
        super(surname, firstname, yearOfBirth, sex);
        this.factory = factory;
        this.job = job;
        this.numberOfWorkdays = numberOfWorkdays;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getNumberOfWorkdays() {
        return numberOfWorkdays;
    }

    public void setNumberOfWorkdays(int numberOfWorkdays) {
        this.numberOfWorkdays = numberOfWorkdays;
    }

    @Override
    public void output() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t =========== Enter information officers ==========.");
        super.input();
        System.out.print("Enter job: "); this.job = scanner.nextLine();
        System.out.print("Enter number of workdays: "); this.numberOfWorkdays = scanner.nextInt(); scanner.nextLine();
    }

    @Override
    public double salary() {
        double salaryOfWorker = 0.0;
        if (this.numberOfWorkdays >= 23) {
            salaryOfWorker = this.numberOfWorkdays * 250000 + 500000;
        } else if (this.numberOfWorkdays >= 20) {
            salaryOfWorker = this.numberOfWorkdays * 250000 + 300000;
        } else if (this.numberOfWorkdays >= 18) {
            salaryOfWorker = this.numberOfWorkdays * 250000;
        } else {
            salaryOfWorker = this.numberOfWorkdays * 250000 - 200000;
        }
        return salaryOfWorker;
    }
}
