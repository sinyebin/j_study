

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
import java.util.HashSet;
import java.util.List;

public class PubSubServer {
    static HashMap<String,HashSet<Socket>>topicList=new HashMap<>();
    static List<Socket> socketList;
    public static void main(String[] args) throws IOException {
        socketList = new ArrayList<>();
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("Server Started...");
        while (true) {
            Socket cs = ss.accept();
            socketList.add(cs);
            System.out.println("[" + cs.getInetAddress() + ":" + cs.getPort() + "] was conneted");
            System.out.println("clients : " + socketList.size());
            PubServerReceiver sr = new PubServerReceiver(cs);
            sr.start();
        }
    }
}
class PubServerReceiver extends Thread {
    Socket cs;

    PubServerReceiver(Socket cs) {
        this.cs = cs;
    }

    void fromSub(String message) {
        String topics = message.substring(1,message.length()-1);
        System.out.println(topics);

        for(String topic:topics.split(",")){
            if(!PubSubServer.topicList.containsKey(topic)){
                HashSet<Socket>topicSocketSet=new HashSet<>();
                topicSocketSet.add(cs);
                PubSubServer.topicList.put(topic, topicSocketSet);
            }else{
                PubSubServer.topicList.get(topic).add(cs);
            }
        }
    }

    void fromPub(String message){
        String topic=message.substring(7,8);
        if(PubSubServer.topicList.containsKey(topic)){
            String msg=message.substring(9);
            try {
                for (Socket client : PubSubServer.topicList.get(topic)) {
                    OutputStream os = client.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeUTF(msg);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("구독자가 없습니다.");
        }
        
    }

    public void run() {
        try {
            InputStream is = cs.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (dis != null) {
                String message = dis.readUTF();
                if(message.contains("topic")) {
                    fromPub(message);
                }else {
                    fromSub(message);
                }
            }
        }catch (SocketException e) {
            PubSubServer.socketList.remove(cs);
            System.out.println("[" + cs.getInetAddress() + ":" + cs.getPort() + "] was left");
            System.out.println("clients : " + PubSubServer.socketList.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}