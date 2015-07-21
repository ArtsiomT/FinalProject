package by.epam.terehovich.internetprovider.entity;

import java.util.GregorianCalendar;

/**
 * Created by aterehovich on 16.7.15.
 */
public class User extends Entity {
    private int role;
    private int cabinet;
    private String login;
    private String password;
    private String email;
    private String firstname;
    private String secondname;
    private String lastname;
    private String address;
    private String city;
    private GregorianCalendar birth;

    public User(int id, String login, String password, String email, int role, String firstname, String secondname,
                String lastname, String address, String city, GregorianCalendar birth) {
        super(id);
        this.role = role;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.birth = birth;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getCabinet() {
        return cabinet;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public GregorianCalendar getBirth() {
        return birth;
    }

    public void setBirth(GregorianCalendar birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", role=" + role +
                ", cabinet=" + cabinet +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", birth=" + birth +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
