
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;


class ServerReceiver extends Thread {
    Socket cs;

    ServerReceiver(Socket cs) {
        this.cs = cs;
    }

    void sendToClient(String message) {
        String target = message.split("/")[2];
        message = message.split("to")[0]+message.split("/")[3];


        try {
            for (Socket client : ToServer.socketList) {
                if (client == cs) continue;

                if (("/"+target).equals(""+client.getInetAddress())) {
                    OutputStream os = client.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeUTF(message);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void sendToAll(String message) {
        try {
            for (Socket client : ToServer.socketList) {
                if (client == cs) continue;
                OutputStream os = null;
                os = client.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        try {
            InputStream is = cs.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (dis != null) {
                String message = dis.readUTF();
                if(message.split("] ")[1].startsWith("to/")) {
                    sendToClient(message);
                }else {
                    sendToAll(message);
                }
            }
        } catch (SocketException e) {
            ToServer.socketList.remove(cs);
            sendToAll("[" + cs.getInetAddress() + ":" + cs.getPort() + "] was left");
            System.out.println("[" + cs.getInetAddress() + ":" + cs.getPort() + "] was left");
            System.out.println("clients : " + ToServer.socketList.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ToServer {
    static List<Socket> socketList;

    public static void main(String[] args) throws IOException {
        socketList = new ArrayList<>();
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("Server Started...");
        while (true) {
            Socket cs = ss.accept();
            socketList.add(cs);
            System.out.println("[" + cs.getInetAddress() + ":" + cs.getPort() + "] was conneted");
            System.out.println("clients : " + socketList.size());
            ServerReceiver sr = new ServerReceiver(cs);
            sr.start();
        }
    }
}

