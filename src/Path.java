import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Path {

    private Graph g;
    private int s;
    private int[] pre;
    private int t;
    private boolean[] visited;
    public Path(Graph g, int s, int t) {
        this.g = g;
        this.s = s;
        this.t = t;
        pre = new int[g.V()];
        visited = new boolean[g.V()];
        dfs(s, s);
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        if (v == this.t) return true;
        for (int w : g.adj(v)){
            if (!visited[w]) {
                if (dfs(w, v)) return true;
            }
        }
        return false;
    }

    public boolean isConnected() {
        return visited[t];
    }
    public Iterable<Integer> path() {

        ArrayList<Integer> pathList = new ArrayList<>();
        if (!isConnected())
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
        Path path = new Path(g, 0, 4);
        System.out.println(path.path());

    }

}
