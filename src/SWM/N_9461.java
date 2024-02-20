package SWM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for(int t=0;t<testcase;t++){
            int n = Integer.parseInt(br.readLine());
           long[] dp = new long [n+3];
            dp[1]=1;
            dp[2]=1;
            dp[3]=1;
            for(int i=4;i<=n;i++){
                dp[i] = dp[i-3]+dp[i-2];
            }
            sb.append(dp[n]+"\n");
        }
        System.out.print(sb);

    }
}
