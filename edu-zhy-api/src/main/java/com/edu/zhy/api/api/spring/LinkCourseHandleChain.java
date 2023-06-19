//package com.edu.zhy.api.api.spring;
//
///**
// * 补充报名信息链处理
// *
// * @author heyixin
// **/
//@org.springframework.stereotype.Component
//@lombok.extern.slf4j.Slf4j
//public class LinkCourseHandleChain implements HandleChain<com.edu.zhy.api.api.dto.LinkCourseHandleContext, Boolean> {
//    private java.util.List<com.edu.zhy.api.api.spring.HandleNodeProxy> nodes = new java.util.ArrayList<>();
//
//    @Override
//    public com.edu.zhy.api.api.dto.HandleChainScene getScene() {
//        return com.edu.zhy.api.api.dto.HandleChainScene.LINK_COURSE;
//    }
//
//    @Override
//    public Boolean process(HandleContext<com.edu.zhy.api.api.dto.LinkCourseHandleContext> context) {
//        if (org.springframework.util.CollectionUtils.isEmpty(nodes)) {
//        }
//        doHandle(nodes, context);
//        return true;
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public HandleChain<com.edu.zhy.api.api.dto.LinkCourseHandleContext, Boolean> registerInOrder(HandleNode<com.edu.zhy.api.api.dto.LinkCourseHandleContext> node, boolean mandatory) {
//        nodes.add(new HandleNodeProxy(node, mandatory));
//        return this;
//    }
//
//    @Override
//    public java.util.List<? extends com.edu.zhy.api.api.spring.HandleNode> getNodes() {
//        return nodes;
//    }
//
//
//    @SuppressWarnings("unchecked")
//    private void doHandle(java.util.List<com.edu.zhy.api.api.spring.HandleNodeProxy> nodes, HandleContext<com.edu.zhy.api.api.dto.LinkCourseHandleContext> ctx) {
//        nodes.forEach(node -> {
//            try {
//                node.handle(ctx);
//            } catch (Exception ex) {
//                if (node.isMandatory()) {
//                    log.error("补充报名信息失败.不可忽略的错误: msg={} node={}", node.getName(), ex.getMessage(), ex);
////                    if (ex instanceof BusinessException) {
////                        throw (BusinessException) ex;
////                    }
////                    throw new BusinessException(ErrorCode.CHAIN_HANDLE_FAILED, ex);
//                }
//                log.warn("补充报名信息失败.忽略 node={}", node.getName(), ex);
//            }
//        });
//    }
//}
