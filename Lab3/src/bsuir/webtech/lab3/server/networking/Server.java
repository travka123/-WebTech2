package bsuir.webtech.lab3.server.networking;


import bsuir.webtech.lab3.server.protocols.AuthorizationProtocol;
import bsuir.webtech.lab3.server.protocols.CommunicationProtocol;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final int port;
    private final CommunicationProtocol protocol;

    private boolean running = false;
    private ServerSocket serverSocket;
    private Thread receivingThread;
    private final List<Connection> connections = new ArrayList<>();

    public Server(int port, CommunicationProtocol protocol) {
        this.port = port;
        this.protocol = protocol;
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        running = true;

        receivingThread = new Thread(() -> {
            while (!serverSocket.isClosed()) {

                removeClosedConnections();

                try {
                    Connection connection = new Connection(serverSocket.accept(), protocol);
                    connection.start();
                    connections.add(connection);
                } catch (SocketException ignore) {

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        receivingThread.start();
    }

    public void stop() throws IOException, InterruptedException {
        serverSocket.close();
        receivingThread.join();

        for (Connection connection : connections) {
            connection.stop();
        }

        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void removeClosedConnections() {
        for (int i = connections.size() - 1; i >= 0; i--) {
            Connection connection = connections.get(i);
            if (connection.isClosed()) {
                connections.remove(connection);
            }
        }
    }
}
