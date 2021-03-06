// 1926번 그림(silver 1)

/*
문제 출처 : https://www.acmicpc.net/problem/1926

문제
어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.

입력
첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다. 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)

출력
첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.

예제 입력 1 
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1

예제 출력 1 
4
9
*/

/*
 * 생각 노트
 * 전투 문제와 비슷하다. 전투 문제는 재귀의 특성을 적극 활용하지 못했었는데 이번 문제는 활용해서 풀어보았다.
*/

// 제출 결과 [메모리: 58460KB 시간: 392ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1926 {
    private static int[][] map;
    private static boolean[][] visit;
    private static int n,m;
    private static int[][] check = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private static int count = 0;
    private static int checkArea;
    private static int maxArea = 0;

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int dx = x + check[i][0];
            int dy = y + check[i][1];

            if(0 <= dx && 0 <= dy && dx < n && dy < m){
                if(!visit[dx][dy] && map[dx][dy] == 1){
                    checkArea++;
                    dfs(dx, dy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapInput = br.readLine().split(" ");
        n = Integer.parseInt(mapInput[0]);
        m = Integer.parseInt(mapInput[1]);

        map = new int[n+1][m+1];
        visit = new boolean[n+1][m+1];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    count++;
                    checkArea = 1;
                    dfs(i, j);
                    if(checkArea > maxArea)
                        maxArea = checkArea;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

}
