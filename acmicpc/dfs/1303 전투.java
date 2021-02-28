// 1303번 전투(silver 1)

/*
문제 출처 : https://www.acmicpc.net/problem/1303

문제
전쟁은 어느덧 전면전이 시작되었다. 결국 전투는 난전이 되었고, 우리 병사와 적국 병사가 섞여 싸우게 되었다.

그러나 당신의 병사들은 하얀 옷을 입고, 적국의 병사들은 파란옷을 입었기 때문에 서로가 적인지 아군인지는 구분할 수 있다.

문제는, 같은 팀의 병사들은 모이면 모일수록 강해진다는 사실이다.

N명이 뭉쳐있을 때는 N^2의 위력을 낼 수 있다. 과연 지금 난전의 상황에서는 누가 승리할 것인가? 단, 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐 있다고 보지 않는다.

입력
첫째 줄에는 전쟁터의 가로 크기 N, 세로 크기 M(1 ≤ N, M ≤ 100)이 주어진다. 그 다음 두 번째 줄에서 M+1번째 줄에는 각각 (X, Y)에 있는 병사들의 옷색이 띄어쓰기 없이 주어진다. 모든 자리에는 병사가 한 명 있다. (B는 파랑, W는 흰색이다.)

출력
첫 번째 줄에 당신의 병사의 위력의 합과 적국의 병사의 위력의 합을 출력한다.

예제 입력 1 
5 5
WBWWW
WWWWW
BBBBB
BBBWW
WWWWW
예제 출력 1 
130 65
*/

/*
 * 생각 노트
 * 기존의 count만 check하던 dfs문제와 다르게 count와 관련된 연산을 해야했던 문제다.
 * 매개변수로 count를 넘겨주면서 전투 Strength를 연산했지만, 재귀 상의 문제로 count가 계속 + 되는 것이 아니라 check 연산 시의 count로 연산이 수행되어
 * static 변수를 이용해서 문제를 해결했다. 다른 class를 선언해서하는 방법이 좀 더 깔끔할 것 같은데 아직 익숙치 않아서 이 방법으로 풀었다.
 * 후에 코드를 다른 방법으로 refactoring 할 생각이다.
*/

// 제출 결과 [메모리: 17324KB 시간: 208ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1303 {
    static String[][] map;
    static boolean[][] visit;
    static int[][] check = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static int n, m;
    static int wStrength = 0, bStrength = 0;
    static int count=0;

    public static void w_dfs(int y, int x){
        visit[y][x] = true;
        wStrength += (count+1) * (count+1) - count * count;

        for (int i = 0; i < 4; i++) {
            int dx = x + check[i][0];
            int dy = y + check[i][1];

            if(0 <= dx && dx < n && 0 <= dy && dy < m){
                if(!visit[dy][dx] && map[dy][dx].equals("W")){
                    count++;
                    w_dfs(dy,dx);
                }
            }
        }
    }

    public static void b_dfs(int y, int x){
        visit[y][x] = true;
        bStrength += (count+1) * (count+1) - count * count;

        for (int i = 0; i < 4; i++) {
            int dx = x + check[i][0];
            int dy = y + check[i][1];

            if(0 <= dx && dx < n && 0 <= dy && dy < m){
                if(!visit[dy][dx] && map[dy][dx].equals("B")){
                    count++;
                    b_dfs(dy,dx);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new String[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = input[j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit[i][j] && map[i][j].equals("W")) {
                    count = 0;
                    w_dfs(i,j);
                }
                if(!visit[i][j] && map[i][j].equals("B")) {
                    count = 0;
                    b_dfs(i,j);
                }
            }
        }

        System.out.println(wStrength + " " + bStrength);
    }
}
