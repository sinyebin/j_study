public class MyStream {
	public static void main(String args[]) {
        MyStream mystream=new MyStream();
        int result;
		try{
            result=100/0;
        }catch(ArithmeticException e){
            result=-1;
            System.out.println("Error");
        }finally{
            mystream.run();
        }
		
	}
    public void run(){
        System.out.printf("running!!");
    }
}
