/*
 * Welcome
 */
package com.achess.practica1apuestas.betsLogic.linkedList;

/**
 *
 * @author achess
 */
public class List<T> {
    private Node head;
    private int len;
    
    public List(){
        len = 0;
    }
    
    public void push(T data){
        Node<T> node = new Node(data);
        if(head == null){
            head = node;
        }else{    
            Node aux = head;
            node.setNext(aux);
            head = node;            
        }
        len++;
    }
    
    public Node pop(){
        Node aux = head;
        head = head.getNext();
        return aux;
    }

    public Node getHead() {
        return head;
    }

    public int getLen() {
        return len;
    }               
}
