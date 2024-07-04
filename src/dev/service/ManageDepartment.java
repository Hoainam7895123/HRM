package dev.service;

import dev.model.Department;
import dev.model.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageDepartment {

        public static void main(List<Department> departments) {
            Scanner scanner = new Scanner(System.in);
            int choose = 0;

            do {
                System.out.println("\t ==================== Manage Department ====================");
                System.out.println("\t 1. Xem danh sách phòng ban");
                System.out.println("\t 2. Thêm thông tin phòng ban");
                System.out.println("\t 3. Sửa thông tin phòng ban");
                System.out.println("\t 4. Xoá thông tin phòng ban");
                System.out.println("\t 5. Thoát");
                System.out.print("Mời bạn nhập lựa chọn: "); choose = scanner.nextInt(); scanner.nextLine();

                switch (choose) {
                    case 1:
                        getAllDepartment(departments);
                        break;
                    case 2:
                        addDepartment(departments);
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

    private static void addDepartment(List<Department> departments) {
        Department department = new Department();
        department.input();
        departments.add(department);
        System.out.println("#. Thêm thông tin phòng ban mới thành công! ^^^");
    }

    public static void getAllDepartment(List<Department> departments) {
        // Print the table header with borders
        String format = "| %-10s | %-20s | %-20s |%n";
        String border = "+----------------------+----------------------+-----------------+";

        System.out.println(border);
        System.out.printf(format,"ID", "Phòng", "Quản lý");
        System.out.println(border);

        int i = 0;
        // Print each factory's details with borders
        for (Department department : departments) {
            System.out.printf(format, ++i, department.getDepartmentName(), department.getManager());
        }

        // Print the bottom border
        System.out.println(border);
    }



}
