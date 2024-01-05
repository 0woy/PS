package SWM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
N2579번 계단 오르기
- 아래 시작점부터 꼭대기 도착점까지 가는 게임
- 계단에는 일정 점수 부여, 해당 계단 밟을 시 점수 추가

<조건>
1. 한 번에 한 개 || 두 개 오를 수 있음
2. 연속한 3개의 계단은 밟을 수 없음
3. 마지막 계단은 반드시 밟아야 함
 */
public class N_2579 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int [] stairs = new int[count+1]; // 각 계단의 점수 저장 배열
        int [] scores = new int[count+1];

        for(int i=1;i<=count;i++)
            stairs[i] = Integer.parseInt(br.readLine());

        scores[1] = stairs[1];
        for(int i=2;i<=count;i++){
            if(i==2)
                scores[2] = stairs[1]+stairs[2];
            else if(i==3)
                scores[3] = Math.max(stairs[1],stairs[2])+stairs[3];
            else
                scores[i] =  Math.max(scores[i-3]+stairs[i-1],scores[i-2]) + stairs[i];
        }
        System.out.println(scores[count]);
    }
}





















