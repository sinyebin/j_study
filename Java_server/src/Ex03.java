import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        //byte[]b=new byte[1024];
        //FileInputStream fis= new FileInputStream("파일주소");
        //fis.read(b);
        //System.out.println(new String(b));
        //fis.close();
        BufferedReader br = new BufferedReader(new FileReader("파일주소"));
        while(true){
            String line=br.readLine();
            if(line==null){
                break;
            }
            System.out.println(line);
        }
    }
}