
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Server05 {
    static List<Socket> socketList;
    public static void main(String[] args) throws IOException {
        socketList = new ArrayList<>();
        ServerSocket ss= new ServerSocket(9999);
        System.out.println("Server Started");
        while(true){
            Socket cs=ss.accept();
            socketList.add(cs); // 여러 명의 클라이언트가 접속   
            System.out.println("[" + cs.getInetAddress() + ":" + cs.getPort() + "]가 입장했습니다.");   
            System.out.println("clients: "+socketList.size());          
            Receiver_2 receiver=new Receiver_2(cs);
            receiver.start();

        }
    }
}
class Receiver_2 extends Thread{
    Socket cs;
    Receiver_2(Socket cs){
        this.cs=cs;
    }
    public void run(){
        String msg;
        try{
            InputStream is =cs.getInputStream(); //상대방으로부터 읽을 수 있는 스트림
            DataInputStream dis = new DataInputStream(is);           
            while(dis!=null){ 
                msg=dis.readUTF();
                String str="["+cs.getInetAddress()+":"+cs.getPort()+"] "+msg;
                sendToAll(str);               
            }
        }catch(SocketException e){
            Server05.socketList.remove(cs);
            String str="["+cs.getInetAddress()+":"+cs.getPort()+"]가 나갔습니다. ";
            sendToAll(str);
            System.out.println("clients: "+Server05.socketList.size());   
        }catch(IOException e){
            throw new RuntimeException();
        }            
    }
    void sendToAll(String msg){
        try{
            for(Socket send:Server05.socketList){
                if(send==cs) continue;
                OutputStream os = send.getOutputStream();
                DataOutputStream dos=new DataOutputStream(os);
                dos.writeUTF(msg);
            } 
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
