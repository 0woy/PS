package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
돌 게임 3
기존 돌게임에서 돌을 1개, 3개 또는 4개를 가져갈 수 있음
 */
public class N_9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean [] dp = new boolean [n+1];
        dp[1] = true;
        // true: 상근 win, false: 창영이 win
        for(int i=2;i<=n;i++){
            if(i==2) dp[i]=false;
            else if(i==3) dp[i]=true;
            else if(i==4) dp[i]=true;
            // 5부터 시작
            else{
                if(dp[i-1]==dp[i-3]==dp[i-4])
                    dp[i]=!dp[i-1];
                else{
                    dp[i]=true;
                }
            }
        }
       String winner =  dp[n]?"SK":"CY";
        System.out.println(winner);
    }
}
