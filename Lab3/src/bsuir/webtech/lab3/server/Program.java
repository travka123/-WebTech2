package bsuir.webtech.lab3.server;

import bsuir.webtech.lab3.server.business.AuthorizationService;
import bsuir.webtech.lab3.server.networking.Server;
import bsuir.webtech.lab3.server.persistence.XMLAccountDao;
import bsuir.webtech.lab3.server.persistence.XMLStudentDao;
import bsuir.webtech.lab3.server.protocols.CommunicationProtocol;
import bsuir.webtech.lab3.server.protocols.AuthorizationProtocol;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException, InterruptedException {

        int port = 4404;

        XMLAccountDao accountDao = new XMLAccountDao("accounts.xml");
        XMLStudentDao studentDao = new XMLStudentDao("students.xml");

        //Init values for first launch
        //accountDao.fillWithDefault();
        //accountDao.saveAll();
        //studentDao.fillWithDefault();
        //studentDao.saveAll();

        Server server = new Server(
                port,
                new AuthorizationProtocol(
                        new AuthorizationService(accountDao),
                        new CommunicationProtocol(studentDao)
                )
        );
        server.start();


        System.out.print("Введите \"stop\" для выключения сервера\n");
        Scanner scanner = new Scanner(System.in);
        while (server.isRunning()) {
            if (Objects.equals(scanner.nextLine(), "stop")) {
                server.stop();
            }
        }

        studentDao.saveAll();
    }
}
