package com.edu.zhy.biz.dubboBean;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.edu.zhy.biz.dubboBean.exceptionHandler.ExceptionHandler;
import com.edu.zhy.biz.dubboBean.exceptionHandler.SimpleLogExceptionHandler;
import com.edu.zhy.biz.dubboBean.retryStrategy.NeverRetryStrategy;
import com.edu.zhy.biz.dubboBean.retryStrategy.RetryStrategy;

import java.beans.ConstructorProperties;

public class FacadeTemplateOptions {
    public static final FacadeTemplateOptions DEFAULT = builder().build();
    private boolean withTransaction;
    private RetryStrategy retryStrategy;
    private ExceptionHandler exceptionHandler;

    private static boolean $default$withTransaction() {
        return false;
    }

    private static RetryStrategy $default$retryStrategy() {
        return new NeverRetryStrategy();
    }

    private static ExceptionHandler $default$exceptionHandler() {
        return new SimpleLogExceptionHandler();
    }

    public static FacadeTemplateOptions.FacadeTemplateOptionsBuilder builder() {
        return new FacadeTemplateOptions.FacadeTemplateOptionsBuilder();
    }

    public boolean isWithTransaction() {
        return this.withTransaction;
    }

    public RetryStrategy getRetryStrategy() {
        return this.retryStrategy;
    }

    public ExceptionHandler getExceptionHandler() {
        return this.exceptionHandler;
    }

    public void setWithTransaction(final boolean withTransaction) {
        this.withTransaction = withTransaction;
    }

    public void setRetryStrategy(final RetryStrategy retryStrategy) {
        this.retryStrategy = retryStrategy;
    }

    public void setExceptionHandler(final ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof FacadeTemplateOptions)) {
            return false;
        } else {
            FacadeTemplateOptions other = (FacadeTemplateOptions)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isWithTransaction() != other.isWithTransaction()) {
                return false;
            } else {
                Object this$retryStrategy = this.getRetryStrategy();
                Object other$retryStrategy = other.getRetryStrategy();
                if (this$retryStrategy == null) {
                    if (other$retryStrategy != null) {
                        return false;
                    }
                } else if (!this$retryStrategy.equals(other$retryStrategy)) {
                    return false;
                }

                Object this$exceptionHandler = this.getExceptionHandler();
                Object other$exceptionHandler = other.getExceptionHandler();
                if (this$exceptionHandler == null) {
                    if (other$exceptionHandler != null) {
                        return false;
                    }
                } else if (!this$exceptionHandler.equals(other$exceptionHandler)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof FacadeTemplateOptions;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + (this.isWithTransaction() ? 79 : 97);
        Object $retryStrategy = this.getRetryStrategy();
        result = result * 59 + ($retryStrategy == null ? 43 : $retryStrategy.hashCode());
        Object $exceptionHandler = this.getExceptionHandler();
        result = result * 59 + ($exceptionHandler == null ? 43 : $exceptionHandler.hashCode());
        return result;
    }

    public String toString() {
        return "FacadeTemplateOptions(withTransaction=" + this.isWithTransaction() + ", retryStrategy=" + this.getRetryStrategy() + ", exceptionHandler=" + this.getExceptionHandler() + ")";
    }

    public FacadeTemplateOptions() {
    }

    @ConstructorProperties({"withTransaction", "retryStrategy", "exceptionHandler"})
    protected FacadeTemplateOptions(final boolean withTransaction, final RetryStrategy retryStrategy, final ExceptionHandler exceptionHandler) {
        this.withTransaction = withTransaction;
        this.retryStrategy = retryStrategy;
        this.exceptionHandler = exceptionHandler;
    }

    public static class FacadeTemplateOptionsBuilder {
        private boolean withTransaction$set;
        private boolean withTransaction;
        private boolean retryStrategy$set;
        private RetryStrategy retryStrategy;
        private boolean exceptionHandler$set;
        private ExceptionHandler exceptionHandler;

        FacadeTemplateOptionsBuilder() {
        }

        public FacadeTemplateOptions.FacadeTemplateOptionsBuilder withTransaction(final boolean withTransaction) {
            this.withTransaction = withTransaction;
            this.withTransaction$set = true;
            return this;
        }

        public FacadeTemplateOptions.FacadeTemplateOptionsBuilder retryStrategy(final RetryStrategy retryStrategy) {
            this.retryStrategy = retryStrategy;
            this.retryStrategy$set = true;
            return this;
        }

        public FacadeTemplateOptions.FacadeTemplateOptionsBuilder exceptionHandler(final ExceptionHandler exceptionHandler) {
            this.exceptionHandler = exceptionHandler;
            this.exceptionHandler$set = true;
            return this;
        }

        public FacadeTemplateOptions build() {
            return new FacadeTemplateOptions(this.withTransaction$set ? this.withTransaction : FacadeTemplateOptions.$default$withTransaction(), this.retryStrategy$set ? this.retryStrategy : FacadeTemplateOptions.$default$retryStrategy(), this.exceptionHandler$set ? this.exceptionHandler : FacadeTemplateOptions.$default$exceptionHandler());
        }

        public String toString() {
            return "FacadeTemplateOptions.FacadeTemplateOptionsBuilder(withTransaction=" + this.withTransaction + ", retryStrategy=" + this.retryStrategy + ", exceptionHandler=" + this.exceptionHandler + ")";
        }
    }
}
