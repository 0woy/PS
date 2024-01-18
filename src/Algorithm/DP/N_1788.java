package Algorithm.DP;
import java.io.*;

public class N_1788 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        long [] dp;

        if(n<0) dp = new long[(-n)+1];
        else dp = new long[n+1];

        if(n==0) sb.append("0"+'\n'+"0");
        else if(n==1) sb.append("1"+'\n'+"1");
        else{
            dp[0] = 0; dp[1]=1;
            if(n>=2) sb.append("1"+'\n');
            else{
                n*=-1;
                if (n % 2 == 0) sb.append("-1" + '\n');
                else    sb.append("1" + '\n');
            }
                for (int i = 2; i <= n; i++) {
                    dp[i] = (dp[i-1]+dp[i-2])%1000000000;
                }
                sb.append(dp[n]);
        }
        System.out.println(sb);
    }
}
