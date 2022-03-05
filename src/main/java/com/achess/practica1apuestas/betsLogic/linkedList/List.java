/*
 * Welcome
 */
package com.achess.practica1apuestas.betsLogic.linkedList;

/**
 *
 * @author achess
 */
public class List<T> {
    private Node<T> head;
    private int len;
    
    public List(){
        len = 0;
    }
    
    public void push(T data){
        Node<T> node = new Node(data);
        if(head == null){
            head = node;
        }else{                
            node.setNext(head);
            head = node;            
        }
        len++;
    }
    
    public void push(Node<T> node){        
        if(head == null){
            head = node;
        }else{                
            node.setNext(head);
            head = node;            
        }
        len++;
    }
    
    public Node pop(){
        if(head != null){
            Node aux = head;
            head = aux.getNext();
            return aux;
        }
        return null;
    }

    public Node getHead() {
        return head;
    }

    public int getLen() {
        return len;
    }               
    
    public void escribir(){
        Node aux = head;
        while(aux != null){
            System.out.println(aux.getData());
            aux = aux.getNext();
        }
    }
          
}
