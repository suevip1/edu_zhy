//package com.edu.zhy.api.api.threadpool.util;
//
//import jakarta.transaction.Transaction;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.concurrent.Callable;
//import java.util.function.Consumer;
//
//public class AsyncUtils {
//    private static final Logger logger = LoggerFactory.getLogger(AsyncUtils.class);
//
//    public static Runnable wrap(Runnable runnable){
//        Context ctx = init();
//        return new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    ctx.start();
//                    runnable.run();
//                } catch (Throwable t) {
//                    ctx.logError(t);
//                    throw t;
//                } finally {
//                    ctx.end();
//                }
//            }
//        };
//    }
//
//    public static <T> Callable<T> wrap(Callable<T> callable){
//        Context ctx = init();
//        return new Callable<T>() {
//            @Override
//            public T call() throws Exception {
//                try {
//                    ctx.start();
//                    return callable.call();
//                } catch (Throwable t) {
//                    ctx.logError(t);
//                    throw t;
//                } finally {
//                    ctx.end();
//                }
//            }
//        };
//    }
//
//    public static <T> Consumer<T> wrap(Consumer<T> consumer) {
//        Context ctx = init();
//        return new Consumer<T>() {
//            @Override
//            public void accept(T t) {
//                try {
//                    ctx.start();
//                    consumer.accept(t);
//                } catch (Throwable e) {
//                    ctx.logError(e);
//                    throw e;
//                } finally {
//                    ctx.end();
//                }
//            }
//        };
//    }
//
//    public static Context init() {
//        return new Context();
//    }
//
//    public static class Context {
//        String rootId;
//        String messageId;
//        String parentId;
//        String childId;
//        Transaction root;
//        volatile String customerKey;
//        CatContext catContext;
//        Context() {
//            MessageTree tree1 = Cat.getManager().getThreadLocalMessageTree();
//            rootId = tree1.getRootMessageId();
//            messageId = tree1.getMessageId();
//            parentId = tree1.getParentMessageId();
//            childId = tree1.getChildMessageId();
//            if(tree1.getMessage() != null && tree1.getMessage() instanceof Transaction) {
//                customerKey = tree1.getMessage().getName();
//            }
//            catContext = CatContext.context();
//        }
//
//        public void start() {
//            MessageTree tree = Cat.getManager().getThreadLocalMessageTree();
//            if(customerKey != null) {
//                try {
//                    root = Cat.newTransaction(RpcConstant.DUMB_TYPE, customerKey);
//                    root.setStatus(Transaction.SUCCESS);
//                } catch (Exception e) {
//                    logger.warn("init transaction error.");
//                }
//            }
//            if(rootId != null) {
//                tree.setRootMessageId(rootId);
//                tree.setMessageId(messageId);
//                tree.setParentMessageId(parentId);
//                tree.setChildMessageId(childId);
//                tree.setSample(false);
//            } else {
//                catContext = (CatContext) Cat.createEntryConext(new CatContext());
//            }
//            CatContext.bind(catContext);
//        }
//
//        public void logError(Throwable t) {
//            if(root != null) {
//                root.setStatus(t);
//            }
//        }
//
//        public void end() {
//            CatContext.clean();
//            if(root != null) {
//                try {
//                    root.complete();
//                } catch (Exception e) {
//                    logger.warn("complete transaction error.");
//                }
//            }
//        }
//    }
//}
//
