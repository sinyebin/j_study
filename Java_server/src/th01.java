
public class th01 {
    public static void main(String[] args) {
        th01_1 t1 = new th01_1();
        t1.start();

        Runnable r = new th01_2();
        Thread t2=new Thread(r);
        t2.start();

        for(int i=0;i<1000;i++){
            System.out.println("main: "+i);
        }
    }
}
class th01_1 extends Thread{
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println("TH01_1: "+i);
        }     
    }
}
class th01_2 implements Runnable{
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println("TH01_2: "+i);
        }  
    }
}