/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedchain;

/**
 *
 * @author zhuan
 */
class Chain {
        Node head=null;
        Node tail=null;
        
        public void add(int value) {
            if (head==null) {
                head=new Node(value);
                tail=head;
            } else {
                Node node=new Node(value);
                tail.next=node;
                node.prev=tail;
                tail=node;
                
                /*tail.next=new Node(value);
                tail.next.prev=tail;
                tail=tail.next;*/
            }
        }
        
        public boolean insert(int insertBeforeValue,int value) {
            Node node=findNode(insertBeforeValue);
            if (node==null) {
                add(value);
                return true;
            }
            Node newNode=new Node(value);
            if (node.prev==null) {
                head=newNode;
                newNode.next=node;
                node.prev=newNode;
            } else {
                node.prev.next=newNode;
                newNode.prev=node.prev;
                newNode.next=node;
                node.prev=newNode;
            }
            
            return true;
        }
        
        public boolean remove(int value) {
            Node node=findNode(value);
            if (node==null) 
                return false;
            if (node.prev==null) {
                head=node.next;
                node.next.prev=null;
            } else {
                node.prev.next=node.next;
                node.next.prev=node.prev;
            }
            if (node.next==null)
                tail=node.prev;

            return true;
        }

    private Node findNode(int value) {
        Node current=head;
        while (current!=null && current.value!=value) {
            current=current.next;
        }
        if (current==null) return null;
        else return current;
    }
        
    @Override
    public String toString() {
        Node current=head;
        String ret="";
        while (current!=null) {
            ret+=current.value+" ";
            current=current.next;
        }
        return ret;
    }
        
}

class Node {
    int value=-1;
    Node next=null;
    Node prev=null;
    
    public Node(int i) {
        value=i;
    }
}
