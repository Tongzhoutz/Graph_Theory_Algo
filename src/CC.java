import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CC {

    private Graph g;
    private int[] visited;
    private int cccount = 0;
    public CC(Graph g) {
        this.g = g;
        visited = new int[g.V()];
        Arrays.fill(visited, -1);
        for (int v = 0; v < g.V(); v++){
            if (visited[v] == -1) {
                dfs(v, cccount);
                cccount++;
            }
        }
    }

    private void dfs(int v, int ccid) {
        visited[v] = ccid;
        for (int w : g.adj(v)){
            if (visited[w] == -1)
                dfs(w, ccid);
        }
    }

    public int getCCcount(){
        return cccount;
    }

    public boolean isConnected(int v, int w) {
        return visited[v] == visited[w];
    }
    private ArrayList<Integer>[] getCCList(){
        ArrayList<Integer>[] res = new ArrayList[cccount];
        for (int i = 0; i < cccount; i++)
            res[i] = new ArrayList<>();

        for (int v = 0; v < g.V(); v++) {
            res[visited[v]].add(v);
        }
        return res;
    }
    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        CC cc = new CC(g);
        System.out.println(cc.getCCcount());
        System.out.println(cc.isConnected(0, 5));
        ArrayList<Integer>[] res = cc.getCCList();
        System.out.println(res.length);
        for (int i = 0; i < res.length; i++) {
            System.out.print(i + " : ");
            for (int w : res[i])
                System.out.print(w + " ");
            System.out.println();
        }
    }

}
