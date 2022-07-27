public class th05 {
    public static void main(String[] args) {
        Account account=new Account();
        for(int i=0;i<10;i++){
            Thread deposit= new Thread(new DepositThread(account));
            Thread withdraw= new Thread(new WithdrawThread(account));
            deposit.start();
            withdraw.start();
        }
    }
    
}
class Account{
    static long  balance=10000;
    public synchronized void deposit(long amount){
        balance=balance+amount;
    }
    public synchronized void withdraw(long amount){
        balance=balance-amount;
    }
    public void getBalance(){
        System.out.println("balance: "+balance);
    }
}
class DepositThread implements Runnable{
    Account account;
    DepositThread(Account account){
        this.account=account;
    }
    public void run(){  
        for(int i=0;i<1000;i++){
            account.deposit(10000);
        }
        account.getBalance();
    }
}
class WithdrawThread implements Runnable{
    Account account;
    WithdrawThread(Account account){
        this.account=account;
    }
    public void run(){  
        for(int i=0;i<1000;i++){
            account.withdraw(10000);
        }
        account.getBalance();
    }
}