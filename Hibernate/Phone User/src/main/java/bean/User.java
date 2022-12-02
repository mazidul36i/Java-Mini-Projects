package bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName, emailid;

    @ElementCollection
    @Embedded
    @JoinTable(name = "PhoneNumber", joinColumns = @JoinColumn(name = "userId"))
    private Set<PhoneNumber> phoneNumbers;

    public User() {
    }

    public User(int userId, String userName, String emailid) {
        this.userId = userId;
        this.userName = userName;
        this.emailid = emailid;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", emailid='" + emailid + '\'' +
                '}';
    }
}
