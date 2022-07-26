import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex05 {
    public static void main(String[] args)throws Exception {
        FileInputStream fis= new FileInputStream("C:\\Users\\BIT\\Desktop\\j_study\\자바 네트워크 프로그래밍\\pic.jpg");
        FileOutputStream fos= new FileOutputStream("C:\\Users\\BIT\\Desktop\\j_study\\자바 네트워크 프로그래밍\\picture.jpg");
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
