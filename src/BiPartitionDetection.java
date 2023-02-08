import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BiPartitionDetection {

    private Graph g;

    private int[] colors;

    private boolean isBiPartition = true;
    public BiPartitionDetection(Graph g) {
        this.g = g;
        colors = new int[g.V()];
        Arrays.fill(colors, -1);
        for (int v = 0; v < g.V(); v++){
            if (colors[v] == -1) {
                if (!dfs(v, 0))
                    isBiPartition = false;
            }
        }

    }

    private boolean dfs(int v, int color) {
        colors[v] = color;
        for (int w : g.adj(v)) {
            if (colors[w] == -1) {
                if (!dfs(w, 1 - color))
                    return false;
            } else if (colors[w] == color)
                    return false;
        }
        return true;
    }
    public boolean isBiPartition(){
        return isBiPartition;
    }
    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        BiPartitionDetection BP = new BiPartitionDetection(g);
        System.out.println(BP.isBiPartition());
    }

}
