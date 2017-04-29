/**
 * Created by soaresad on 4/27/2017.
 */
public class Main {

    public static void main(String[] args){
        PriorityQueue q = new PriorityQueue();
        System.out.println("Empty?: " + q.is_empty()); //test empty
        //Insert some numbers
        q.insert(110);
        q.insert(5);
        q.insert(19123);
        q.insert(400);
        q.insert(1100);
        q.insert(3200);
        //Print out and heap a few times to test that feature.
        System.out.println(q.to_string());
        q.heapify();
        System.out.println("Ids: " + q.id_string());
        System.out.println(q.to_string());
        q.delete(3);
        System.out.println(q.to_string());
        System.out.println("Ids: " + q.id_string());
        q.insert(702);
        System.out.println("Ids: " + q.id_string());
        System.out.println(q.to_string());






    }
}
