package users;

public class Employee extends User {
    public String department, jobTitle;

    public Employee(String firstName, String lastName, Long idNumber, String department, String jobTitle) {
        super(firstName, lastName, idNumber);
        this.department = department;
        this.jobTitle = jobTitle;
    }

    @Override
    public void showUserData() {
        super.showUserData();
        System.out.println("You belong to the department: " + getDepartment());
        System.out.println("Your job title is: " + getJobTitle());
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
