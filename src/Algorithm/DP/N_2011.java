package Algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2011 {
    static String n;
    static public char peek(int idx){
        if(idx > n.length()-1) return '0';
        return n.charAt(idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
        int len = n.length();
        long[] dp = new long[len + 2];
        if(n.charAt(0)=='0'){
            System.out.println(0);
            return;
        }
        else {
            dp[0] = 1;
            dp[1] = 1;
            for(int i=2;i<=len;i++){
                if(n.charAt(i-1)=='0') {
                    char next = peek(i - 2);
                    if (next == '1' || next == '2') {
                        dp[i] = dp[i - 2] % 1000000;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
                else {
                    int next = Integer.parseInt(n.substring(i-2, i));
                    if (next > 9 && next < 27) {
                        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                    } else {
                        dp[i] = dp[i - 1] % 1000000;
                    }
                }
            }
        }
            System.out.println(dp[len]%1000000);
    }
}
