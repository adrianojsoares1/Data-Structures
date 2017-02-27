// Created by soaresad on 2/20/2017.

public class SortedLinkedList {
    private Node head;
    private String list_name;
    public SortedLinkedList(String name){head = null; list_name = name;}
    public SortedLinkedList(Node n, String name){head = n; list_name = name;}
    public SortedLinkedList(Node[] n, String name){
        for(Node x : n){
            insert(x.getElement());
        }
        list_name = name;
    }
    public Node getHead(){return head;}
    public String getName(){return list_name;}

    public void insert(int item){
        if(head == null)
            head = new Node(item, null);
        else if(item < head.getElement()){
            head = new Node(item,head);
        }
        else if(item == head.getElement())
            System.out.println("Error. Duplicate Items in List.");
        else if(item > head.getElement())
            head.insert(item);
    }

    public void delete(int item){
        if(head == null)
            System.out.println("There are no items to delete.");
        else if(item < head.getElement())
            System.out.print("Item not found in the list!");
        else if(item == head.getElement())
            head = head.getNext();
        else
            head.delete(item);
    }

    public int length(){
        if(head == null)
            return 0;
        else
            return 1 + head.length();
    }

    public boolean isEmpty() {return length() == 0;}

    public boolean find(int key){
        Node current = head;
        while(current != null){
            if(current.getElement() == key)
                return true;
            current = current.getNext();
        }
        return false;
    }

    public void print(){
        if(head == null){
            System.out.print("List is Empty!");
        }
        else{
            System.out.println("List: " + list_name + "\n" + "Element: " + head.getElement());
            head.print();
        }
    }
}
