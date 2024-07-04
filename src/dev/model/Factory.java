package dev.model;

import java.util.Scanner;

public class Factory {
    private String factoryName;
    private String manager;
    private int numberOfWorker;

    public Factory() {
    }

    public Factory(String factoryName, String manager, int numberOfWorker) {
        this.factoryName = factoryName;
        this.manager = manager;
        this.numberOfWorker = numberOfWorker;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getNumberOfWorker() {
        return numberOfWorker;
    }

    public void setNumberOfWorker(int numberOfWorker) {
        this.numberOfWorker = numberOfWorker;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t ----- Enter information factory -----");
        System.out.print("Enter factory name: "); this.factoryName = scanner.nextLine();
        System.out.print("Enter manager: "); this.manager = scanner.nextLine();
        System.out.print("Enter number of worker: "); this.numberOfWorker = scanner.nextInt(); scanner.nextLine();
    }

    public void output() {
        System.out.printf("%s%s%i", this.factoryName, this.manager, this.numberOfWorker);
    }
}
