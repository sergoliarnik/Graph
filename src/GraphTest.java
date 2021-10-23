import Graph.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

public class GraphTest {

    @Test
    public void getSize() {
        //Test input
        Human user1 = new Human("Igor", 15);
        Human user2 = new Human("Igor", 17);
        Human user3 = new Human("Igor", 15);
        Human user4 = new Human("Sergiy", 19);
        Human user5 = new Human("Andrii", 15);
        //Expected
        int expectedSize = 4;
        //Actual
        Graph<Human> graph = new Graph<Human>();
        graph.addVertex(user1);
        graph.addVertex(user2);
        graph.addVertex(user3);
        graph.addVertex(user4);
        graph.addVertex(user5);
        int actualSize = graph.getSize();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getVertexByName() {
        //Test input
        Human user1 = new Human("Igor", 15);
        Human user2 = new Human("Igor", 17);
        Human user3 = new Human("Igor", 15);
        Human user4 = new Human("Sergiy", 19);
        Human user5 = new Human("Andrii", 15);
        //Expected
        Human expectedHuman = user1;
        //Actual
        Graph<Human> graph = new Graph<Human>();
        graph.addVertex(user1);
        graph.addVertex(user2);
        graph.addVertex(user3);
        graph.addVertex(user4);
        graph.addVertex(user5);
        Human actualHuman = graph.getVertex("Graph.Human{name='Igor', year=15}");

        Assert.assertEquals(expectedHuman, actualHuman);
    }

    @Test
    public void getVertexById() {
        //Test input
        Human user1 = new Human("Igor", 15);
        Human user2 = new Human("Igor", 17);
        Human user3 = new Human("Igor", 15);
        Human user4 = new Human("Sergiy", 19);
        Human user5 = new Human("Andrii", 15);
        //Expected
        Human expectedHuman = user2;
        //Actual
        Graph<Human> graph = new Graph<Human>();
        graph.addVertex(user1);
        graph.addVertex(user2);
        graph.addVertex(user3);
        graph.addVertex(user4);
        graph.addVertex(user5);
        Human actualHuman = graph.getVertex(graph.getId(user2));

        Assert.assertEquals(expectedHuman, actualHuman);
    }

    @Test
    public void getShortestWay() throws Exception {
        //Test input
        Human user1 = new Human("Igor", 15);
        Human user2 = new Human("Igor", 17);
        Human user3 = new Human("Igor", 15);
        Human user4 = new Human("Sergiy", 19);
        Human user5 = new Human("Andrii", 15);
        //Expected
        Set<Human> expectedWay = new LinkedHashSet();
        expectedWay.add(user1);
        expectedWay.add(user2);
        expectedWay.add(user5);
        //Actual
        Graph<Human> graph = new Graph<Human>();
        graph.addEdge(new Edge<>(user1 ,user2));
        graph.addEdge(new Edge<>(user2 ,user5));
        graph.addEdge(new Edge<>(user1 ,user3));
        graph.addEdge(new Edge<>(user3 ,user4));
        graph.addEdge(new Edge<>(user4 ,user5));

        Set<Human> actualWay = graph.getShortestWay(user1,user5);

        Assert.assertEquals(expectedWay, actualWay);
    }
}