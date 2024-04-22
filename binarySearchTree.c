#include<stdlib.h>
#include<stdio.h>

typedef struct node{
  int data;
  struct node *leftChild;
  struct node *rigthChild;
}Node;

Node *root = NULL;

void insertion(int data){
  Node *no = (Node*)malloc(sizeof(Node));
  no->data = data;
  no->leftChild = NULL;
  no->rigthChild = NULL;
  if(root == NULL){
    root = no;
  }else{
    Node *noAuxiliar = root;    
    Node *noPai = NULL;
    // busca o local para inserir
    while(noAuxiliar != NULL){
      noPai = noAuxiliar;
      if(data < noAuxiliar->data){ //anda para a esquerda
        noAuxiliar = noAuxiliar->leftChild;
      }else{ //anda para a direita
        noAuxiliar = noAuxiliar->rigthChild;
     } 
    }
    if(data < noPai->data){
      noPai->leftChild = no;
    }else{
      noPai->rigthChild = no;
    }
  } 
}

Node* search(int data){
  Node *noAuxiliar = root;
  
  while(noAuxiliar != NULL){
    if(data == noAuxiliar->data){
      break;     
    }else{
      if(data < noAuxiliar->data){
        noAuxiliar = noAuxiliar->leftChild;
      }else{
        noAuxiliar = noAuxiliar->rigthChild;
      }
    }
  }
  return noAuxiliar;
}



int main(){

  insertion(25);
  insertion(20);
  insertion(40);
  insertion(10);
  insertion(30);
  insertion(45);
  insertion(22);

  Node *resultado = search(2);
  resultado == NULL ? printf("NÂO ENCONTRADO \n") : printf("Valor encontrado: %d \n", resultado->data); 

  return 0;
}
