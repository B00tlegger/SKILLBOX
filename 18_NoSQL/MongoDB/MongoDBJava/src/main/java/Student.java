import java.util.ArrayList;
import java.util.List;

public class Student {
    private String[] infoParts;
    private String name;
    private int age;
    private List<String> courses =new ArrayList<>();

    public Student(String info){
        infoParts = info.replaceAll("\"" , "").split(",");
        setName();
        setAge();
        setCourses();
    }

    private void setName(){
        name = infoParts[0];
    }

    public String getName(){
        return name;
    }

    private void setAge(){
        age = Integer.parseInt(infoParts[1]);
    }

    public int getAge(){
        return age;
    }

    private void setCourses(){
        for (int i = 2 ; i < infoParts.length ; i++){
            courses.add(infoParts[i]);
        }
    }

    public List<String> getCourses(){
        return courses;
    }



}
