package rule;

import java.util.List;

/**
 * Created by khanh on 07/04/2018.
 */

public class QueryData<E> {

    private List<E> list;
    private QueryType type;

    public QueryData(QueryType type) {
        this.type = type;
    }

    public QueryData(List<E> list, QueryType type) {
        this.list = list;
        this.type = type;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public QueryType getType() {
        return type;
    }

    public void setType(QueryType type) {
        this.type = type;
    }

}
