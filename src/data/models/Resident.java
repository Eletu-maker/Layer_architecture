package data.models;

import java.util.Objects;

public class Resident {
    private String name;
    private long id ;
    private String phoneNumber;
    private String email;
    private String password;

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public  boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resident that = (Resident) o;
        return Objects.equals(name,that.name)&&
                Objects.equals(id,that.id)&&
                Objects.equals(phoneNumber,that.phoneNumber)&&
                Objects.equals(email,that.email)&&
                Objects.equals(password,that.password);
    }

}
