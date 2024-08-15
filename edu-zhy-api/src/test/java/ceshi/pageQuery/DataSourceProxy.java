package ceshi.pageQuery;

/**
 * @author heyixin
 **/
public interface DataSourceProxy<R> {
    boolean mayHasMore();

    R query();
}
