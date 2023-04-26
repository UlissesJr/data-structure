package top.luobogan.pattern.structural.proxy.staticproxy;

import top.luobogan.pattern.structural.proxy.Order;

/**
 * Created by luobogan
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}
