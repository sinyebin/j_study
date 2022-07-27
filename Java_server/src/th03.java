

public class th03 {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();

        for(int i=0;i<1000;i++){
            System.out.printf("%S ","-");
        }
        System.out.println("소요시간1: "+(System.currentTimeMillis()-start));
        
        for(int i=0;i<1000;i++){
            System.out.printf("%s","|");
        }
        System.out.println("소요시간2: "+(System.currentTimeMillis()-start));
    }
}
