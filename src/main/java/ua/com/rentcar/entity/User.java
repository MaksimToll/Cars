package ua.com.rentcar.entity;

import ua.com.rentcar.dao.Identified;

import java.sql.Timestamp;

/**
 * Created by maks on 28.01.2015.
 */
public class User implements Identified<Integer> {
    private int id;
    private String phone;
    private String avatar;
    private String email;
    private String passport;
    private int enabled;
    private String login;
    private String password;
    private String name;
    private Timestamp lastLogin;

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", passport='" + passport + '\'' +
                ", enabled=" + enabled +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
