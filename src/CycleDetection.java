import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CycleDetection {

    private Graph g;
    private int[] pre;
    private boolean[] visited;

    private boolean hasCycle;
    public CycleDetection(Graph g) {
        this.g = g;
        pre = new int[g.V()];
        visited = new boolean[g.V()];

        for (int v = 0; v < g.V(); v++) {
            if (!visited[v]) {
                if (dfs(v, v))
                    hasCycle = true;
            }
        }
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;

        for (int w : g.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) return true;
            } else if (visited[w] && w != parent)
                return true;
        }

        return false;
    }
    public boolean cycle(){
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        CycleDetection cc = new CycleDetection(g);
        System.out.println(cc.cycle());

    }

}
