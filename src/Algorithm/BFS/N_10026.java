package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class N_10026 {
    static int n;
    static int [][] paint;
    static boolean [][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        paint =new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++) {
            String str =br.readLine();
            for(int j=0;j<str.length();j++){
                switch (str.charAt(j)) {
                    case 'R':
                        paint[i][j] = 0;
                        break;
                    case 'G':
                        paint[i][j] = 1;
                        break;
                    case 'B':
                        paint[i][j] = 2;
                        break;
                }
            }
        }

        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    count++;
                    bfs(i,j,true);
                }
            }
        }
        sb.append(count+" ");

        count=0;
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    count++;
                    bfs(i,j,false);
                }
            }
        }

        sb.append(count);
        System.out.println(sb);
    }
    
    public static void bfs(int i,int j, boolean color){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});
        int c_col = paint[i][j];

        visited[i][j] = true;

        int []dx = {0,1,0,-1};
        int []dy = {1,0,-1,0};

        while (queue.size()>0){
            int [] tmp = queue.poll();
            for(int d=0;d<4;d++) {
                boolean check = false;
                int nx = tmp[0] + dx[d];
                int ny = tmp[1] + dy[d];

                if (nx < n && ny < n && nx >=0 && ny >= 0) {
                    if(!color){
                        if(c_col == 0 || c_col==1)
                            if(!visited[nx][ny]&&paint[nx][ny]!=2)
                                check=true;
                        else
                            if(!visited[nx][ny]&&paint[nx][ny]==c_col)
                                check=true;
                    }

                    if (!visited[nx][ny]&& paint[nx][ny]==c_col)
                        check=true;

                    if(check){
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny]= true;
                    }
                }
            }
        }
    }
}
