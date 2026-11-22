// Task 7.5
import java.util.TreeSet;

public class IntSet {
    private TreeSet<Integer> elements = new TreeSet<Integer>();

    public IntSet() {
    }

    public IntSet(int[] values) {
        for (int v : values)
            elements.add(v);
    }

    public void add(int x) {
        elements.add(x);
    }

    public void remove(int x) {
        elements.remove(x);
    }

    public boolean contains(int x) {
        return elements.contains(x);
    }

    public int size() {
        return elements.size();
    }

    public IntSet union(IntSet other) {
        IntSet res = new IntSet();
        res.elements.addAll(elements);
        res.elements.addAll(other.elements);
        return res;
    }

    public IntSet intersection(IntSet other) {
        IntSet res = new IntSet();
        for (int x : elements) {
            if (other.contains(x))
                res.add(x);
        }
        return res;
    }

    public String toString() {
        String s = "{";
        for (int x : elements) {
            if (s.length() > 1) s += ", ";
            s += x;
        }
        return s + "}";
    }
}
