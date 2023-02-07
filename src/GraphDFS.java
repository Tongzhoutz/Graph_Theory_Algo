import java.util.ArrayList;
import java.util.Stack;

public class GraphDFS {

    private Graph g;
    private boolean[] visited;
    private ArrayList<Integer> preorderedList;
    private ArrayList<Integer> postorderedList;
    private ArrayList<Integer> preorderedList_stack;
    public GraphDFS(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        preorderedList = new ArrayList<>();
        postorderedList = new ArrayList<>();
        for (int v = 0; v < g.V(); v++){
            if (!visited[v])
                dfs(v);
        }

        visited = new boolean[g.V()];
        preorderedList_stack = new ArrayList<>();
        for (int v = 0; v < g.V(); v++) {
            if (!visited[v])
                dfs_stack(v);
        }
    }

    private void dfs_stack(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        while (!stack.isEmpty()) {
            int out = stack.pop();
            preorderedList_stack.add(out);
            for (int w : g.adj(out)) {
                if (!visited[w]){
                    stack.push(w);
                    visited[w] = true;

                }
            }
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
    public Iterable<Integer> preorder_stack() {
        return preorderedList_stack;
    }
    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println(graphDFS.preorder());
        System.out.println(graphDFS.preorder_stack());
    }

}
