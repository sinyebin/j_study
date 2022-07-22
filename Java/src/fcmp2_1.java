import java.util.*;
public class fcmp2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s=scanner.nextLine();
        String t=scanner.nextLine();
        Select1 P=new Select1(s, t);
        Ts Q=P.check();
        System.out.println(Q.cmp());
    }
}
class Tr1{
    protected String s,t;
    public Tr1(String s, String t){
        this.s=s;
        this.t=t;
    }
}
interface Ts{
    int cmp();
}
class Strcmp1 extends Tr1 implements Ts{
    public Strcmp1(String s, String t) {
        super(s, t);
        //TODO Auto-generated constructor stub
    }
    public int cmp() {
        return s.compareTo(t);
    }

}
class Numcmp1 extends Tr1 implements Ts{
    public Numcmp1(String s, String t) {
        super(s, t);
        //TODO Auto-generated constructor stub
    }
    @Override
    public int cmp() {
        return Double.compare(Double.parseDouble(s),Double.parseDouble(t));
    }
}

class Select1 extends Tr1{
    public Select1(String s, String t) {
        super(s, t);
        //TODO Auto-generated constructor stub
    }
    public Ts check(){
        if(isNumeric(s)&&isNumeric(t)){
            return new Numcmp1(s, t);
        }else{
            return new Strcmp1(s, t);
        }        
    }
    public boolean isNumeric(String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }  
}
