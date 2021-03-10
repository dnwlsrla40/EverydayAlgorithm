// 11725번 트리의 부모 찾기(silver 2)

/*
문제 출처 : https://www.acmicpc.net/problem/11725

문제
루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

출력
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.

예제 입력 1 
7
1 6
6 3
3 5
4 1
2 4
4 7
예제 출력 1 
4
6
1
3
1
4
예제 입력 2 
12
1 2
1 3
2 4
3 5
3 6
4 7
4 8
5 9
5 10
6 11
6 12
예제 출력 2 
1
1
2
3
3
4
4
5
5
6
6
*/

/*
 * 생각 노트
 * 처음엔 트리라고 하여 노드를 구현해서 트리 연결을 해주려 했지만, 입력 값의 부모 관계를 통해 트리 구현이 안되어
 * parent 배열을 통한 dfs로 부모자식 관계를 정하였다. 예전에 풀었던 촌수 관계와 비슷한 개념으로 풀었다.
*/

// 제출 결과 [메모리: 17340KB 시간: 180ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_11725 {
    static int n;
    static ArrayList<ArrayList<Integer>> listGraph;
    static int[] parents;
    static boolean[] check;

    public static void dfs(int v){
        check[v] = true;
        for (int vChild : listGraph.get(v)) {
            if(!check[vChild]){
                parents[vChild] = v;
                dfs(vChild);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        listGraph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n+1; i++) {
            listGraph.add(new ArrayList<Integer>());
        }

        parents = new int[n+1];
        check = new boolean[n + 1];



        for (int i = 0; i < n-1; i++) {
            String[] inputNode = br.readLine().split(" ");
            int n1 = Integer.parseInt(inputNode[0]);
            int n2 = Integer.parseInt(inputNode[1]);

            listGraph.get(n1).add(n2);
            listGraph.get(n2).add(n1);
        }

        for (int i = 1; i <= n; i++) {
            if(!check[i])
                dfs(i);
        }
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }

    }
}