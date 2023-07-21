import java.util.*;

public class Eulerian {
    public static void main(String[] args) {

        //Initlization
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        scanner.next();
        int n = scanner.nextInt();
        scanner.next();
        scanner.next();
        int m = scanner.nextInt();
        Map map = new Map(n);

        //Array created to hold number of edges on each node
        scanner.nextLine();

        //Loop to read through input
        for (int i = 1; i < n; i++) {
            scanner.next();
            String vertexs = scanner.next();
            vertexs = vertexs.substring(0, vertexs.length() - 1);
            int v = Integer.parseInt(vertexs);
            for (int j = 0; j < v; j++) {
                Integer connection = scanner.nextInt();
                if (j == 0) {
                    map.addEdge(i, connection);
                }
            }
            scanner.nextLine();
        }
        // beginning path selection my starting at each possible node
        // Arraylist is created to hold all successful paths
        map.printEulerPath();
    }

}