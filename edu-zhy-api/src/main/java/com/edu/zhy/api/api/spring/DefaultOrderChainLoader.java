//package com.edu.zhy.api.api.spring;
//
//public class DefaultOrderChainLoader implements HandleChainLoader{
//    @Override
//    public java.util.List<com.edu.zhy.api.api.spring.HandleChain> load() {
//        java.util.List<HandleChain> list = new java.util.ArrayList<>();
//        //offlineChain
//        OfflineOrderHandleChain offlineChain = new OfflineOrderHandleChain();
////        offlineChain.registerInOrder(shopRoleCheckNode, true)
////                .registerInOrder(studentSaveHandleNode, true)
////                .registerInOrder(courseInfoQueryNode, true)
////                .registerInOrder(giveawayCheckNode, true)
////                .registerInOrder(coursePriceCheckNode, true)
////                .registerInOrder(studentInClassCheckNode, true)
////                .registerInOrder(saleContractCreateNode, true)
////                .registerInOrder(offlineOrderCreateHandleNode, true)
////                .registerInOrder(contractFillOrderNode, true)
////                .registerInOrder(offlinePrepayOrderCreateNode, true);
//        ChainChecker.check(offlineChain);
//        list.add(offlineChain);
//
//        //线下报名续费订单
//        OfflineRenewOrderHandleChain offlineOrderHandleChain = new OfflineRenewOrderHandleChain();
////        offlineOrderHandleChain.registerInOrder(shopRoleCheckNode, true)
////                .registerInOrder(studentSaveHandleNode, true)
////                .registerInOrder(courseInfoQueryNode, true)
////                .registerInOrder(giveawayCheckNode, true)
////                .registerInOrder(coursePriceCheckNode, true)
////                .registerInOrder(studentInClassCheckNode, true)
////                .registerInOrder(cashierFillOrderNodeForRenew, true)
////                .registerInOrder(saleContractCreateNodeForRenew, true)
////                .registerInOrder(offlineOrderCreateHandleNodeForRenew, true)
////                .registerInOrder(contractFillOrderNodeForRenew, true)
////                .registerInOrder(offlinePrepayOrderCreateNodeForRenew, true);
//        ChainChecker.check(offlineOrderHandleChain);
//        list.add(offlineOrderHandleChain);
//
//        return list;
//    }
//
//}
