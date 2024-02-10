package Algorithm.BFS;

import java.util.*;
import java.io.*;
public class N_2667 {
    static int n;
    static boolean [][] visitied;
    static int [][]square;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        visitied = new boolean[n][n];
        square = new int [n][n];

        for(int i=0;i<n;i++){
            String tmp  = br.readLine();
            for(int j=0;j<n;j++){
                square[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }
        List<Integer> list = new ArrayList<>();
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visitied[i][j]&&square[i][j]==1){
                    list.add(bfs(i,j));
                    count++;
                }
            }
        }
        Collections.sort(list);
        sb.append(count+"\n");
        for(int i:list)
            sb.append(i+"\n");
        System.out.println(sb);

    }
    static int bfs(int i,int j) {
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};

        visitied[i][j] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{i, j});
        int count = 0;
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            for (int d = 0; d < 4; d++) {
                int nx = tmp[0] + dx[d];
                int ny = tmp[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visitied[nx][ny] && square[nx][ny] == 1) {
                        visitied[nx][ny] = true;
                        que.offer(new int[]{nx, ny});
                    }
                }
            }
            count++;
        }
        return count;
    }
}
