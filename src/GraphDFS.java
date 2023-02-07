import java.util.ArrayList;

public class GraphDFS {

    private Graph g;
    private boolean[] visited;
    private ArrayList<Integer> orderedList;
    public GraphDFS(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        orderedList = new ArrayList<>();
        dfs(0);
    }

    private void dfs(int v) {
        visited[v] = true;
        orderedList.add(v);
        for (int w : g.adj(v)){
            if (!visited[w])
                dfs(w);
        }
    }
    public Iterable<Integer> order(){
        return orderedList;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println(graphDFS.order());
    }

}
