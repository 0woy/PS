package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11659 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int len =Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] dp = new int[len+1];
        int [] arr = new int[len+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1;i<=len;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[0]=0;
        dp[1] = arr[1];
        for(int i=2;i<=len;i++){
            dp[i] = arr[i]+dp[i-1];
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int res = dp[e] -dp[s-1];
            sb.append(res+"\n");
        }
        System.out.println(sb);

    }
}
