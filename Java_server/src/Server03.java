
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999); //9999번 포트 사용
        Socket clientSocket = serverSocket.accept();
        System.out.println("client IP addr: "+clientSocket.getInetAddress());
        System.out.println("server IP addr: "+clientSocket.getLocalAddress());
        System.out.println("client Port: "+clientSocket.getPort());
        System.out.println("server Port: "+clientSocket.getLocalPort());
        InputStream is =clientSocket.getInputStream(); //상대방으로부터 읽을 수 있는 스트림
        DataInputStream dis = new DataInputStream(is);
        int data=dis.readInt();
        System.out.println(data);

        clientSocket.close();
        
        
        //clientSocket.getOutputStream(); //상대방으로부터 보낼 수 있는 스트림
    }
}
