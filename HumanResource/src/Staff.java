public abstract class Staff {
    private String ID;
    private String Name;
    private int Age;
    private double salary;
    private String dateJoin;
    private String department;
    private int dateOff;
    public Staff(String ID, String Name,int Age, double salary,String dateJoin,int dateOff,String department){
        this.ID = ID;
        this.Name = Name;
        this.Age = Age;
        this.salary =  salary;
        this.dateJoin = dateJoin;
        this.department = department;
        this.dateOff = dateOff;
    }
    public Staff() {
    }
    public String getID(){
        return ID;
    }
    public  void setID(String ID){
        this.ID= ID;
    }
    public String getName(){
        return Name;
    }
    public  void  setName(String Name){
        this.Name=Name;
    }
    public int getAge(){
        return Age;
    }
    public void setAge(int Age){
        this.Age=Age;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public String getDateJoin(){
        return dateJoin;
    }
    public void setDateJoin(String dateJoin){
        this.dateJoin=dateJoin;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public int getDateOff(){
        return dateOff;
    }
    public void setDateOff(int dateOff){
        this.dateOff=dateOff;
    }

    abstract void displayInformation(); // Cài đặt class Staff dạng abstract và phương thức abstract displayInformation tương ứng
}
