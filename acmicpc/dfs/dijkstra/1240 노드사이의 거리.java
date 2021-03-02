// 1240번 노드사이의 거리(gold 4)

/*
문제 출처 : https://www.acmicpc.net/problem/1240

문제
N(2≤N≤1,000)개의 노드로 이루어진 트리가 주어지고 M(M≤1,000)개의 두 노드 쌍을 입력받을 때 두 노드 사이의 거리를 출력하라.

입력
첫째 줄에 노드의 개수 N이 입력되고 다음 N-1개의 줄에 트리 상에 연결된 두 점과 거리(10,000 이하의 정수)를 입력받는다. 그 다음 줄에는 거리를 알고 싶은 M개의 노드 쌍이 한 줄에 한 쌍씩 입력된다.

출력
M개의 줄에 차례대로 입력받은 두 노드 사이의 거리를 출력한다.

예제 입력 1 
4 2
2 1 2
4 3 2
1 4 3
1 2
3 2
예제 출력 1 
2
7
*/

/*
 * 생각 노트
 * 처음에는 ArrayList를 이용해 Edge를 만들고 가중치를 둬 계산하려 했지만 틀렸다고 하여 검색을 해보니 dijkstra 방식을 이용해 쉽게 구하는 방법이 있었다.
 * dijkstra는 처음 사용하여 이번엔 개념 정리 및 코드 작성 방법을 중점으로 문제를 풀었다.
*/

// 제출 결과 [메모리: 26620KB 시간: 2660ms]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;


public class BJ_1240 {

    static int n;
    static int[][] graph;

    static int[] dijkstra(int v) {
        int distance[] = new int[n+1];
        boolean[] check = new boolean[n+1];

        // 모든 distance 값 최대 값으로 초기화
        for (int i = 0; i < n+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[v] = 0;
        check[v] = true;

        // 가중치를 계산 해 distance 갱신(처음 입력 받은 값)
        for (int i = 1; i < n+1; i++) {
            if(!check[i] && graph[v][i] != 0){
                distance[i] = graph[v][i];
            }
        }

        for (int i = 0; i < n-1; i++) {
            int min = Integer.MAX_VALUE; // 최솟값 초기화
            int min_index = -1; // 최솟값을 가지는 index 초기화

            // 최소값 찾기
            for (int j = 1; j < n+1; j++) {
                // 방문 하진 않았고, 유효한 노드
                if(!check[j] && distance[j] != Integer.MAX_VALUE){
                    // 최소 값 갱신
                    if(distance[j] < min){
                        min = distance[j];
                        min_index = j;
                    }
                }
            }

            check[min_index] = true;
            for (int j = 1; j < n+1; j++) {
                if(!check[j] && graph[min_index][j] != 0){
                    // 직선 거리와 노드를 거쳐서 가는 거리 중 최소 값으로 설정
                    if(distance[j] > distance[min_index] + graph[min_index][j]) {
                        distance[j] = distance[min_index] + graph[min_index][j];
                    }
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        graph = new int[n+1][n+1];

        for (int i = 0; i < n-1; i++) {
            String[] inputNode = br.readLine().split(" ");
            int n1 = Integer.parseInt(inputNode[0]);
            int n2 = Integer.parseInt(inputNode[1]);
            int w = Integer.parseInt(inputNode[2]);

            graph[n1][n2] = w;
            graph[n2][n1] = w;
        }

        for (int i = 0; i < m; i++) {
            String[] inputNode = br.readLine().split(" ");
            int n1 = Integer.parseInt(inputNode[0]);
            int n2 = Integer.parseInt(inputNode[1]);
            int[] totalW = dijkstra(n1);
            System.out.println(totalW[n2]);
        }
    }
}
