/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.queue;

/**
 *
 * @author jhon
 */
public class Queue {
    
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    static Node front = null;
    static Node back = null;

    public static boolean isEmpty(){
        return front == null;
    }
    
    public static void printQueue(){
        if(isEmpty()){
            System.out.println("VAZIA");
        }else{
            Node aux = front;
            System.out.print("[");
            while(aux != null){
                System.out.print("\t" + aux.data);
                aux = aux.next;
            }
            System.out.print("]");
        }
    }
    
    public static Node peek(){
        return front;
    }
    
    public static void insertion(int data){
        Node node = new Node(data);
        if(isEmpty()){
            front = node;
            back = node;
        }else{
            back.next = node;
            back = node;
        }
    }
    
     public static void delete(){
        if(isEmpty()){
            System.out.println("VAZIA");
        }else{
            front = front.next;
        }
    }
    
    
    
    public static void main(String[] args) {
        insertion(23);
        insertion(14);
        insertion(2);
        insertion(1);
        //topo da pilha
        System.out.println("Elemento na frente da fila:");
        Node node = peek();
        System.out.println(node.data);
        System.out.println("\n");
        //Elementos
        printQueue();
        //delete
        System.out.println("\n");
        delete();
        printQueue();
    }
}
