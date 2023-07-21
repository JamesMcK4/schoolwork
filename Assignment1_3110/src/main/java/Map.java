import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Map {
    int v;
    HashMap map;

    Map(int v) {
        this.v =v;
        map = new HashMap<Integer, ArrayList<Integer>>(v+1);
    }

    public void addEdge(int u, int v) {
        if(map.get(u) == null){
            ArrayList newlist = new ArrayList();
            map.put(u, newlist);
        }
        ArrayList list = (ArrayList) map.get(u);
        list.add(v);
        map.put(u, list);
        if(map.get(v) == null){
            ArrayList newlist = new ArrayList();
            map.put(v, newlist);
        }
        list = (ArrayList) map.get(v);
        list.add(u);
        map.put(v , list);
    }

    void removeEdge(int u, int v) {
        ArrayList list = (ArrayList) map.get(u);
        list.remove(Integer.valueOf(v));
        map.put(u, list);
        list = (ArrayList) map.get(v);
        list.remove(Integer.valueOf(u));
        map.put(v , list);
    }

    void printEulerPath() {
        int odd = 0;
        int oddV = 0;

        for(int i = 1; i <= v; i++){
            if(map.get(i) == null){
                ArrayList newlist = new ArrayList();
                map.put(i, newlist);
            }
            ArrayList list = (ArrayList) map.get(i);
            if(list.size()%2 == 1){
                odd++;
                oddV = i;
            }
        }

        if(odd == 0){
            printEuler(1);
        } else if(odd == 2){
            printEuler(oddV);
        } else {
            System.out.println("non-eulerian");
        }
    }

    void printEuler(int v) {
        Stack<Integer> current = new Stack();
        Stack<Integer> finalP = new Stack();

        current.push(v);

        while(!current.empty()){
            int u = current.peek();

            ArrayList list = (ArrayList) map.get(u);
            if(list.size() == 0){
                finalP.push(u);
                current.pop();
            } else {
                int x = (int) list.get(0);
                list.remove(0);
                current.push(x);
                removeEdge(u, x);
            }
        }

        while(!finalP.empty()){
            System.out.print(finalP.pop() + " ");
        }
    }


}



