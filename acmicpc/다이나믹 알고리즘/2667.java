// 단지번호붙이기

/*
*   이 문제는 전체 map을 탐색해서 단지 수를 찾아야 하므로 dfs 방식이 좋을 것 같았다.
*   왼쪽 위부터 오른쪽으로 탐색하다 1인 경우를 찾으면 count 가중치를 올려 단지를 구분하고, 
*   dfs를 호출하여 재귀적인 방식으로 탐색하도록 하였다. 그 후 각 해당 가중치로 바뀐 map을 통해 
*   house 배열에 map의 index 값에 저장된 가중치(단지 값)대로 house배열의 index 값을 설정해주었다.
*
*   처음 제출 했을 때에는 stackoverflowerror가 발생하였다 그 이유는 재귀함수를 돌때 방문 했던 곳인지 확인을 하지 않아서 무한루프에 빠져
*   stack 크기보다 많아져 error 발생한 것 같다.
*/ 

// 제출 결과: [메모리: 13384KB 시간: 92ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2667_dfs {
    static int[][] map = new int[26][26];
    static int count = 0;
    static int n = 0;
    static int[][] check = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[] house = new int[25*25/2];

    // ac = apartment complex
    static void dfs(int x, int y, int ac){
        map[x][y] = ac;
        for (int i = 0; i < 4; i++) {
            int dx = x + check[i][0];
            int dy = y + check[i][1];
            if(0<=dx && 0<=dy && dx<=n && dy<=n){
                if(map[dx][dy] == 1)
                    dfs(dx,dy,ac);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] Input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(Input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==1){
                    dfs(i,j,++count);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j=0; j< n; j++){
                if(map[i][j] > 0){
                    house[map[i][j]-1]++;
                }
            }
        }

        Arrays.sort(house);

        System.out.println(count);

        for (int i = 0; i < n; i++) {
            if(house[i] != 0)
                System.out.println(house[i]);
        }
    }
}
