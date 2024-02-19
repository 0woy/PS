package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long [][] dp = new long[n+1][10];
        for(int i=0;i<10;i++){
            dp[1][i] =1;
        }
        for(int k=2;k<=n;k++){
            for(int i=0;i<10;i++){
                for(int j=i;j<10;j++)
                    dp[k][i] =(dp[k][i]+ dp[k-1][j])%10007;
            }
        }
        long res = 0;
        for(int i=0;i<10;i++)
            res += dp[n][i];
        System.out.println(res%10007);
    }

}
