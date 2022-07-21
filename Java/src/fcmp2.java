import java.util.*;
public class fcmp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s=scanner.nextLine();
        String t=scanner.nextLine();
        Tr P=new Select(s, t);
        Tr Q=((Select)P).check();
        System.out.println(((Select)P).connect(Q));
    }
}
class Tr{
    private String s,t;
    public Tr(String s, String t){
        this.s=s;
        this.t=t;
    }
    public String getS(){
        return s;
    }
    public String getT(){
        return t;
    }
}
class Select extends Tr{

    public Select(String s, String t) {
        super(s, t);
        //TODO Auto-generated constructor stub
    }
    public Tr check(){
        String s=getS();
        String t=getT();
        if(isNumeric(s)&&isNumeric(t)){
            return new Numcmp(s, t);
        }else{
            return new Strcmp(s,t);
        }        
    }
    public static boolean isNumeric(String s){
        try{
            Double.parseDouble(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
        /*
        boolean check=true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==45||s.charAt(i)==46||(s.charAt(i)>=48&&s.charAt(i)<=57)){

            }else{
                check=false;
                return check;
            }
        }
        return check;
         */
    }
    public static int connect(Tr Q){
        int ans=0;
        if(Q instanceof Strcmp){
            ans=((Strcmp)Q).cmp();
        }else{
            ans=((Numcmp)Q).cmp();
        }
        return ans;
    }
   
}
class Strcmp extends Tr{

    public Strcmp(String s, String t) {
        super(s, t);
        //TODO Auto-generated constructor stub
    }
    public int cmp(){
        String s=getS();
        String t=getT();
        return s.compareTo(t);
    }

}
class Numcmp extends Tr{

    public Numcmp(String s, String t) {
        super(s, t);
        //TODO Auto-generated constructor stub
    }
    public int cmp(){
        Double s=Double.parseDouble(getS());
        Double t=Double.parseDouble(getT());
        /*int ans=0;
        if(s>t){
            ans=1;
        }else if(s==t){
            ans=0;
        }else{
            ans=-1;
        }
        return ans;
        */
        return s.compareTo(t);
    }

}
