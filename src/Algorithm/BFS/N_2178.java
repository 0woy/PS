package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_2178 {
    static int n;
    static int m;
    static int [][] maze;
    static boolean [][] visited;
    static Queue<int[]> que = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            String tmp = br.readLine();
            for(int j=0;j<tmp.length();j++)
                maze[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
        }

        que.offer(new int[]{0,0});
        visited[0][0]= true;
        bfs(0,0);
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++) {
//                if(!visited[i][j])
//                    bfs(i,j);
//            };
//        }
        System.out.println(maze[n-1][m-1]);
    }
    static void bfs(int i, int j){
        int dx[] ={0,1,0,-1};
        int dy[] ={1,0,-1,0};
        while(!que.isEmpty()){
            int [] tmp = que.poll();
            for(int d=0;d<4;d++){
                int nx = tmp[0]+dx[d];
                int ny = tmp[1]+dy[d];
                if(nx>=0&&ny>=0&&nx<n&&ny<m){
                    if(!visited[nx][ny]&&maze[nx][ny]==1){
                        visited[nx][ny]=true;
                        que.offer(new int[]{nx,ny});
                        maze[nx][ny]= maze[tmp[0]][tmp[1]]+1;
                    }
                }
            }
        }


    }
}
