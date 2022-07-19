import java.util.*;
public class Rvr {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        char c=scanner.next().charAt(0);
        String result=revsqueeze(str,c);
        System.out.println(result);
    }
    static String revsqueeze(String str,char c){
        String ans="";
        str=str.replaceAll(String.valueOf(c), "");
        char n[]=str.toCharArray();
        /*for(int i=n.length-1;i>=0;i--){ //for문
            ans+=n[i];
        }*/ 
        for(char a:n){ //for each문
            ans=a+ans;
        }
        return ans;
    }
}
