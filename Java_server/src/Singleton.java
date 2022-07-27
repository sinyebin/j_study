
public class Singleton {
    //thread-safe: 함수 또는 변수 또는 객체가 여러 스레드로부터 동시에 접근이 이루어져도 동시에 이루어지지 않을 때와 차이가 없는 것을 의미
    private Singleton(){ }
    /*private static Singleton instance=null;
    public synchronized static Singleton getInstance() {
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }*/
    public static Singleton getInstance(){
        return LazyHolder.INSTANCE;
    }
    private static class LazyHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
}
