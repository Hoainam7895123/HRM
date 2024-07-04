package dev.service;

import dev.main.TestDrive;
import dev.model.Officers;
import dev.model.Personnel;
import dev.model.Worker;

import java.util.List;
import java.util.Scanner;

public class ManageWorker {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(List<Personnel> personnels) {

            int choose = 0;

            do {
                System.out.println("\t ================== Mangage Officers ====================");
                System.out.println("\t 1. Xem danh sách công nhân.");
                System.out.println("\t 2. Thêm công nhân");
                System.out.println("\t 3. Sửa công nhân");
                System.out.println("\t 2. Xoá công nhân");
                System.out.print("Nhập lựa chọn của bạn: "); choose = scanner.nextInt(); scanner.nextLine();

                switch (choose) {
                    case 1:
                        showAllOfficers(personnels);
                        break;
                    case 2:
                        addWorker(personnels);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            } while (choose != 0);
        }

    public static void showAllOfficers(List<Personnel> personnels) {
            // Example list of officers

            // Print the table header with borders
            String format = "| %-10s | %-10s | %-10s | %-5s | %-15s | %-15s | %-10s | %-5s |%n";
            String border = "+------------+------------+------------+-------+-----------------+-----------------+------------+-------+-------+";

            System.out.println(border);
            System.out.printf(format, "First Name", "Last Name", "Birth Year", "Gender", "Department", "Dept Head", "Position", "Grade");
            System.out.println(border);

            // Print each officer's details with borders
            for (Personnel officer : personnels) {
                if (officer instanceof Officers) {
                    Officers off = (Officers) officer;
                    System.out.printf(format,
                            off.getFirstname(),
                            off.getSurname(),
                            off.getYearOfBirth(),
                            off.getSex(),
                            off.getDepartment().getDepartmentName(),
                            off.getDepartment().getManager(),
                            off.getPosition(),
                            off.getGrading()
                    );
                }
            }

            // Print the bottom border
            System.out.println(border);
        }

    public static void addWorker(List<Personnel> personnels) {
            Worker personnel = new Worker();
            personnel.input();
            ManageFactory.showListFactory(TestDrive.getFactories());
            System.out.print("Enter id factory: "); int idFactory = scanner.nextInt(); scanner.nextLine();
            personnel.setFactory(TestDrive.getFactories().get(idFactory - 1));
            System.out.print("#. Thêm công nhân thành công! ^^^");
        }
}
