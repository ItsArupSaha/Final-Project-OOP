import java.io.Serializable;

public class Student implements Serializable{
    String name;
    String id;
    String department;
    String batch;
    String section;

    
    public Student(String name, String id, String department, String batch, String section){
        this.name = name;
        this.id = id;
        this.department = department;
        this.batch = batch;
        this.section = section;
    }
}
