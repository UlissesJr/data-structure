//package top.luobogan.logStack.chapter4;
//
//import cn.hutool.log.Log;
//import cn.hutool.log.LogFactory;
//
//import java.util.logging.LogManager;
//import java.util.logging.Logger;
//
///**
// * <h1>使用 log4j2</h1>
// * */
//public class UseLog4j2 {
//
//    private static final Log logger = LogFactory.getLog(UseLog4j2.class);
//    private static final Logger logger2 = LogManager.getLogger(UseLog4j2.class);
//
//    // 这样做有什么好处呢 ?
//    protected final Log logger3 = LogFactory.getLog(getClass());
//
//    /**
//     * <h2>log4j2 支持占位符, jcl 不支持</h2>
//     * */
//    public static void placeholder() {
//
//        logger2.info("use placeholder, not: [{}]", "abcde");
//    }
//
//    /**
//     * <h2>打印异常栈</h2>
//     * */
//    public static void logWithException() {
//
//        try {
//            System.out.println(Integer.parseInt("a"));
//        } catch (NumberFormatException ex) {
//            logger.error("parse int has some error", ex);
//        }
//    }
//
//    public static void main(String[] args) {
//
//        // 最基本的打印方法
////        logger.error("use jcl + log4j2 to log");
////        logger.info("use jcl + log4j2 to log");
////        logger2.info("use lo4j2 to log");
//
////        placeholder();
//
////        logWithException();
//    }
//}
