
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class WebServer {
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
            WebServerReceiver receiver=new WebServerReceiver(cs);
            receiver.start();

        }
    }
}
class WebServerReceiver extends Thread{
    Socket cs;
    WebServerReceiver(Socket cs){
        this.cs=cs;
    }
    public void run(){

        try{
            InputStream is =cs.getInputStream(); //상대방으로부터 읽을 수 있는 스트림
//            DataInputStream dis = new DataInputStream(is);  
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String msg;
            while((msg=br.readLine())!=null){ 
                System.out.println(msg);                
                sendToClient(msg);
                break;   
            }
            
        }catch (SocketException e) {
            WebServer.socketList.remove(cs);
            System.out.println("[" + cs.getInetAddress() + ":" + cs.getPort() + "] was left");
            System.out.println("clients : " + WebServer.socketList.size());
        }catch(IOException e){
            throw new RuntimeException();
        }            
    }
    void sendToClient(String requestLine){
        String filePath=requestLine.split(" ")[1];
        String realPath="파일주소"+filePath;
        System.out.println(realPath);
        try{
            OutputStream os = cs.getOutputStream();
//            DataOutputStream dos=new DataOutputStream(os);
            PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
            BufferedReader br = new BufferedReader(new FileReader(realPath));
            pw.write("HTTP/1.1 200 OK\r\n");
            pw.write("\r\n");
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                pw.write(line+"\r\n");
            }
            br.close();
            pw.close();
            cs.close();
            
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
