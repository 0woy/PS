package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
- 문제
수빈이는 동생과 숨바꼭질을 하고 있다.
수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
수빈이는 걷거나 순간이동을 할 수 있다.
만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때,
수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

- 입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

- 출력
첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
둘째 줄에 어떻게 이동해야 하는지 공백으로 구분해 출력한다
 */
public class N_13913 {
    private static Queue<Person> person;
    private static Person [] visited;
    private static int goal, max_len;
    private static class Person{
       private int x, before, count;
       private Person(int x, int before, int count){
            this.x=x;
            this.before=before;
            this.count = count;
        }
        public int getBefore(){ return this.before;}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        person = new ArrayDeque<>();
        int start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());

        person.offer(new Person(start,-1,0));

        max_len = (start<goal)?goal:start;
        max_len= max_len*2+1;
        visited = new Person[max_len];
        visited[start] = new Person(start, -1,0);

        Person res = bfs();
        sb.append(res.count+"\n");

        List<Integer> arr = new ArrayList<>();
        arr.add(res.x);
        while(true){
            if(res.before ==-1) break;
            arr.add(res.before);
            res = visited[res.before];
        }

        Collections.reverse(arr);
        for(int i: arr){
            sb.append(i+" ");
        }
        System.out.println(sb);
    }

    private static Person bfs(){
        int [] dx = new int[]{1,-1,2};
        while (!person.isEmpty()){
            Person cp = person.poll();
            if(cp.x == goal) return visited[cp.x];
            for(int d=0;d<3;d++) {
                int nx = (d < 2) ? cp.x + dx[d] : cp.x * dx[d];
                if ( nx >= 0 && nx < max_len) {
                    if (nx == goal) {
                        visited[nx] = new Person(nx, cp.x,cp.count+1);
                        return visited[nx];
                    }
                    if (visited[nx] == null) {
                        visited[nx] = new Person(nx, cp.x,cp.count+1); // 방문 처리
                        person.offer(new Person(nx, cp.x,cp.count+1));
                    }
                }
            }
        }
        return null;
    }
}
