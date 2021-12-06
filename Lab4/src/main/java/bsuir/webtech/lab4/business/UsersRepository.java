package bsuir.webtech.lab4.business;

import bsuir.webtech.lab4.business.Beans.User;

public abstract class UsersRepository {
    public abstract User getAccountByLogin(String login);
    public abstract void add(User user);
}
