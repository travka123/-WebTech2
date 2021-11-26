package bsuir.webtech.lab4.business;

public class Account {
    private int id;
    private String name;
    private String email;
    private String passHash;
    private UserRole role;

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

    public Account() {

    }

    public Account(int id, String name, String email, String passHash, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passHash = passHash;
        this.role = role;
    }
}