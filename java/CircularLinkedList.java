/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.circularlinkedlist;

/**
 *
 * @author jhon
 */
public class CircularLinkedList {
    
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    static Node head = null;
    static Node last = null;
    
    
    static public boolean isEmpty(){
        return head == null;
    }
    
    static public void delete(int data){
        Node aux = head;
        while(aux.data != data){
            aux = aux.next;
        }
    }
    
    static public void display(){
        if(isEmpty()){
            System.out.println("VAZIA");
        }else{
            Node aux = head;
            while(true){
                System.out.println(aux.data);
                aux = aux.next;
                if (aux == head)
                    break;
            }
        }
    }
    
    static public void insertionAtEnding(int data){
        Node node = new Node(data);
        if(isEmpty()){
            head = node;
            last = head;
        }else{
            last.next = node;
            last = last.next;
            last.next = head; //circular
        }
    }
    
    public static void main(String[] args) {
        insertionAtEnding(1);
        insertionAtEnding(2);
        insertionAtEnding(3);
        display();
    }
}
