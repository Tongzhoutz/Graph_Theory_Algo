import java.util.ArrayList;

public class GraphDFS {

    private Graph g;
    private boolean[] visited;
    private ArrayList<Integer> preorderedList;
    private ArrayList<Integer> postorderedList;
    public GraphDFS(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        preorderedList = new ArrayList<>();
        postorderedList = new ArrayList<>();
        for (int v = 0; v < g.V(); v++){
            if (!visited[v])
                dfs(v);
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        preorderedList.add(v);
        for (int w : g.adj(v)){
            if (!visited[w])
                dfs(w);
        }
        postorderedList.add(v);
    }
    public Iterable<Integer> preorder(){
        return preorderedList;
    }

    public Iterable<Integer> postorder() {
        return postorderedList;
    }
    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println(graphDFS.preorder());
        System.out.println(graphDFS.postorder());
    }

}
