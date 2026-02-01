/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universityregistrationsystem;

/**
 *
 * @author meria
 */
public class LinkedList {
    int ID;
    Node head; 
    LinkedList next;
    int count;
    public LinkedList(int ID) {
        this.ID=ID;
        this.head = null;
        this.next = null;
        this.count=0;
    }  
}
