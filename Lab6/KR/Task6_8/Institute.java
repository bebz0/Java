// Task 6.8
import java.io.Serializable;

public class Institute implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Faculty[] faculties;

    public Institute(String name, Faculty[] faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public Faculty[] getFaculties() {
        return faculties;
    }

    public int getStudents() {
        int sum = 0;
        for (int i = 0; i < faculties.length; i++)
            sum += faculties[i].getStudents();
        return sum;
    }

    public String toString() {
        String s = "Institute: " + name + "\n";
        for (int i = 0; i < faculties.length; i++)
            s += "  " + (i + 1) + ". " + faculties[i] + "\n";
        s += "  Total students: " + getStudents();
        return s;
    }
}
