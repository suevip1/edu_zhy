package com.edu.zhy.api.api.spring;

/**
 * 增强处理节点
 *
 * @author heyixin
 **/
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class HandleNodeProxy<T> implements HandleNode<T> {
    private HandleNode<T> node;
    /**
     * 是否节点必须处理（当异常发生时是否可以忽略该节点的处理）
     */
    private boolean mandatory = false;


    @Override
    public String getName() {
        return node.getName();
    }

    @Override
    public void handle(HandleContext<T> context) {
        node.handle(context);
    }

    @Override
    public java.util.List<String> requiredNodeName() {
        return node.requiredNodeName();
    }
}
