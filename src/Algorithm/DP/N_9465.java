package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for(int t=0;t<testcase;t++){
            int n = Integer.parseInt(br.readLine());
            int [][] desk = new int [2][n];
            long [][] dp= new long [2][n];
            int max =0;

            for(int r=0;r<2;r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0;c<n;c++){
                    desk[r][c] =Integer.parseInt(st.nextToken());
                }
            }   // end r

            dp[0][0] = desk[0][0];
            dp[1][0] = desk[1][0];

            for(int i=1;i<n;i++){
                if(i==1){
                    dp[0][i] = dp[1][0]+desk[0][i];
                    dp[1][i] = dp[0][0]+desk[1][i];
                }
                else {
                    dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + desk[0][i];
                    dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + desk[1][i];
                }
            }
            sb.append(Math.max(dp[0][n-1],dp[1][n-1])+"\n");

        }   // end t

        System.out.println(sb);
    }// end main
}
