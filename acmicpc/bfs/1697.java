// 숨바꼭질

/*
*   동생을 찾을 수 있는 가장 빠른 시간이므로 bfs를 사용했다. 큰 틀은 변하지 않았고 다만 1차원으로 된 배열을 사용한 적이 처음이었다.
*   동생을 찾는 순간 그만 둬야 하기에 반복문에 if(n==k)를 넣어주었고 특정 이동 조건을 주어 그것에 맞게 코딩하였다.
*   문제 자체는 어렵지 않았지만, 이 문제를 bfs 분류에서 찾지 않았으면 bfs를 사용해야 한다는 것에 시간을 걸릴 것 같았다.
*/

// 제출 결과: [메모리:18312KB 시간: 120ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Java_1697 {
    static Queue<Integer> q = new LinkedList<Integer>();
    static int[] map = new int[100001];
    static boolean[] visit = new boolean[100001];
    static int n,k;

    static void bfs(){
        int x;

        while(!q.isEmpty()){
            x=q.poll();
            visit[x]=true;

            if(n==k)
                break;

            if(0<=x-1 && !visit[x-1]) {
                q.add(x-1);
                visit[x-1] = true;
                map[x-1] = map[x]+1;
            } if(x+1<=100000 && !visit[x+1]) {
                q.add(x + 1);
                visit[x+1] = true;
                map[x+1] = map[x]+1;
            } if(x*2<=100000 && !visit[x*2]) {
                q.add(x*2);
                visit[x*2]= true;
                map[x*2] = map[x]+1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        n = Integer.parseInt(Input[0]);
        k = Integer.parseInt(Input[1]);

        q.add(n);
        bfs();
        System.out.println(map[k]);
    }
}
