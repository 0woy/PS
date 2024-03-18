package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

 */
public class N_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [] time = new int[n];
        int [] pay = new int[n];
        int [] dp = new int[n+1];

        for(int i=0;i<=n-1;i++){
            st = new StringTokenizer(br.readLine());
            time[i]= Integer.parseInt(st.nextToken());
            pay[i]= Integer.parseInt(st.nextToken());
        }
        int max =0;
        for(int i=0;i<n;i++){
            if(i+time[i]<=n ){
            dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + pay[i]);
            max = (max < dp[i+time[i]]) ? dp[i+time[i]] : max;
            }
            dp[i+1] = Math.max(dp[i+1],dp[i]);
        }
        System.out.println(max);
    }
}
