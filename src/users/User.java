import java.time.LocalDate;

public abstract class User {
    public String firstName, lastName;
    private Long idNumber;
    private LocalDate dateOfRegistration;

    public  User(String firstName, String lastName, Long idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.dateOfRegistration = LocalDate.now();

    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

}
