package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_5014 {
    static int [] elevator;
    static boolean [] visited;
    static int total, start, goal,up,down;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        total = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        up= Integer.parseInt(st.nextToken());
        down  = Integer.parseInt(st.nextToken());
        elevator = new int [total+1];
        visited = new boolean [total+1];
        elevator[0]=-1;
        visited[0]=true;
        bfs(start);

        if(visited[goal]&&elevator[goal]>=0)
            System.out.println(elevator[goal]);
        else
            System.out.println("use the stairs");
    }

    public static void bfs(int i){
        Queue<Integer> que = new ArrayDeque<>();
        visited[i] = true;
        que.offer(i);
        while(!que.isEmpty()){
            int c_floor = que.poll();
            if(c_floor==goal) break;
            int n1 = c_floor+up;
            int n2 = c_floor-down;
            if(n1>=1&&n1<=total) {
                if (!visited[n1]) {
                    elevator[n1] = elevator[c_floor] + 1;
                    visited[n1] = true;
                    que.offer(n1);
                }
            }
            if(n2>=1&&n2<=total) {
                if (!visited[n2]) {
                    elevator[n2] = elevator[c_floor] + 1;
                    visited[n2] = true;
                    que.offer(n2);
                }
            }
        }
    }
}
