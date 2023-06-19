//package com.edu.zhy.api.api.spring;
//
//@lombok.extern.slf4j.Slf4j
//@org.springframework.stereotype.Component
//public class DefaultHandlerChainSelector implements HandleChainSelector {
//
//    @javax.annotation.Resource
//    private HandlerChainRegistry handlerChainRegistry;
//
//    @Override
//    public HandleChain ofScene(String sceneName) {
//        return handlerChainRegistry.getByScene(sceneName);
//    }
//
//
//
//
//    @org.springframework.stereotype.Component
//    @lombok.extern.slf4j.Slf4j
//    private static class HandlerChainRegistry implements org.springframework.context.ApplicationContextAware {
//        private NullHandlerChain nullHandlerChain = new NullHandlerChain();
//        private java.util.Map<String, HandleChain> chainMap = new java.util.HashMap<>();
//
//        HandleChain getByScene(String scene) {
//            return chainMap.getOrDefault(scene, nullHandlerChain);
//        }
//
//        @Override
//        public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws org.springframework.beans.BeansException {
//            applicationContext.getBeansOfType(HandleChainLoader.class).forEach((k, loader) -> {
//                try {
//                    java.util.List<HandleChain> chains = loader.load();
//                    chains.forEach(chain -> {
//                        ChainChecker.check(chain);
//                        chainMap.put(chain.getScene().getName(), chain);
//                        log.info( "order chain[{}] registered.", chain.getScene().getName());
//                    });
////                } catch (ChainCheckException ex) {
////                    // 捕获交易链初始化失败，不影响其他流程初始化
//                } catch (Exception ex) {
//                    log.error("DefaultHandlerChainSelector load chain ex. loader:{}", loader.getClass().getSimpleName(),ex);
//                    throw ex;
//                }
//            });
//        }
//    }
//
//
//    private static class NullHandlerChain implements HandleChain {
//        @Override
//        public com.edu.zhy.api.api.dto.HandleChainScene getScene() {
//            return com.edu.zhy.api.api.dto.HandleChainScene.NULL_CHAIN;
//        }
//
//        @Override
//        public Object process(HandleContext context) {
//            return null;
//        }
//
//        @Override
//        public HandleChain registerInOrder(HandleNode node, boolean mandatory) {
//            return this;
//        }
//
//        @Override
//        public java.util.List<HandleNode> getNodes() {
//            return new java.util.ArrayList<>();
//        }
//    }
//
//
//
//
//}
