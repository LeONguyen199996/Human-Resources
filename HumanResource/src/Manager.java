public class Manager extends Staff implements ICalculator {  // class Manager  thừa kế từ class Staff và implements interface ICalculator
    private String position;

    public Manager(String ID, String Name, int Age, double salary, String dateJoin, int dateOff, String department,String position) {
        super(ID, Name, Age, salary, dateJoin, dateOff, department);
        this.position=position;
    }

    public Manager() {

    }

    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position = position;
    }

    @Override
    //     Hàm hiển thị thông tin cá nhân
    void displayInformation() {
        System.out.printf("%-15s | %-30s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %.2f\n", getID(),getName(),getAge(),getSalary(),getDateJoin(),getDepartment(),getDateOff(),getPosition(),calculateSalary());
    }

    @Override
    //     Hàm tính lườn cho các Manager
    public double calculateSalary() { // Triển khai interface để tính lương cho các class Manager
        double salaryManager;
        double salaryResponsive;
        if (position== "Business Leader"){
            salaryResponsive=8000000;
        }
        else if (position=="Project Leader"){
            salaryResponsive=5000000;
        }
        else {
            salaryResponsive=6000000;
        }
        salaryManager= getSalary()*5000000+salaryResponsive;
        return salaryManager;
    }
}
