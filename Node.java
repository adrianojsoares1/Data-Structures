/**
 * Created by soaresad on 2/20/2017.
 */
public class Node {
    private int element;
    private Node next_node;

    public Node(int elem, Node next_node) {
        element = elem;
        this.next_node = next_node;
    }

    public Node(int elem) {
        element = elem;
        this.next_node = null;
    }

    protected int getElement() {
        return element;
    }

    protected Node getNext() {
        return next_node;
    }

    public void setElement(int item) {
        element = item;
    }

    protected void setNext(Node item) {
        next_node = item;
    }

    public void print() {
        if (next_node == null)
            System.out.print("");
        else {
            System.out.println("Element: " + next_node.getElement());
            next_node.print();
        }

    }

    public void insert(int key) {
        if (next_node == null)
            next_node = new Node(key, null);
        else if (key < next_node.getElement()) {
            Node tmp = new Node(key, next_node);
            next_node = tmp;
        }
        else if (key == next_node.getElement())
            System.out.println("Error: Duplicate Items In List.");
        else
            next_node.insert(key);
    }

    public void delete(int key) {
        if (next_node == null)
            System.out.println("Cannot delete from empty list!");
        else if (key < next_node.getElement())
            System.out.println("Item not found in list!");
        else if (key == next_node.getElement())
            next_node = next_node.getNext();
        else
            next_node.delete(key);
    }

    public int length() {
        if (next_node == null) {
            return 0;
        } else return next_node.length() + 1;
    }

    private boolean isEmpty() {
        return next_node == null;
    }
}

