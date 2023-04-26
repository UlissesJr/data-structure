package top.luobogan.pattern.structural.proxy.dynamicproxy;

import top.luobogan.pattern.structural.proxy.IOrderService;
import top.luobogan.pattern.structural.proxy.Order;
import top.luobogan.pattern.structural.proxy.OrderServiceImpl;

/**
 * Created by luobogan
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
//        order.setUserId(2);
        order.setUserId(1);
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();

        orderServiceDynamicProxy.saveOrder(order);
    }
}
