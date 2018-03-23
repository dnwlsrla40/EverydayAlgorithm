#include <stdio.h>

int main() {
  // 자연수 N 선언
  int N=0;
  int i;
  scanf("%d", &N);
  // N이 자연수 라면
  if(N>0){
    // N부터 1까지 차례로 출력
    for(i=0; i<N; i++){
      printf("%d\n", N-i);
    }
  }
  return 0;
}
