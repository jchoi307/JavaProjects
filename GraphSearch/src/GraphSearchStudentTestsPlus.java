import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Student tests for your GraphSearch class.
 *
 * @author CS 1332 TAs //Modifications added by W. K.
 * @version 1.0
 */
public class GraphSearchStudentTestsPlus {
    private static final int TIMEOUT = 200;
    private Map<String, List<String>> adjList;
    private Map<String, List<VertexDistancePair<String>>> weightedGraph;

    @Before
    public void setUp() {
        // Creates a directed, unweighted graph.
        adjList = new HashMap<>();

        List<String> aList = new LinkedList<>();
        aList.add("B");
        aList.add("C");
        aList.add("D");
        adjList.put("A", aList);

        List<String> bList = new LinkedList<>();
        bList.add("H");
        adjList.put("B", bList);

        List<String> cList = new LinkedList<>();
        cList.add("E");
        cList.add("G");
        cList.add("H");
        adjList.put("C", cList);

        List<String> dList = new LinkedList<>();
        dList.add("G");
        adjList.put("D", dList);

        List<String> eList = new LinkedList<>();
        eList.add("F");
        eList.add("H");
        adjList.put("E", eList);

        List<String> fList = new LinkedList<>();
        fList.add("G");
        adjList.put("F", fList);

        List<String> gList = new LinkedList<>();
        adjList.put("G", gList);

        List<String> hList = new LinkedList<>();
        hList.add("F");
        adjList.put("H", hList);

        //Creates an undirected, weighted graph.
        weightedGraph = new HashMap<>();

        List<VertexDistancePair<String>> aListWeighted = new LinkedList<>();
        aListWeighted.add(new VertexDistancePair<String>("B", 8));
        aListWeighted.add(new VertexDistancePair<String>("C", 3));
        weightedGraph.put("A", aListWeighted);

        List<VertexDistancePair<String>> bListWeighted = new LinkedList<>();
        bListWeighted.add(new VertexDistancePair<String>("A", 8));
        bListWeighted.add(new VertexDistancePair<String>("C", 4));
        bListWeighted.add(new VertexDistancePair<String>("D", 11));
        weightedGraph.put("B", bListWeighted);

        List<VertexDistancePair<String>> cListWeighted = new LinkedList<>();
        cListWeighted.add(new VertexDistancePair<String>("A", 3));
        cListWeighted.add(new VertexDistancePair<String>("B", 4));
        cListWeighted.add(new VertexDistancePair<String>("D", 6));
        cListWeighted.add(new VertexDistancePair<String>("E", 7));
        weightedGraph.put("C", cListWeighted);

        List<VertexDistancePair<String>> dListWeighted = new LinkedList<>();
        dListWeighted.add(new VertexDistancePair<String>("B", 11));
        dListWeighted.add(new VertexDistancePair<String>("C", 6));
        dListWeighted.add(new VertexDistancePair<String>("E", 7));
        weightedGraph.put("D", dListWeighted);

        List<VertexDistancePair<String>> eListWeighted = new LinkedList<>();
        eListWeighted.add(new VertexDistancePair<String>("C", 7));
        eListWeighted.add(new VertexDistancePair<String>("D", 7));
        weightedGraph.put("E", eListWeighted);

        List<VertexDistancePair<String>> fListWeighted = new LinkedList<>();
        weightedGraph.put("F", eListWeighted);
    }

    @Test(timeout = TIMEOUT)
    public void testDepthFirstSearch() {
        assertTrue(GraphSearch.depthFirstSearch("A", adjList, "G"));
        assertTrue(GraphSearch.depthFirstSearch("A", adjList, "B"));
        assertTrue(GraphSearch.depthFirstSearch("A", adjList, "H"));
        assertTrue(GraphSearch.depthFirstSearch("A", adjList, "A"));
        assertFalse(GraphSearch.depthFirstSearch("G", adjList, "A"));
        assertFalse(GraphSearch.depthFirstSearch("H", adjList, "C"));
    }

