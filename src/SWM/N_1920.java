package SWM;
/*
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
이 안에 X라는 정수가 존재하는지 알아내기
 */

import java.util.*;
import java.io.*;
public class N_1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n =Integer.parseInt(br.readLine());
        int [] ans = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            ans[i] = Integer.parseInt(st.nextToken());

        // 오름차순 정렬
        Arrays.sort(ans);

        int m =Integer.parseInt(br.readLine());
        int [] find = new int[m];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++)
            find[i] = Integer.parseInt(st.nextToken());

        for (Integer i: find) {
            int start = 0, end = ans.length - 1;
            while (true) {
                if (i == ans[(start + end) / 2]){
                    sb.append(1).append("\n");
                    break;
                }
                else if (start > end){
                    sb.append(0).append("\n");
                    break;
                }
                else if(i < ans[(start + end) / 2])
                    end = (start+end)/2-1;
                else
                    start = (start+end)/2+1;
            }
        }
        System.out.println(sb);
    }
}
