#include <stdio.h>

void insertionSort(int arr[], int size){
    for(int i = 1; i < size; i++){
        int key = arr[i];
        int j = i;
        while(j > 0 && arr[j-1] > key){
            arr[j] = arr[j-1];
            j--;
        }
        arr[j] = key;
    }
}

int binarySearch(int arr[], int size, int value){
    int key = value;
    int low = 0;
    int high = size - 1;

    while(low <= high){
        int mid = low + (high-low)/2;

        if(arr[mid] == key){
            return mid;
        }

        if(arr[mid] < key ){
            low = mid +1;
        }else{
            high = mid -1;
        }
    }
    return -1;
}

int main(){
    int array[9] = {100, 19, 14, 206, 27, 31, 33, -35, 42};
    //sorting
    insertionSort(array, 9);
    //search
    int res = binarySearch(array, 9, -35);
    res == -1 ? printf("\nValor não encontrado \n") : printf("\nO %d está na posição %d do array \n", array[res], res);
    
    return 0;
}
