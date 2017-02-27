import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserInterface{
    private static ArrayList<SortedLinkedList> lists;
    private static SortedLinkedList selected = new SortedLinkedList("Empty");
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] ags){
        lists = new ArrayList<SortedLinkedList>();
        System.out.println("Welcome to the Sorted Linked List Module.");
        mainMenu();
    }
    private static void mainMenu()
    {
        boolean exit = true;
        do{
            System.out.println("\nM A I N  M E N U");
            System.out.println("To create a new list, enter 1.");
            System.out.println("To access/modify a list, enter 2.");
            System.out.println("To quit, enter 0.");
            System.out.print("Enter: ");
            int val = sc.nextInt();
            sc.nextLine();
            switch(val){
                case 0: exit = false; break;
                case 1: create(); break;
                case 2: access(); break;
                default: System.out.println("Error. Enter a valid number.");
            }
        }while(exit);
    }
    private static void access(){
        System.out.println("\nACCESS / MODIFICATION MENU");
        System.out.println("Current Lists: ");
        if(lists.size() < 1)
            System.out.println("None!\n");
        else
            for (int i = 0; i < lists.size(); i++)
                System.out.println("Press " + (i+1) + " for list : \"" + lists.get(i).getName()+ "\"");
        System.out.print("\nEnter: ");
        String val = sc.nextLine();
        if(val.matches("\\d+"))
            try{
            selected = lists.get(Integer.parseInt(val)-1);
            operations();
            }
            catch(Exception x){
                System.out.println("Enter a valid index.");}
    }
    //Perform operations on "selected" list.
    private static void operations(){
        System.out.println("Press 1 to insert.");
        System.out.println("Press 2 to delete element.");
        System.out.println("Press 3 to retrieve length of list.");
        System.out.println("Press 4 to view list contents.");
        System.out.println("Press 5 to search list for element.");
        System.out.print("Enter: ");
        int val = Integer.parseInt(sc.nextLine());
        switch(val){
            case 1: {
                System.out.print("Enter a number to insert: ");
                int ins = Integer.parseInt(sc.nextLine());
                selected.insert(ins);
                System.out.println(ins + " has been added to list " + selected.getName() + "."); break;
            }
            case 2: {
                System.out.print("Enter a number to delete: ");
                int ins = Integer.parseInt(sc.nextLine());
                selected.delete(ins);
                System.out.println(ins + " has been deleted from list " + selected.getName());
                break;
            }
            case 3: System.out.println("Length of " + selected.getName() + " is " + selected.length() + "."); break;
            case 4: selected.print(); break;
            case 5:{
                System.out.print("Enter a number to search for: ");
                int ins = Integer.parseInt(sc.nextLine());
                System.out.println(selected.find(ins) + " that " + ins + " is in the list " + selected.getName() + "."); break;
            }
            default: System.out.println("Not a valid list element.");
        }

    }
    //create a new list.
    private static void create(){
        System.out.println("LIST CREATION MENU");
        System.out.print("Ok, Let's create a list. Give it a name: ");
        String name = sc.nextLine();
        System.out.println("Enter list elements, separated by spaces.\nIf you'd like to modify the list later, " +
                "you may do so through the main menu.");
        String data = sc.nextLine();
        SortedLinkedList toAdd = new SortedLinkedList(name);
        for(Integer c: stringToIntegers(data))
            toAdd.insert(c);
        lists.add(toAdd);
        System.out.println("Success! List " + name + " has been created.");
    }
    //Convert string to int to take input to create a new list.
    private static ArrayList<Integer> stringToIntegers(String s){
        ArrayList<Integer> temp = new ArrayList<>();
        String regex = "\\d+";
        StringTokenizer str = new StringTokenizer(s);
        while(str.hasMoreTokens()) {
            String t = str.nextToken();
            if (t.matches(regex))
               temp.add(Integer.parseInt(t));
        }
        return temp;
    }
}
