package dev.main;

import dev.model.*;
import dev.service.ManageDepartment;
import dev.service.ManageFactory;
import dev.service.ManageOfficers;

import java.util.*;

public class TestDrive {
    private static List<Personnel> personnels = new ArrayList<>();
    private static List<Factory> factories = new ArrayList<>();
    private static List<Department> departments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addDepartment();
        addFactory();
        addOfficers();
        addWorker();
        Personnel personnel;
        int choose = 0;
        do {
            System.out.println("\t ******************* Menu **********************");
            System.out.println("\t 1. Quản lý cán bộ.");
            System.out.println("\t 2. Quản lý công nhân.");
            System.out.println("\t 3. Quản lý nhà máy.");
            System.out.println("\t 4. Quản lý phòng ban.");
            System.out.println("\t 5. Quản lý tiền lương.");
            System.out.println("\t 6. Hiển thị danh sách công nhân nam.");
            System.out.println("\t 7. Hiển thị danh sách cán bộ nữ.");
            System.out.println("\t 8. Sắp xếp danh sách nhân viên theo thứ tự từ điển");
            System.out.println("\t 0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choose = 0;
            choose = scanner.nextInt(); scanner.nextLine();

            switch (choose) {
                case 1:
                    ManageOfficers.main(personnels);
                    break;
                case 2:
                    break;
                case 3:
                    ManageFactory.main(factories);
                    break;
                case 4:
                    ManageDepartment.main(departments);
                    break;
                case 5:
                    manageSalary();
                    break;
                case 6:
                    showMaleWorkers();
                    break;
                case 7:
                    showFemaleOfficers();
                    break;
                case 8:
                    moveWorkersToTheBottomOTheList();
                    break;
                case 9:
                    sortNamesInDictionaryOrder();
                    break;
                case 0:

                    break;
            }

        } while (choose != 0);
    }

    private static void sortNamesInDictionaryOrder() {

        Comparator<Personnel> comparator = new Comparator<Personnel>() {
            @Override
            public int compare(Personnel p1, Personnel p2) {
                return p1.getFirstname().trim().compareTo(p2.getFirstname().trim());
            }
        };

        Collections.sort(personnels, comparator);

        int i = personnels.size();
        String formatOfficers = "| %-10s | %-10s | %-10s | %-5s | %-15s | %-15s | %-10s | %-5s |%n";
        String formatWorker = "| %-10s | %-10s | %-10s | %-5s | %-15s | %-15s | %-10s | %-5s |%n";

        for (Personnel personnel : personnels) {
            if (personnel instanceof Officers) {
                Officers off = (Officers) personnel;
                System.out.printf(formatOfficers,
                        ++i,
                        off.getFirstname(),
                        off.getSurname(),
                        off.getYearOfBirth(),
                        off.getSex(),
                        off.getDepartment().getDepartmentName(),
                        off.getDepartment().getManager(),
                        off.getPosition(),
                        off.getGrading()
                );
            } else {
                Worker off = (Worker) personnel;
                System.out.printf(formatWorker,
                        ++i,
                        off.getFirstname(),
                        off.getSurname(),
                        off.getYearOfBirth(),
                        off.getSex(),
                        off.getFactory().getFactoryName(),
                        off.getFactory().getManager(),
                        off.getJob(),
                        off.getNumberOfWorkdays()
                );
            }
        }
    }

