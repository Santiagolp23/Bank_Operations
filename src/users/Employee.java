public class Employee extends User{
    public String department, jobTitle;

    public Employee(String firstName, String lastName, Long idNumber, String department, String jobTitle) {
        super(firstName, lastName, idNumber);
        this.department = department;
        this.jobTitle = jobTitle;
    }
}
