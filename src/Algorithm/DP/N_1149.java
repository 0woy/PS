package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] dp = new int[n][n];
        int [][] rgb = new int [n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];

        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                dp[i][j] = rgb[i][j]+Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
            }
        }
        int min = (dp[n-1][0]>dp[n-1][1])
                ?(dp[n-1][1]>dp[n-1][2]?dp[n-1][2]:dp[n-1][1])
                :(dp[n-1][0]>dp[n-1][2]?dp[n-1][2]:dp[n-1][0]);

        System.out.println(min);
    }
}
