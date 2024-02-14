package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_2468 {
    static int [][] region;
    static boolean [][] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n= Integer.parseInt(br.readLine());
        region  = new int[n][n];
        visited  = new boolean[n][n];
        int min = 101;
        int max =0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                region[i][j] = Integer.parseInt(st.nextToken());
                if(min >region[i][j]) min = region[i][j];
                if(max <region[i][j]) max = region[i][j];
            }
        }

        int res = 0;
        for(int k=min-1;k<max;k++) {
            int count =0;
            visited  = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]&&region[i][j]>k) {
                        bfs(i, j,k);
                        count++;
                    }
                }
            }
            if(res < count) res = count;
        }
        System.out.println(res);
    }

    public static void bfs(int i,int j, int min){
        Queue<int []> que = new ArrayDeque<>();
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};

        visited[i][j] = true;
        que.offer(new int[]{i,j});
        while(!que.isEmpty()){
            int [] tmp = que.poll();
            for(int d=0;d<4;d++){
                int nx = tmp[0]+dx[d];
                int ny = tmp[1]+dy[d];
                if(nx>=0&&ny>=0&&nx<n&&ny<n){
                    if(!visited[nx][ny]&&region[nx][ny]>min){
                        visited[nx][ny] = true;
                        que.offer(new int[]{nx,ny});
                    }
                }
            }
        }

    }
}
