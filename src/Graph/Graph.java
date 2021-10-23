package Graph;

import java.util.*;

public class Graph<T> implements GraphInterface<T> {
    private int size = 0;
    private Map<T, Integer> listOfVertex;
    private List<Edge<T>> listOfEdge;
    private static int globalId = 0;

    public Graph() {
        listOfVertex = new HashMap<>();
        listOfEdge = new ArrayList<>();
    }

    public Graph(List<Edge<T>> listOfEdge) {
        this();
        for (var i : listOfEdge) {
            addEdge(i);
        }
    }

    public void addVertex(T a) {

        listOfVertex.put(a, globalId++);
        size = listOfVertex.size();
    }

    public void addEdge(Edge<T> a) {

        if (getVertex(a.getFirst().toString()) == null) {
            listOfVertex.put(a.getFirst(), globalId++);
            size = listOfVertex.size();
        }
        if (getVertex(a.getSecond().toString()) == null) {
            listOfVertex.put(a.getSecond(), globalId++);
            size = listOfVertex.size();
        }
        listOfEdge.add(a);
    }

    public int getSize() {
        return size;
    }

    public Set<T> getChildVertex(T a) {
        Set<T> res = new HashSet<>();
        for (var i : listOfEdge) {
            if (i.getFirst().equals(a)) {
                res.add(i.getSecond());
            } else if (i.getSecond().equals(a)) {
                res.add(i.getFirst());
            }
        }
        return res;
    }

    public T getVertex(String name) {
        for (var i : listOfVertex.keySet()) {
            if (i.toString().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public T getVertex(int id) {
        for (var i : listOfVertex.entrySet()) {
            if (i.getValue() == id) {
                return i.getKey();
            }
        }
        return null;
    }

    public List<Set<T>> getAllWays(T start, T finish) throws Exception {
        if(!listOfVertex.containsKey(start) || !listOfVertex.containsKey(finish))throw new Exception("Vertex isn't declare");
        List<Set<T>> allWays = new ArrayList<>();
        findAllWays(start, finish, new HashSet<>(), allWays);
        return allWays;
    }

    public Set<T> getShortestWay(T start, T finish) throws Exception {
        List<Set<T>> allWays = getAllWays(start, finish);
        int mnDist = 10000;
        Set<T> res = new LinkedHashSet<>();
        for (var i : allWays) {
            if (i.size() < mnDist) {
                mnDist = i.size();
                res = i;
            }
        }
        return res;
    }

    private void findAllWays(T start, T finish, Set<T> isVisited, List<Set<T>> allWays) {
        isVisited.add(start);
        if (start.equals(finish)) {
            allWays.add(isVisited);
            return;
        }
        var childVertex = getChildVertex(start);
        for (var i : childVertex) {
            if (isVisited.contains(i)) continue;
            Set<T> currentList = new LinkedHashSet<>(List.copyOf(isVisited));
            currentList.add(i);
            findAllWays(i, finish, currentList, allWays);
        }

    }

    public int getId(T n){
        return listOfVertex.get(n);
    }
}
