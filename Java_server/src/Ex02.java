import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Ex02 {
    public static void main(String[] args) throws IOException {
        //FileOutputStream outputStream= new FileOutputStream("파일주소");
        //FileWriter fw= new FileWriter("파일주소");
        PrintWriter pw= new PrintWriter("파일주소");
        for(int i=1;i<11;i++){
            String data=i+"번째 라인";
            //outputStream.write(data.getBytes());
            //fw.write(data);
            pw.println(data);
        }
        //outputStream.close(); //닫기
        //fw.close();
        pw.close(); 
    }
}
