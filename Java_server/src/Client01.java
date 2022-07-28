import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client01 {
    public static void main(String[] args) throws IOException{
        Socket clientSocket=new Socket("IP주소",9999);
        OutputStream os = clientSocket.getOutputStream();
        DataOutputStream dos=new DataOutputStream(os);
        dos.writeInt(100);
        clientSocket.close();
    }   
}