package top.luobogan.threadCoreKnowledge.disruptor;

import com.lmax.disruptor.WorkHandler;
import top.luobogan.threadCoreKnowledge.utils.Print;

/**
 * 类似于消费者
 * disruptor会回调此处理器的方法
 */
class LongEventWorkHandler implements WorkHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event) throws Exception {
        Print.tcfo(event.getValue());
    }
}