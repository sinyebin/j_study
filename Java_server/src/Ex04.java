import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class Ex04 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("파일주소"));
        PrintWriter pw= new PrintWriter("파일주소");
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
