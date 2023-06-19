//package com.edu.zhy.api.api.spring;
//
//@org.springframework.stereotype.Service
//public class OfflineRenewOrderHandleChain implements HandleChain<com.edu.zhy.api.api.dto.OfflineOrderHandleContext, com.edu.zhy.api.api.dto.GatherResponseDTO>{
//
//    private java.util.List<HandleNodeProxy> nodes = new java.util.ArrayList<>();
//
//    @Override
//    public com.edu.zhy.api.api.dto.HandleChainScene getScene() {
//        return null;
//    }
//
//    @Override
//    public com.edu.zhy.api.api.dto.GatherResponseDTO process(com.edu.zhy.api.api.spring.HandleContext<com.edu.zhy.api.api.dto.OfflineOrderHandleContext> context) {
//        return null;
//    }
//
//    @Override
//    public com.edu.zhy.api.api.spring.HandleChain<com.edu.zhy.api.api.dto.OfflineOrderHandleContext,
//            com.edu.zhy.api.api.dto.GatherResponseDTO> registerInOrder(com.edu.zhy.api.api.spring.HandleNode<com.edu.zhy.api.api.dto.OfflineOrderHandleContext> node, boolean mandatory) {
//       nodes.add(new com.edu.zhy.api.api.spring.HandleNodeProxy(node,mandatory));
//        System.err.println("OfflineRenewOrderHandleChain.registerInOrder"+this);
//        return this;
//    }
//
//    @Override
//    public java.util.List<? extends com.edu.zhy.api.api.spring.HandleNode> getNodes() {
//        return nodes;
//    }
//}
