import java.util.ArrayList;
import java.util.List;


public class Graph {
    static int v;
    static ArrayList<Integer>[] edges;

    Graph(int v) {
        Graph.v = v;
        edges = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        edges[u].add(v);
        edges[v].add(u);
    }

    static void removeEdge(int u, int v) {
        edges[u].remove(v);
        edges[v].remove(u);
    }

    public static void printEulerPath() {
        int n = 0;
        for (int i = 0; i < v; i++) {
            if (edges[v].size() % 2 == 1) {
                n = i;
                break;
            }
        }
        printEulerPath(v);
    }

    static void printEulerPath(int v) {
        for (int i = 0; i < edges[v].size(); i++) {
            int n = (int)edges[v].get(i);
            System.out.print(v + " - " + n);
            removeEdge(v, n);
            printEulerPath(n);
        }
    }


}



