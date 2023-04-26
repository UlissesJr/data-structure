package top.luobogan.threadCoreKnowledge.deadLock;

import java.util.Random;

/**
 * 描述：     多人同时转账，依然很危险
 * Created by LuoboGan
 * Date:2022/10/23
 */
public class MultiTransferMoney {

    private static final int NUM_ACCOUNTS = 20;
    private static final int NUM_MONEY = 100000;
    private static final int NUM_ITERATIONS = 1000000;
    private static final int NUM_THREADS = 50;

    public static void main(String[] args) {

        Random rnd = new Random();
        TransferMoneyNoHelper.Account[] accounts = new TransferMoneyNoHelper.Account[NUM_ACCOUNTS];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new TransferMoneyNoHelper.Account(NUM_MONEY);
        }
        class TransferThread extends Thread {
            @Override
            public void run() {
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int toAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int amount = rnd.nextInt(NUM_MONEY);
                    TransferMoneyNoHelper.transferMoney(accounts[fromAcct], accounts[toAcct], amount);
                }
                System.out.println("运行结束");
            }
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            new TransferThread().start();
        }
    }
}

