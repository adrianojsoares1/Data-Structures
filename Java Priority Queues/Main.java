/**
 * Created by soaresad on 4/27/2017.
 */
public class Main {

    public static void main(String[] args){
        System.out.println("int[] input = {77, 18, 49, 62, 35, 25, 90, 82, 7, 30, 72};" +
        "\nPriorityQueue q = new PriorityQueue(input);" +
        "\nSystem.out.print(q.to_string());\n");

        int[] input = {77, 18, 49, 62, 35, 25, 90, 82, 7, 30, 72};
        PriorityQueue q = new PriorityQueue(input);
        System.out.print(q.to_string());

        System.out.println("\nq.insert(52);\n" + "System.out.print(q.to_string());\n");
        q.insert(52);
        System.out.print(q.to_string());

        System.out.println("\nq.heapify();\n" + "System.out.print(q.to_string());\n");
        q.heapify();
        System.out.print(q.to_string());

        System.out.println("\nq.set_priority(4, 21);\n" + "System.out.print(q.to_string());\n");
        q.set_priorty(4, 21);
        System.out.print(q.to_string());

        System.out.println("\nq.delete(3);\n" + "System.out.print(q.to_string());\n");
        q.delete(3);
        System.out.print(q.to_string());

        System.out.println("\nq.set_priority(1, 76);\n" + "System.out.print(q.to_string());\n");
        q.set_priorty(1, 76);
        System.out.print(q.to_string());



    }
}
