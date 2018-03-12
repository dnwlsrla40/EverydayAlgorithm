#include <stdio.h>
int main() {
  int N;
  int i;                             // 구구단 행
  scanf("%d", &N);
  // 1<N<9 면
  if(1<=N && N<=9){
    // N단 구구단 출력
    for(i=1; i<10; i++){
      printf("%d * %d = %d\n", N, i, N*i);
    }
  }
  return 0;
}
