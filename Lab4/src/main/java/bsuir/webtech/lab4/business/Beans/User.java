package bsuir.webtech.lab4.business.Beans;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String name;
    private String email;
    private String passHash;
    private String role;

    public class UserRole {
        public static final String guest = "guest";
        public static final String user = "user";
        public static final String admin = "admin";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {

    }

    public User(int id, String name, String email, String passHash, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passHash = passHash;
        this.role = role;
    }
}