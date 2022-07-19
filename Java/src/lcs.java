import java.util.*;
public class lcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
        System.out.println(Integer.toBinaryString(num));
		int n=scanner.nextInt();
		int check=0X80000000;
		for(int i=0;i<n;i++) {
            int temp=check&num;
			if(temp==0){
                num=num<<1;
            }else{
                num=num<<1;
                num=num|1;
            }
		}		
		System.out.println(Integer.toBinaryString(num));
	}
}