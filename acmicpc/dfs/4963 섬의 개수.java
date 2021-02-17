// 4963번 섬의 개수(silver 2)

/*
문제 출처 : https://www.acmicpc.net/problem/4963

문제
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.

한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

출력
각 테스트 케이스에 대해서, 섬의 개수를 출력한다.


예제 입력 1 
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0

예제 출력 1 
0
1
1
3
1
9
*/

// 제출 결과 [메모리: 17340KB 시간: 180ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_4963 {

    static int[][] map;
    static boolean[][] visit;
    static int[][] check = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,1}, {1,1}, {-1,-1}, {1,-1}};
    static int w,h, count = 0;

    public static void dfs(int x, int y){
        for (int i = 0; i < 8; i++) {
            int dx = x + check[i][0];
            int dy = y + check[i][1];
            if(0 <= dx && 0 <= dy && dx < h && dy < w){
                if(!visit[dx][dy] && map[dx][dy] == 1) {
                    visit[dx][dy] = true;
                    dfs(dx, dy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            map = new int[h][w];
            visit = new boolean[h][w];

            if(w == 0 && h == 0)
                break;

            for (int i = 0; i < h; i++) {
                String[] mapInput = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(mapInput[j]);
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visit[i][j] && map[i][j] == 1){
                        count++;
                        dfs(i,j);
                    }
                }
            }

            System.out.println(count);
            count = 0;
            for (int i = 0; i < h; i++) {
                Arrays.fill(visit[i], false);
            }
        }

    }
}
