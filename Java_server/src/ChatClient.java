

import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class ChatClient {
    public static void main(String[] args) throws IOException {
        //연결 부분
        Socket cs= new Socket("192.168.1.13",9999);
        ChatSender sender = new ChatSender(cs);
        sender.start();
        ChatReceiver receiver=new ChatReceiver(cs);
        receiver.start();
        System.out.println("닉네임 변경: [nickname]변경할닉네임");
        System.out.println("귓속말: [to:상대닉네임]메시지");
        System.out.println("접속한 사용자: [list]");
    }
}
class ChatReceiver extends Thread{
    Socket cs;
    ChatReceiver(Socket cs){
        this.cs=cs;
    }
    public void run(){
        try{
            InputStream is =cs.getInputStream(); //상대방으로부터 읽을 수 있는 스트림
            DataInputStream dis = new DataInputStream(is);
            while(dis!=null){    
                System.out.println(dis.readUTF());
            }
        }catch(IOException e){
            throw new RuntimeException();
        }           
    }
}

class ChatSender extends Thread{
    Socket cs;
    ChatSender(Socket cs){
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