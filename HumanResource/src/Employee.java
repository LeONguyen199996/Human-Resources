
public class Employee  extends  Staff implements ICalculator{ //   class Employee kế thừa class Staff implements interface ICalculator
    private double OverTime;

    public Employee(String ID, String Name,int Age, double salary,String dateJoin,int dateOff,String department,double OverTime) {
        super(ID, Name, Age, salary, dateJoin, dateOff, department);
        this.OverTime= OverTime;
    }
    public Employee() {
        super();
    }
    public double getOverTime(){
        return OverTime;
    }
    public void setOverTime(double OverTime){
        this.OverTime = OverTime;
    }
    @Override
    //      Hàm hiển thị thông tin cá nhân
    void displayInformation() {
        System.out.printf("%-15s | %-30s | %-4s | %-10s | %-13s | %-20s | %-20s | %-23s | %.2f\n", getID(),getName(),getAge(),getSalary(),getDateJoin(),getDepartment(),getDateOff(),getOverTime(),calculateSalary());
    }
    @Override
    //      Hàm tính lương
    public double calculateSalary(){  // Triển khai interface để tính lương cho các class  Employee
        return  (super.getSalary() * 3000000 + OverTime *200000);
    }





}
