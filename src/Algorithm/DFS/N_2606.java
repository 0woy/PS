package Algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class N_2606 {
    static int total;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int count =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        total = Integer.parseInt(br.readLine());
        int edge =  Integer.parseInt(br.readLine());
        visited = new boolean[total+1];
        graph = new ArrayList[total+1];

        for(int i=1;i<total+1;i++)
            graph[i] = new ArrayList<>();

        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        dfs(1);
        System.out.println(count);
    }
    public static void dfs(int start){
        if (visited[start]) return;
        visited[start]=true;

        for(int i: graph[start]){
            if(!visited[i]) {
            count++;
            dfs(i);
            }
        }
    }
}
