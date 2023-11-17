public class Employee {
    // variables

    private String name;
    private int idNumber;
    private String department;
    private String position;
    public Employee(String employeeName, int employeeIdNumber, String employeeDepartment, String employeePosition) {
        name = employeeName;
        idNumber = employeeIdNumber;
        department = employeeDepartment;
        position = employeePosition;

    }

    public Employee(String employeeName, int employeeIdNumber) {
        name = employeeName;
        idNumber = employeeIdNumber;
        department = "";
        position = "";
    }

    public Employee() {
        name = "";
        idNumber = 0;
        department = "";
        position = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String empName) {
        this.name = empName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int empId) {
        this.idNumber = empId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String empDept) {
        this.department = empDept;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String empPos){
        this.position = empPos;
    }
}
