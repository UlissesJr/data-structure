package top.luobogan.pattern.structural.bridge;

/**
 * Created by luobogan
 */
public abstract class Bank {
    protected Account account;
    public Bank(Account account){
        this.account = account;
    }
    abstract Account openAccount();

}
