package Algorithm.DP;

import java.io.*;
import java.util.*;

public class N_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n= Integer.parseInt(st.nextToken());
        int testcase= Integer.parseInt(st.nextToken());
        int [][] arr = new int[n+2][n+2];   // 1,1이 맨 처음 칸으로 맞추기 위함.
        int [][] dp = new int[n+1][n+1];
        // 배열 초기화
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=n;i++){
            dp[i][1] = arr[i][1];
            for(int j=2;j<=n;j++){
                dp[i][j] = dp[i][j-1]+arr[i][j];
            }
        }

        for(int i=0;i<testcase;i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int tmp=0;

            if(x1==x2&& y1==y2) tmp = arr[x1][y1];
            else {
               for(int k=x1;k<=x2;k++){
                   tmp = tmp +(dp[k][y2]-dp[k][y1-1]);
               }
            }
            sb.append(tmp+"\n");
        }
        System.out.println(sb);
    }
}
