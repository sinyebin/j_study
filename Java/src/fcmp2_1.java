
import java.util.*;
public class fcmp2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s=scanner.nextLine();
        String t=scanner.nextLine();
        Select P=new Select(s, t);
        Ts Q=P.check();
        System.out.println(Q.cmp());
    }
}
class Tr{
    protected String s,t;
    public Tr(String s, String t){
        this.s=s;
        this.t=t;
    }
}
interface Ts{
    int cmp();
}
class Strcmp extends Tr implements Ts{
    public Strcmp(String s, String t) {
        super(s, t);
        //TODO Auto-generated constructor stub
    }
    public int cmp() {
        return s.compareTo(t);
    }

}
class Numcmp extends Tr implements Ts{
    public Numcmp(String s, String t) {
        super(s, t);
        //TODO Auto-generated constructor stub
    }
    @Override
    public int cmp() {
        return Double.compare(Double.parseDouble(s),Double.parseDouble(t));
    }
}

class Select extends Tr{
    public Select(String s, String t) {
        super(s, t);
        //TODO Auto-generated constructor stub
    }
    public Ts check(){
        if(isNumeric(s)&&isNumeric(t)){
            return new Numcmp(s, t);
        }else{
            return new Strcmp(s, t);
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
