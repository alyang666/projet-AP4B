import java.util.ArrayList;

/**
 * @author Kendrick Liu
 * @create 2020-12-0:07
 */
public class Student {
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int score;

    public ArrayList<DestinationCard> cardList1=new ArrayList<>();
//    public ArrayList<ClassCard> cardList2=new ArrayList<>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Student(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

//    @Override
    public String toString() {
        return "Student" +
                " name: " + name +
                ", score: " + score +
//                ", Number of Destination Card =" + cardList1.size() +
//                ", Number of Class Card =" + cardList2.size() +
                " ";
    }


}
