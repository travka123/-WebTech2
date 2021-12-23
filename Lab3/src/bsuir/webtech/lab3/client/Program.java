package bsuir.webtech.lab3.client;

import bsuir.webtech.lab3.client.infrastructure.CommunicationProtocol;
import bsuir.webtech.lab3.client.infrastructure.ServerIO;
import bsuir.webtech.lab3.client.presentation.Main;
import bsuir.webtech.lab3.client.presentation.UserIO;
import bsuir.webtech.lab3.client.infrastructure.AuthorizationProtocol;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Program {
    public static void main(String[] args) throws IOException {
        try {
            ServerIO serverIO = new ServerIO(new Socket("localhost", 4404));

            new Main(new UserIO(), new CommunicationProtocol(serverIO), new AuthorizationProtocol(serverIO)).show();

            serverIO.close();
        }
        catch (ConnectException e) {
            System.err.print("Не удалось подключиться к серверу\n");
        }
        catch (IOException e) {
            System.err.print("Потеряно соединение с сервером\n");
        }
    }
}
