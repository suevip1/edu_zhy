public class Test {


    private static final com.edu.zhy.api.api.spring.FrameworkThreadPoolExecutor threadPool
            = new com.edu.zhy.api.api.spring.FrameworkThreadPoolExecutor(4, 10, 30L
            , java.util.concurrent.TimeUnit.MILLISECONDS
            , new java.util.concurrent.LinkedBlockingQueue<>(50)
            , new com.google.common.util.concurrent.ThreadFactoryBuilder().setNameFormat("DowngradeWscTeacherPool-%d").build());

//    @javax.annotation.Resource
//    private HandleChainSelector handleChainSelector;
//    @javax.annotation.Resource
//    private DefaultHandlerChainSelector defaultHandlerChainSelector;
//
//    @org.junit.Test
//     public void m1 (){
//
//
//         // 逆向相关的责任链
////         RefundChainLoader refundChainLoader = DubboReflectionUtils.doWithFields(new RefundChainLoader(), DubboReflectionUtils.DEFAULT_DUBBO_FCV2, true);
//         com.edu.zhy.api.api.spring.HandleChainSelector handleChainSelector = org.mockito.Mockito.mock(com.edu.zhy.api.api.spring.HandleChainSelector.class);
//         org.mockito.stubbing.OngoingStubbing<com.edu.zhy.api.api.spring.HandleChain> when = org.mockito.Mockito.when(handleChainSelector.ofScene(com.edu.zhy.api.api.dto.HandleChainScene.REFUND.getName()));
//         System.err.println(when);
////         DubboReflectionUtils.targetClassContext.put(HandleChainSelector.class, handleChainSelector);
//
//
//     }

//    public static void main(String[] args) {
//
//        org.springframework.web.context.WebApplicationContext currentWebApplicationContext
//                = org.springframework.web.context.ContextLoader.getCurrentWebApplicationContext();
//
//        Object handlerChainRegistry = currentWebApplicationContext.getBean("defaultHandlerChainSelector");
//
//        String name = handlerChainRegistry.getClass().getName();
//        System.err.println(name);
//        try {
//            java.lang.reflect.Method ofScene = handlerChainRegistry.getClass().getClass().getDeclaredMethod("ofScene");
//            System.err.println(ofScene);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//
//
//    }


    @org.junit.Test
    public void m12 (){

        java.util.List<String> a1 = new java.util.ArrayList<>(3);
        java.util.List<String> list = java.util.Arrays.asList("1","2","3","5","11","00","1010","2929","19191","122","1101");


        java.util.concurrent.CompletableFuture.runAsync(() -> {
            String name = Thread.currentThread().getName();
            for (String b1 : list){
                 a1.add(b1);
                System.err.println("当前执行的线程是"+name +"////"+a1);
            }

        },threadPool);

        java.util.concurrent.CompletableFuture.runAsync(() -> {
            String name = Thread.currentThread().getName();
            for (String b1 : list){
                a1.add(b1);
                System.err.println("当前执行的线程是"+name +"////"+a1);
            }

        },threadPool);



//        java.util.List<String> a2 = new java.util.ArrayList<>(3);
//        java.util.List<String> list2 = java.util.Arrays.asList("1","2","3","5","11","00","1010","2929","19191","122","1101");
//
//
//        java.util.concurrent.CompletableFuture.runAsync(() -> {
//            String name = Thread.currentThread().getName();
//            for (String b1 : list2){
//                a2.add(b1);
//                System.err.println("当前执行的线程是"+name +"////"+a2);
//            }
//
//        },threadPool);
//
    }







}
