package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N_11724 {
    static ArrayList<Integer>[] graph;  // 그래프를 인접 리스트로 표현
    static boolean [] visited;  // 방문 노드 check

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        graph = new ArrayList[node+1];
        visited =new boolean[node+1];

        for(int i=1;i<node+1;i++){
            graph[i] = new ArrayList<Integer>();    //인접 리스트 초기화
        }

        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 무방향 그래프이므로 양쪽에 더함
            graph[start].add(end);  // start -> end
            graph[end].add(start);  // end -> start
        }
        int count =0;
        for(int i=1;i<node+1;i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    static void DFS(int v){
        if(visited[v]){return;}
        visited[v] = true;
        for(int i:graph[v]){
            // 연결 노드 중 방문하지 않은 노드만 탐색
            if(visited[i] == false) 
                DFS(i);
        }
    }
}
