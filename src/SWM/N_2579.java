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
        int total = 0; // 총 점수
        int count = Integer.parseInt(br.readLine());
        boolean check = false;  // 연속된 3계단 감지
        int [] stairs = new int[count]; // 각 계단의 점수 저장 배열

        for(int i=0;i<count;i++)
            stairs[i] = Integer.parseInt(br.readLine());

        total += stairs[count-1]; // 마지막 계단 필수
        int i;
        // 계단 오르기 시작
        for(i = count-1;i>=2;){
            if(!check && stairs[i-1] > stairs[i-2]){
                total+=stairs[i-1];
                i=i-1;
                check = true;
            }
            else{
                total+=stairs[i-2];
                i=i-2;
                check=false;
            }
        }
        if(!check) {
            switch (i) {
                case 1:
                    total += stairs[0];
                    break;
                case 2:
                    total += stairs[0]<stairs[1]?stairs[1]:stairs[0];
                    break;
            }
        }
        System.out.println(total);
    }
}





















