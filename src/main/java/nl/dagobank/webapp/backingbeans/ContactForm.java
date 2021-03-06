package nl.dagobank.webapp.backingbeans;

import java.util.Arrays;
import java.util.List;

public class ContactForm {
    private String firstName;
    private String prefix;
    private String lastName;
    private String email;
    private String phoneNumber;

    public static List<String> subjects = Arrays.asList("Maak een keuze...", "1. Inloggegevens", "2. Registratie", "3. Openen rekening", "4. Mederekeninghouder", "5. Klacht", "6. Compliment", "7. Rekening sluiten", "8. Anders");
    private String message;

    public ContactForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /*public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }*/

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
