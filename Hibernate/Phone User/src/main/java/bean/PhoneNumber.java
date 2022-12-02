package bean;

import java.util.Objects;

public class PhoneNumber {

    private int phoneId;
    private String phoneNumber, phoneType;

    public PhoneNumber() {
    }

    public PhoneNumber(int phoneId, String phoneNumber, String phoneType) {
        this.phoneId = phoneId;
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneId=" + phoneId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneType='" + phoneType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return phoneId == that.phoneId && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(phoneType, that.phoneType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneId, phoneNumber, phoneType);
    }
}
