public class Department extends Staff{
    private String departmentCode;
    private String departmentName;
    private int totalMember;
    public Department(String departmentCode,String departmentName,int totalmember){
        this.departmentCode=departmentCode;
        this.departmentName = departmentName;
        this.totalMember=totalmember;
    }

    public Department() {

    }

    public String getDepartmentCode(){
        return departmentCode;
    }
    public void setDepartmentCode(String departmentCode){
        this.departmentCode= departmentCode;
    }
    public String getDepartmentName(){
        return departmentName;
    }
    public void setDepartmentName(String departmentName){
        this.departmentName =  departmentName;
    }
    public int getTotalMember(){
        return totalMember;
    }
    public void setTotalMember(int totalMember){
        this.totalMember= totalMember;
    }
    public String toString(){
        return String.format("%-20s | %-25s | %15s\n",getDepartmentCode(),getDepartmentName(),getTotalMember()) ;
    }


    @Override
    void displayInformation() {

    }
}
