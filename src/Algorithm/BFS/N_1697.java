package Algorithm.BFS;

import java.io.*;
import java.util.*;

public class N_1697 {
    static int c_pos, g_pos;
    static int[] road;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c_pos = Integer.parseInt(st.nextToken());
        g_pos = Integer.parseInt(st.nextToken());

        road = new int[100001];
        visited = new boolean[100001];

        bfs(c_pos);
        System.out.println(road[g_pos]);

    }
    static void bfs(int pos){
        int [] move = {1,-1,2};
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(pos);
        while (!que.isEmpty()){
            int tmp = que.poll();
            if(tmp == g_pos) break;
            for(int d=0;d<3;d++){
                int m_pos = (d<2)?tmp+move[d]:tmp*move[d];
                if(m_pos>=0&&m_pos<=100000){
                    if(!visited[m_pos]){
                        visited[m_pos] = true;
                        road[m_pos] = road[tmp]+1;
                        que.offer(m_pos);
                    }
                }
            }
        }
    }
}
