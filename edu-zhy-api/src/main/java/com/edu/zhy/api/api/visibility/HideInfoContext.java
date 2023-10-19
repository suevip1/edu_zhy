package com.edu.zhy.api.api.visibility;
import lombok.Data;


/**
 * @Auther: zishan
 * @Date: 2020-02-19
 */
@Data
public class HideInfoContext {

    private static final ThreadLocal<HideInfoContext> HIDE_INFO_CONTEXT_THREAD_LOCAL = ThreadLocal.withInitial(HideInfoContext::new);

    private FieldReferenceCache fieldReferenceCache;

    private SwitchCache switchCache;


    public HideInfoContext(){
        this.fieldReferenceCache = ApplicationContextHolder.getContext().getBean(FieldReferenceCache.class);
        this.switchCache = ApplicationContextHolder.getContext().getBean(SwitchCache.class);
    }


    public static HideInfoContext getContext() {
        return HIDE_INFO_CONTEXT_THREAD_LOCAL.get();
    }

    public static void clean() {
        HIDE_INFO_CONTEXT_THREAD_LOCAL.remove();
    }

}
