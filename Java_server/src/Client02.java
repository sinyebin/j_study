import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client02 {
    public static void main(String[] args) throws IOException{
        Socket clientSocket=new Socket("www.ddarahakit.kro.kr",80);
        OutputStream os = clientSocket.getOutputStream();
        DataOutputStream dos=new DataOutputStream(os);
        dos.writeBytes("GET / HTTP/1.1\r\nHost: www.ddarahakit.kro.kr\r\n\r\n");
        
        InputStream is=clientSocket.getInputStream();
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(isr);
        PrintWriter pw = new PrintWriter("C:\\Users\\BIT\\Desktop\\j_study\\자바 네트워크 프로그래밍\\ab.html");
        while(true){
            String data=br.readLine();
            if(data==null){
                break;
            }
            System.out.println(data);
            pw.println(data);
        }
        br.close();
        pw.close();
        clientSocket.close();
    }   
}