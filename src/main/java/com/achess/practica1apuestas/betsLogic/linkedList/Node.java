/*
 * Welcome
 */
package com.achess.practica1apuestas.betsLogic.linkedList;

/**
 *
 * @author achess
 */
public class Node <T>{
    private T data;
    private Node next;

    public Node(T data) {
        this.data = data;        
        this.next = null;
    }

    public T getData() {
        return data;
    }
    
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    public String csv(){
        return data.toString();
    }
     
}
