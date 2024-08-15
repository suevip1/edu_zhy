//package ceshi.pageQuery;
//
//import com.edu.zhy.biz.dubboBean.businessException.BusinessException;
//import com.youzan.ebiz.common.model.Sort;
//import com.youzan.owl.crm.biz.common.constant.ErrorCode;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//
//import java.util.function.Function;
//
///**
// * 滚动分页查询，适用于统计（query and save 场景勿用）
// * @author heyixin
// **/
//public class PageBasedTraversalDataSource<T> implements PageDataSource<T> {
//    private int pageNo = 0, pageSize = 200;
//    private Function<PageRequest, Page<T>> resultsSupplier;
//
//    private int currentSize = 0;
//    private Long total = 0L;
//
//    public PageBasedTraversalDataSource(Function<PageRequest, Page<T>> results, Integer pageSize) {
//        this.resultsSupplier = results;
//        this.setPageSize(pageSize);
//    }
//
//    private void setPageSize(Integer size) {
//        if (size < 0 || size >= 4000) {
//            throw new BusinessException(-100, "分页值不合法");
//        }
//        this.pageSize = size;
//    }
//
//    @Override
//    public boolean mayHasMore() {
//        //pageNo=0 保证第一次查询一定会命中 mayHasMore
//        return pageNo == 0 || currentSize == pageSize
//                || pageNo * pageSize < total;
//    }
//
//    @Override
//    public Page<T> query() {
//        newRound();
//        PageRequest pageRequest = new PageRequest(pageNo, pageSize);
//        pageRequest.setSort(new Sort(new Sort.Order(Sort.Direction.ASC, "id")));
//        Page<T> page = resultsSupplier.apply(pageRequest);
//        currentSize = page.getNumberOfElements();
//        total = page.getTotal();
//        return page;
//    }
//
//    @Override
//    public Integer getCurrentPage() {
//        return pageNo;
//    }
//
//    @Override
//    public Long estimateSize() {
//        Page<T> apply = resultsSupplier.apply(new PageRequest(1, 1));
//        return apply.getTotal();
//    }
//
//    private void newRound() {
//        this.pageNo++;
//    }
//}
