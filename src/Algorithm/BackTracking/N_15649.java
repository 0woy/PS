package Algorithm.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_15649 {
    private static int n;
    private static int m_len;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m_len = Integer.parseInt(st.nextToken());
        boolean [] visited = new boolean[n+1];
        int [] arr = new int[m_len];
        sb = new StringBuilder();

        dfs(visited,arr,0);
        System.out.print(sb);

    }

    private static void dfs(boolean[] visited, int[] res ,int depth){
        if(depth == m_len){
            for(int i: res){
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++) {
            if (!visited[i]) {
                visited[i]=true;
                res[depth] = i;
                dfs(visited, res, depth+1);
                visited[i]=false;
            }
        }
    }
}
