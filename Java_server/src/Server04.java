
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server04 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(9999);
        System.out.println("Server Started...");
        
        Socket cs=ss.accept();

        //수신 부분
        Receiver_1 receiver=new Receiver_1(cs);
        receiver.start();

        //전송 부분
        Sender_1 sender=new Sender_1(cs);
        sender.start();
        
    }
}
class Receiver_1 extends Thread{
    Socket cs;
    Receiver_1(Socket cs){
        this.cs=cs;
    }
    public void run(){
        try{
            InputStream is =cs.getInputStream(); //상대방으로부터 읽을 수 있는 스트림
            DataInputStream dis = new DataInputStream(is);
            while(dis!=null){    
                System.out.println("["+cs.getInetAddress()+":"+cs.getPort()+"] "+dis.readUTF());
            }
        }catch(IOException e){
            throw new RuntimeException();
        }
        
            
    }
}

class Sender_1 extends Thread{
    Socket cs;
    Sender_1(Socket cs){
        this.cs=cs;
    }
    public void run(){
        try {
            OutputStream os = cs.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            Scanner scanner=new Scanner(System.in);
            while(dos!=null){
                String msg=scanner.nextLine();
                if(msg.equals("quit")){
                    return;
                }
                dos.writeUTF(msg);
            }           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
}