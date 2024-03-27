package Algorithm.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
자연수 N과 M이 주어졌을 때,
아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
- 고른 수열은 오름차순이어야 한다.
 */
public class N_15650 {
    private static int n;
    private static int m_len;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb= new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m_len = Integer.parseInt(st.nextToken());
        boolean [] visited = new boolean[n+1];
        int [] arr = new int[m_len+1];
        if(n==m_len|| m_len==1){
            for(int i=1;i<=n;i++){
                sb.append(i);
                if(m_len==n) sb.append(" ");
                else if(m_len==1) sb.append("\n");
            }
        }
        else {
            dfs(visited, arr, 1);
        }
        System.out.print(sb);
    }

    private static void dfs(boolean [] visited, int[] res, int depth){
        if(depth == m_len+1){
            for(int i: res){
                if(i!=0) sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++){
            if(!visited[i]) {
                if (i > res[depth - 1]) {
                    res[depth] = i;
                    visited[i]= true;
                    dfs(visited, res, depth + 1);
                    visited[i] = false;
                }
            }
        }

    }
}
