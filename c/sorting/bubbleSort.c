#include<stdio.h>

void bubbleSorting(int array[], int size){
  int aux, swap = 0;
  for(int i = 0; i<size; i++){
    for(int j = 0; j<size-1; j++){
      if(array[j] > array[j+1]){
        aux = array[j];
        array[j] = array[j+1];
        array[j+1] = aux;
        swap = 1;
      }
    }
    if(!swap){
      printf("Array ordenado");
      break;
    }
  }
  //return array;
}

int main (){
  int array[5] = {67, 44, 82, 17, 20};
  bubbleSorting(array, 5);
  for(int i = 0; i<5; i++)
    printf("%d", array[i]);

  return 0;
}
