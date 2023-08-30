package com.edu.zhy.biz.dubboBean;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.edu.zhy.biz.dubboBean.exceptionHandler.DirectThrowExceptionHandler;
import com.edu.zhy.biz.dubboBean.exceptionHandler.ExceptionHandler;
import com.edu.zhy.biz.dubboBean.retryStrategy.DirectReturnResultMapper;
import com.edu.zhy.biz.dubboBean.retryStrategy.NeverRetryStrategy;
import com.edu.zhy.biz.dubboBean.retryStrategy.NullExceptionResultMapper;
import com.edu.zhy.biz.dubboBean.retryStrategy.RetryStrategy;

import java.beans.ConstructorProperties;
import java.util.function.Function;

public class ClientTemplateOptions {
    public static final ClientTemplateOptions DEFAULT = builder().build();
    private Function<Object, Object> resultMapper;
    private RetryStrategy retryStrategy;
    private ExceptionHandler exceptionHandler;
    private Function<Throwable, Object> exceptionResultMapper;

    private static Function<Object, Object> $default$resultMapper() {
        return new DirectReturnResultMapper();
    }

    private static RetryStrategy $default$retryStrategy() {
        return new NeverRetryStrategy();
    }

    private static ExceptionHandler $default$exceptionHandler() {
        return new DirectThrowExceptionHandler();
    }

    private static Function<Throwable, Object> $default$exceptionResultMapper() {
        return new NullExceptionResultMapper();
    }

    public static ClientTemplateOptions.ClientTemplateOptionsBuilder builder() {
        return new ClientTemplateOptions.ClientTemplateOptionsBuilder();
    }

    public Function<Object, Object> getResultMapper() {
        return this.resultMapper;
    }

    public RetryStrategy getRetryStrategy() {
        return this.retryStrategy;
    }

    public ExceptionHandler getExceptionHandler() {
        return this.exceptionHandler;
    }

    public Function<Throwable, Object> getExceptionResultMapper() {
        return this.exceptionResultMapper;
    }

    public void setResultMapper(final Function<Object, Object> resultMapper) {
        this.resultMapper = resultMapper;
    }

    public void setRetryStrategy(final RetryStrategy retryStrategy) {
        this.retryStrategy = retryStrategy;
    }

    public void setExceptionHandler(final ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public void setExceptionResultMapper(final Function<Throwable, Object> exceptionResultMapper) {
        this.exceptionResultMapper = exceptionResultMapper;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ClientTemplateOptions)) {
            return false;
        } else {
            ClientTemplateOptions other = (ClientTemplateOptions)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$resultMapper = this.getResultMapper();
                    Object other$resultMapper = other.getResultMapper();
                    if (this$resultMapper == null) {
                        if (other$resultMapper == null) {
                            break label59;
                        }
                    } else if (this$resultMapper.equals(other$resultMapper)) {
                        break label59;
                    }

                    return false;
                }

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

                Object this$exceptionResultMapper = this.getExceptionResultMapper();
                Object other$exceptionResultMapper = other.getExceptionResultMapper();
                if (this$exceptionResultMapper == null) {
                    if (other$exceptionResultMapper != null) {
                        return false;
                    }
                } else if (!this$exceptionResultMapper.equals(other$exceptionResultMapper)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ClientTemplateOptions;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $resultMapper = this.getResultMapper();
         result = result * 59 + ($resultMapper == null ? 43 : $resultMapper.hashCode());
        Object $retryStrategy = this.getRetryStrategy();
        result = result * 59 + ($retryStrategy == null ? 43 : $retryStrategy.hashCode());
        Object $exceptionHandler = this.getExceptionHandler();
        result = result * 59 + ($exceptionHandler == null ? 43 : $exceptionHandler.hashCode());
        Object $exceptionResultMapper = this.getExceptionResultMapper();
        result = result * 59 + ($exceptionResultMapper == null ? 43 : $exceptionResultMapper.hashCode());
        return result;
    }

    public String toString() {
        return "ClientTemplateOptions(resultMapper=" + this.getResultMapper() + ", retryStrategy=" + this.getRetryStrategy() + ", exceptionHandler=" + this.getExceptionHandler() + ", exceptionResultMapper=" + this.getExceptionResultMapper() + ")";
    }

    public ClientTemplateOptions() {
    }

    @ConstructorProperties({"resultMapper", "retryStrategy", "exceptionHandler", "exceptionResultMapper"})
    protected ClientTemplateOptions(final Function<Object, Object> resultMapper, final RetryStrategy retryStrategy, final ExceptionHandler exceptionHandler, final Function<Throwable, Object> exceptionResultMapper) {
        this.resultMapper = resultMapper;
        this.retryStrategy = retryStrategy;
        this.exceptionHandler = exceptionHandler;
        this.exceptionResultMapper = exceptionResultMapper;
    }

    public static class ClientTemplateOptionsBuilder {
        private boolean resultMapper$set;
        private Function<Object, Object> resultMapper;
        private boolean retryStrategy$set;
        private RetryStrategy retryStrategy;
        private boolean exceptionHandler$set;
        private ExceptionHandler exceptionHandler;
        private boolean exceptionResultMapper$set;
        private Function<Throwable, Object> exceptionResultMapper;

        ClientTemplateOptionsBuilder() {
        }

        public ClientTemplateOptions.ClientTemplateOptionsBuilder resultMapper(final Function<Object, Object> resultMapper) {
            this.resultMapper = resultMapper;
            this.resultMapper$set = true;
            return this;
        }

        public ClientTemplateOptions.ClientTemplateOptionsBuilder retryStrategy(final RetryStrategy retryStrategy) {
            this.retryStrategy = retryStrategy;
            this.retryStrategy$set = true;
            return this;
        }

        public ClientTemplateOptions.ClientTemplateOptionsBuilder exceptionHandler(final ExceptionHandler exceptionHandler) {
            this.exceptionHandler = exceptionHandler;
            this.exceptionHandler$set = true;
            return this;
        }

        public ClientTemplateOptions.ClientTemplateOptionsBuilder exceptionResultMapper(final Function<Throwable, Object> exceptionResultMapper) {
            this.exceptionResultMapper = exceptionResultMapper;
            this.exceptionResultMapper$set = true;
            return this;
        }

        public ClientTemplateOptions build() {
            return new ClientTemplateOptions(this.resultMapper$set ? this.resultMapper : ClientTemplateOptions.$default$resultMapper(), this.retryStrategy$set ? this.retryStrategy : ClientTemplateOptions.$default$retryStrategy(), this.exceptionHandler$set ? this.exceptionHandler : ClientTemplateOptions.$default$exceptionHandler(), this.exceptionResultMapper$set ? this.exceptionResultMapper : ClientTemplateOptions.$default$exceptionResultMapper());
        }

        public String toString() {
            return "ClientTemplateOptions.ClientTemplateOptionsBuilder(resultMapper=" + this.resultMapper + ", retryStrategy=" + this.retryStrategy + ", exceptionHandler=" + this.exceptionHandler + ", exceptionResultMapper=" + this.exceptionResultMapper + ")";
        }
    }
}
