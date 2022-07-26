import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class Ex04 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\BIT\\Desktop\\j_study\\자바 네트워크 프로그래밍\\out.txt"));
        PrintWriter pw= new PrintWriter("C:\\Users\\BIT\\Desktop\\j_study\\자바 네트워크 프로그래밍\\print.txt");
        while(true){
            String line=br.readLine();
            if(line==null){
                break;
            }
            pw.println(line);
        }
        pw.close();
        br.close();
    }
}
