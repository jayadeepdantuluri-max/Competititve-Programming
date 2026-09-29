import java.io.*;
import java.util.*;

public class Solution {

    static int V;
    static int[][] capacity;
    static int[][] flow;

    static int bfs(int s, int t, int[] parent) {
        Arrays.fill(parent, -1);
        parent[s] = s;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v = 0; v < V; v++) {
                if (parent[v] == -1 && capacity[u][v] - flow[u][v] > 0) {
                    parent[v] = u;
                    if (v == t) {
                        int pathFlow = Integer.MAX_VALUE;
                        int cur = t;

                        while (cur != s) {
                            int prev = parent[cur];
                            pathFlow = Math.min(pathFlow, capacity[prev][cur] - flow[prev][cur]);
                            cur = prev;
                        }
                        return pathFlow;
                    }
                    q.add(v);
                }
            }
        }
        return 0;
    }

    static int fordFulkerson(int s, int t) {
        flow = new int[V][V];
        int maxFlow = 0;
        int[] parent = new int[V];

        int pathFlow;
        while ((pathFlow = bfs(s, t, parent)) > 0) {
            int cur = t;

            while (cur != s) {
                int prev = parent[cur];
                flow[prev][cur] += pathFlow;
                flow[cur][prev] -= pathFlow;
                cur = prev;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        int E = sc.nextInt();

        capacity = new int[V][V];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            capacity[u][v] += c;
        }

        System.out.println(fordFulkerson(0, V - 1));
    }
}
