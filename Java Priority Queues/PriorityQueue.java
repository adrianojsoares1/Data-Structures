/**
 * Created by Adriano on 4/25/2017.
 */
import java.util.ArrayList;

public class PriorityQueue {
    private final int MAX_LENGTH = 200;
    private static Integer processNumber = 0;
    private ArrayList<Integer> ids;
    private ArrayList<Process> heap;

    PriorityQueue() {
        ids = new ArrayList<>();
        heap = new ArrayList<>();
    }
    PriorityQueue(int[] args){
        ids = new ArrayList<>();
        heap = new ArrayList<>();

        for(int i : args)
            insert(i);
    }
    //If theres a hole, replace process x from null with a new Process
    void insert(Integer i) {
        boolean found_hole = false;
        for (int x = 0; x < ids.size(); x++) {
            if (ids.get(x) == null) {
                heap.add(new Process(x, i));
                ids.set(x, heap.size() - 1);
                found_hole = true;
                heap_up(heap.size() - 1);
                break;
            }
        }
        // Else add normally
        if (!found_hole) {
            if (processNumber >= MAX_LENGTH)
                System.out.println("Capacity has been reached. Could not insert.");
            else {
                ids.add(processNumber);
                heap.add(new Process(processNumber, i));
                heap_up(heap.size() - 1);
                processNumber++;
            }
        }

    }

    boolean is_empty() {return processNumber == 0;}

    String to_string() {
        StringBuilder str = new StringBuilder("");
        for (Process i : heap) {
            if (i == null) {
                str.append("Null");
            } else {
                str.append("Process: ");
                str.append(i.get_id());
                str.append(" | Process Priority: ");
                str.append(i.get_priority());
                str.append("\n");
            }
        }
        return str.toString();
    }

    private int length() {
        return heap.size();
    }

    private Integer parent(Integer id) {
        return (id - 1) / 2;
    }

    private Integer right(Integer id) {
        return 2 * id + 2;
    }

    private Integer left(Integer id) {
        return 2 * id + 1;
    }

    // Take in spot in heap
    private void heap_up(Integer id) {
        int parentId;
        Process temp;
        if (id != 0) {
            parentId = parent(id);
            if (heap.get(parentId).get_priority() < heap.get(id).get_priority()) {
                ids.set(heap.get(id).get_id(), parentId);
                ids.set(heap.get(parentId).get_id(), id);
                temp = heap.get(parentId);
                heap.set(parentId, heap.get(id));
                heap.set(id, temp);
                heap_up(parentId);
            }
        }
    }

    private void heap_down(Integer id) {
        Integer min = id, rightID, leftID;
        Process temp;
        rightID = right(id);
        leftID = left(id);
        if(rightID < heap.size() || leftID < heap.size()) {
            if (rightID >= heap.size()){
                min = leftID;
            }
            else if (leftID >= heap.size())
                min = rightID;
            else{
                if(heap.get(leftID).get_priority() > heap.get(rightID).get_priority())
                    min = leftID;
                else min = rightID;
            }
            if((heap.get(id).get_priority()<heap.get(min).get_priority())){
                ids.set(heap.get(min).get_id(), id);
                ids.set(heap.get(id).get_id(), min);
                temp = heap.get(min);
                heap.set(min, heap.get(id));
                heap.set(id, temp);
                heap_down(min);
            }
        }
    }

    public Integer max() {
        if (heap.size() == 0) {
            System.out.println("Empty!");
            return null;
        }
        System.out.println("Maximum: " + heap.get(0).get_priority() + " | ID: " + heap.get(0).get_id());

        return heap.get(0).get_priority();
    }

    Integer heapify(){
        return generic_heapify(0);
    }

    private Integer generic_heapify(int index){
        if(length() <= 0)
            return null;
        if(length() == 1){
            ids.set(heap.get(index).get_id(), null);
            heap.remove(0);
            return null;
        }
        else {
            Process temp = heap.get(index);
            ids.set(heap.get(heap.size() - 1).get_id(), 0);
            ids.set(heap.get(0).get_id(), null);
            heap.set(index, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            heap_down(index);
            return temp.get_priority();
        }
    }

    public void delete(int index){
        if (length() == 0)
            System.out.println("List is empty.");
        if (index < 0 || index > length())
            System.out.println("Index is invalid.");
        else{
            generic_heapify(index);
        }
    }

    void increase(int process_id, int delta){
        generic_priority_change(process_id, delta, '+');
    }

    void decrease(int process_id, int delta){
        generic_priority_change(process_id, delta, '-');
    }

    void set_priorty(int process_id, int delta){
        generic_priority_change(process_id, delta, '=');
    }

    String id_string() {
        String str = "";
        for (Integer i : ids) {
            str += (" " + i);
        }
        return str;
    }

    private void generic_priority_change(int id, int delta, char dir){
        Process mod = heap.get(ids.get(id));
        switch (dir){
            case '+':
                mod.set_priority(mod.get_priority() + delta); break;
            case '-':
                mod.set_priority(mod.get_priority() - delta); break;
            case '=':
                mod.set_priority(delta); break;
            default: System.out.println("Something went wrong! You shouldn't be here.");
        }
        heap_up(ids.get(id));
        heap_down(ids.get(id));
    }
}
