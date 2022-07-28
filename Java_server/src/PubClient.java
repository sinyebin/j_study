
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PubClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket cs= new Socket("IP주소",9999);
        PubSender pubSender = new PubSender(cs);
        pubSender.start();
    }
}
class PubSender extends Thread{
    Socket cs;
    PubSender(Socket cs){
        this.cs=cs;
    }
    public void run(){
        try {
            OutputStream os = cs.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            Scanner scanner=new Scanner(System.in);
            while(dos!=null){
                String msg=scanner.nextLine();
                dos.writeUTF(msg);
            }           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
}