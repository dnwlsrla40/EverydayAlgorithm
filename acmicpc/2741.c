#include <stdio.h>

int main() {
  // 자연수 N 선언
  int N=0;
  int i;
  scanf("%d", &N);
  // N이 자연수 라면
  if(N>0){
    // 1부터 N까지 차례로 출력
    for(i=1; i<=N; i++){
      printf("%d\n", i);
    }
  }
  return 0;
}
