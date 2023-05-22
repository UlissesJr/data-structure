package top.luobogan.threadCoreKnowledge.disruptor;

import com.lmax.disruptor.EventFactory;

class LongEventFactory implements EventFactory {
        @Override
        public Object newInstance() {
            return new LongEvent();
        }
    }
