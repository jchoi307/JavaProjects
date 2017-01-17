import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Your implementations of various graph search algorithms.
 *
 * @author Joon Gyu Choi
 * @version 1.0
 */
public class GraphSearch {

    /**
     * Searches the Graph passed in as an adjacency list(adjList) to find if a
     * path exists from the start node to the goal node using General Graph
     * Search.
     *
     * Assume the adjacency list contains adjacent nodes of each node in the
     * order they should be added to the Structure. If there are no adjacent
     * nodes, then an empty list is present.
     *
     * The structure(struct) passed in is an empty structure that may behave as
     * a Stack or Queue and this function should execute DFS or BFS on the
     * graph, respectively.
     *
     * DO NOT use {@code instanceof} to determine the type of the Structure!
     *
     * @param start the object representing the node you are starting at.
     * @param struct the Structure you should use to implement the search.
     * @param adjList the adjacency list that represents the graph we are
     *        searching.
     * @param goal the object representing the node we are trying to reach.
     * @param <T> the data type representing the nodes in the graph.
     * @return true if path exists, false otherwise.
     */
    private static <T> boolean generalGraphSearch(T start, Structure<T> struct,
            Map<T, List<T>> adjList, T goal) {
        if (start == null || !adjList.containsKey(start)
                || goal == null || !adjList.containsKey(goal)) {
            throw new IllegalArgumentException(
                    "input value is Null or Does Not Exist");
        }
        LinkedList<T> list = new LinkedList<T>();
        struct.add(start);
        while (!struct.isEmpty()) {
            T pos = struct.remove();
            list.add(pos);
            if (pos.equals(goal)) {
                return true;
            } else if (adjList.get(pos) == null
                    || adjList.get(pos).size() == 0) {
                return false;
            } else {
                for (int i = 0; i < adjList.get(pos).size(); i++) {
                    if (!list.contains(adjList.get(pos).get(i))) {
                        struct.add(adjList.get(pos).get(i));
                    }
                }
            }
        }
        return false;
    }

    /**
     * Searches the Graph passed in as an adjacency list(adjList) to find if a
     * path exists from the start node to the goal node using Breadth First
     * Search.
     *
     * Assume the adjacency list contains adjacent nodes of each node in the
     * order they should be added to the Structure. If there are no adjacent
     * nodes, then an empty list is present.
     *
     * This method should be written in one line.
     *
     * @throws IllegalArgumentException if any input is null, or if
     * {@code start} or {@code goal} doesn't exist in the graph
     * @param start the object representing the node you are starting at.
     * @param adjList the adjacency list that represents the graph we are
     *        searching.
     * @param goal the object representing the node we are trying to reach.
     * @param <T> the data type representing the nodes in the graph.
     * @return true if path exists false otherwise
     */
    public static <T> boolean breadthFirstSearch(T start,
            Map<T, List<T>> adjList, T goal) {
        return generalGraphSearch(start, new StructureStack<T>(),
                adjList, goal);
    }

    /**
     * Searches the Graph passed in as an adjacency list(adjList) to find if a
     * path exists from the start node to the goal node using Depth First
     * Search.
     *
     * Assume the adjacency list contains adjacent nodes of each node in the
     * order they should be added to the Structure. If there are no adjacent
     * nodes, then an empty list is present.
     *
     * This method should be written in one line.
     *
     * @throws IllegalArgumentException if any input is null, or if
     * {@code start} or {@code goal} doesn't exist in the graph
     * @param start the object representing the node you are starting at.
     * @param adjList the adjacency list that represents the graph we are
     *        searching.
     * @param goal the object representing the node we are trying to reach.
     * @param <T> the data type representing the nodes in the graph.
     * @return true if path exists false otherwise
     */
    public static <T> boolean depthFirstSearch(T start,
            Map<T, List<T>> adjList, T goal) {
        return generalGraphSearch(start, new StructureQueue<T>(),
                adjList, goal);
    }

    /**
     * Find the shortest distance between the start node and the goal node
     * given a weighted graph in the form of an adjacency list where the
     * edges only have positive weights. If there are no adjacent nodes for
     * a node, then an empty list is present.
     *
     * Return the aforementioned shortest distance if there exists a path
     * between the start and goal, -1 otherwise.
     *
     * There are guaranteed to be no negative edge weights in the graph.
     *
     * You may import/use {@code java.util.PriorityQueue}.
     *
     * @throws IllegalArgumentException if any input is null, or if
     * {@code start} or {@code goal} doesn't exist in the graph
     * @param start the object representing the node you are starting at.
     * @param adjList the adjacency list that represents the graph we are
     *        searching.
     * @param goal the object representing the node we are trying to reach.
     * @param <T> the data type representing the nodes in the graph.
     * @return the shortest distance between the start and the goal node
     */
    public static <T> int dijkstraShortestPathAlgorithm(T start,
            Map<T, List<VertexDistancePair<T>>> adjList, T goal) {
        if (start == null || !adjList.containsKey(start)
                || goal == null || !adjList.containsKey(goal)) {
            throw new IllegalArgumentException(
                    "input value is Null or Does Not Exist");
        }
        if (goal.equals(start)) {
            return 0;
        }
        HashSet<T> sources = new HashSet<>();
        PriorityQueue<VertexDistancePair<T>> distances = new PriorityQueue<>();
        distances.add(new VertexDistancePair<T>(start, 0));
        while (!distances.isEmpty()) {
            VertexDistancePair<T> src = distances.poll();
            if (src.getVertex() == goal) {
                return src.getDistance();
            }
            sources.add(src.getVertex());
            for (VertexDistancePair<T> pair : adjList.get(src.getVertex())) {
                if (!sources.contains(pair.getVertex())) {
                    T vertex = pair.getVertex();
                    int distance = pair.getDistance() + src.getDistance();
                    distances.add(new VertexDistancePair<T>(vertex, distance));
                }
            }
        }
        return -1;
    }
}