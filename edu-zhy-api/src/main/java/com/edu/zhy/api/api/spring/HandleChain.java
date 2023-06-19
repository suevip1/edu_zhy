package com.edu.zhy.api.api.spring;

public interface HandleChain <I , R>{

    com.edu.zhy.api.api.dto.HandleChainScene getScene();

    R process(HandleContext<I> context);

    HandleChain<I, R> registerInOrder(HandleNode<I> node, boolean mandatory);

    java.util.List<? extends HandleNode> getNodes();

}
