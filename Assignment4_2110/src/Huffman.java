/**
 * James McKinlay
 * B00867096
 * Assignment 4 - CSCI 2110
 * This is the driver code + few helper methods (generated for our use) used to build a Huffman tree and encode lines of text
 * in accordance with the instructions for Assignment 4
 */

import java.util.*;

public class Huffman{
    public static void main(String[] args) {

        //Initlization
        String read;
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        scanner.next();
        int n = scanner.nextInt();
        scanner.next();
        scanner.next();
        int m = scanner.nextInt();


        // Map created to hold arraylist of possible moves from each node
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        //Array created to hold number of edges on each node
        int[] array = new int[n];
        scanner.nextLine();
        //Loop to read through input
        for( int i = 0; i < n; i++){
            scanner.next();
            String vertexs = scanner.next();
            vertexs = vertexs.substring(0, vertexs.length()-1);
            int v = Integer.parseInt(vertexs);

            ArrayList<Integer> holder = new ArrayList<>();
            for (int j = 0; j < v; j++){
                array[i] = v;
                Integer connection = scanner.nextInt();
                holder.add(connection);
                if (j == 0) {
                    map.put(i, holder);
                }
            }
            scanner.nextLine();
        }
        System.out.println("INPUT TEST");
        for( int i = 0; i < n; i++){
            System.out.print("Node = " + i + " connections = " + array[i] + " ");
            System.out.print(map.get(i) + " ");
            System.out.println();
        }
        System.out.println("INPUT TEST");

        System.out.println("PROCESSING");
        // beginning path selection my starting at each possible node
        // Arraylist is created to hold all successful paths
        ArrayList<int[]> sPaths = new ArrayList<>();
        for( int i = 0; i < n; i++) {
            // remember starting node to check if we are at the end again
            int startingNode = i;
            // node we are on
            int node = i;
            //Loop is started to move a maximum possibility of m times, m being the number of edges
            for (int j = 0; j < m; j++) {
                // Possible path array created
                int[] path = new int[m];
                //The current nodes connections are checked to see if there are any possible moves
                if (map.get(i).size() != 0) {
                    ArrayList<Integer> paths = map.get(i);
                    //If there are no moves the loop is broken
                    if (paths.size() == 0) {
                        break;
                    }
                    // For each possible move we loop through
                    for (int k = 0; k < paths.size(); k++) {
                        // node added to path, made new node, then removed from list
                        path[j] = node + 1;
                        node = paths.get(k)-1;
                        paths.remove(k);
                    }
                }
                // we check to see if we are the end if all of the edges have been used
                if (j == m - 1 && node == startingNode) {
                    for (int q = 0; q < n; q++) {
                        ArrayList<Integer> list = map.get(q);
                        if(list.size() != 0){
                            break;
                        }
                        if( q == n-1){
                            // Path is added to success paths array
                            sPaths.add(path);
                        }
                    }

                }
            }


        }

        System.out.println("RESULTS");
        for(int[] list: sPaths){
            System.out.println(list);
        }

    }
}
