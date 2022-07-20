import java.util.*;
public class Pay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pay;
		int hours;
		Scanner input=new Scanner(System.in);
		System.out.print("시간을 입력하세요: ");
		hours=input.nextInt();
		if(hours>0) {
			pay=hours*6030;
			System.out.printf("임금은 %d입니다.\n", pay);
		}else {
			System.out.println("시간이 잘못 입력되었습니다.");
		}
	}

}
