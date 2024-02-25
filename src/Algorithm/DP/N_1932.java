package Algorithm.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1932 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        int count = size*(size+1)/2;
        int [] arr = new int[count+3];
        int [] dp =  new int[count+3];

        int idx = 1;
        for(int i=1;i<=size;i++) {
            st = new StringTokenizer(br.readLine());
            int len = st.countTokens();
            for (int j = 0; j < len; j++) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0]=0;
        dp[1] = arr[1];
        dp[2] = dp[1] +arr[2];
        dp[3] = dp[1] +arr[3];

        int plus =2;
        int s_line = 1;
        for(int i=1;i<size-1;i++) {
            s_line = s_line+i;
            for (int j = 0; j <= i; j++) {
                for(int k=0;k<2;k++) {
                    int c_idx = s_line+j;
                    int n_idx = c_idx+plus+k;
                    if (dp[n_idx] == 0)
                        dp[n_idx] = dp[c_idx] + arr[n_idx];
                    else {
                        dp[n_idx] = Math.max(dp[n_idx], dp[c_idx]+arr[n_idx]);
                    }
                }
            }
            plus++;
        }
        int max = Integer.MIN_VALUE;
        for(int i=count;i>count-size;i--){
            max = (max < dp[i])?dp[i]:max;
        }
        System.out.println(max);
    }
}
