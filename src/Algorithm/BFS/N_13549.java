package Algorithm.BFS;

import java.util.*;
import java.io.*;
public class N_13549 {
    static int [] road = new int[100001];
    static boolean [] visited = new boolean[100001];
    static int start, goal;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());

        for(int k=start;k<goal*2;k*=2){
            if(k>50000||k==0) break;
            if(k==goal) {
                visited[goal] = true;
                break;
            }
        }
        if(!visited[goal]){
            bfs(start);
        }
        System.out.println(road[goal]);
    }
    public static void bfs(int i){
        int [] move ={2,-1,1};
        Queue<Integer> que = new ArrayDeque<>();
        visited[i] = true;
        que.offer(i);
        while (!que.isEmpty()) {
            int tmp= que.poll();
            if(tmp == goal) break;
            for(int d=0;d<3;d++){
            int next = (d!=0)?tmp+move[d]:tmp*move[d];
            if(next>=0&&next<100001){
                if(!visited[next]) {
                    road[next] = (d!=0)?road[tmp] + 1:road[tmp];
                    visited[next] = true;
                    que.offer(next);
                }
            }
            }
        }
    }
}
