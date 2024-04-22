/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.linkedlist;
import java.util.Scanner;
/**
 *
 * @author jhon
 */
public class LinkedList {

    static class Node{
        int data;
        Node next;
        Node(int value){
            data = value;
            next = null;
        }
    }
    
  
    static Node head;
    
    
    static boolean isEmpty(Node head){
        return head == null;
    }
    
    
    static void printList(){
        if(isEmpty(head)){
            System.out.println("Lista vazia");
            return;
        }
        Node aux = head;
        System.out.print("[");
        while(aux != null){
            System.out.print(" " + aux.data + " ");
            aux = aux.next;
        }
        System.out.print("]");
    }
 
    static void insertionAtBeginning(int data){
        Node node = new Node(data);
        if(isEmpty(head)){
            head = node;
        }else{
            node.next = head;
            head = node;
        }
    }
    
    static void insertionAtEnding(int data){
        Node node = new Node(data);
        Node aux = head;
        if(isEmpty(head)){
            head = node;
        }else{ 
            while(aux.next != null){
                aux = aux.next;
            }
            aux.next = node;
        }
    }
    
    static void search(int data){
        if(isEmpty(head)){
            System.out.println("Lista vazia");
            return;
        }
        Node auxNode = head;
        boolean trigger = false;
        while(auxNode.data != data){
            auxNode = auxNode.next;
            if(auxNode.next == null){
                trigger = true;
                break;
            }
        }
        if(trigger == true)
            System.out.println("Elemento nao encontrado");
        else
            System.out.print("O " + data + "foi encontrado na lista");
    }
    
    static void deleteInitial(){
        if(isEmpty(head)){
            System.out.println("Lista vazia");
            return;
        }
        head = head.next;
    }
    
    static void deleteFinal(){
        if(isEmpty(head)){
            System.out.println("Lista vazia");
            return;
        }
        Node aux = head;
        while(aux.next.next != null){
            aux = aux.next;
        }
        aux.next = null;
    }
    
    static void delete(int data) {
        
        if(isEmpty(head)){
            System.out.println("Lista vazia");
            return;
        }
        
        Node currentNode = head;
        Node prevNode = null;
        
        if(currentNode.next != null && currentNode.data == data){
            head = currentNode.next;
            return;
        }
        
        while(currentNode.next != null && currentNode.data != data){
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        
        if(currentNode.next == null && currentNode.data != data){
            System.out.println("Elemento não existe");
        }else{
            prevNode.next = currentNode.next;
        }
            
    }
    
    
    public static void main(String[] args) {
        int opcao, num;
        boolean trigger = true;
        Scanner scanner = new Scanner(System.in);
        while(trigger){
            System.out.println("Digite uma opcao: ");
            System.out.println("1 - inserir");
            System.out.println("2 - buscar");
            System.out.println("3 - deletar");
            System.out.println("4 - listar:");
            System.out.println("5 - sair:");
            opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    System.out.print("Digite o numero para inserir: ");
                    num = scanner.nextInt();
                    insertionAtEnding(num);
                    break;
                case 2:
                    System.out.print("Digite o numero para buscar: ");
                    num = scanner.nextInt();
                    search(num);
                    break;
                case 3:
                    System.out.print("Digite o numero para deletar: ");
                    num = scanner.nextInt();
                    delete(num);
                    break;
                case 4:
                    printList();
                    break;
                case 5:
                    trigger = false;
            }        
        }
    } 
}
       