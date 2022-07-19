import java.util.*;
public class midStr {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String a= scanner.nextLine();
        String b= scanner.nextLine();
        String result=midstr(s,a,b);
        System.out.println(result);
    }
    static String midstr(String ... s){
        String ans="";
        int a=Integer.parseInt(s[1]);
        int b=Integer.parseInt(s[2]);
        if(s[0].length()<a||a==0){
            System.out.println("a인자 값 잘못 되었음");
            System.exit(0);
        }else if(s[0].length()<a+b-1||b==0){
            System.out.println("b인자 값 잘못 되었음");
            System.exit(0);
        }
        for(int i=a-1;i<a+b-1;i++){
            ans+=s[0].charAt(i);
        }
        return ans;
    }
}

