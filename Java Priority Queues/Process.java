/**
 * Created by Adriano on 4/25/2017.
 */
public class Process {
    private Integer id;
    private Integer priority;

    Process(Integer id, Integer priority){
        this.id = id;
        this.priority = priority;
    }

    Integer get_id(){
        return id;
    }

    Integer get_priority(){
        return priority;
    }

    void set_id(Integer item){
        id = item;
    }

    void set_priority(Integer item){
        priority = item;
    }
}
