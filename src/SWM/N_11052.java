package SWM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] price = new int[n+1];
        int [] dp = new int[n+1];
        dp[0] = 0;

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++)
            price[i] = Integer.parseInt(st.nextToken());
        dp[1] = price[1];
        for(int i=2;i<=n;i++){
          for(int j=1;j<=i;j++){
             dp[i] = Math.max(dp[i-j]+price[j],dp[i]);
          }
        }

        System.out.println(dp[n]);


    }
}
