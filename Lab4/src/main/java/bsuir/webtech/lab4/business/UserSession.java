package bsuir.webtech.lab4.business;

public abstract class UserSession {
    public abstract boolean isAuthorized();

    public abstract int getUserId();
    public abstract void setUserId(int userId);

    public abstract UserRole getUserRole();
    public abstract void setUserRole(UserRole userRole);

    public abstract String getUserName();
    public abstract void setUserName(String name);

    public abstract void clear();
}
