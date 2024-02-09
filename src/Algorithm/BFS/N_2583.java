package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import static Algorithm.BFS.N_1012.visitied;

public class N_2583 {
    static int [][] square;
    static boolean [][] visited;
    static LinkedList<Integer> que;
    static int count =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int height=Integer.parseInt(st.nextToken());
        int weight=Integer.parseInt(st.nextToken());
        int total=Integer.parseInt(st.nextToken());
        visited = new boolean[height+2][weight+2];
        square = new int[height+2][weight+2];

        for(int i=0, j=0;i<height+2;i++){
            square[i][0] = 1;
            square[i][weight+1] = 1;
        }

        for(int i=0;i<weight+2;i++){
            square[0][i] = 1;
            square[height+1][i] = 1;
        }

        for(int k=0;k<total;k++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=y1;j<y2;j++) {
                for (int i = x1 + 1; i <= x2; i++)
                    square[height - j][i] = 1;
            }
        }

        que = new LinkedList<>();
        int size =0;
        for(int i=1;i<=height;i++){
            for(int j=1;j<=weight;j++){
                if(!visited[i][j]&&square[i][j]==0) {
                    size = bfs(square, i, j);
                    sb.append(size+" ");
                }
            }
        }
        st = new StringTokenizer(sb.toString());
        int [] sizes = new int[st.countTokens()];
        for(int i=0;i<sizes.length;i++)
            sizes[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sizes);
        sb = new StringBuilder();
        for(int i=0;i<sizes.length;i++)
            sb.append(sizes[i]+" ");

        System.out.println(count+"\n"+sb);
    }
    static int bfs(int[][] arr , int x, int y){
        int size =0;
        que.add(x);
        que.add(y);
        visited[x][y] = true;
        while(que.size()!=0){
            size++;
            int x1 = que.poll();
            int y1 = que.poll();
            if(!visited[x1-1][y1]&&arr[x1-1][y1]==0 ){
                que.add(x1-1);
                que.add(y1);
                visited[x1-1][y1]=true;
            }
            if(!visited[x1+1][y1]&&arr[x1+1][y1]==0){
                que.add(x1+1);
                que.add(y1);
                visited[x1+1][y1]=true;
            }
            if(!visited[x1][y1-1]&&arr[x1][y1-1]==0){
                que.add(x1);
                que.add(y1-1);
                visited[x1][y1-1]=true;
            }
            if(!visited[x1][y1+1]&&arr[x1][y1+1]==0){
                que.add(x1);
                que.add(y1+1);
                visited[x1][y1+1]=true;
            }
        }
        count++;
        return size;
    }
}
