// 43165번 타겟 넘버

/*
문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43165?language=java

문제 설명
n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.
입출력 예
numbers	target	return
[1, 1, 1, 1, 1]	3	5
입출력 예 설명
문제에 나온 예와 같습니다.
*/

/*
 * 생각 노트
 * 모든 경우를 계산 해야 해서 dfs를 사용하였다. 시작 노드부터 다음 노드 들을 합하거나 빼면서 끝에 다달았을 때 타겟 넘버가 되는 경우의 수를 출력하였다.
*/

public class PG_43165 {
    public static int answer = 0;
    public static int solution(int[] numbers, int target){

        dfs(numbers, target, numbers[0], 1);
        dfs(numbers, target, -numbers[0], 1);

        return answer;
    }

    public static void dfs(int[] numbers, int target, int current, int index){
        if(index == numbers.length) {
            if(current == target)
                answer++;
        }

        int nextIndex = index + 1;
        if(nextIndex <= numbers.length){
            dfs(numbers, target, current+numbers[index], nextIndex);
            dfs(numbers, target, current-numbers[index], nextIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};

        System.out.println(solution(arr, 3));
    }
}
