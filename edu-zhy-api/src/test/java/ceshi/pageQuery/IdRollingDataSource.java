package ceshi.pageQuery;

import java.util.function.Function;

/**
 * 通过 上次返回的 id进行滚动查询
 * @author heyixin
 **/
public class IdRollingDataSource<T, ID> implements DataSourceProxy<T> {
    private boolean firstQuery = true;
    private Function<ID, T> resultsSupplier;
    private Function<T, ID> idExtractor;
    private Function<T, Boolean> stopSign;
    private ID startId;
    private T latestResult;

    public IdRollingDataSource(Function<ID, T> results,
                               Function<T, ID> idExtractor,
                               Function<T, Boolean> stopSign,
                               ID startId) {
        this.resultsSupplier = results;
        this.startId = startId;
        this.stopSign = stopSign;
        this.idExtractor = idExtractor;
    }

    @Override
    public boolean mayHasMore() {
        return firstQuery || !stopSign.apply(latestResult);
    }

    @Override
    public T query() {
        newRound();
        latestResult = resultsSupplier.apply(startId);
        firstQuery = false;
        return latestResult;
    }

    private void newRound() {
        this.startId = firstQuery ? startId : idExtractor.apply(latestResult);
    }
}

