#include <stdio.h>
#include <stdlib.h>
#define SIZE 20

typedef struct DataItem{
    int data;
    int key;
}DATA;

DATA* hashArray[SIZE];

//compute the hash code of the key of the item 
int hashCode(int key) {
    return key % SIZE;
}

void insert(int key, int data){
    DATA *item = (DATA*)malloc(sizeof(DATA));
    item->key = key;
    item->data = data;

    int hashIndex = hashCode(key);
    // printf("%d", hashIndex);

    while(hashArray[hashIndex] != NULL && hashArray[hashIndex]->key != -1){
        ++hashIndex;
        hashIndex = hashIndex % SIZE;
    }
    hashArray[hashIndex] = item;
}

DATA *search(int key){
    int hashIndex = hashCode(key);

    while(hashArray[hashIndex] != NULL){
        if(hashArray[hashIndex]->key == key){
            return hashArray[hashIndex];
        }
        ++hashIndex;
        hashIndex %= SIZE;
    }
    return NULL;
}

void delete(int key){
    DATA *temp = search(key);
    if(temp != NULL)
        free(temp);
    else
        printf("Dado não encontrado para remoção");
}

int main(){
    DATA *dummyItem = (DATA*)malloc(sizeof(DATA));
    dummyItem->data = -1;
    dummyItem->key = -1;
    insert(1, 10);
    insert(2, 20);
    insert(3, 30);
    DATA *result = search(3);
    delete(3);
    printf("%d", result->data);
}  