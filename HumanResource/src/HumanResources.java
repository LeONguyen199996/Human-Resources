import java.util.*;

public class HumanResources {
    //    Khai báo mảng để lưu thông tin nhân viên
    static ArrayList<Staff> StaffLisst = new ArrayList<>();
    //    Khai báo mảng để lưu các bộ phận trong công ty
    static ArrayList<Department> DepartmentList = new ArrayList<>();
    //        Tạo ra các bộ phận cho công ty
   static Department bp1 = new Department("IT", "Công nghệ Thông Tin", 2);
    static Department bp2 = new Department("MKT", "Marketing", 0);
    static Department bp3 = new Department("HC", "Hành chính nhân sự", 2);
    static Scanner sc = new Scanner(System.in); // để tránh bị lỗi dùng 1 scanner cho nhập số,
    static Scanner str = new Scanner(System.in);// 1 scaner nhập chuỗi
//e khai báo lên trên cùng này

    // Hàm main xử lý luồng chính của chương trình
    public static void main(String[] args) {
        show();
        danhSach();
        boPhan();
//        Dùng vòng lặp while để chạy các chức năng
        while (true) {
            menu();
        }
    }

    //    Hàm hiển thị danh sách chức năng
    static void show() {
        System.out.println("                                 CHÀO MỪNG ĐẾN VỚI ỨNG DỤNG QUẢN LÝ NHÂN VIÊN");
        System.out.println("                                 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    //    Hàm lập lại chức năng menu của chương trình
    static void menu() {
        System.out.println();
        System.out.println("Các chức năng: ");
        System.out.println("1. Hiện thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("2. Hiện thị các bộ phận trong công ty.");
        System.out.println("3. Hiển thị các nhân viên theo ừng bộ phận.");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty.");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
        System.out.println("0. Thoát chương trình.");
        System.out.print("Lựa chọn của bạn: ");
        int luaChon = sc.nextInt();// lựa chọn người dùng nhập vào
        switch (luaChon) {
            // Chức năng 1 Hiển thị danh sách nhân viên
            case 1:
                System.out.println("Danh sách nhân viên công ty:");
                System.out.printf("%-15s | %-30s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %7s\n", "Mã nhân viên", "Họ và Tên", "Tuổi", "HS Lương", "Ngày vào làm", "Bộ phận làm việc", "Số ngày nghỉ phép", "Số giờ làm thêm/Chức vụ", "Lương");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                inDanhSach();
                System.out.println("                                                        _______________________________                                                                                     ");
                System.out.println();
                break;
            // Chức năng 2 Hiển thị các bộ phận trong công ty
            case 2:
                System.out.println("Các bộ phận của công ty:");
                System.out.printf("%-20s | %-25s | %-15s\n", "Mã bộ phận", "Tên bộ phận", "Số lương nhân viên hiện tại");
                System.out.println("------------------------------------------------------------------------------");
                inBoPhan();
                System.out.println("                            ___________________________                             ");
                System.out.println();
                break;
            // Chức năng 3 Hiển thị nhân viên theo bộ phận
            case 3:
                inNhanVienTheoBoPhan();
                System.out.println("                                                        _______________________________                                                                                     ");
                System.out.println();
                break;
            // Chức năng 4 Thêm nhân viên
            case 4:
                addNhanVien();
                System.out.println("                                                        _______________________________                                                                                     ");
                System.out.println();
                break;
            // Chức năng 5 Tìm kiếm nhân viên theo mã hoặc họ và tên
            case 5:
                timKiemNhanVien();
                System.out.println("                                                        _______________________________                                                                                     ");
                System.out.println();
                break;
            // Chức năng 6 Hiển thị bảng lượng toàn công ty (giảm dần)
            case 6:
                System.out.println("Bảng lương của nhân viên toàn công ty theo thứ tự giảm dần");
                System.out.printf("%-15s | %-30s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %7s\n", "Mã nhân viên", "Họ và Tên", "Tuổi", "HS Lương", "Ngày vào làm", "Bộ phận làm việc", "Số ngày nghỉ phép", "Số giờ làm thêm/Chức vụ", "Lương");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                Collections.sort(StaffLisst, new Comparator<Staff>() { // sử dụng colletions sort để sắp xếp lương giảm dần
                    @Override
                    public int compare(Staff o1, Staff o2) {
                        return (int) (((ICalculator) o2).calculateSalary() - ((ICalculator) o1).calculateSalary()); // ép kiểu o1=(ICalculator)o1) vì class staff ko có hàm caculateSlary()
                    }
                });
                for (Staff x : StaffLisst) {
                    x.displayInformation();
                }
                System.out.println("                                                        _______________________________                                                                                     ");
                System.out.println();
                break;
            // Chức năng 7 Hiển thị bảng lương nhân viên theo thứ tự tăng dần
            case 7:
                System.out.println("Bảng lương của nhân viên theo thứ tự tăng dần:");
                System.out.printf("%-15s | %-30s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %7s\n", "Mã nhân viên", "Họ và Tên", "Tuổi", "HS Lương", "Ngày vào làm", "Bộ phận làm việc", "Số ngày nghỉ phép", "Số giờ làm thêm/Chức vụ", "Lương");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                Collections.sort(StaffLisst, new Comparator<Staff>() { // sử dụng colletions sort để sắp xếp lương tăng dần
                    @Override
                    public int compare(Staff o1, Staff o2) {
                        return (int) (((ICalculator) o1).calculateSalary() - ((ICalculator) o2).calculateSalary());
                    }
                });
                for (Staff x : StaffLisst) {
                    x.displayInformation();
                }
                System.out.println("                                                        _______________________________                                                                                     ");
                System.out.println();
                break;
            // Chức năng thoát khỏi chương trình
            case 0:
                System.out.println("Tạm biệt!");
                System.exit(0);
            default:
                System.out.println("Chức Năng bạn chon không tồn tại.Xin nhập lại!");

        }
    }

    //    Hàm tạo danh sách nhân viên và quản lý
    static void danhSach() {
//    Danh sách nhân viên
        Employee nv1 = new Employee("E001", "Phong Thuyết Hoa", 28, 3.2, "10/10/2010", 10, "Hành chính nhân sự", 4.0);
        Employee nv2 = new Employee("E002", "Trần Thị B", 24, 2.2, "02/10/2010", 7, "Hành chính nhân sự", 3.0);
//     Danh sách quản lý
        Manager ql1 = new Manager("M001", "Nguyễn Văn An", 25, 2.5, "11/11/2010", 5, "Công nghệ Thông Tin", "Business Leader");
        Manager ql2 = new Manager("M002", "Tạ VĂn Lục", 32, 4.5, "01/11/2010", 1, "Công nghệ Thông Tin", "Technical Leader");
//      Thêm nhân viên và quản lý vào danh sách mảng
        StaffLisst.add(nv1);
        StaffLisst.add(nv2);
        StaffLisst.add(ql1);
        StaffLisst.add(ql2);
    }

    //    Hàm in danh sách nhân viên 
    static void inDanhSach() {

        for (Staff x : StaffLisst) { // Dùng vòng lặp duyệt qua mảng, và mỗi phần tử thì dùng phương thức displayInformation() để hiển thị thông tin.
            x.displayInformation();
        }
    }

    //    Hàm tạo ra danh sách các bộ phận trong công ty
    static void boPhan() {

//        ADD các bộ phận vào danh sách mảng
        DepartmentList.add(bp1);
        DepartmentList.add(bp2);
        DepartmentList.add(bp3);

    }

    //    Hàm in các bộ phận của công ty
    static void inBoPhan() {

        for (Department x : DepartmentList) {  //  Dùng vòng lặp duyệt qua mảng, và mỗi phần tử thì dùng toString() để hiển thị thông tin..
            System.out.println(x.toString());
        }
    }

    //    Hàm thêm nhân viên vào danh sách
    static void addNhanVien() {


        while (true) {
            System.out.println("1. Thêm nhân viên thông thường");
            System.out.println("2. Thêm nhân viên là cấp quản lý (có thêm chức vụ)");
            System.out.print("Bạn chọn: ");
            int chon = sc.nextInt();  //  Dùng Scanner input để nhập dữ liệu cho Employee rồi chèn vào ArrayList
            if (chon == 1) {
                Employee addList = new Employee();
                System.out.print("Nhập mã nhân viên: ");
                addList.setID(str.next());
                str.nextLine();
                System.out.print("Nhập tên nhân viên: ");
                addList.setName(str.nextLine());

                System.out.print("Nhập tuổi nhân viên: ");
                addList.setAge(sc.nextInt());
                System.out.print("Nhập hệ số lương của nhân viên: ");
                addList.setSalary(sc.nextDouble());
                System.out.print("Nhập ngày vào làm của nhân viên: ");
                addList.setDateJoin(str.nextLine());
                System.out.print("Nhập số ngày nghỉ  phép của nhân viên: ");
                addList.setDateOff(sc.nextInt());
                System.out.println("1. HC - Hành chính nhân sự");
                System.out.println("2. IT - Công nghệ thông tin");
                System.out.println("3. MKT- Marketing");
                System.out.print("Bạn chọn bộ phận: ");
                int chonBoPhan = sc.nextInt();
                if (chonBoPhan == 1) {
                    System.out.println("Bộ phận làm việc:" + "Hành chính nhân sự");
                    addList.setDepartment("Hành chính nhân sự");
                    bp3.setTotalMember(bp3.getTotalMember()+1);
                } else if (chonBoPhan == 2) {
                    System.out.println("Bộ phận làm việc: " + "Công nghệ thông tin");
                    addList.setDepartment("Công nghệ thông tin");
                    bp1.setTotalMember(bp1.getTotalMember()+1);
                } else if (chonBoPhan == 3) {
                    System.out.println("Bộ phận làm việc: " + "Marketing");
                    addList.setDepartment("Marketing");
                    bp2.setTotalMember(bp2.getTotalMember()+1);
                }
                System.out.print("Nhập số giờ làm thêm: ");
                addList.setOverTime(sc.nextDouble());
//               thêm vào List StaffLisst
                StaffLisst.add(addList);
                break;

            } else if (chon == 2) {   //  Dùng Scanner input để nhập dữ liệu cho Manager rồi chèn vào ArrayList
                Manager newManager = new Manager();
                System.out.print("Nhập mã nhân viên: ");
                newManager.setID(str.nextLine());
                sc.nextLine();
                System.out.print("Nhập tên nhân viên: ");
                newManager.setName(sc.nextLine());
                System.out.print("Nhập tuổi nhân viên: ");
                newManager.setAge(sc.nextInt());
                System.out.print("Nhập hệ số lương của nhân viên: ");
                newManager.setSalary(sc.nextDouble());
                //sc.nextLine();
                System.out.print("Nhập ngày vào làm việc của nhân viên: ");
                newManager.setDateJoin(str.nextLine());
                System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
                //newManager.setDateJoin(String.valueOf(sc.nextInt()));
                newManager.setDateOff(sc.nextInt());
                System.out.println("1. HC - Hành chính nhân sự");
                System.out.println("2. IT - Công nghệ thông tin");
                System.out.println("3. MKT - Marketing");
                System.out.print("Bạn chọn bộ phận: ");
                int chonPhong = sc.nextInt();
                if (chonPhong == 1) {
                    System.out.println("Bộ phận làm việc:" + "Hành chính nhân sự");
                    newManager.setDepartment("Hành chính nhân sự");
                    bp3.setTotalMember(bp3.getTotalMember()+1);
                } else if (chonPhong == 2) {
                    System.out.println("Bộ phận làm việc: " + "Công nghệ thông tin");
                    newManager.setDepartment("Công nghệ thông tin");
                    bp1.setTotalMember(bp1.getTotalMember()+1);
                } else if (chonPhong == 3) {
                    System.out.println("Bộ phận làm việc: " + "Marketing");
                    newManager.setDepartment("Marketing");
                    bp2.setTotalMember(bp2.getTotalMember()+1);
                }
                System.out.println("Chức danh: ");
                System.out.println(" 1 : Business Leader");
                System.out.println(" 2 : Project Leader");
                System.out.println(" 3 : Technical Leader");
                System.out.println("Nhập chức danh: ");
                int chonChucDanh = sc.nextInt();
                if (chonChucDanh == 1) {
                    System.out.println("Chức danh: " + "Business Leader");
                    newManager.setPosition("Business Leader");
                } else if (chonChucDanh == 2) {
                    System.out.println("Chức danh: " + "Project Leader");
                    newManager.setPosition("Project Leader");
                } else if (chonChucDanh == 3) {
                    System.out.println("Chức danh: " + "Technical Leader");
                    newManager.setPosition("Technical Leader");
                }
//               thêm vào list StaffList
                StaffLisst.add(newManager);
                break;
            }
        }
    }

    //    Hàm tìm kiếm nhân viên
    static void timKiemNhanVien() {
        boolean result = false; //      dùng 1 biến boolean kiểm tra in ra kết quả không tìm thấy nhân viên
        System.out.println("1. Tìm nhân viên bằng tên ");
        System.out.println("2. Tìm nhân viên bằng mã nhân viên");
        System.out.print("Bạn chọn: ");
        int chon = sc.nextInt();
        if (chon == 1) {
            System.out.print("Nhập tên nhân viên cần tìm: ");
            String timKiem = str.nextLine();
            for (Staff x : StaffLisst) {
                if (timKiem.equalsIgnoreCase(x.getName())) {
                    System.out.printf("%-15s | %-30s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %7s\n", "Mã nhân viên", "Họ và Tên", "Tuổi", "HS Lương", "Ngày vào làm", "bộ phận làm việc", "Số ngày nghỉ phép", "Số giờ làm thêm/Chức vụ", "Lương");
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    x.displayInformation();
                    result = true;
                    break;
                }
            }
        }
        if (chon == 2) {
            System.out.print("Nhập mã nhân viên cần tìm: ");
            String timKiem = str.nextLine();
            for (Staff x : StaffLisst) {
                if (timKiem.equalsIgnoreCase(x.getID())) {
                    System.out.printf("%-15s | %-30s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %7s\n", "Mã nhân viên", "Họ và Tên", "Tuổi", "HS Lương", "Ngày vào làm", "bộ phận làm việc", "Số ngày nghỉ phép", "Số giờ làm thêm/Chức vụ", "Lương");
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    x.displayInformation();
                    result = true;
                    break;
                }
            }
        }
        if (result == false) { //    Dùng lệnh điều kiện để kiểm tra thông tin nhân viên có tồn tại hay không.
            System.out.println(" Không tìm thấy nhân viên ");
        }
    }

    //    Hàm in danh sách sinh viên theo từng bộ phận
    static void inNhanVienTheoBoPhan() {
        for (Department x : DepartmentList) { //   Dùng vòng lặp duyệt qua mảng, và mỗi phần tử thì dùng phương thức displayInformation() để hiển thị thông tin..
            System.out.println(x.getDepartmentName());
            System.out.printf("%-15s | %-30s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %7s\n", "Mã nhân viên", "Họ và Tên", "Tuổi", "HS Lương", "Ngày vào làm", "Bộ phận làm việc", "Số ngày nghỉ phép", "Số giờ làm thêm/Chức vụ", "Lương");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Staff y : StaffLisst) {
                if (y.getDepartment().equals(x.getDepartmentName())) {
                    y.displayInformation();
                }
            }
            System.out.println();
        }
    }
}