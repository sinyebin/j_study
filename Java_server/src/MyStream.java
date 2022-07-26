public class MyStream {
	public static void main(String args[]) {
        MyStream mystream=new MyStream();
        int result;
		try{
            result=100/0; // 예외 발생
        }catch(ArithmeticException e){ // 예외 처리
            result=-1;
            System.out.println("Error");
        }finally{ // 예외가 발생하더라도 수행
            mystream.run();
        }
		
	}
    public void run(){
        System.out.printf("running!!");
    }
}
