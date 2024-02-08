package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int j=0;j<testcase;j++){
            int n = Integer.parseInt(br.readLine());
            long [] dp = new long[n+3];
            dp[1] =1;
            dp[2] =2;
            dp[3] =4;
            for(int i=4;i<=n;i++){
                dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
            }
            sb.append(dp[n]+"\n");
        }
        System.out.println(sb);
    }
}
