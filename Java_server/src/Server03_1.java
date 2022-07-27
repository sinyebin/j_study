
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class Server03_1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(9999);
        while(true){
            //연결 부분
            Socket cs=ss.accept();
            System.out.println("client IP: "+cs.getInetAddress());
            System.out.println("client Post: "+cs.getPort());

            //데이터 수신 부분
            InputStream is =cs.getInputStream(); //상대방으로부터 읽을 수 있는 스트림
            DataInputStream dis = new DataInputStream(is);
            String data=dis.readUTF();
            System.out.println(data);
            
            //데이터 전송 부분
            OutputStream os = cs.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            dos.writeUTF("echo "+data);
            
            //연결 해제 부분
            dos.close();
            cs.close();
            dis.close();
            is.close();
        }
    }
}
