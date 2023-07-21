import java.util.*;

public class Test {
    public static void main(String[] args) {

        //Initlization
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        scanner.next();
        int n = scanner.nextInt();
        scanner.next();
        scanner.next();
        int m = scanner.nextInt();
        Graph graph = new Graph(n);

        //Array created to hold number of edges on each node
        scanner.nextLine();

        //Loop to read through input
        for (int i = 0; i < n; i++) {
            scanner.next();
            String vertexs = scanner.next();
            vertexs = vertexs.substring(0, vertexs.length() - 1);
            int v = Integer.parseInt(vertexs);
            for (int j = 0; j < v; j++) {
                Integer connection = scanner.nextInt();
                if (j == 0) {
                    graph.addEdge(i, connection);
                }
            }
            scanner.nextLine();

        }

        // beginning path selection my starting at each possible node
        // Arraylist is created to hold all successful paths
        if (connected(n) && count() == 0 || count() == 2) {
            Graph.printEulerPath();
        } else {
            System.out.println("non-Test");
        }
        scanner.close();

    }

    static boolean connected(int x) {
        boolean[] stops = new boolean[x];

        for (int i = 0; i < x; i++) {
            if (Graph.edges[i].size() > 0) {
                dfs(i, stops);
                break;
            }
        }
        for (int i = 0; i < x; i++) {
            if (!stops[i] && Graph.edges[i].size() > 0) {
                return false;
            }
        }
        return true;
    }

    static int count() {
        int count = 0;
        for (List<Integer> list : Graph.edges) {
            if ((list.size() & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    static void dfs(int v, boolean[] stops) {
        stops[v] = true;

        for (Object n : Graph.edges[v]) {
            if (!stops[(int)n]) {
                dfs((int)n, stops);
            }
        }
    }
}