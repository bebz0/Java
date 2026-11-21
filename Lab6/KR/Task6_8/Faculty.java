// Task 6.8
import java.io.Serializable;

public class Faculty implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String dean;
    private int students;

    public Faculty(String name, String dean, int students) {
        this.name = name;
        this.dean = dean;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public String getDean() {
        return dean;
    }

    public int getStudents() {
        return students;
    }

    public String toString() {
        return name + ", dean: " + dean + ", students: " + students;
    }
}
