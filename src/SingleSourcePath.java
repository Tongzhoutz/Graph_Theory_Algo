import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class SingleSourcePath {

    private Graph g;
    private boolean[] visited;
    private int[] pre;
    public SingleSourcePath(Graph g, int s) {
        this.g = g;
        visited = new boolean[g.V()];
        pre = new int[g.V()];
        dfs(s, s);
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        for (int w : g.adj(v)){
            if (!visited[w]) {
                return dfs(w, v);
            }
        }
        return false;
    }

    public boolean isConnected(int t) {
        return visited[t];
    }
    public Iterable<Integer> path(int t) {

        ArrayList<Integer> pathList = new ArrayList<>();
        if (!isConnected(t))
            return pathList;
        pathList.add(t);
        while (pre[t] != t) {
            pathList.add(pre[t]);
            t = pre[t];
        }
        Collections.reverse(pathList);
        return pathList;
    }
    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        SingleSourcePath ss = new SingleSourcePath(g, 0);
        System.out.println("0 -> 6 :" + ss.path(6));

    }

}
