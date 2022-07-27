

public class th02 {
    public static void main(String[] args) {
        th02_1 t1 = new th02_1();
        t1.start();

        
    }
}
class th02_1 extends Thread{
    public void run(){
        try{
            throw new Exception();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
