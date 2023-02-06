package Graph_draft;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjMatrix {

    private int V;
    private int E;

    private int[][] adj;

    public AdjMatrix(String filename) {
        File file = new File(filename);

        try ( Scanner sc = new Scanner(file) ) {
            V = sc.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("V must be non-negative");

            E = sc.nextInt();
            if (E < 0)
                throw new IllegalArgumentException("E must be non-negative");

            adj = new int[V][V];

            for (int i = 0; i < E; i++) {
                int a = sc.nextInt();
                validateVertex(a);
                int b = sc.nextInt();
                validateVertex(b);

                if (a == b)
                    throw new IllegalArgumentException("Self Loop Is Detected!");

                if (adj[a][b] == 1)
                    throw new IllegalArgumentException("Parallel Ddges Are Detected!");
                adj[a][b] = 1;
                adj[b][a] = 1;
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
        return adj[v][w] == 1;
    }

    public ArrayList<Integer> adj(int v) {
        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int j = 0; j < V; j++){
            if (adj[v][j] == 1)
                res.add(j);
        }
        return res;
    }

    public int degree(int v) {
        return adj(v).size();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                sb.append(String.format("%d ", adj[i][j]));
            sb.append('\n');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adj = new AdjMatrix("g.txt");
        System.out.println(adj);
    }

}
