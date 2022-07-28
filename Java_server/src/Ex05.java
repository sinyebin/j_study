import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex05 {
    public static void main(String[] args)throws Exception {
        FileInputStream fis= new FileInputStream("파일주소");
        FileOutputStream fos= new FileOutputStream("파일주소");
        while(true){
            int b=fis.read();
            if(b==-1){
                break;
            }
            fos.write(b);
        }
        fis.close();
        fos.close();
    }
}
