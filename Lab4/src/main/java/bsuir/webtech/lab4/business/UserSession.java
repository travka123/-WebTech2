package bsuir.webtech.lab4.business;

public abstract class UserSession {
    public abstract boolean isAuthorized();
    public abstract void setUserId(int userId);
    public abstract int getUserId();
    public abstract void clear();
}
