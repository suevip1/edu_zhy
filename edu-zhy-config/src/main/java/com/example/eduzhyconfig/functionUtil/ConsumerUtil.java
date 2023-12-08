package com.example.eduzhyconfig.functionUtil;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by Admin.
 * Time 2023/12/7 16:07
 * Desc 文件描述
 */
public class ConsumerUtil {


    //这里需要想下常用的几种使用如何把常用的抽出来

    /**
     * *执行参数和方法 无返回值
     * @param t 执行参数
     * @param consumer 执行方法
     * @param <T>
     */
    public static <T> void executeConsumer(T t,Consumer<T> consumer){

        consumer.accept(t);

    }


    /**
     * *执行函数式接口
     * @param t
     * @param u
     * @param biConsumer
     * @param <T>
     * @param <U>
     */
    public static <T,U> void  executeBiConsumer(T t, U u, BiConsumer<T, U> biConsumer){
        biConsumer.accept(t, u);
    }




}
