import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AllSourcePath {

    private Graph g;

    private SingleSourcePath[] paths;
    private boolean[] visited;
    public AllSourcePath(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        paths = new SingleSourcePath[g.V()];
        for (int v = 0; v < g.V(); v++)
            paths[v] = new SingleSourcePath(g, v);
    }

    public boolean isConnected(int s, int t) {
        return paths[s].isConnected(t);
    }
    public Iterable<Integer> path(int s, int t) {
        return paths[s].path(t);
    }
    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        AllSourcePath allPath = new AllSourcePath(g);
        System.out.println(allPath.isConnected(0, 6));
        System.out.println(allPath.path(0, 5));

    }

}
