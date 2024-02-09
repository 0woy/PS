package SWM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1260 {
    static ArrayList<Integer>[] graph;
    static boolean [] visited;
    static  StringBuilder sb=new StringBuilder();
    static LinkedList<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1;i<=n;i++)
            graph[i] = new ArrayList<>();

        for(int i=0;i<v;i++){
            st = new StringTokenizer(br.readLine());
            int n1= Integer.parseInt(st.nextToken());
            int n2= Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        for(int i=1;i<=n;i++)
            Collections.sort(graph[i]);

        DFS(start);
        sb.append("\n");
        visited = new boolean[n+1];
        BFS(start);

        System.out.println(sb);
    }
    public static void DFS(int node){
        if(visited[node]) return;
        sb.append(node+" ");
        visited[node]= true;
        for(int i:graph[node]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
    public static void BFS(int start) {
        que.add(start);
        visited[start] = true;
        while (que.size() != 0) {
            int node = que.poll();
            sb.append(node+" ");
            for (int i : graph[node]) {
                if (!visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
