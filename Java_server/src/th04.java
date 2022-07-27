
public class th04 {
    static long start=0;
    public static void main(String[] args) {
        start=System.currentTimeMillis();
        th04_1 t1=new th04_1();
        t1.start();

        for(int i=0;i<1000;i++){
            System.out.printf("%s","|");
        }
        System.out.println("소요시간2: "+(System.currentTimeMillis()-th04.start));
    }
}

class th04_1 extends Thread{
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.printf("%S ","-");
        }
        System.out.println("소요시간1: "+(System.currentTimeMillis()-th04.start));
        
    }
    
}