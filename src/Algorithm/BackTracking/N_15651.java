package Algorithm.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_15651 {
    private static int n;
    private static int m_len;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        sb= new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m_len = Integer.parseInt(st.nextToken());
        int [] arr= new int[m_len];
        dfs(arr,0);
        System.out.print(sb);
    }
    private static void dfs(int[]res, int depth){
        if(depth == m_len){
            for(int i: res)
                sb.append(i+" ");
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++){
            res[depth] = i;
            dfs(res, depth+1);
        }
    }
}
