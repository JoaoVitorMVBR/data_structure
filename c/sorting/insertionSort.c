#include<stdio.h>

void insertionSort(int arr[], int size){
    for(int i = 1; i < size; i++){
        int j = i;
        int key = arr[i];
        while(j > 0 && arr[j-1] > key){
            arr[j] = arr[j-1];
            j--;
        }
        arr[j] = key;
    }
}


int main(){
    int array[5] = {67, 44, 82, 17, 20};
    insertionSort(array, 5);
    for(int i = 0; i<5; i++)
        printf("%d - ", array[i]);

    return 0; 
}