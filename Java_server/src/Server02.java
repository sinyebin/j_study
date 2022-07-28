
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("파일주소"));
        ServerSocket serverSocket = new ServerSocket(9999); //9999번 포트 사용
        Socket clientSocket = serverSocket.accept();
        while(true){
            String line=br.readLine();
            if(line==null){
                break;
            }
            if(line.equals(clientSocket.getInetAddress().toString())){
                System.out.println("403 forbidden");
                clientSocket.close();
                return;    
            }
        }
        InputStream is =clientSocket.getInputStream(); //상대방으로부터 읽을 수 있는 스트림
        DataInputStream dis = new DataInputStream(is);
        int data=dis.readInt();
        System.out.println(data);
        clientSocket.close();

        //clientSocket.getOutputStream(); //상대방으로부터 보낼 수 있는 스트림
    }
}