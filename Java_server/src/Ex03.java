import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        //byte[]b=new byte[1024];
        //FileInputStream fis= new FileInputStream("C:\\Users\\BIT\\Desktop\\j_study\\자바 네트워크 프로그래밍\\out.txt");
        //fis.read(b);
        //System.out.println(new String(b));
        //fis.close();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\BIT\\Desktop\\j_study\\자바 네트워크 프로그래밍\\out.txt"));
        while(true){
            String line=br.readLine();
            if(line==null){
                break;
            }
            System.out.println(line);
        }
    }
}