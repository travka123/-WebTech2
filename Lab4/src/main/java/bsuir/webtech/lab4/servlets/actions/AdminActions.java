package bsuir.webtech.lab4.servlets.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminActions extends UserActions {
    @Override
    public String book(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return "/404";
    }
}
