

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client03 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        //연결 부분
        Socket cs= new Socket("192.168.1.13",9999);

        //데이터 전송 부분
        Scanner scanner = new Scanner(System.in);
        String msg=scanner.nextLine();        
        OutputStream os = cs.getOutputStream();
        DataOutputStream dos=new DataOutputStream(os); 
        dos.writeUTF(msg);
        
        //데이터 수신 부분
        InputStream is = cs.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        System.out.println(dis.readUTF());
        
        dos.close();
        os.close();
        dis.close();
        cs.close();
    }
}
