package users;

import java.time.LocalDate;

public abstract class User {
    public String firstName, lastName;
    private Long idNumber;
    private LocalDate dateOfRegistration;

    public User(String firstName, String lastName, Long idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.dateOfRegistration = LocalDate.now();


    }

    public void showUserData() {
        System.out.println("Your name is: " + getFullName());
        System.out.println("Your id number is: " + getIdNumber());
        System.out.println("You registered at: " + getDateOfRegistration());
    }

    public String getFullName() {
        return firstName + " " + lastName;
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
