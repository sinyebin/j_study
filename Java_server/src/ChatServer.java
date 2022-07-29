
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ChatServer {
    static List<Socket> socketList;
    static HashMap<String,Socket> nickSet;
   
    public static void main(String[] args) throws IOException {
        socketList = new ArrayList<>();
        nickSet=new HashMap<>();
        ServerSocket ss= new ServerSocket(9999);
        System.out.println("Server Started");
        while(true){
            Socket cs=ss.accept();
            socketList.add(cs); // 여러 명의 클라이언트가 접속     
            String nick="";       
            while(!nickSet.containsKey(nick)){ //중복되지 않았는지 확인
                nick=random_nick(); //닉네임 생성
                if(!nickSet.containsKey(nick)){
                    nickSet.put(nick,cs);
                }
            }           
            System.out.println("[" + nick + "]가 입장했습니다.");  //서버 입장 전달, 접속해 있는 인원 
            System.out.println("clients: "+socketList.size()); 
            ChatReciever receiver=new ChatReciever(cs,nick);
            receiver.start();

        }
    }
    static String random_nick(){ //랜덤 닉네임 생성
        String nick="";
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10; // 10글자 제한
        Random random = new Random();
        nick = random.ints(leftLimit, rightLimit + 1)
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
        return nick;
    }
}
class ChatReciever extends Thread{
    Socket cs;
    String nick;
    ChatReciever(Socket cs,String nick){
        this.cs=cs;
        this.nick=nick;
    }
    public void run(){
        String msg;
        try{
            InputStream is =cs.getInputStream(); //상대방으로부터 읽을 수 있는 스트림
            DataInputStream dis = new DataInputStream(is);           
            while(dis!=null){ 
                msg=dis.readUTF(); 
                if(msg.equals("[list]")){ // 리스트 출력
                    printList();
                }else if(msg.length()>10&&msg.substring(0,10).equals("[nickname]")){ // 닉네임 변경
                    String str=msg.substring(10);
                    changeNick(str);
                }else if(msg.length()>4&&msg.substring(0,4).equals("[to:")){ // 귓속말 구현
                    String str=msg.substring(4);
                    sendToOne(str);
                }else{ // 전체 메시지 전송
                    String str="["+nick+"] "+msg;
                    sendToAll(str);  
                }
                            
            }
        }catch(SocketException e){ // 채팅 종료
            ChatServer.socketList.remove(cs);
            ChatServer.nickSet.remove(nick);
            String str="["+nick+"]가 나갔습니다. ";
            sendToAll(str);
            System.out.println(str);
            System.out.println("clients: "+ChatServer.socketList.size());   
        }catch(IOException e){
            throw new RuntimeException();
        }            
    }
    void sendToAll(String msg){ // 메시지 전체 보내기
        try{
            for(Socket send:ChatServer.socketList){
                if(send==cs) continue; // 본인 제외
                OutputStream os = send.getOutputStream();
                DataOutputStream dos=new DataOutputStream(os);
                dos.writeUTF(msg);
            } 
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    void printList(){ //접속해 있는 리스트 출력
        try {
            OutputStream os = cs.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            for(String str: ChatServer.nickSet.keySet()){
                dos.writeUTF(str);
            }           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    void changeNick(String str){ // 닉네임 변경
        if(!ChatServer.nickSet.containsKey(str)){ // 닉네임 중복 체크
            ChatServer.nickSet.put(str,cs);
            ChatServer.nickSet.remove(nick);
            this.nick=str;
        }else{
            try {
                OutputStream os = cs.getOutputStream();
                DataOutputStream dos=new DataOutputStream(os);
                dos.writeUTF("중복된 닉네임 입니다.");           
            } catch (IOException e) {
                // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }
    }
    void sendToOne(String str){ // 귓속말 구현
        String []message=str.split("]");
        try{
            if(!ChatServer.nickSet.containsKey(message[0])){ //존재하는 닉네임인지 확인
                OutputStream os = cs.getOutputStream();
                DataOutputStream dos=new DataOutputStream(os);
                dos.writeUTF("존재하지 않는 닉네임 입니다.");    
            }else{
                Socket send=ChatServer.nickSet.get(message[0]); 
                if(send==cs){ // 본인인지 확인
                    OutputStream os = cs.getOutputStream();
                    DataOutputStream dos=new DataOutputStream(os);
                    dos.writeUTF("사용자 본인 입니다.");    
                }else{
                    OutputStream os = send.getOutputStream();
                    DataOutputStream dos=new DataOutputStream(os);            
                    dos.writeUTF("["+nick+"]"+message[1]);
                }
                
            }    
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
