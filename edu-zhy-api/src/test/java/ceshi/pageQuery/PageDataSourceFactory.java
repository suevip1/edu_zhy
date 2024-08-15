//package ceshi.pageQuery;
//
//import com.youzan.ebiz.common.model.Page;
//import com.youzan.ebiz.common.model.PageRequest;
//
//import java.util.function.Function;
//
///**
// * @author heyixin
// **/
//public class PageDataSourceFactory {
//
//    public static <T> PageDataSource<T> pageBasedTraversalDataSource(Function<PageRequest, Page<T>> supplier) {
//        return new PageBasedTraversalDataSource<>(supplier, 200);
//    }
//
//    public static <T> PageDataSource<T> pageBasedTraversalDataSource(Function<PageRequest, Page<T>> supplier, Integer pageSize) {
//        return new PageBasedTraversalDataSource<>(supplier, pageSize);
//    }
//
//    /**
//     * 使用 id 作为多次分页依据的查询
//     * @param supplier    查询细节
//     * @param idExtractor 从结果抽取下一次分页查询的起始 id
//     * @param stopSign    什么时候表示查询中止
//     * @param startId     查询起始 id
//     * @param <T>         返回值
//     * @param <ID>        参与分页的 id
//     * @return
//     */
//    public static <T, ID> DataSourceProxy<T> idBasedTraversalDataSource(Function<ID, T> supplier,
//                                                                        Function<T, ID> idExtractor,
//                                                                        Function<T, Boolean> stopSign,
//                                                                        ID startId) {
//        return new IdRollingDataSource<>(supplier, idExtractor, stopSign, startId);
//    }
//
//
//}
