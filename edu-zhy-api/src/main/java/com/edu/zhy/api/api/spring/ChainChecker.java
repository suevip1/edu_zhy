package com.edu.zhy.api.api.spring;
@lombok.extern.slf4j.Slf4j
public class ChainChecker {
    public static void check(HandleChain chain) {
        java.util.List<? extends HandleNode> nodes = chain.getNodes();
        java.util.Set<String> currentCollect = new java.util.HashSet<>();
        nodes.forEach(node -> {
            currentCollect.add(node.getName());
            if (!currentCollect.containsAll(node.requiredNodeName())) {
                log.error("交易链路初始化检查失败 chainScene={},nodeName={}", chain.getScene(), node.getName());
                try {
                    throw new Exception("失败了");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
