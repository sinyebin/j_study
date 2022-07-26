import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Ex02 {
    public static void main(String[] args) throws IOException {
        //FileOutputStream outputStream= new FileOutputStream("C:\\Users\\BIT\\Desktop\\j_study\\자바 네트워크 프로그래밍\\out.txt");
        //FileWriter fw= new FileWriter("C:\\Users\\BIT\\Desktop\\j_study\\자바 네트워크 프로그래밍\\out.txt");
        PrintWriter pw= new PrintWriter("C:\\Users\\BIT\\Desktop\\j_study\\자바 네트워크 프로그래밍\\out.txt");
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
