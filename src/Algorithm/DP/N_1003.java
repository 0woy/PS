package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
      dp[][] =
      {
          {1,0},
          {0,1},
          {1,1} = fib(1)+fib(0)
          {1,2} = fib(2)+fib(1)
          {2,3} = fib(3)+fib(2)
      }
       */

public class N_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for(int k=0;k<testcase;k++) {
            int n = Integer.parseInt(br.readLine());
            int [][] dp = new int[n+1][2];
            for(int i=0;i<=n;i++){
                if (i == 0) dp[i] = new int[]{1, 0};
                else if (i == 1) dp[i] = new int[]{0, 1};
                else{
                    dp[i][0] = dp[i-1][0]+dp[i-2][0];
                    dp[i][1] = dp[i-1][1]+dp[i-2][1];
                }
            }
        System.out.println(dp[n][0]+" "+dp[n][1]);
        }
    }
}
