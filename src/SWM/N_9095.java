package SWM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
11 이하의 정수 n을 1, 2, 3을 이용한 덧셈으로 나타내기
dp문제

1: 1: 1개
2: 1+1, 2 :2개
3: 1+1+1, 1+2, 2+1, 3 : 4개

4= 3의 경우의 수에 각 1을 더한 값, 2의 경우의 수에 2를 더한 값, 1의 경우의 수에 3을 더한 값
=> 4+2+1 = 7개

점화식: dp[n] =dp[n-1]+dp[n-2]+dp[n-3]

 */

public class N_9095 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int [] test = new int [count];
        int [] dp = new int[12];    // n은 11이하의 정수

        for(int i =0;i<count;i++){
            test[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<test.length;i++){
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            int n = test[i];
            for(int j=4;j<=n;j++){
                dp[j] = dp[j-1] +dp[j-2]+dp[j-3];
            }
            System.out.println(dp[n]);
        }
    }
}