package bsuir.webtech.lab3.server.networking;

import bsuir.webtech.lab3.server.protocols.UnauthorizedCommunication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {
    private final Socket socket;
    private final UnauthorizedCommunication protocol;
    private Thread communicationThread;

    public Connection(Socket socket, UnauthorizedCommunication unauthorizedCommunication) {
        this.socket = socket;
        this.protocol = unauthorizedCommunication;
    }

    public void start() {
        communicationThread = new Thread(() -> {
            try {
                try {
                    protocol.Communicate(
                            new DataInputStream(socket.getInputStream()),
                            new DataOutputStream(socket.getOutputStream())
                    );
                } catch (IOException ignore) {

                } finally {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        communicationThread.start();
    }

    public void stop() throws IOException, InterruptedException {
        socket.close();
        communicationThread.join();
    }

    public boolean isClosed() {
        return socket.isClosed();
    }
}
