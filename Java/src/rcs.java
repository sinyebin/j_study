import java.util.*;
public class rcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		int n=scanner.nextInt();
		System.out.println(Integer.toBinaryString(num));
		int check= 0X7FFFFFFF;
        int check2= 0X80000000;
		for(int i=0;i<n;i++) {
			if(num>=0) {
				if((num&1)==0) {
					num=num>>1;
				}else {
					num=num>>1;
					num=num|check2;
				}
			}else {
				if((num&1)==0) {
					num=num>>1;
					num=num&check;
				}else {
					num=num>>1;
				}
			}
		}
        System.out.println(Integer.toBinaryString(num));		
	}
}

