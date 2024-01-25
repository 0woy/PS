package Algorithm.DP;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int [] dp = new int [n+3];

        dp[1] =0;
        dp[2] =1;
        dp[3]=1;

        for(int i=4;i<=n;i++){
            int tmp = Integer.MAX_VALUE;
            if(i%2==0) tmp = Math.min(dp[i/2], tmp);
            if(i%3==0) tmp = Math.min(dp[i/3], tmp);
            tmp = Math.min(dp[i-1],tmp);
            dp[i] = tmp+1;
        }
            sb.append(dp[n]+"\n");
        while (true){
            sb.append(n+" ");
            int tmp = Integer.MAX_VALUE;
            int idx=-1;
            if(n==1) break;

            if(n%2==0){
                if(dp[n/2]<tmp){
                    tmp = dp[n/2];
                    idx = n/2;
                }
            }
            if(n%3==0){
                if(dp[n/3]<tmp){
                    tmp = dp[n/3];
                    idx =n/3;
                }
            }
            if(dp[n-1]<tmp) idx =n-1;
            n = idx;
            }
        System.out.println(sb);
        }
    }
