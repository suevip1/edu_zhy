package com.example.eduzhyconfig.functionUtil;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Admin.
 * Time 2023/12/7 16:22
 * Desc 文件描述
 */
public class SupplierUtil {

    //这里需要想下常用的几种使用如何把常用的抽出来


    /**
     * *传入方法获取结果 Supplier 有返回值
     * @param supplier
     * @param <R>
     * @return
     */
    private static <R>  Supplier<R> executeSupplierGetR(Supplier<R> supplier){
        return Optional.ofNullable((Supplier<R>) supplier.get()).orElse(null);
    }


    /**
     * *返回正常结果
     * @param supplier
     * @param <R>
     * @return
     */
    private static <R>  R executeSupplierGet(Supplier<R> supplier){
        return Optional.ofNullable(supplier.get()).orElse(null);
    }


    /**
     * *带返回值
     * @param t
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    private static<T,R>  R  executeFunction(T t,Function<T,R> function){
        return Optional.ofNullable(function.apply(t)).orElse(null);
    }



    public static void main(String[] args) {

        Supplier<ArrayList> arrayListSupplier = executeSupplierGetR(() -> {

            return new ArrayList();
        });



    }



}
