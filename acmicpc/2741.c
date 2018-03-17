#include <stdio.h>
int main() {
  int N;                      // 자연수 N
  int i;                      // 비교 대상 i
  scanf("%d", &N);

  // N이 자연수 일때
  if(N>0){
    // 1부터 N까지 출력
    for(i=1; i<=N; i++){
      printf("%d\n", i);
    }
  }
  return 0;
}
