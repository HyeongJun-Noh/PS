import java.util.*;
import java.io.*;

//

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int n;
    static ArrayList<Integer>[] g;
    static boolean[] visited;
    static int[][] dp;
    static int[] depth;

    static void DFS(int now, int d) {
        visited[now] = true;
        depth[now] = d;
        for(int next : g[now]) {
            if(!visited[next]) {
                dp[next][0] = now;
                DFS(next, d + 1);
            }
        }
    }

    static void arrSet() {
        for(int j = 1; j < 30; j++) {
            for(int i = 1; i <= n; i++) {
                dp[i][j] = dp[dp[i][j-1]][j-1];
            }
        }
    }

    static int LCA(int u, int v) {
        if(depth[u] < depth[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        int diff = depth[u] - depth[v];
        for(int i = 0; diff != 0; i++) {
            if((diff & 1) == 1) u = dp[u][i];
            diff >>= 1;
        }
        
        if(u == v) return u;

        for(int i = 29; i >= 0; i--) {
            if(dp[u][i] != dp[v][i]) {
                u = dp[u][i];
                v = dp[v][i];
            }
        }
        return dp[u][0];
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        
        init();

        for(int i = 0; i < n - 1; i++) {
            int t1, t2;
            st = new StringTokenizer(br.readLine());
            
            t1 = Integer.parseInt(st.nextToken());
            t2 = Integer.parseInt(st.nextToken());
            g[t1].add(t2);
            g[t2].add(t1);
        }

        DFS(1, 0);
        arrSet();

        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++) {
            int t1, t2;
            st = new StringTokenizer(br.readLine());

            t1 = Integer.parseInt(st.nextToken());
            t2 = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(LCA(t1,t2)) + "\n");
        }

        bw.close();
        br.close();
    }

    static void init() {
        g = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        dp = new int[n + 1][30];
        depth = new int[n + 1];
    }
}