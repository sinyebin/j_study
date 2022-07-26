public class MyStream {
	public static void main(String args[]) throws Exception {
        MyStream mystream=new MyStream();
        int result;
		try{
            result=100/0; // 예외 발생
            mystream.input("qwe"); 
            mystream.input("test"); //예외 발생
        }catch(ArithmeticException e){ // 예외 처리
            result=-1;
            System.out.println("by zero");
        }catch(Exception e){
            System.out.println("test is not valid name");
        }finally{ // 예외가 발생하더라도 수행
            mystream.run();
        }
		
	}
    public void run(){
        System.out.printf("running!!");
    }
    public void input(String name) throws Exception{ // 예외 처리
        if(name.equals("test")){
            throw new Exception(); // 예외 발생
        }
    }
}
