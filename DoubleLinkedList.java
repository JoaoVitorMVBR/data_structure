/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.doublelinkedlist;
import java.util.*;

/**
 *
 * @author jhon
 */

public class DoubleLinkedList {
    
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    static Node head;   // aponta para o primeiro no;
    static Node last; // aponta para o ultimo no;
    
    static public boolean isEmpty(){
        return head == null;
    }
    
    static public void printFoward(){
        if(isEmpty()){
            System.out.println("Lista vazia");
        }else{
            Node aux = head;
            while(aux != null){
                System.out.print(aux.data + " ");
                aux = aux.next;
            }
        }
    }
    
    static public void printBackward(){
        if(isEmpty()){
            System.out.println("Lista vazia");
        }else{
            Node aux = last;
            while(aux != null){
                System.out.print(aux.data + " ");
                aux = aux.prev;
            }
        }
    }
    
    static public void insertion(int data){
        
        Node no = new Node(data);
        
        if(isEmpty()){
            last = no;
        }else{
            head.prev = no;
        }
        no.next = head;
        head = no;
    }
    
    static public void insertionEnding(int data){
        Node no = new Node(data);
        if(isEmpty()){
            head = no;
            last = no;
        }else{
            last.next = no ;
            no.prev = last;
            last = no;
        }
    }
    
    static public Node search(int dataSearch){
        Node aux = head;
        while(aux.data != dataSearch){
                if(aux.next == null){
                    return null;
                }
                aux = aux.next;
            }
        return aux;
    }
    
    static public void insertionAfter(int nodeAfter, int data){
        if(isEmpty()){
            System.out.println("Lista vazia");
        }else{
            Node aux = search(nodeAfter);
            if(aux == null){
                System.out.println("Dado não existe");
                return;
            }       
            if(aux.next == null){ // significa que aux é o ultimo no da lista
                insertionEnding(data);
            }else{
                Node no = new Node(data);
                no.prev = aux;
                no.next = aux.next;
                aux.next.prev = no;
                aux.next = no;
            }
        }
    }
    
    static public void delete(){
        if(isEmpty()){
            System.out.println("Lista vazia");
        }else{
            head = head.next;
        }
    }
    
    static public void deleteLast(){
        if(isEmpty()){
            System.out.println("Lista vazia");
        }else{
            last = last.prev;
            last.next = null;
            System.out.println(last.data);
        }        
    }
    
    static public void deleteAfter(int nodeAfter){
        if(isEmpty()){
            System.out.println("Lista vazia");
        }else{
            Node aux = search(nodeAfter);
            if(aux.next == null){
                deleteLast();
            }else{
                aux.next.prev = aux;
                aux.next = aux.next.next;
            }
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
                    insertion(num);
                    break;
                case 2:
                    System.out.print("Digite o numero para buscar: ");
                    num = scanner.nextInt();
                    Node no = search(num);
                    if(no == null){
                        System.out.println("Dado não existe");
                    }else{
                        System.out.println("Numero: " + no.data);
                    }
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    printFoward();
                    break;
                case 5:
                    trigger = false;
            }        
        }
    }
}
