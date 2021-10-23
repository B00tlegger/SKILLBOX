package ResponsObjects;


public class ToDo {
    private int id;
    private String name;
    private String date;
    private String place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void copyToDo(ToDo toDo) {
        this.name = toDo.getName();
        this.date = toDo.getDate();
        this.place = toDo.getPlace();
    }
}
