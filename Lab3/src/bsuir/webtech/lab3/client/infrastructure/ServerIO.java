package bsuir.webtech.lab3.client.infrastructure;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerIO {
    private final Socket socket;
    public final DataInputStream in;
    public final DataOutputStream out;

    public ServerIO(Socket socket) throws IOException {
        this.socket = socket;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    public void close() throws IOException {
        socket.close();
    }
}
