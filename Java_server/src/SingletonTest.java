class SingletonTest {
    public static void main(String[] args) {
        //new Sigleton(); // 불가
        for(int i=0;i<5;i++){
            Thread singlethonThread=new Thread(new SigletonThread());
            singlethonThread.start();
        }
    }
}
class SigletonThread implements Runnable{
    public void run(){
        System.out.println(Singleton.getInstance());
    }
}