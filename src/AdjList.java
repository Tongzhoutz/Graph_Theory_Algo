import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjList {

    private int V;
    private int E;

    private LinkedList<Integer>[] adj;

    public AdjList(String filename) {
        File file = new File(filename);

        try ( Scanner sc = new Scanner(file) ) {
            V = sc.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("V must be non-negative");

            E = sc.nextInt();
            if (E < 0)
                throw new IllegalArgumentException("E must be non-negative");

            adj = new LinkedList[V];
            for (int i = 0; i < V; i++)
                adj[i] = new LinkedList<>();

            for (int i = 0; i < E; i++) {
                int a = sc.nextInt();
                validateVertex(a);
                int b = sc.nextInt();
                validateVertex(b);

                if (a == b)
                    throw new IllegalArgumentException("Self Loop Is Detected!");

                if (adj[a].contains(b))
                    throw new IllegalArgumentException("Parallel Ddges Are Detected!");
                adj[a].add(b);
                adj[b].add(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex" + v + "is invalid!");
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }

    public boolean hasEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }

    public LinkedList<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v) {
        return adj(v).size();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int v = 0; v < V; v++) {
            sb.append(String.format("%d : ", v));
            adj[v].forEach(w -> sb.append(String.format("%d ", w)));
            sb.append('\n');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AdjList adj = new AdjList("g.txt");
        System.out.println(adj);
    }

}
