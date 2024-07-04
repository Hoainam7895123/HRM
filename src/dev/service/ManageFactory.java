package dev.service;

import dev.model.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageFactory {

    public static void main(List<Factory> factories) {
        Scanner scanner = new Scanner(System.in);
        int choose = 0;

        do {
            System.out.println("\t ==================== Manage Factory ====================");
            System.out.println("\t 1. Xem danh sách nhà máy");
            System.out.println("\t 2. Thêm thông tin nhà máy");
            System.out.println("\t 3. Sửa thông tin nhà máy");
            System.out.println("\t 4. Xoá thông tin nhà máy");
            System.out.println("\t 5. Thoát");
            System.out.print("Mời bạn nhập lựa chọn: "); choose = scanner.nextInt(); scanner.nextLine();

            switch (choose) {
                case 1:
                    showListFactory(factories);
                    break;
                case 2:
                    addFactory(factories);

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("# Thoát!");
                    break;
            }
        } while (choose != 5);
    }

    private static void addFactory(List<Factory> factories) {
        Factory factory = new Factory();
        factory.input();
        factories.add(factory);
        System.out.println("#. Thêm thông tin nhà máy mới thành công!");
    }

    public static void showListFactory(List<Factory> factories) {
        // Print the table header with borders
        String format = "| %-10s | %-20s | %-20s | %-15s |%n";
        String border = "+----------------------+----------------------+-----------------+";

        System.out.println(border);
        System.out.printf(format, "ID", "Nhà máy", "Quản lý", "Số công nhân");
        System.out.println(border);

        int i = 0;
        // Print each factory's details with borders
        for (Factory factory : factories) {
            System.out.printf(format, ++i, factory.getFactoryName(), factory.getManager(), factory.getNumberOfWorker());
        }

        // Print the bottom border
        System.out.println(border);
    }
}
