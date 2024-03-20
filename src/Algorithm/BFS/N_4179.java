package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
- 문제
지훈이는 미로에서 일을 한다. 지훈이를 미로에서 탈출하도록 도와주자!
미로에서의 지훈이의 위치와 불이 붙은 위치를 감안해서 지훈이가 불에 타기전에 탈출할 수 있는지의 여부,
그리고 얼마나 빨리 탈출할 수 있는지를 결정해야한다.
지훈이와 불은 매 분마다 한칸씩 수평또는 수직으로(비스듬하게 이동하지 않는다) 이동한다.
불은 각 지점에서 네 방향으로 확산된다.
지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다.
지훈이와 불은 벽이 있는 공간은 통과하지 못한다.

- 입력
입력의 첫째 줄에는 공백으로 구분된 두 정수 R과 C가 주어진다.
단, 1 ≤ R, C ≤ 1000 이다. R은 미로 행의 개수, C는 열의 개수이다.
다음 입력으로 R줄동안 각각의 미로 행이 주어진다.
각각의 문자들은 다음을 뜻한다.

#: 벽
.: 지나갈 수 있는 공간
J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
F: 불이 난 공간
J는 입력에서 하나만 주어진다.

- 출력
지훈이가 불이 도달하기 전에 미로를 탈출 할 수 없는 경우 IMPOSSIBLE 을 출력한다.
지훈이가 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출시간을 출력한다.
 */
public class N_4179 {
    private static char[][] map;
    private static Queue<int[]> fire = new ArrayDeque<>();
    private static Queue<Person> person = new ArrayDeque<>();
    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[] dy = new int[]{1, 0, -1, 0};

    public static class Person {
        int x, y, count;

        public Person(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J')
                    person.offer(new Person(i, j, 1));
                else if (map[i][j] == 'F')
                    fire.offer(new int[]{i, j});
            }
        }

        int res = p_bfs();
        if(res == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(res);

    }

    private static int p_bfs() {
        while (!person.isEmpty()) {
            int f_len = fire.size();
            int i=0;
            while(i<f_len) {
                int[] c_fire = fire.poll();
                for (int d = 0; d < 4; d++) {
                    int fx = c_fire[0] + dx[d];
                    int fy = c_fire[1] + dy[d];

                    // 불 이동
                    if (fx >= 0 && fy >= 0 && fx < map.length && fy < map[0].length) {
                        if (map[fx][fy] == '.') {
                            map[fx][fy] = 'F';  // 방문 처리
                            fire.offer(new int[]{fx, fy}); // 다음 이동
                        }
                    }
                }
                i++;
            }

            i=0;
            int p_len = person.size();
            while(i<p_len) {
                Person simon = person.poll();
                if(simon.x == 0 || simon.x ==map.length-1 ||
                simon.y==0 || simon.y == map[0].length-1)
                    return simon.count;
                for (int d = 0; d < 4; d++) {
                    int px = simon.x + dx[d];
                    int py = simon.y + dy[d];

                    if (px >= 0 && py >= 0 && px < map.length && py < map[0].length) {
                        // 탈출이 가능 지점에 있는 경우
                        if (px == 0 || px == map.length - 1 || py == 0 || py == map[0].length) {
                            if(map[px][py]!='#' && map[px][py]!='F')
                                return simon.count+1;
                        }
                        if (map[px][py] == '.') {
                            map[px][py] = 'J';  // 방문 처리
                            person.offer(new Person(px, py, simon.count + 1)); // 다음 이동
                        }
                    }
                }
                i++;
            }
        }
        return -1;
    }
}
