package top.luobogan.threadCoreKnowledge.deadLock;

/**
 * 描述：     转账时候遇到死锁，一旦打开注释，便会发生死锁
 * Created by LuoboGan
 * Date:2022/10/23
 */
public class TransferMoneyNoHelper implements Runnable {

    int flag = 1;
    static Account a = new Account(500);
    static Account b = new Account(500);
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        TransferMoneyNoHelper r1 = new TransferMoneyNoHelper();
        TransferMoneyNoHelper r2 = new TransferMoneyNoHelper();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a的余额" + a.balance);
        System.out.println("b的余额" + b.balance);
    }

    @Override
    public void run() {
        if (flag == 1) {
            transferMoney(a, b, 200);
        }
        if (flag == 0) {
            transferMoney(b, a, 200);
        }
    }

    public static void transferMoney(Account from, Account to, int amount) {
        synchronized (from) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            synchronized (to) {
                if(from.balance - amount < 0){
                    System.out.println("账户余额不足，转账失败。");
                }else{
                    from.balance -= amount;
                    to.balance += amount;
                    System.out.println("转账成功 " + amount + "元");
                }
            }
        }
    }

    static class Account {

        int balance;

        public Account(int balance) {
            this.balance = balance;
        }

    }
}