    @Test(timeout = TIMEOUT)
    public void testBreadthFirstSearch() {
        assertTrue(GraphSearch.depthFirstSearch("A", adjList, "G"));
        assertTrue(GraphSearch.depthFirstSearch("A", adjList, "B"));
        assertTrue(GraphSearch.depthFirstSearch("A", adjList, "H"));
        assertTrue(GraphSearch.depthFirstSearch("A", adjList, "A"));
        assertFalse(GraphSearch.depthFirstSearch("G", adjList, "A"));
        assertFalse(GraphSearch.depthFirstSearch("H", adjList, "C"));
    }

    @Test(timeout = TIMEOUT)
    public void testDijkstras() {
        assertEquals(7, GraphSearch.dijkstraShortestPathAlgorithm("A",
                weightedGraph, "B"));
        assertEquals(10, GraphSearch.dijkstraShortestPathAlgorithm("B",
                weightedGraph, "D"), 10);
        assertEquals(10, GraphSearch.dijkstraShortestPathAlgorithm("A",
                weightedGraph, "E"), 10);
        assertEquals(-1, GraphSearch.dijkstraShortestPathAlgorithm("A",
                weightedGraph, "F"));
        assertEquals(0, GraphSearch.dijkstraShortestPathAlgorithm("F",
                weightedGraph, "F"));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testVertexNotInGraph() {
        GraphSearch.breadthFirstSearch("J", adjList, "G");
    }

    @Test(timeout = TIMEOUT)
    public void test() {
        Map<String, List<VertexDistancePair<String>>> map = new HashMap<>();
        List<VertexDistancePair<String>> listForA = new ArrayList<>();
        listForA.add(new VertexDistancePair<>("B", 8));
        listForA.add(new VertexDistancePair<>("C", 3));
        map.put("A", listForA);

        List<VertexDistancePair<String>> listForB = new ArrayList<>();
        listForB.add(new VertexDistancePair<>("A", 8));
        listForB.add(new VertexDistancePair<>("C", 4));
        listForB.add(new VertexDistancePair<>("D", 11));
        map.put("B", listForB);

        List<VertexDistancePair<String>> listForC = new ArrayList<>();
        listForC.add(new VertexDistancePair<>("A", 3));
        listForC.add(new VertexDistancePair<>("B", 4));
        listForC.add(new VertexDistancePair<>("D", 6));
        listForC.add(new VertexDistancePair<>("E", 7));
        map.put("C", listForC);

        List<VertexDistancePair<String>> listForD = new ArrayList<>();
        listForD.add(new VertexDistancePair<>("B", 11));
        listForD.add(new VertexDistancePair<>("C", 6));
        listForD.add(new VertexDistancePair<>("E", 7));
        map.put("D", listForD);

        List<VertexDistancePair<String>> listForE = new ArrayList<>();
        listForE.add(new VertexDistancePair<>("C", 7));
        listForE.add(new VertexDistancePair<>("D", 7));
        map.put("E", listForE);

        GraphSearch graphSearch = new GraphSearch();
        System.out.printf("The distance From %s to %s is %d.\n", "A", "A"
                , graphSearch.dijkstraShortestPathAlgorithm("A", map, "A"));
        System.out.printf("The distance From %s to %s is %d.\n", "A", "B"
                , graphSearch.dijkstraShortestPathAlgorithm("A", map, "B"));
        System.out.printf("The distance From %s to %s is %d.\n", "A", "C"
                , graphSearch.dijkstraShortestPathAlgorithm("A", map, "C"));
        System.out.printf("The distance From %s to %s is %d.\n", "A", "D"
                , graphSearch.dijkstraShortestPathAlgorithm("A", map, "D"));
        System.out.printf("The distance From %s to %s is %d.\n", "A", "E"
                , graphSearch.dijkstraShortestPathAlgorithm("A", map, "E"));
    }
}