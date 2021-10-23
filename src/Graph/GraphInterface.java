package Graph;

import java.util.Set;

public interface GraphInterface<T> {
    public Set<T> getChildVertex(T a);
    public T getVertex(String name);
    public T getVertex(int id);
    public Set<T> getShortestWay(T start, T finish) throws Exception;
}
