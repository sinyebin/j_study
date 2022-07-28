
import java.io.IOException;
import java.net.Socket;

public class Client04 {
    public static void main(String[] args) throws IOException {
        //연결 부분
        Socket cs= new Socket("IP주소",9999);
        Sender_1 sender = new Sender_1(cs);
        sender.start();

        Receiver_1 receiver=new Receiver_1(cs);
        receiver.start();
    }
}