    private static void moveWorkersToTheBottomOTheList() {

        Comparator<Personnel> comparator = new Comparator<Personnel>() {
            @Override
            public int compare(Personnel o1, Personnel o2) {
                if (o1.getClass().getSimpleName().equalsIgnoreCase("Worker") && !o2.getClass().getSimpleName().equalsIgnoreCase("Worker")) {
                    return 1;
                } else if (!o1.getClass().getSimpleName().equalsIgnoreCase("Worker") && o2.getClass().getSimpleName().equalsIgnoreCase("Worker")) {
                    return -1;
                }
                return 0;
            }
        };

        Collections.sort(personnels, comparator);

        int i = personnels.size();
        String formatOfficers = "| %-10s | %-10s | %-10s | %-5s | %-15s | %-15s | %-10s | %-5s |%n";
        String formatWorker = "| %-10s | %-10s | %-10s | %-5s | %-15s | %-15s | %-10s | %-5s |%n";

        for (Personnel personnel : personnels) {
            if (personnel instanceof Officers) {
                Officers off = (Officers) personnel;
                System.out.printf(formatOfficers,
                        off.getFirstname(),
                        off.getSurname(),
                        off.getYearOfBirth(),
                        off.getSex(),
                        off.getDepartment().getDepartmentName(),
                        off.getDepartment().getManager(),
                        off.getPosition(),
                        off.getGrading()
                );
            } else {
                Worker off = (Worker) personnel;
                System.out.printf(formatWorker,
                        off.getFirstname(),
                        off.getSurname(),
                        off.getYearOfBirth(),
                        off.getSex(),
                        off.getFactory().getFactoryName(),
                        off.getFactory().getManager(),
                        off.getJob(),
                        off.getNumberOfWorkdays()
                );
            }
        }
    }
    private static void showFemaleOfficers() {

        String format = "| %-10s | %-10s | %-10s | %-5s | %-15s | %-15s | %-10s | %-5s |%n";
        String border = "+------------+------------+------------+-------+-----------------+-----------------+------------+-------+-------+";

        System.out.println(border);
        System.out.printf(format, "First Name", "Last Name", "Birth Year", "Gender", "Department", "Dept Head", "Position", "Grade");
        System.out.println(border);

        for (Personnel p : personnels) {
            if (p instanceof Officers) {
                if (p.getSex().equalsIgnoreCase("Nu")) {
                    Officers off = (Officers) p;
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
        }
    }

    private static void showMaleWorkers() {
        String format = "| %-10s | %-10s | %-10s | %-5s | %-15s | %-15s | %-10s |%n";
        String border = "+------------+------------+------------+----------+----------+-----------------+------------+-------+";

        System.out.println(border);
        System.out.printf(format, "Họ", "Tên", "Năm sinh", "Giới tính", "Nhà máy", "Quản lý", "Số ngày công");
        System.out.println(border);
        for (Personnel p : personnels) {
            if (p instanceof Worker) {
                if (p.getSex().equalsIgnoreCase("Nam")) {
                    System.out.printf(format, p.getSurname(), p.getFirstname(), p.getYearOfBirth(), p.getSex(), ((Worker) p).getFactory().getFactoryName(), ((Worker) p).getFactory().getManager(), ((Worker) p).getFactory().getNumberOfWorker());
                }
            }
        }
        System.out.println(border);
    }

    private static void manageSalary() {
        int choose = 0;
        double totalSalary = 0;

        do {
            System.out.println("\t --------------- Quản lý tiêng lương ---------------");
            System.out.println("\t 1. Xem bảng lương của tất cả nhân viên.");
            System.out.println("\t 2. Tính tổng lương của công nhân.");
            System.out.println("\t 3. Tính tổng lương của cán bộ.");
            System.out.println("\t 4. Thoát.");
            System.out.print("Nhập lựa chọn của bạn: "); choose = scanner.nextInt(); scanner.nextLine();

            switch (choose) {
                case 1:
                    String format = "| %-10s | %-20s | %-20s |%n";
                    String border = "+----------------------+----------------------+------------";

                    System.out.println(border);
                    System.out.printf(format,"STT", "Tên nhân viên", "Lương");
                    System.out.println(border);

                    int i = 0;
                    for (Personnel p : personnels) {
                        System.out.printf(format, ++i, p.getFirstname(), p.salary());
                    }

                    System.out.println(border);
                    break;
                case 2:
                    totalSalary = 0.0;
                    for (Personnel p : personnels) {
                        if (p instanceof Worker) {
                            totalSalary += p.salary();
                        }
                    }
                    System.out.println("\n" + "Tổng lương của công nhân là: " + totalSalary + "\n");
                    break;
                case 3:
                    totalSalary = 0.0;
                    for (Personnel p : personnels) {
                        if (p instanceof Officers) {
                            totalSalary += p.salary();
                        }
                    }
                    System.out.println("\n" + "Tổng lương của cán bộ là: " + totalSalary + "\n");
                    break;
                case 4:
                    return;
            }
        } while (true);
    }

    public static void addDepartment() {
        Department department1 = new Department("Nhân Sự", "Thanh Hoàn");
        Department department2 = new Department("Lập Trình", "Hoài Nam");
        Department department3 = new Department("Marketing", "Hoàng Quân");
        Department department4 = new Department("Kinh Doanh", "Danh Thành");
        Department department5 = new Department("Kế Toán", "Hồng Đại");
        departments.add(department1);
        departments.add(department2);
        departments.add(department3);
        departments.add(department4);
        departments.add(department5);
    }

    public static void addFactory() {
        Factory factory1 = new Factory("Hải Quang", "Thanh Hoàn", 28);
        Factory factory2 = new Factory("Coteccons", "Hoài Nam", 1000);
        Factory factory3 = new Factory("Trung Nam GROUP", "Hoàng Quân", 228);
        Factory factory4 = new Factory("Phương Đông", "Danh Thành", 288);
        Factory factory5 = new Factory("Hải Đông", "Hồng Đại", 248);
        factories.add(factory1);
        factories.add(factory2);
        factories.add(factory3);
        factories.add(factory4);
        factories.add(factory5);
    }

    public static void addOfficers() {
        Officers officers1 =
                new Officers(
                        "Truong", "Nam", 2003, "Nam",
                        TestDrive.getDepartments().get(1),
                        "Nhan vien", 3.1, "A");
        Officers officers2 =
                new Officers(
                        "Cao", "Long", 2003, "Nam",
                        TestDrive.getDepartments().get(2),
                        "Nhan vien", 3.0, "A");
        Officers officers3 =
                new Officers(
                        "Dinh", "Minh", 2003, "Nam",
                        TestDrive.getDepartments().get(3),
                        "Nhan vien", 3.0, "A");
        Officers officers4 =
                new Officers(
                        "Dao", "Lien", 2003, "Nam",
                        TestDrive.getDepartments().get(4),
                        "Nhan vien", 3.0, "A");
        Officers officers5 =
                new Officers(
                        "Truong", "Truc", 2003, "Nu",
                        TestDrive.getDepartments().get(0),
                        "Nhan vien", 3.0, "A");
        personnels.add(officers1);
        personnels.add(officers2);
        personnels.add(officers3);
        personnels.add(officers4);
        personnels.add(officers5);
    }

    public static void addWorker() {
        Worker worker1 =
                new Worker(
                        "Hoang", "Phuong", 2003, "Nam",
                        TestDrive.getFactories().get(1),
                        "Ky su", 28);
        Worker worker2 =
                new Worker(
                        "Hong", "Tri", 2007, "Nam",
                        TestDrive.getFactories().get(2),
                        "Ky su", 20);
        Worker worker3 =
                new Worker(
                        "Van", "Giap", 2004, "Nam",
                        TestDrive.getFactories().get(3),
                        "Ky su", 30);
        Worker worker4 =
                new Worker(
                        "Van", "Hiep", 2001, "Nam",
                        TestDrive.getFactories().get(4),
                        "Ky su", 29);
        Worker worker5 =
                new Worker(
                        "Hoang", "Phong", 2004, "Nam",
                        TestDrive.getFactories().get(0),
                        "Ky su", 28);
        personnels.add(worker1);
        personnels.add(worker2);
        personnels.add(worker3);
        personnels.add(worker4);
        personnels.add(worker5);
    }

    // getter, setter
    public static List<Factory> getFactories() {
        return factories;
    }

    public static void setFactories(List<Factory> factories) {
        TestDrive.factories = factories;
    }

    public static List<Department> getDepartments() {
        return departments;
    }

    public static void setDepartments(List<Department> departments) {
        TestDrive.departments = departments;
    }

    public static List<Personnel> getPersonnels() {
        return personnels;
    }

    public static void setPersonnels(List<Personnel> personnels) {
        TestDrive.personnels = personnels;
    }
}
