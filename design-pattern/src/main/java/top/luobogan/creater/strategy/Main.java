package top.luobogan.creater.strategy;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.testFactory();
    }

    // 工厂模式
    public void testFactory() {
        CashSuper cs = CashFactory.createCashAccept("打8折");
        double result = cs.acceptCash(300);
        System.out.println(result);
    }

    // 策略
    public void testContext() {
        CashContext context = null;
        double money = 0.0;
        String strategy = "打8折";
        switch (strategy) {
            case "正常收费":
                context = new CashContext(new CashNormal());
                break;
            case "打8折":
                context = new CashContext(new CashRebate(8));
                break;
            case "满300减100":
                context = new CashContext(new CashReturn(300, 100));
                break;

            default:
                break;
        }

        money = context.getResult(300);
        System.out.println(money);
    }

    // 策略
    public void testCashContextStrategy() {
        CashContextStrategy context = null;
        double money = 0.0;
        String strategy = "打8折";
        context = new CashContextStrategy(strategy);
        money = context.getResult(300);
        System.out.println(money);
    }


    // 策略高级用法
    public void test() {
        CashContextReflect context = null;
        double money = 0.0;
        String type = "com.zhaowa.course.design.strategy.CashRebate";
        Class[] paramTypes = {double.class};
        Object[] params = {8.0};
        context = new CashContextReflect(type, paramTypes, params);
        money = context.getResult(300);
        System.out.println(money);
    }
}