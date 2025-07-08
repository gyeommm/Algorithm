import java.util.*;
import java.io.*;

class Main{
    static List<Node>[] tree;
    static boolean[] visited;
    static int result = 0;
    static int id = 0;

    static class Node{
        int id;
        int m;

        Node(int id, int m){
            this.id = id;
            this.m = m;
        }
    }

    static void dfs(int now, int sum){
        visited[now] = true;

        if(sum > result){
            result = sum;
            id = now;
        }

        for(int i = 0; i < tree[now].size(); i++){
            Node next = tree[now].get(i);
            if(visited[next.id]){
                continue;
            }

            dfs(next.id, sum + next.m);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            tree[u].add(new Node(v, m));
            tree[v].add(new Node(u, m));
        }

        for(int i = 1; i <= n; i++){
            Collections.sort(tree[i], (a, b) -> b.m - a.m);
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(id, 0);
        System.out.print(result);
    }
}