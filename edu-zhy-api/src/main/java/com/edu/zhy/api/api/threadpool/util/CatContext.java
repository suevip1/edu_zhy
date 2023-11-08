//package com.edu.zhy.api.api.threadpool.util;
//
//
//import com.alibaba.fastjson.annotation.JSONField;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * CatContext对象用于存储上下文信息
// * 静态方法用于线程上下文信息的存取
// * Created by yueminmin on 17/8/29.
// */
//public class CatContext implements Cat.Context {
//    private static final Logger logger = LoggerFactory.getLogger(CatContext.class);
//
//    private static final ThreadLocal<CatContext> local = new ThreadLocal<>();
//
//    @JSONField(name = "_catRootMessageId")
//    private String rootId;
//
//    @JSONField(name = "_catParentMessageId")
//    private String parentId;
//
//    @JSONField(name = "_catChildMessageId")
//    private String childId;
//
//    public CatContext() {
//    }
//
//    @Override
//    public void addProperty(String key, String value) {
//
//        if(ROOT.equals(key)) {
//            this.rootId = value;
//        }
//        else if(CHILD.equals(key)) {
//            this.childId = value;
//        }
//        else if(PARENT.equals(key)) {
//            this.parentId = value;
//        }
//    }
//
//    @Override
//    public String getProperty(String key) {
//
//        String value = "";
//        if(ROOT.equals(key)) {
//            value =this.rootId;
//        }
//        else if(CHILD.equals(key)) {
//            value = this.childId;
//        }
//        else if(PARENT.equals(key)) {
//            value= this.parentId;
//        }
//        return value;
//    }
//
//    public String getRootId() {
//        return rootId;
//    }
//
//    public String getParentId() {
//        return parentId;
//    }
//    public String getChildId() {
//        return childId;
//    }
//
//    public void setChildId(String childId) {
//        this.childId = childId;
//    }
//
//    public void setParentId(String parentId) {
//        this.parentId = parentId;
//    }
//
//    public void setRootId(String rootId) {
//        this.rootId = rootId;
//    }
//
//    /**
//     * 业务标签
//     * @param tag
//     */
//    public static void mark(String tag) {
//        CatUtils.addSessionData(RpcConstant.TRACE_TAG_KEY, tag);
//    }
//
//    /**
//     * 可搜索的业务ID
//     * @param customerKey
//     */
//    public static void customerLog(String customerKey) {
//        CatUtils.addSessionData(RpcConstant.CUSTOMER_LOG_KEY, customerKey);
//    }
//
//    /**
//     * 当前MessageTree根部Transaction,有可能为null
//     * @return
//     */
//    private static Transaction rootTransaction() {
//        return (Transaction) Cat.getManager().getThreadLocalMessageTree().getMessage();
//    }
//
//    /**
//     * 给当前线程绑定cat上下文
//     * 设置MDC信息
//     * 修改tag的path信息，对于异步调用不需要新增subPath信息
//     * @param context
//     */
//    public static void bind(Cat.Context context) {
//        if(context != null) {
//            if(!(context instanceof CatContext)) {
//                throw new IllegalArgumentException("context type should by CatContext");
//            } else {
//                CatContext catContext = (CatContext) context;
//                local.set(catContext);
//                MDCUtils.setCatContext(context);
//            }
//        }
//    }
//
//    public static void clean() {
//        local.remove();
//    }
//
//    /**
//     * 获得当前线程绑定的cat上下文,有可能为null
//     * @return
//     */
//    public static CatContext context() {
//        return local.get();
//    }
//
//    /**
//     * 获得当前线程绑定的traceId
//     * @return
//     */
//    public static String traceId() {
//        String traceId = null;
//        if(local.get() != null) {
//            traceId = local.get().rootId;
//        }
//        return traceId;
//    }
//}
