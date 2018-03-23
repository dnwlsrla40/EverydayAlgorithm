#include <stdio.h>
int main() {
	int N=0;                             // 설탕 kg
	int f=0, t=0;                        // 5k,3k 봉지
	int a;
	scanf("%d", &N);
  for(){
    if(N>5) {
      if(N%5 != 0 && N%5 == 3){
        f = N / 5;
        N = N - 5 * f;
        t = N / 3;
        printf("%d", t + f);
      }
      else if(N%5 != 0 && N%5 != 3){
        t = N/3;
        printf("%d", t);
      }
      else if(N%5 != 0)
    }
    else if(N==3) {
      printf("1");
    }
    else{
      printf("-1");
    }
  }
	return 0;
}
