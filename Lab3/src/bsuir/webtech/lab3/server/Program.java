package bsuir.webtech.lab3.server;

import bsuir.webtech.lab3.server.business.AuthorizationService;
import bsuir.webtech.lab3.server.networking.Server;
import bsuir.webtech.lab3.server.persistence.SimpleAccountDao;
import bsuir.webtech.lab3.server.persistence.XMLStudentDao;
import bsuir.webtech.lab3.server.protocols.AuthorizedCommunication;
import bsuir.webtech.lab3.server.protocols.UnauthorizedCommunication;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException, InterruptedException {

        XMLStudentDao studentDao = new XMLStudentDao("students.xml");

        Server server = new Server(
                4404,
                new UnauthorizedCommunication(
                        new AuthorizationService(new SimpleAccountDao()),
                        new AuthorizedCommunication(studentDao)
                )
        );
        server.start();

        Scanner scanner = new Scanner(System.in);
        while (server.isRunning()) {
            if (Objects.equals(scanner.nextLine(), "stop")) {
                server.stop();
            }
        }

        studentDao.saveAll();
    }
}
