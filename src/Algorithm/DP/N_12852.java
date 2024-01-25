package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int [] dp = new int [n+1];
        String [] sol= new String[n+1];

        switch (n){
            case 1:
                dp[1] =0;
                sol[1]= "1";
                break;
            case 2:
                dp[2]=1;
                sol[2]="1 2";
                break;
            case 3:
                dp[3]=1;
                sol[3] ="1 3";
                break;
        }

        if(n>3) {
            dp[1] =0;
            sol[1]= "1";
            dp[2] =1;
            sol[2]="1 2";
            dp[3] =1;
            sol[3] ="1 3";
            for (int i = 4; i <= n; i++) {
                if(i%3==0&&i%2!=0) {
                    if(dp[i/3]<dp[i-1]){
                        dp[i] = dp[i/3]+1;
                        sol[i] = sol[i/3]+" "+i;
                    }
                    else{
                        dp[i]=dp[i-1]+1;
                        sol[i]=sol[i-1]+" "+i;
                    }
                }
                else if(i%3==0&&i%2==0){
                    if(dp[i/3]<dp[i/2]){
                        dp[i] = dp[i/3]+1;
                        sol[i] = sol[i/3]+" "+i;
                    }
                    else{
                        dp[i]=dp[i/2]+1;
                        sol[i]=sol[i/2]+" "+i;
                    }
                }

                else if(i%2==0){
                    if(dp[i/2]<dp[i-1]){
                        dp[i] = dp[i/2]+1;
                        sol[i] = sol[i/2]+" "+i;
                    }
                    else{
                        dp[i]=dp[i-1]+1;
                        sol[i]=sol[i-1]+" "+i;
                    }
                }
                else{
                    dp[i]=dp[i-1]+1;
                    sol[i] = sol[i-1]+" "+i;
                }
            }
        }
        String [] res = sol[n].split(" ");
        for(int i =res.length-1;i>=0;i--)
            sb.append(res[i]+ " ");

        System.out.println(dp[n]);
        System.out.println(sb);
        }
    }
