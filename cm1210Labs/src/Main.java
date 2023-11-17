import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee MattMorgan = new Employee("Matt Morgan", 67485, "COMSC", "Lecturer" );
        Employee TimMarshall = new Employee("TimMarshall", 78495, "BIOSI", "Professor");
        Employee RichardWright = new Employee("RichardWright", 43637, "PHYSX", "Reader");
        employeeList.add(MattMorgan);
        employeeList.add(TimMarshall);
        employeeList.add(RichardWright);

        System.out.println("Name, ID Number, Department, Position");
        System.out.println(MattMorgan);
        for (int person = 0 ; person < employeeList.size() ; person++) {

            System.out.println(employeeList.get(person).getName(),
                    employeeList.get(person).getIdNumber());
        }
    }
}