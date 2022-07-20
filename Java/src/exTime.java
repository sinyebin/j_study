import java.util.*;
public class exTime {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int hour=scanner.nextInt();
        int min=scanner.nextInt();
        int sec=scanner.nextInt();
        Time first_time=new Time(10, 10, 10);
        Time second_time = new Time(hour, min, sec);
        Time add_time=first_time.add(second_time);
        Time sub_time=first_time.sub(second_time);
        System.out.println("두 시간의 합은");
        add_time.print_time();
        System.out.println("두 시간의 차는");
        sub_time.print_time();
        int result=first_time.compare(second_time);
        System.out.println(result);
    }
}
class Time{
    private int day;
    private int hour;
    private int min;
    private int sec;
    public Time(){}
    public Time(int hour, int min, int sec){
        this.hour=hour;
        this.min=min;
        this.sec=sec;
    }
    public Time(int day,int hour, int min, int sec){
        this.day=day;
        this.hour=hour;
        this.min=min;
        this.sec=sec;
    }
    
    public int getHour(){
        return hour;
    }
    public int getMin(){
        return min;
    }
    public int getSec(){
        return sec;
    }
    public Time add(Time second_time){
        int first=this.hour*3600+this.min*60+this.sec;
        int second=second_time.getHour()*3600+second_time.getMin()*60+second_time.getSec();
        int add_time=first+second;
        int n_day=0;
        int n_hour;
        int n_min;
        int n_sec;
        n_hour=add_time/3600;
        add_time%=3600;
        n_min=add_time/60;
        add_time%=60;
        n_sec=add_time;
        if(n_hour>=24){
            n_day++;
            n_hour-=24;
        }
        return new Time(n_day, n_hour, n_min, n_sec);
    }
    public Time sub(Time second_time){
        int first=this.hour*3600+this.min*60+this.sec;
        int second=second_time.getHour()*3600+second_time.getMin()*60+second_time.getSec();
        int sub_time=first-second;
        int n_day=0;
        int n_hour;
        int n_min;
        int n_sec;
        if(sub_time<0){
            sub_time=86400+sub_time;
            n_day=-1;
        }
        n_hour=sub_time/3600;
        sub_time%=3600;
        n_min=sub_time/60;
        sub_time%=60;
        n_sec=sub_time;       
        return new Time(n_day, n_hour, n_min, n_sec);
    }
    public void print_time(){
        if(day==1){
            System.out.print("후일 ");
        }else if(day==0){
            System.out.print("당일 ");
        }else{
            System.out.print("전일 ");
        }
        System.out.println(hour+"시 "+min+"분 "+sec+"초 입니다.");
    }
    public int compare(Time second_time){
        int result=0;
        int first=this.hour*3600+this.min*60+this.sec;
        int second=second_time.getHour()*3600+second_time.getMin()*60+second_time.getSec();
        int sub_time=first-second;
        result=Math.abs(sub_time);
        return result;
    }
}
