package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1010 {

    public static long pascal(int m, int n, long [][] dp){
        for(int i=1;i<=m;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i) dp[i][j]=1;
                else   dp[i][j] =  dp[i-1][j-1]+dp[i-1][j];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int test =  Integer.parseInt(br.readLine());
        for(int i=0;i<test;i++){

             st= new StringTokenizer(br.readLine());
             int n = Integer.parseInt(st.nextToken());
             int m = Integer.parseInt(st.nextToken());
             long [][] dp = new long[m][m+1];

           sb.append(pascal(m,n)+"\n");
        }
        System.out.println(sb);
    }
}
